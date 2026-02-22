package com.vulpuslabs.modules.piezo;

import java.util.function.DoubleUnaryOperator;

public final class ClockRateEngine {

    private static final int SAMPLE_RATE = 48000;
    private static final double SYNC_LENGTH_MS_PAL = 1000.0 / 50.0;
    private static final double SYNC_LENGTH_NTSC = 1000.0 / 60.0;
    private static final double SAMPLE_LENGTH_MS = 1000.0 / SAMPLE_RATE;
    private static final double SAMPLE_LENGTH_MS_RECIPROCAL = SAMPLE_RATE / 1000.0;
    private static final double CYCLE_LENGTH_MS = 1000.0 / 3_500_000.0;
    private static final double C2 = 65.406;

    private final TickRateEngine tickRateEngine = new TickRateEngine();

    private int tickLengthInCycles = 50;
    private double syncLengthMs;
    private double syncAccumulatorMs = 0.0;
    private double tickRatePositionMs = 0.0;
    private double frequencyMult;
    private DoubleUnaryOperator filter = FilterProfile.PIEZO.getFilter();

    private final double[] vocts = new double[4];
    private final int[] phaseDeltas = new int[4];
    private final int[] pulseWidths = new int[4];
    private final boolean[] gates = new boolean[4];

    private boolean resetPhase;

    public ClockRateEngine() {
        setSyncToPal();
        setTickLengthInCycles(50);
        setAudioBudgetPercent(100.0);
        fireSync();
    }

    public void setMixMode(MixMode mixMode) {
        tickRateEngine.setMixMode(mixMode);
    }

    public void setFilterProfile(FilterProfile profile) {
        this.filter = profile.getFilter();
    }

    public void setChannel(int channel, double voct, boolean gate, int pulseWidth) {
        vocts[channel] = voct;
        gates[channel] = gate;
        pulseWidths[channel] = pulseWidth;
    }

    public void setJitter(double jitter) {
        tickRateEngine.setJitter(jitter);
    }

    public void setResetPhase(boolean resetPhase) {
        this.resetPhase = resetPhase;
    }

    public void setSyncToPal() {
        syncLengthMs = SYNC_LENGTH_MS_PAL;
        recalculate();
    }

    public void setSyncToNtsc() {
        syncLengthMs = SYNC_LENGTH_NTSC;
        recalculate();
    }

    public void setTickLengthInCycles(int cycles) {
        this.tickLengthInCycles = cycles;
        recalculate();
    }

    public void setAudioBudgetPercent(double audioBudgetPercent) {
        tickRateEngine.setTimeAllowanceMs(syncLengthMs * audioBudgetPercent * 0.01);
    }

    private void recalculate() {
        double tickLengthMs = CYCLE_LENGTH_MS * tickLengthInCycles;
        tickRateEngine.setTickLengthMs(tickLengthMs);
        frequencyMult =  tickLengthMs * 0x10000 * 0.001;
    }

    public double processSample() {
        double intervalTotal = 0.0;
        double sampleAllowanceMs = SAMPLE_LENGTH_MS;

        // Ensure the current tick position is past the start position of this interval.
        while (tickRatePositionMs <= syncAccumulatorMs) {
            tickRatePositionMs = tickRateEngine.tick();
        }

        while (sampleAllowanceMs > 1e-11) {
            // Do we hit the sync pulse before the next tick?
            if (syncLengthMs < tickRatePositionMs) {
                double timeToSyncMs = syncLengthMs - syncAccumulatorMs;
                // Do we hit the sync pulse in in the time remaining?
                if (timeToSyncMs <= sampleAllowanceMs) {
                    // Grab the remainder of this tick's beeper state
                    intervalTotal += timeToSyncMs * tickRateEngine.getBeeperState();
                    sampleAllowanceMs -= timeToSyncMs;

                    // Fire the sync pulse and take the next tick.
                    fireSync();
                    tickRatePositionMs = tickRateEngine.tick();
                }
            }

            double timeToTickMs = tickRatePositionMs - syncAccumulatorMs;
            // Does the next tick fall within our remaining sample allowance?
            if (timeToTickMs <= sampleAllowanceMs) {
                // Chomp the tick, advance the accumulator, take the next tick.
                intervalTotal += timeToTickMs * tickRateEngine.getBeeperState();
                sampleAllowanceMs -= timeToTickMs;
                syncAccumulatorMs = tickRatePositionMs;
                tickRatePositionMs = tickRateEngine.tick();
            } else {
                // Chomp the remaining sample allowance, don't take another tick yet.
                intervalTotal += sampleAllowanceMs * tickRateEngine.getBeeperState();
                syncAccumulatorMs += sampleAllowanceMs;
                break;
            }
        }

        return filter.applyAsDouble(intervalTotal * SAMPLE_LENGTH_MS_RECIPROCAL);
    }

    private void fireSync() {
        for (int i=0; i<4; i++) {
            double frequencyHz = C2 * Math.pow(2.0, vocts[i]);
            phaseDeltas[i] = (int) (frequencyHz * frequencyMult);
        }

        syncAccumulatorMs = 0.0;
        tickRateEngine.initialiseSync(
                phaseDeltas,
                pulseWidths,
                gates,
                resetPhase
        );
    }

}

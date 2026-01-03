package com.vulpuslabs.modules.piezo;

final class TickRateEngine {

    private final int[] phaseAccumulators = new int[4];
    private final int[] phaseDeltas = new int[4];
    private final int[] pulseWidths = new int[3];
    private final boolean[] gates = new boolean[4];
    private final boolean[] beeperStates = new boolean[4];

    private double tickLengthMs;
    private double timeAllowanceMs;
    private MixMode mixMode = MixMode.OR;
    private int interleaveSelector = 0;

    private double beeperState;
    private double timeSinceSyncMs;

    private final LFSR noiseLFSR = new LFSR();
    private int previousNoisePhase;

    private final LFSR jitterLFSR = new LFSR();
    private double jitter;

    public void setMixMode(MixMode mixMode) {
        this.mixMode = mixMode;
    }

    public void setTickLengthMs(double tickLengthMs) {
        this.tickLengthMs = tickLengthMs;
    }

    public void setTimeAllowanceMs(double timeAllowanceMs) {
        this.timeAllowanceMs = timeAllowanceMs;
    }

    public void setJitter(double jitter) {
        this.jitter = jitter * 0.001;
    }

    public void initialiseSync(int[] phaseDeltas, int[] pulseWidths, boolean[] gates, boolean resetPhase) {
        System.arraycopy(phaseDeltas, 0, this.phaseDeltas, 0, 4);
        System.arraycopy(gates, 0, this.gates, 0, 4);
        System.arraycopy(pulseWidths, 0, this.pulseWidths, 0, 3);

        if (resetPhase) {
            for (int i = 0; i < 4; i++) {
                phaseAccumulators[i] = 0;
            }
        }

        if (mixMode == MixMode.INTERLEAVE) {
            for (int i = 0; i < 4; i++) {
                interleaveSelector = (interleaveSelector + 1) & 0x03;
                if (gates[interleaveSelector]) break;
            }
        }

        timeSinceSyncMs = 0.0;
    }

    public double tick() {
        timeSinceSyncMs += tickLengthMs + (jitter * ((jitterLFSR.getNextByte() & 0xF) - 7.5));
        if (timeSinceSyncMs > timeAllowanceMs) {
            return timeSinceSyncMs;
        }

        for (int i = 0; i < 3; i++) {
            int currentPhase = (phaseAccumulators[i] + phaseDeltas[i]) & 0xFFFF;
            phaseAccumulators[i] = currentPhase;
            beeperStates[i] = gates[i] & (currentPhase > pulseWidths[i]);
        }

        // Noise channel (3) - LFSR clocked at the specified rate
        int currentPhase = (phaseAccumulators[3] + phaseDeltas[3]) & 0xFFFF;
        phaseAccumulators[3] = currentPhase;

        // Clock the LFSR when phase wraps (changes from high to low)
        if (gates[3] && currentPhase < previousNoisePhase) {
            noiseLFSR.clock();
        }
        previousNoisePhase = currentPhase;
        beeperStates[3] = gates[3] & noiseLFSR.getBoolean();

        beeperState = mixMode.mixVoices(beeperStates, interleaveSelector);

        return timeSinceSyncMs;
    }

    public double getBeeperState() {
        return beeperState;
    }
}

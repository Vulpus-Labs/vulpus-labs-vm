package com.vulpuslabs.modules.piezo;

public class SpectrumEngine {

    private static final double SYNC_LENGTH_MS_PAL = 1000.0 / 50.0;
    private static final double SYNC_LENGTH_NTSC = 1000.0 / 60.0;
    private static final double SAMPLE_LENGTH_MS = 1000.0 / 48000.0;
    private static final double CYCLE_LENGTH_MS = 1000.0 / 3_500_000.0;
    private static final double C2 = 65.406;
    private static final int SAMPLE_RATE = 48000;
    private static final double PIEZO_CUTOFF_FREQ = 300.0; // Typical piezo buzzer high-pass cutoff

    private double syncLengthMs;
    private double syncAccumulator;
    private double tickLengthMs;
    private double tickLengthMsReciprocal;
    private double frequencyMult;

    // High-pass filter for piezo simulation
    private final HighPassFilter highPassFilter = new HighPassFilter(PIEZO_CUTOFF_FREQ, SAMPLE_RATE);

    private final int[] startPhase = new int[4];
    private final int[] phase = new int[4];
    private final int[] rates = new int[4];
    private final int[] currentPulseWidth = new int[4];
    private final boolean[] playing = new boolean[4];
    private final boolean[] toggle = new boolean[4];
    private final double[] vocts = new double[4];
    private final boolean[] gates = new boolean[4];
    private final int[] pulseWidths = new int[4];
    private int previousTick;
    private int budgetedTicksPerSync;
    private boolean beeperState;
    private double output;
    private double audioBudgetPercent;
    private int tickLengthInCycles;
    private boolean resetPhase;
    private MixMode mixMode = MixMode.INTERLEAVE;
    private int interleaveSelector = 0;
    private int interleaveCounter;

    // Noise channel state
    private final LFSR noiseLFSR = new LFSR();
    private int noisePhase = 0;

    public SpectrumEngine() {
        for (int i=0; i<4; i++) {
            currentPulseWidth[i] = 0x7FFF;
        }
        setSyncToPal();
        setTickLengthInCycles(50);
        setAudioBudgetPercent(50.0);
    }

    public void setMixMode(MixMode mixMode) {
        this.mixMode = mixMode;
    }

    public void setChannel(int channel, double voct, boolean gate, int pulseWidth) {
        vocts[channel] = voct;
        gates[channel] = gate;
        pulseWidths[channel] = pulseWidth;
    }

    public void setSyncToPal() {
        syncLengthMs = SYNC_LENGTH_MS_PAL;
        recalculate();
    }

    public void setSyncToNtsc() {
        syncLengthMs = SYNC_LENGTH_NTSC;
        recalculate();
    }

    public void setResetPhase(boolean resetPhase) {
        this.resetPhase = resetPhase;
    }

    public void setTickLengthInCycles(int cycles) {
        this.tickLengthInCycles = cycles;
        recalculate();
    }

    public void setAudioBudgetPercent(double audioBudgetPercent) {
        this.audioBudgetPercent = audioBudgetPercent;
        recalculate();
    }

    private void recalculate() {
        tickLengthMs = CYCLE_LENGTH_MS * tickLengthInCycles;
        tickLengthMsReciprocal = 1.0 / tickLengthMs;
        frequencyMult =  tickLengthMs * 0x10000 * 0.001;

        double ticksPerSync = syncLengthMs / tickLengthMs;
        budgetedTicksPerSync = (int) (ticksPerSync * audioBudgetPercent / 100);
    }

    public double processSample() {
        syncAccumulator += SAMPLE_LENGTH_MS;

        if (syncAccumulator > syncLengthMs) {
            syncAccumulator -= syncLengthMs;
            initialiseSync();
        }

        int currentTick = Math.min(budgetedTicksPerSync, (int) (syncAccumulator * tickLengthMsReciprocal));

        if (currentTick != previousTick) {
            updateOutput(currentTick);
            previousTick = currentTick;
        }

        return highPassFilter.process(output);
    }

    private void updateOutput(int currentTick) {
        // Regular tone channels (0-2)
        for (int i = 0; i < 3; i++) {
            int currentPhase = (startPhase[i] + (currentTick * rates[i])) & 0xFFFF;
            toggle[i] = playing[i] & (currentPhase > currentPulseWidth[i]);
            phase[i] = currentPhase;
        }

        // Noise channel (3) - LFSR clocked at the specified rate
        int currentPhase = (startPhase[3] + (currentTick * rates[3])) & 0xFFFF;
        phase[3] = currentPhase;

        // Clock the LFSR when phase wraps (changes from high to low)
        if (playing[3] && currentPhase < noisePhase) {
            noiseLFSR.clock();
        }
        noisePhase = currentPhase;
        toggle[3] = playing[3] & noiseLFSR.getOutput();

        mixVoices();
    }

    private void mixVoices() {
        switch (mixMode) {
            case XOR -> {
                beeperState = false;
                for (int i=0; i<4; i++) {
                    beeperState = beeperState ^ toggle[i];
                }
                output = beeperState ? 5.0 : 0.0;
            }
            case OR -> {
                beeperState = false;
                for (int i=0; i<4; i++) {
                    beeperState = beeperState | toggle[i];
                }
                output = beeperState ? 5.0 : 0.0;
            }
            case QUAD -> {
                output = 0.0;
                for (int i = 0; i < 4; i++) {
                    output += toggle[i] ? 1.25 : 0.0;
                }
            }
            case INTERLEAVE -> output = toggle[interleaveSelector] ? 5.0 : 0.0;
        }
    }

    private void initialiseSync() {
        for (int i=0; i<4; i++) {
            startPhase[i] = resetPhase ? 0 : phase[i];
            currentPulseWidth[i] = pulseWidths[i];
            rates[i] = calculateRate(vocts[i]);
            playing[i] = gates[i];
        }
        if (mixMode == MixMode.INTERLEAVE) {
            for (int i = 0; i < 4; i++) {
                interleaveSelector = (interleaveSelector + 1) & 0x03;
                if (playing[interleaveSelector]) break;
            }
        }
    }

    private int calculateRate(double voct) {
        double frequencyHz = C2 * Math.pow(2.0, voct);
        return (int) (frequencyHz * frequencyMult);
    }
}

package com.vulpuslabs.modules.rkw2;

import java.util.function.DoubleUnaryOperator;

public class SoundEngine {

    private static final double C2 = 65.41;
    private static final int LAST_VCO = 0;
    private static final int PHASE = 1;
    private static final int PHASE_DELTA = 2;
    private static final int PULSE_WIDTH = 3;
    private static final int ON = 0;
    private static final int OFF = 1;

    private final double sampleRateReciprocal;
    private final double[] oscillators = new double[64];
    private final int[] pulseTrain = new int[8];
    private double jitterAmount;
    private int pulseSize;
    private double pulseScaling;

    private int activeChannels;
    private int pulseTrainRead = 0;
    private int pulseTrainWrite = 0;
    private int rng = 0x12345678;

    private DoubleUnaryOperator filter = FilterProfile.PIEZO.getFilter();

    public SoundEngine(double sampleRate) {
        this.sampleRateReciprocal = 1.0 / sampleRate;
    }

    public void setJitter(double jitter) {
        jitterAmount = jitter * 0.01 / 32768.0;
    }

    public void setPulseSize(int pulseSize) {
        this.pulseSize = pulseSize;
        this.pulseScaling = (pulseSize - 2) * 0.2;
    }

    public void setFilterProfile(FilterProfile filterProfile) {
        this.filter = filterProfile.getFilter();
    }

    public void updateChannel(int channel, double vco, double velocity) {
        boolean isActive = velocity > 0.0;
        activeChannels = isActive
            ? activeChannels | 1 << channel
            : activeChannels & ~(1 << channel);

        if (!isActive) return;

        int oscillatorPtr = channel << 2;
        if (oscillators[oscillatorPtr + LAST_VCO] != vco) {
            oscillators[oscillatorPtr + LAST_VCO] = vco;
            oscillators[oscillatorPtr + PHASE_DELTA] = C2 * (Math.pow(2.0, vco - 1.0)) * sampleRateReciprocal;
        }

        oscillators[oscillatorPtr + PULSE_WIDTH] = velocity;
    };

    private int fastRandom() {
        rng = rng * 1664525 + 1013904223;
        return ((rng >>> 16) & 0xFFFF) - 32768;
    }

    public double processSample() {
        return filter.applyAsDouble(
        (processSample96khz() + processSample96khz()) * 0.5);
    }

    private double processSample96khz() {
        int channelBits = activeChannels;

        while (channelBits != 0) {
            int channel = Integer.numberOfTrailingZeros(channelBits);
            addToPulseTrain(channel << 2);
            channelBits &= channelBits - 1;  // clear lowest set bit
        }

        return readPulseTrain();
    }

    private double readPulseTrain() {
        if (pulseTrainRead == pulseTrainWrite) {
            return 0.0;
        }

        int currentPulsePtr = pulseTrainRead << 1;
        if (pulseTrain[currentPulsePtr + ON] > 0) {
            pulseTrain[currentPulsePtr + ON]--;
            return 5.0;
        }

        if (pulseTrain[currentPulsePtr + OFF] > 0) {
            pulseTrain[currentPulsePtr + OFF]--;
            return 0.0;
        }

        pulseTrainRead = (pulseTrainRead + 1) & 0x3;
        return 0.0;
    }

    private void addToPulseTrain(int oscillatorPtr) {
        double newPhase = oscillators[oscillatorPtr + PHASE] - oscillators[oscillatorPtr + PHASE_DELTA];

        if (newPhase > 0.0) {
           oscillators[oscillatorPtr + PHASE] = newPhase;
           return;
        }

        double jitter = fastRandom() * jitterAmount * Integer.bitCount(activeChannels);
        oscillators[oscillatorPtr + PHASE] = newPhase + 1.0 + jitter;

        int newWrite = (pulseTrainWrite + 1) & 0x3;
        if (newWrite == pulseTrainRead) return;

        pulseTrainWrite = newWrite;
        int pulsePtr = pulseTrainWrite << 1;

        int onLength = 1 + (int) (oscillators[oscillatorPtr + PULSE_WIDTH] * pulseScaling);
        pulseTrain[pulsePtr + ON] = onLength;
        pulseTrain[pulsePtr + OFF] = pulseSize - onLength;
    }

}
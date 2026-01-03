package com.vulpuslabs.modules.piezo;

import java.util.function.DoubleUnaryOperator;

/**
 * Filter profiles for different audio output characteristics.
 * Each profile defines a three-stage filter chain: high-pass, peak, and low-pass.
 */
public enum FilterProfile {

    /**
     * Direct piezo beeper output.
     * - High-pass at 300Hz removes sub-bass rumble
     * - Peak at 2500Hz with high Q adds characteristic resonant "beep"
     * - Low-pass at 5000Hz simulates cone's physical bandwidth limit
     */
    PIEZO(
        300.0,   // highPassFreq
        5000.0,  // lowPassFreq
        2500.0,  // peakFreq
        1.5,     // peakQ
        6.0      // peakGainDb
    ),

    /**
     * 1980s TV speaker.
     * - High-pass at 200Hz (small speaker bass roll-off)
     * - Peak at 800Hz with moderate Q (cabinet/cone resonance)
     * - Low-pass at 8000Hz (limited treble extension)
     */
    TV_SPEAKER(
        200.0,   // highPassFreq
        8000.0,  // lowPassFreq
        800.0,   // peakFreq
        1.0,     // peakQ
        3.0      // peakGainDb
    );

    private static final int SAMPLE_RATE = 48_000;
    private final double highPassFreq;
    private final double lowPassFreq;
    private final double peakFreq;
    private final double peakQ;
    private final double peakGainDb;

    FilterProfile(double highPassFreq, double lowPassFreq, double peakFreq, double peakQ, double peakGainDb) {
        this.highPassFreq = highPassFreq;
        this.lowPassFreq = lowPassFreq;
        this.peakFreq = peakFreq;
        this.peakQ = peakQ;
        this.peakGainDb = peakGainDb;
    }

    public DoubleUnaryOperator getFilter() {
        HighPassFilter highPassFilter = new HighPassFilter(highPassFreq, SAMPLE_RATE);
        PeakFilter peakFilter = new PeakFilter(peakFreq, peakQ, peakGainDb, SAMPLE_RATE);
        LowPassFilter lowPassFilter = new LowPassFilter(lowPassFreq, SAMPLE_RATE);

        return (input) -> lowPassFilter.process(
                peakFilter.process(
                        highPassFilter.process(input)
                )
        );
    }
}

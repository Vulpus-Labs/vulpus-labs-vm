package com.vulpuslabs.modules.piezo;

/**
 * Second-order peak/bell filter for adding resonant character to the beeper sound.
 * Uses a biquad filter structure to create a boost at a specific frequency.
 *
 * This emulates the resonant characteristics of the piezo beeper cone,
 * which typically has a resonant peak in the midrange frequencies.
 */
public class PeakFilter {

    private final double b0, b1, b2, a1, a2;
    private double x1 = 0.0, x2 = 0.0;  // Previous inputs
    private double y1 = 0.0, y2 = 0.0;  // Previous outputs

    /**
     * Create a peak filter with the specified parameters.
     * @param centerFrequency the center frequency of the peak in Hz
     * @param Q the Q factor (resonance) - higher values = narrower peak. Typical range 0.5-5.0
     * @param gainDb the gain at the center frequency in dB. Typical range 0-12 dB
     * @param sampleRate the audio sample rate in Hz
     */
    public PeakFilter(double centerFrequency, double Q, double gainDb, int sampleRate) {
        double A = Math.pow(10.0, gainDb / 40.0);
        double omega = 2.0 * Math.PI * centerFrequency / sampleRate;
        double sinOmega = Math.sin(omega);
        double cosOmega = Math.cos(omega);
        double alpha = sinOmega / (2.0 * Q);

        // Biquad coefficients for peaking EQ
        double a0 = 1.0 + alpha / A;
        this.b0 = (1.0 + alpha * A) / a0;
        this.b1 = (-2.0 * cosOmega) / a0;
        this.b2 = (1.0 - alpha * A) / a0;
        this.a1 = (-2.0 * cosOmega) / a0;
        this.a2 = (1.0 - alpha / A) / a0;
    }

    /**
     * Process a single sample through the filter.
     * @param input the input sample
     * @return the filtered output sample
     */
    public double process(double input) {
        double output = b0 * input + b1 * x1 + b2 * x2 - a1 * y1 - a2 * y2;

        // Shift history
        x2 = x1;
        x1 = input;
        y2 = y1;
        y1 = output;

        return output;
    }

    /**
     * Reset the filter state to zero.
     */
    public void reset() {
        x1 = x2 = 0.0;
        y1 = y2 = 0.0;
    }
}

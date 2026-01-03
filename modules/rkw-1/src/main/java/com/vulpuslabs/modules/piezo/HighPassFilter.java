package com.vulpuslabs.modules.piezo;

/**
 * Simple first-order high-pass RC filter.
 * Uses the difference equation: y[n] = alpha * (y[n-1] + x[n] - x[n-1])
 * where alpha = RC / (RC + dt) and RC = 1 / (2 * pi * fc)
 */
public class HighPassFilter {

    private final double alpha;
    private double x1 = 0.0;  // Previous input
    private double y1 = 0.0;  // Previous output

    /**
     * Create a high-pass filter with the specified cutoff frequency.
     * @param cutoffFrequency the cutoff frequency in Hz
     * @param sampleRate the audio sample rate in Hz
     */
    public HighPassFilter(double cutoffFrequency, int sampleRate) {
        double rc = 1.0 / (2.0 * Math.PI * cutoffFrequency);
        double dt = 1.0 / sampleRate;
        this.alpha = rc / (rc + dt);
    }

    /**
     * Process a single sample through the filter.
     * @param input the input sample
     * @return the filtered output sample
     */
    public double process(double input) {
        double output = alpha * (y1 + input - x1);
        x1 = input;
        y1 = output;
        return output;
    }

    /**
     * Reset the filter state to zero.
     */
    public void reset() {
        x1 = 0.0;
        y1 = 0.0;
    }
}

package com.vulpuslabs.modules.piezo;

/**
 * Simple first-order low-pass RC filter.
 * Uses the difference equation: y[n] = alpha * x[n] + (1 - alpha) * y[n-1]
 * where alpha = dt / (RC + dt) and RC = 1 / (2 * pi * fc)
 */
public class LowPassFilter {

    private final double alpha;
    private double y1 = 0.0;  // Previous output

    /**
     * Create a low-pass filter with the specified cutoff frequency.
     * @param cutoffFrequency the cutoff frequency in Hz
     * @param sampleRate the audio sample rate in Hz
     */
    public LowPassFilter(double cutoffFrequency, int sampleRate) {
        double rc = 1.0 / (2.0 * Math.PI * cutoffFrequency);
        double dt = 1.0 / sampleRate;
        this.alpha = dt / (rc + dt);
    }

    /**
     * Process a single sample through the filter.
     * @param input the input sample
     * @return the filtered output sample
     */
    public double process(double input) {
        double output = alpha * input + (1.0 - alpha) * y1;
        y1 = output;
        return output;
    }

    /**
     * Reset the filter state to zero.
     */
    public void reset() {
        y1 = 0.0;
    }
}

package com.vulpuslabs.modules.prismatic;

public class ButterworthLPF {
    private double x1, x2;  // Previous input samples
    private double y1, y2;  // Previous output samples

    // Filter coefficients
    private double a0, a1, a2;
    private double b1, b2;

    public ButterworthLPF(double sampleRate, double cutoffFreq) {
        calculateCoefficients(sampleRate, cutoffFreq);
        reset();
    }

    private void calculateCoefficients(double sampleRate, double cutoffFreq) {
        double omega = 2.0 * Math.PI * cutoffFreq / sampleRate;
        double cosOmega = Math.cos(omega);
        double sinOmega = Math.sin(omega);
        double alpha = sinOmega / (2.0 * 0.707);  // Q = 0.707 for Butterworth

        // Calculate coefficients
        double b0 = (1.0 - cosOmega) / 2.0;
        double b1_temp = 1.0 - cosOmega;
        double b2_temp = (1.0 - cosOmega) / 2.0;
        double a0_temp = 1.0 + alpha;
        double a1_temp = -2.0 * cosOmega;
        double a2_temp = 1.0 - alpha;

        // Normalize by a0
        a0 = b0 / a0_temp;
        a1 = b1_temp / a0_temp;
        a2 = b2_temp / a0_temp;
        b1 = a1_temp / a0_temp;
        b2 = a2_temp / a0_temp;
    }

    public void reset() {
        x1 = x2 = 0.0;
        y1 = y2 = 0.0;
    }

    public double process(double input) {
        // Direct Form II implementation
        double output = a0 * input + a1 * x1 + a2 * x2 - b1 * y1 - b2 * y2;

        // Shift samples
        x2 = x1;
        x1 = input;
        y2 = y1;
        y1 = output;

        return output;
    }
}

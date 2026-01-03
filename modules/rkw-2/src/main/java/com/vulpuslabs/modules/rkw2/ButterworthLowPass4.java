package com.vulpuslabs.modules.rkw2;
package com.vulpuslabs.modules.rkw2;

/**
 * 4th-order Butterworth low-pass filter implemented as two cascaded biquad sections.
 * Provides 24dB/octave roll-off for anti-aliasing applications.
 */
public class ButterworthLowPass4 {

    private final Biquad stage1;
    private final Biquad stage2;

    /**
     * Create a 4th-order Butterworth low-pass filter.
     * @param cutoffFrequency the cutoff frequency in Hz
     * @param sampleRate the audio sample rate in Hz
     */
    public ButterworthLowPass4(double cutoffFrequency, int sampleRate) {
        double[] coeffs1 = new double[5];
        double[] coeffs2 = new double[5];
        computeCoefficients(cutoffFrequency, sampleRate, coeffs1, coeffs2);

        stage1 = new Biquad(coeffs1);
        stage2 = new Biquad(coeffs2);
    }

    private void computeCoefficients(double fc, int fs, double[] coeffs1, double[] coeffs2) {
        // Prewarp the cutoff frequency
        double wc = 2.0 * Math.PI * fc;
        double T = 1.0 / fs;
        double wa = (2.0 / T) * Math.tan(wc * T / 2.0);

        // 4th-order Butterworth has two conjugate pole pairs
        // Poles at angles: pi*3/8, pi*5/8, pi*11/8, pi*13/8 (normalised to unit circle)
        // Q values for each biquad section
        double Q1 = 1.0 / (2.0 * Math.cos(Math.PI * 3.0 / 8.0));  // ~0.541
        double Q2 = 1.0 / (2.0 * Math.cos(Math.PI * 1.0 / 8.0));  // ~1.307

        computeBiquadCoeffs(wa, T, Q1, coeffs1);
        computeBiquadCoeffs(wa, T, Q2, coeffs2);
    }

    private void computeBiquadCoeffs(double wa, double T, double Q, double[] coeffs) {
        // Bilinear transform of s-domain prototype: H(s) = wa^2 / (s^2 + wa/Q * s + wa^2)
        double wa2 = wa * wa;
        double twoOverT = 2.0 / T;
        double twoOverT2 = twoOverT * twoOverT;
        double waOverQ = wa / Q;

        double a0 = twoOverT2 + waOverQ * twoOverT + wa2;

        // Normalised coefficients
        coeffs[0] = wa2 / a0;                                    // b0
        coeffs[1] = 2.0 * wa2 / a0;                              // b1
        coeffs[2] = wa2 / a0;                                    // b2
        coeffs[3] = (2.0 * wa2 - 2.0 * twoOverT2) / a0;          // a1
        coeffs[4] = (twoOverT2 - waOverQ * twoOverT + wa2) / a0; // a2
    }

    /**
     * Process a single sample through the filter.
     * @param input the input sample
     * @return the filtered output sample
     */
    public double process(double input) {
        return stage2.process(stage1.process(input));
    }

    /**
     * Reset the filter state to zero.
     */
    public void reset() {
        stage1.reset();
        stage2.reset();
    }

    /**
     * Transposed Direct Form II biquad implementation.
     */
    private static class Biquad {
        private final double b0, b1, b2, a1, a2;
        private double z1 = 0.0;
        private double z2 = 0.0;

        Biquad(double[] coeffs) {
            this.b0 = coeffs[0];
            this.b1 = coeffs[1];
            this.b2 = coeffs[2];
            this.a1 = coeffs[3];
            this.a2 = coeffs[4];
        }

        double process(double input) {
            double output = b0 * input + z1;
            z1 = b1 * input - a1 * output + z2;
            z2 = b2 * input - a2 * output;
            return output;
        }

        void reset() {
            z1 = 0.0;
            z2 = 0.0;
        }
    }
}
package com.codepoetics.fourier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealPackedFFTTest {

    private static final double EPSILON = 1e-5f;

    @Test
    void testConstructorValidSizes() {
        assertDoesNotThrow(() -> new RealPackedFFT(4));
        assertDoesNotThrow(() -> new RealPackedFFT(8));
        assertDoesNotThrow(() -> new RealPackedFFT(16));
        assertDoesNotThrow(() -> new RealPackedFFT(1024));
        assertDoesNotThrow(() -> new RealPackedFFT(4096));
    }

    @Test
    void testConstructorInvalidSizes() {
        assertThrows(IllegalArgumentException.class, () -> new RealPackedFFT(0));
        assertThrows(IllegalArgumentException.class, () -> new RealPackedFFT(2));
        assertThrows(IllegalArgumentException.class, () -> new RealPackedFFT(3));
        assertThrows(IllegalArgumentException.class, () -> new RealPackedFFT(100));
        assertThrows(IllegalArgumentException.class, () -> new RealPackedFFT(1000));
    }

    @Test
    void testKnownDFT4() {
        // Test against hand-computed DFT of [1, 2, 3, 4]
        RealPackedFFT fft = new RealPackedFFT(4);
        double[] buf = {1, 2, 3, 4};
        double[] spectrum = fft.forward(buf);

        // X[0] = 10, X[1] = -2+2j, X[2] = -2
        // Packed: [X[0].re, X[2].re, X[1].re, X[1].im] = [10, -2, -2, 2]
        double[] expected = {10, -2, -2, 2};

        for (int i = 0; i < 4; i++) {
            assertEquals(expected[i], spectrum[i], EPSILON, "Mismatch at index " + i);
        }
    }

    @Test
    void testKnownDFT8Impulse() {
        // Test against hand-computed DFT for N=8: x = [1,0,0,0,0,0,0,0] (impulse)
        RealPackedFFT fft = new RealPackedFFT(8);
        double[] buf = {1, 0, 0, 0, 0, 0, 0, 0};
        double[] spectrum = fft.forward(buf);

        // DFT of impulse = all ones: X[k] = 1 + 0j for all k
        // Packed: [X[0].re, X[4].re, X[1].re, X[1].im, X[2].re, X[2].im, X[3].re, X[3].im]
        //       = [1, 1, 1, 0, 1, 0, 1, 0]
        double[] expected = {1, 1, 1, 0, 1, 0, 1, 0};

        for (int i = 0; i < 8; i++) {
            assertEquals(expected[i], spectrum[i], EPSILON, "Mismatch at index " + i);
        }
    }

    @Test
    void testDCSignal() {
        // DC signal: x[n] = C for all n
        int n = 64;
        RealPackedFFT fft = new RealPackedFFT(n);
        double[] buf = new double[n];
        double[] original = new double[n];

        for (int i = 0; i < n; i++) {
            buf[i] = 3.5f;
            original[i] = 3.5f;
        }

        double[] spectrum = fft.forward(buf);

        // DC bin should be 3.5 * 64 = 224
        assertEquals(224.0f, spectrum[0], 1e-3f);

        // All other bins should be zero
        for (int i = 1; i < n; i++) {
            assertEquals(0.0f, spectrum[i], 1e-3f, "Non-zero value at index " + i);
        }

        // Test round-trip
        double[] output = fft.inverse(spectrum);
        for (int i = 0; i < n; i++) {
            assertEquals(original[i], output[i], 1e-3f, "Mismatch at index " + i);
        }
    }

    @Test
    void testNyquistSignal() {
        // Nyquist signal: x[n] = (-1)^n
        int n = 64;
        RealPackedFFT fft = new RealPackedFFT(n);
        double[] buf = new double[n];
        double[] original = new double[n];

        for (int i = 0; i < n; i++) {
            double val = (i % 2 == 0) ? 1.0f : -1.0f;
            buf[i] = val;
            original[i] = val;
        }

        double[] spectrum = fft.forward(buf);

        // Only the Nyquist bin (index 1 in packed format) should be nonzero: 64
        assertEquals(64.0f, spectrum[1], 1e-3f);
        assertEquals(0.0f, spectrum[0], 1e-3f);

        for (int i = 2; i < n; i++) {
            assertEquals(0.0f, spectrum[i], 1e-3f, "Non-zero value at index " + i);
        }

        // Round-trip
        double[] output = fft.inverse(spectrum);
        for (int i = 0; i < n; i++) {
            assertEquals(original[i], output[i], 1e-3f, "Mismatch at index " + i);
        }
    }

    @Test
    void testSinusoid() {
        // Pure sinusoid at bin 5
        int n = 256;
        int bin = 5;
        RealPackedFFT fft = new RealPackedFFT(n);

        double[] buf = new double[n];
        double[] original = new double[n];

        for (int i = 0; i < n; i++) {
            double val = (double) Math.cos(2.0 * Math.PI * bin * i / n);
            buf[i] = val;
            original[i] = val;
        }

        double[] spectrum = fft.forward(buf);

        // For cos at bin 5: X[5] = N/2 = 128
        // In packed format X[5] is at indices [10, 11]
        assertEquals(n / 2.0f, spectrum[2 * bin], 1e-3f);
        assertEquals(0.0f, spectrum[2 * bin + 1], 1e-3f);

        // All other bins should be near zero
        for (int i = 0; i < n; i++) {
            if (i == 2 * bin || i == 2 * bin + 1) continue;
            assertEquals(0.0f, spectrum[i], 1e-3f, "Non-zero value at index " + i);
        }

        // Round-trip
        for (int i = 0; i < n; i++) buf[i] = original[i];
        double[] spectrum2 = fft.forward(buf);
        double[] output = fft.inverse(spectrum2);

        for (int i = 0; i < n; i++) {
            assertEquals(original[i], output[i], 1e-3f, "Mismatch at index " + i);
        }
    }

    @Test
    void testRoundTrip4() {
        testRoundTrip(4);
    }

    @Test
    void testRoundTrip8() {
        testRoundTrip(8);
    }

    @Test
    void testRoundTrip16() {
        testRoundTrip(16);
    }

    @Test
    void testRoundTrip64() {
        testRoundTrip(64);
    }

    @Test
    void testRoundTrip256() {
        testRoundTrip(256);
    }

    @Test
    void testRoundTrip1024() {
        testRoundTrip(1024);
    }

    @Test
    void testRoundTrip2048() {
        testRoundTrip(2048);
    }

    @Test
    void testRoundTrip4096() {
        testRoundTrip(4096);
    }

    private void testRoundTrip(int n) {
        RealPackedFFT fft = new RealPackedFFT(n);

        double[] original = new double[n];
        double[] input = new double[n];

        // Generate a test signal with mixed frequencies
        for (int i = 0; i < n; i++) {
            original[i] = (double) (
                    1.0 +
                            0.7 * Math.sin(2.0 * Math.PI * 3 * i / n) +
                            0.3 * Math.cos(2.0 * Math.PI * 7 * i / n + 0.5) +
                            0.1 * Math.sin(2.0 * Math.PI * (n / 4) * i / n)
            );
            input[i] = original[i];
        }

        // Forward
        double[] spectrum = fft.forward(input);

        // Inverse
        double[] output = fft.inverse(spectrum);

        // Compare
        for (int i = 0; i < n; i++) {
            assertEquals(original[i], output[i], 1e-4f, "Mismatch at index " + i);
        }
    }

    // ========================================================================
    //  Spectrum Manipulation Tests
    // ========================================================================

    @Test
    void testDCRemoval() {
        // Test DC removal by zeroing out the DC bin
        int n = 256;
        RealPackedFFT fft = new RealPackedFFT(n);

        double dcOffset = 2.5f;
        double[] input = new double[n];
        double[] originalInput = new double[n];

        // Generate a signal with a DC offset and some AC components
        for (int i = 0; i < n; i++) {
            double value = dcOffset +
                          (double) (0.7 * Math.sin(2.0 * Math.PI * 5 * i / n) +
                                   0.3 * Math.cos(2.0 * Math.PI * 10 * i / n));
            input[i] = value;
            originalInput[i] = value;
        }

        // Forward transform (input array is destroyed)
        double[] spectrum = fft.forward(input);

        // Verify DC component is present
        double expectedDC = dcOffset * n;
        assertEquals(expectedDC, spectrum[0], 1.0f, "DC component should be present");

        // Zero out the DC bin (index 0 in packed format)
        spectrum[0] = 0.0f;

        // Inverse transform (spectrum array is destroyed)
        double[] output = fft.inverse(spectrum);

        // The output should be the original signal with DC offset removed
        // i.e., the AC components only
        for (int i = 0; i < n; i++) {
            double expectedValue = originalInput[i] - dcOffset;
            assertEquals(expectedValue, output[i], 1e-3f,
                        "Output at index " + i + " should have DC removed");
        }

        // Verify the mean of the output is near zero (DC removed)
        double mean = 0;
        for (int i = 0; i < n; i++) {
            mean += output[i];
        }
        mean /= n;
        assertEquals(0.0f, mean, 1e-4f, "Mean should be zero after DC removal");
    }

    @Test
    void testPhaseNormalization() {
        // Test phase normalization: zero out all phases in the spectrum
        int n = 256;
        RealPackedFFT fft = new RealPackedFFT(n);

        double[] input = new double[n];
        double[] expectedOutput = new double[n];

        // Generate a signal with sinusoids at different phases
        // We'll use cosines at various phases, which after normalization should become pure cosines (phase 0)
        for (int i = 0; i < n; i++) {
            // Bin 5: cosine with phase π/4
            // Bin 10: cosine with phase π/2 (becomes a sine)
            // Bin 15: cosine with phase π
            input[i] = (double) (
                    0.8 * Math.cos(2.0 * Math.PI * 5 * i / n + Math.PI / 4) +
                    0.5 * Math.cos(2.0 * Math.PI * 10 * i / n + Math.PI / 2) +
                    0.3 * Math.cos(2.0 * Math.PI * 15 * i / n + Math.PI)
            );

            // Expected: same frequencies but with zero phase (pure cosines)
            expectedOutput[i] = (double) (
                    0.8 * Math.cos(2.0 * Math.PI * 5 * i / n) +
                    0.5 * Math.cos(2.0 * Math.PI * 10 * i / n) +
                    0.3 * Math.cos(2.0 * Math.PI * 15 * i / n)
            );
        }

        // Forward transform
        double[] spectrum = fft.forward(input);

        // Normalize phases: set phase to zero for each bin while preserving magnitude
        // DC bin (index 0) is already real
        // Nyquist bin (index 1) is already real

        // For bins 1 to N/2-1, stored as [2k, 2k+1] = [real, imag]
        // Magnitude = sqrt(real^2 + imag^2)
        // Phase = atan2(imag, real)
        // To set phase to 0: real = magnitude, imag = 0

        for (int k = 1; k < n / 2; k++) {
            int idx = 2 * k;  // Real part index in packed format
            double re = spectrum[idx];
            double im = spectrum[idx + 1];

            // Compute magnitude
            double magnitude = (double) Math.sqrt(re * re + im * im);

            // Set to magnitude with zero phase: (magnitude, 0)
            spectrum[idx] = magnitude;
            spectrum[idx + 1] = 0.0f;
        }

        // Inverse transform
        double[] output = fft.inverse(spectrum);

        // The output should match the expected phase-normalized signal
        for (int i = 0; i < n; i++) {
            assertEquals(expectedOutput[i], output[i], 1e-3f,
                        "Output at index " + i + " should be phase-normalized");
        }
    }
}

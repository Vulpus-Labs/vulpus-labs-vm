package com.codepoetics.fourier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealUnpackedFFTTest {

    private static final double EPSILON = 1e-5;

    @Test
    void testConstructorValidSizes() {
        assertDoesNotThrow(() -> new RealUnpackedFFT(4));
        assertDoesNotThrow(() -> new RealUnpackedFFT(8));
        assertDoesNotThrow(() -> new RealUnpackedFFT(16));
        assertDoesNotThrow(() -> new RealUnpackedFFT(1024));
        assertDoesNotThrow(() -> new RealUnpackedFFT(4096));
    }

    @Test
    void testConstructorInvalidSizes() {
        assertThrows(IllegalArgumentException.class, () -> new RealUnpackedFFT(0));
        assertThrows(IllegalArgumentException.class, () -> new RealUnpackedFFT(2));
        assertThrows(IllegalArgumentException.class, () -> new RealUnpackedFFT(3));
        assertThrows(IllegalArgumentException.class, () -> new RealUnpackedFFT(100));
        assertThrows(IllegalArgumentException.class, () -> new RealUnpackedFFT(1000));
    }

    @Test
    void testKnownDFT4() {
        // Test against hand-computed DFT of [1, 2, 3, 4]
        RealUnpackedFFT fft = new RealUnpackedFFT(4);
        double[] buf = {1, 0, 2, 0, 3, 0, 4, 0}; // Interleaved [re, im]
        double[] spectrum = fft.forward(buf);

        // X[0] = 10+0j, X[1] = -2+2j, X[2] = -2+0j, X[3] = -2-2j
        double[] expected = {10, 0, -2, 2, -2, 0, -2, -2};

        for (int i = 0; i < 8; i++) {
            assertEquals(expected[i], spectrum[i], EPSILON, "Mismatch at index " + i);
        }
    }

    @Test
    void testDCSignal() {
        // DC signal: x[n] = C for all n
        int n = 64;
        RealUnpackedFFT fft = new RealUnpackedFFT(n);
        double[] buf = new double[2 * n];
        double[] original = new double[2 * n];

        for (int i = 0; i < n; i++) {
            buf[2 * i] = 3.5;
            buf[2 * i + 1] = 0.0;
            original[2 * i] = 3.5;
            original[2 * i + 1] = 0.0;
        }

        double[] spectrum = fft.forward(buf);

        // DC bin should be 3.5 * 64 = 224
        assertEquals(224.0, spectrum[0], 1e-3, "DC real part");
        assertEquals(0.0, spectrum[1], 1e-3, "DC imaginary part");

        // All other bins should be zero
        for (int i = 1; i < n; i++) {
            assertEquals(0.0, spectrum[2 * i], 1e-3, "Non-zero real at bin " + i);
            assertEquals(0.0, spectrum[2 * i + 1], 1e-3, "Non-zero imag at bin " + i);
        }

        // Test round-trip
        double[] output = fft.inverse(spectrum);
        for (int i = 0; i < 2 * n; i++) {
            assertEquals(original[i], output[i], 1e-3, "Mismatch at index " + i);
        }
    }

    @Test
    void testRoundTrip() {
        testRoundTripForSize(64);
        testRoundTripForSize(256);
        testRoundTripForSize(1024);
    }

    private void testRoundTripForSize(int n) {
        RealUnpackedFFT fft = new RealUnpackedFFT(n);

        double[] original = new double[2 * n];
        double[] input = new double[2 * n];

        // Generate a test signal with mixed frequencies
        for (int i = 0; i < n; i++) {
            double value = 1.0 +
                          0.7 * Math.sin(2.0 * Math.PI * 3 * i / n) +
                          0.3 * Math.cos(2.0 * Math.PI * 7 * i / n + 0.5) +
                          0.1 * Math.sin(2.0 * Math.PI * (n / 4) * i / n);

            original[2 * i] = value;
            original[2 * i + 1] = 0.0;
            input[2 * i] = value;
            input[2 * i + 1] = 0.0;
        }

        // Forward
        double[] spectrum = fft.forward(input);

        // Inverse
        double[] output = fft.inverse(spectrum);

        // Compare (only check real parts, imaginaries should be ~0 for real input)
        for (int i = 0; i < n; i++) {
            assertEquals(original[2 * i], output[2 * i], 1e-4,
                        "Real mismatch at index " + i + " for size " + n);
            assertEquals(0.0, output[2 * i + 1], 1e-3,
                        "Imaginary should be near zero at index " + i + " for size " + n);
        }
    }

    @Test
    void testHermitianSymmetry() {
        // For real input, output should have Hermitian symmetry: X[k] = conj(X[N-k])
        int n = 256;
        RealUnpackedFFT fft = new RealUnpackedFFT(n);
        double[] buf = new double[2 * n];

        // Generate real signal
        for (int i = 0; i < n; i++) {
            buf[2 * i] = Math.sin(2.0 * Math.PI * 5 * i / n) +
                        0.5 * Math.cos(2.0 * Math.PI * 13 * i / n);
            buf[2 * i + 1] = 0.0;
        }

        double[] spectrum = fft.forward(buf);

        // Check Hermitian symmetry: X[k] = conj(X[N-k])
        // i.e., Re[k] = Re[N-k] and Im[k] = -Im[N-k]
        for (int k = 1; k < n / 2; k++) {
            int kIdx = 2 * k;
            int nMinusKIdx = 2 * (n - k);

            assertEquals(spectrum[kIdx], spectrum[nMinusKIdx], 1e-10,
                        "Real parts should match for k=" + k);
            assertEquals(spectrum[kIdx + 1], -spectrum[nMinusKIdx + 1], 1e-10,
                        "Imaginary parts should be conjugates for k=" + k);
        }

        // X[0] and X[N/2] should be purely real
        assertEquals(0.0, spectrum[1], 1e-10, "DC bin should be real");
        assertEquals(0.0, spectrum[n + 1], 1e-10, "Nyquist bin should be real");
    }
}

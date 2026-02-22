package com.codepoetics.fourier;

/**
 * Unpacked real FFT implementation for benchmarking comparison.
 *
 * This implementation:
 * - Accepts an array of length 2*N with interleaved [real, imag] pairs
 * - Input has imaginaries zeroed (real signal)
 * - Output contains full N complex values with Hermitian symmetry
 * - Pre-calculates twiddle factors and bit-reversal permutation
 * - Performs in-place transform (destructive)
 */
public class RealUnpackedFFT {
    private final int n;           // FFT size
    private final int[] bitReverse; // Bit-reversal permutation indices
    private final double[] cosTable; // Pre-calculated cos values
    private final double[] sinTable; // Pre-calculated sin values

    /**
     * Construct an unpacked real FFT of size n.
     *
     * @param n FFT size, must be a power of 2 and >= 4
     * @throws IllegalArgumentException if n is not a power of 2 or < 4
     */
    public RealUnpackedFFT(int n) {
        if (n < 4 || (n & (n - 1)) != 0) {
            throw new IllegalArgumentException("n must be a power of 2 and >= 4");
        }

        this.n = n;
        this.bitReverse = new int[n];
        this.cosTable = new double[n];
        this.sinTable = new double[n];

        precomputeBitReversal();
        precomputeTwiddles();
    }

    /**
     * Pre-compute bit-reversal permutation indices.
     */
    private void precomputeBitReversal() {
        int bits = Integer.numberOfTrailingZeros(n);
        for (int i = 0; i < n; i++) {
            bitReverse[i] = Integer.reverse(i) >>> (32 - bits);
        }
    }

    /**
     * Pre-compute twiddle factors (roots of unity).
     */
    private void precomputeTwiddles() {
        for (int i = 0; i < n; i++) {
            double angle = -2.0 * Math.PI * i / n;
            cosTable[i] = Math.cos(angle);
            sinTable[i] = Math.sin(angle);
        }
    }

    /**
     * Perform forward FFT.
     *
     * @param buf Array of length 2*n with interleaved [real, imag] pairs.
     *            Input should have imaginaries zeroed (real signal).
     *            Array is modified in-place with full spectrum (Hermitian symmetric).
     * @return The same array (for convenience)
     */
    public double[] forward(double[] buf) {
        if (buf.length != 2 * n) {
            throw new IllegalArgumentException("Buffer must have length 2*n = " + (2 * n));
        }

        complexFFT(buf, false);
        return buf;
    }

    /**
     * Perform inverse FFT.
     *
     * @param buf Array of length 2*n with interleaved [real, imag] pairs.
     *            Should contain full spectrum (Hermitian symmetric).
     *            Array is modified in-place with time-domain signal.
     * @return The same array (for convenience)
     */
    public double[] inverse(double[] buf) {
        if (buf.length != 2 * n) {
            throw new IllegalArgumentException("Buffer must have length 2*n = " + (2 * n));
        }

        complexFFT(buf, true);

        // Normalize by 1/n
        double scale = 1.0 / n;
        for (int i = 0; i < 2 * n; i++) {
            buf[i] *= scale;
        }

        return buf;
    }

    /**
     * Perform in-place complex FFT using Cooley-Tukey radix-2 DIT algorithm.
     *
     * @param buf Interleaved [real, imag] pairs (length 2*n)
     * @param inverse true for inverse transform, false for forward
     */
    private void complexFFT(double[] buf, boolean inverse) {
        // Bit-reversal permutation
        for (int i = 0; i < n; i++) {
            int j = bitReverse[i];
            if (j > i) {
                // Swap complex values at positions i and j
                int i2 = i << 1;
                int j2 = j << 1;

                double tempR = buf[i2];
                double tempI = buf[i2 + 1];
                buf[i2] = buf[j2];
                buf[i2 + 1] = buf[j2 + 1];
                buf[j2] = tempR;
                buf[j2 + 1] = tempI;
            }
        }

        // Cooley-Tukey decimation-in-time
        for (int size = 2; size <= n; size <<= 1) {
            int halfSize = size >> 1;
            int tableStep = n / size;

            for (int i = 0; i < n; i += size) {
                for (int j = 0; j < halfSize; j++) {
                    int k = i + j;
                    int kPlusHalfSize = k + halfSize;

                    // Indices in interleaved buffer
                    int idx1 = k << 1;
                    int idx2 = kPlusHalfSize << 1;

                    // Twiddle factor W = cos - i*sin (forward) or cos + i*sin (inverse)
                    int tIdx = j * tableStep;
                    double wReal = cosTable[tIdx];
                    double wImag = inverse ? -sinTable[tIdx] : sinTable[tIdx];

                    // Complex multiplication: t = W * buf[kPlusHalfSize]
                    double tReal = wReal * buf[idx2] - wImag * buf[idx2 + 1];
                    double tImag = wReal * buf[idx2 + 1] + wImag * buf[idx2];

                    // Butterfly
                    double uReal = buf[idx1];
                    double uImag = buf[idx1 + 1];

                    buf[idx1] = uReal + tReal;
                    buf[idx1 + 1] = uImag + tImag;
                    buf[idx2] = uReal - tReal;
                    buf[idx2 + 1] = uImag - tImag;
                }
            }
        }
    }

    /**
     * Get the FFT size.
     */
    public int getSize() {
        return n;
    }
}

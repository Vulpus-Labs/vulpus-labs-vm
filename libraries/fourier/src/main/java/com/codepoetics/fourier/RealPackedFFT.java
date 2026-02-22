package com.codepoetics.fourier;

/**
 * Packed Real FFT — forward and inverse transforms for real-valued signals.
 *
 * Uses an N/2-point complex FFT as the engine, with the standard trick of
 * treating N real samples as N/2 interleaved complex values. The output is
 * packed into N doubles using the CMSIS/ARM convention:
 *
 *   [0] = X[0].real        (DC, purely real)
 *   [1] = X[N/2].real      (Nyquist, purely real)
 *   [2] = X[1].real
 *   [3] = X[1].imag
 *   [4] = X[2].real
 *   [5] = X[2].imag
 *   ...
 *   [N-2] = X[N/2-1].real
 *   [N-1] = X[N/2-1].imag
 *
 * The forward transform produces an unnormalized DFT. The inverse includes
 * the 1/(N/2) normalisation from the complex IFFT, so forward followed by
 * inverse is identity (within doubleing-point tolerance).
 *
 * Constraints:
 *   - N must be a power of 2, >= 4
 *   - Input samples are single-precision doubles
 *   - No heap allocation occurs during forward() or inverse()
 */
public class RealPackedFFT {

    private final int n;           // real FFT length
    private final int halfN;       // N/2: complex FFT length
    private final int log2HalfN;   // log2(halfN), number of butterfly stages

    // Bit-reversal permutation table for the N/2-point complex FFT.
    // bitRev[i] gives the bit-reversed index of i within [0, halfN).
    private final int[] bitRev;

    // Twiddle factors for the radix-2 complex FFT engine.
    // Stored as halfN/2 complex pairs (halfN doubles total):
    //   fftTw[2k]   = cos(2πk / halfN)
    //   fftTw[2k+1] = -sin(2πk / halfN)   i.e. W_{halfN}^k = e^{-j2πk/halfN}
    // Indexed with stride at each butterfly stage.
    private final double[] fftTw;

    // Twiddle factors for the real FFT post-processing (forward) and
    // pre-processing (inverse). Stored as halfN complex pairs (N doubles):
    //   realTw[2k]   = cos(2πk / N)
    //   realTw[2k+1] = -sin(2πk / N)      i.e. W_N^k = e^{-j2πk/N}
    private final double[] realTw;

    /**
     * Construct a PackedRealFFT for a given signal length.
     *
     * @param n signal length; must be a power of 2, >= 4
     */
    public RealPackedFFT(int n) {
        if (n < 4 || (n & (n - 1)) != 0) {
            throw new IllegalArgumentException("n must be a power of 2 and >= 4, got " + n);
        }
        this.n = n;
        this.halfN = n >> 1;
        this.log2HalfN = Integer.numberOfTrailingZeros(halfN);

        // --- Bit-reversal table for halfN-point complex FFT ---
        this.bitRev = new int[halfN];
        for (int i = 0; i < halfN; i++) {
            int rev = 0, val = i;
            for (int b = 0; b < log2HalfN; b++) {
                rev = (rev << 1) | (val & 1);
                val >>= 1;
            }
            bitRev[i] = rev;
        }

        // --- Complex FFT twiddles ---
        // W_{halfN}^k for k = 0 .. halfN/2 - 1
        this.fftTw = new double[halfN];
        for (int k = 0; k < (halfN >> 1); k++) {
            double angle = -2.0 * Math.PI * k / halfN;
            fftTw[2 * k]     = (double) Math.cos(angle);
            fftTw[2 * k + 1] = (double) Math.sin(angle);
        }

        // --- Real FFT twiddles ---
        // W_N^k for k = 0 .. halfN - 1
        this.realTw = new double[n];
        for (int k = 0; k < halfN; k++) {
            double angle = -2.0 * Math.PI * k / n;
            realTw[2 * k]     = (double) Math.cos(angle);
            realTw[2 * k + 1] = (double) Math.sin(angle);
        }
    }

    /**
     * Forward real FFT.
     *
     * Transforms N real samples into a packed complex spectrum of N doubles.
     * The input array is modified in-place and returned.
     *
     * @param buf N real samples (destroyed and overwritten with packed spectrum)
     * @return the same array, now containing the packed spectrum
     */
    public double[] forward(double[] buf) {
        // Step 1: The N reals are already laid out as N/2 interleaved complex
        // values: z[k] = buf[2k] + j*buf[2k+1]. Perform the N/2-point
        // complex FFT in-place.
        complexFFT(buf, false);

        // Step 2: Post-process to extract the N-point real DFT from the
        // N/2-point complex DFT result.
        //
        // Z[k] is currently at buf[2k], buf[2k+1].
        // We need X[k] for k = 0..N/2.
        //
        // The relations (derived from decimation-in-time splitting):
        //   A[k] = ½(Z[k] + Z*[halfN - k])      (DFT of even-indexed samples)
        //   B[k] = (-j/2)(Z[k] - Z*[halfN - k])  (DFT of odd-indexed samples)
        //   X[k] = A[k] + W_N^k * B[k]

        // --- DC and Nyquist (special: both purely real) ---
        double zr0 = buf[0], zi0 = buf[1];
        buf[0] = zr0 + zi0;   // X[0] = Re(Z[0]) + Im(Z[0])
        buf[1] = zr0 - zi0;   // X[N/2] = Re(Z[0]) - Im(Z[0])

        // --- Midpoint k = N/4 (self-paired: X[N/4] = Z*[N/4]) ---
        // Only negate the imaginary part.
        int mid = halfN >> 1;       // N/4
        buf[2 * mid + 1] = -buf[2 * mid + 1];

        // --- General pairs k and halfN - k, for k = 1 .. N/4 - 1 ---
        for (int k = 1; k < mid; k++) {
            int ik  = 2 * k;               // index of Z[k]
            int im  = 2 * (halfN - k);     // index of Z[halfN - k]

            double zrK = buf[ik],     ziK = buf[ik + 1];
            double zrM = buf[im],     ziM = buf[im + 1];

            // Sums and differences
            double sumR  = zrK + zrM;   // Re(Z[k]) + Re(Z[halfN-k])
            double diffR = zrK - zrM;   // Re(Z[k]) - Re(Z[halfN-k])
            double sumI  = ziK + ziM;   // Im(Z[k]) + Im(Z[halfN-k])
            double diffI = ziK - ziM;   // Im(Z[k]) - Im(Z[halfN-k])

            // Twiddle W_N^k = (wr, wi) where wr = cos, wi = -sin
            double wr = realTw[ik];
            double wi = realTw[ik + 1];

            // A[k] = ( sumR/2, diffI/2 )
            // B[k] = ( sumI/2, -diffR/2 )
            // W_N^k * B[k] where B = (sumI/2, -diffR/2):
            //   real = wr*(sumI/2) - wi*(-diffR/2) = (wr*sumI + wi*diffR) / 2
            //   imag = wi*(sumI/2) + wr*(-diffR/2) = (wi*sumI - wr*diffR) / 2

            double twBr = (wr * sumI  + wi * diffR) * 0.5f;
            double twBi = (wi * sumI  - wr * diffR) * 0.5f;

            // X[k] = A[k] + W*B[k]
            buf[ik]     = sumR  * 0.5f + twBr;
            buf[ik + 1] = diffI * 0.5f + twBi;

            // --- Mirror bin X[halfN - k] ---
            // By the same derivation with k' = halfN - k:
            //   A[k'] = ( sumR/2, -diffI/2 )   (same sumR, negated diffI)
            //   B[k'] = ( sumI/2,  diffR/2 )    (same sumI, negated -diffR)

            double wrM = realTw[im];
            double wiM = realTw[im + 1];

            // W_N^{k'} * B[k'] where B' = (sumI/2, diffR/2):
            //   real = wrM*(sumI/2) - wiM*(diffR/2) = (wrM*sumI - wiM*diffR) / 2
            //   imag = wiM*(sumI/2) + wrM*(diffR/2) = (wiM*sumI + wrM*diffR) / 2

            double twBrM = (wrM * sumI  - wiM * diffR) * 0.5f;
            double twBiM = (wiM * sumI  + wrM * diffR) * 0.5f;

            buf[im]     =  sumR  * 0.5f + twBrM;
            buf[im + 1] = -diffI * 0.5f + twBiM;
        }

        return buf;
    }

    /**
     * Inverse real FFT.
     *
     * Transforms a packed complex spectrum back to N real samples.
     * The spectrum array is modified in-place (destroyed) and returned
     * containing the real-valued result.
     *
     * The inverse includes 1/(N/2) normalisation so that forward() followed
     * by inverse() is identity.
     *
     * @param freq packed spectrum (N doubles, destroyed and overwritten with real samples)
     * @return the same array, now containing N real samples
     */
    public double[] inverse(double[] freq) {
        // Step 1: Pre-process — recover Z[k] from the packed spectrum X[k].
        // This is the exact inverse of the forward post-processing.
        //
        // Given X[k] and X*[halfN - k], we recover:
        //   Z[k] = ½(X[k] + X*[halfN-k]) + j * W_N^{-k} * ½(X[k] - X*[halfN-k])
        //        = A[k] + j * B[k]
        // where W_N^{-k} is the conjugate twiddle.

        // --- DC and Nyquist ---
        double dc  = freq[0];
        double nyq = freq[1];
        freq[0] = (dc + nyq) * 0.5f;   // Re(Z[0])
        freq[1] = (dc - nyq) * 0.5f;   // Im(Z[0])

        // --- Midpoint k = N/4: Z[N/4] = X*[N/4] (conjugate) ---
        int mid = halfN >> 1;
        freq[2 * mid + 1] = -freq[2 * mid + 1];

        // --- General pairs k and halfN - k ---
        for (int k = 1; k < mid; k++) {
            int ik = 2 * k;
            int im = 2 * (halfN - k);

            double xrK = freq[ik],     xiK = freq[ik + 1];
            double xrM = freq[im],     xiM = freq[im + 1];

            // P = X[k] + X*[halfN-k],  Q = X[k] - X*[halfN-k]
            double pr = xrK + xrM;      // sum of reals
            double pi = xiK - xiM;      // diff of imags
            double qr = xrK - xrM;      // diff of reals
            double qi = xiK + xiM;      // sum of imags

            // We need j * conj(W_N^k) * Q/2
            // conj(W_N^k) = (wr, -wi) where (wr, wi) = realTw at k
            // j * conj(W_N^k) = (wi, wr) ... but wi is stored as -sin, so:
            //   realTw[ik]   = cos(2πk/N) = wr
            //   realTw[ik+1] = -sin(2πk/N) = wi
            //   conj = (wr, -wi)
            //   j * conj = j*(wr - j*wi) = j*wr + wi  → real=wi, imag=wr

            double wr = realTw[ik];
            double wi = realTw[ik + 1];

            // (wi + j*wr) * (qr + j*qi) / 2
            //   real = (wi*qr - wr*qi) / 2
            //   imag = (wr*qr + wi*qi) / 2

            double jtwQr = (wi * qr - wr * qi) * 0.5f;
            double jtwQi = (wr * qr + wi * qi) * 0.5f;

            // Z[k] = P/2 + j*conj(tw)*Q/2
            freq[ik]     = pr * 0.5f + jtwQr;
            freq[ik + 1] = pi * 0.5f + jtwQi;

            // --- Mirror: Z[halfN - k] ---
            // For k' = halfN-k, X[k'] = (xrM, xiM), X*[halfN-k'] = X*[k] = (xrK, -xiK)
            // P' = X[k'] + X*[halfN-k'] = (xrM+xrK, xiM-xiK) = (pr, -pi)
            // Q' = X[k'] - X*[halfN-k'] = (xrM-xrK, xiM+xiK) = (-qr, qi)

            double wrM = realTw[im];
            double wiM = realTw[im + 1];

            // j*conj(W_N^{k'}) * Q'/2
            // = (wiM + j*wrM) * (-qr + j*qi) / 2
            //   real = (-wiM*qr - wrM*qi) / 2
            //   imag = (-wrM*qr + wiM*qi) / 2

            double jtwQrM = (-wiM * qr - wrM * qi) * 0.5f;
            double jtwQiM = (-wrM * qr + wiM * qi) * 0.5f;

            freq[im]     =  pr * 0.5f + jtwQrM;
            freq[im + 1] = -pi * 0.5f + jtwQiM;
        }

        // Step 2: Inverse N/2-point complex FFT in-place.
        complexFFT(freq, true);

        // Step 3: Normalise in-place by 1/(N/2).
        double scale = 1.0f / halfN;
        for (int i = 0; i < n; i++) {
            freq[i] *= scale;
        }

        return freq;
    }

    // ---------------------------------------------------------------
    //  Private: radix-2 DIT complex FFT (in-place, interleaved format)
    // ---------------------------------------------------------------

    /**
     * In-place radix-2 decimation-in-time complex FFT.
     *
     * Operates on halfN complex values stored as N interleaved doubles:
     *   buf[2k] = real part of element k
     *   buf[2k+1] = imaginary part of element k
     *
     * No normalisation is applied in either direction. The caller is
     * responsible for scaling (the inverse path does this during the
     * final copy in inverse()).
     *
     * @param buf     interleaved complex data (N doubles, modified in-place)
     * @param inverse true for inverse FFT (conjugate twiddles), false for forward
     */
    private void complexFFT(double[] buf, boolean inverse) {
        int m = halfN;

        // --- Bit-reversal permutation ---
        for (int i = 0; i < m; i++) {
            int j = bitRev[i];
            if (j > i) {
                int ii = 2 * i, jj = 2 * j;
                double tr = buf[ii];     double ti = buf[ii + 1];
                buf[ii]     = buf[jj];  buf[ii + 1] = buf[jj + 1];
                buf[jj]     = tr;       buf[jj + 1] = ti;
            }
        }

        // --- Butterfly stages ---
        for (int s = 1; s <= log2HalfN; s++) {
            int halfSize = 1 << (s - 1);       // butterflies per group
            int fullSize = halfSize << 1;       // group size
            int stride   = m >> s;              // twiddle table stride

            for (int g = 0; g < m; g += fullSize) {
                for (int j = 0; j < halfSize; j++) {
                    int twIdx = 2 * j * stride;
                    double wr = fftTw[twIdx];
                    double wi = fftTw[twIdx + 1];
                    if (inverse) wi = -wi;      // conjugate for IFFT

                    int idx1 = 2 * (g + j);
                    int idx2 = 2 * (g + j + halfSize);

                    double ar = buf[idx1],     ai = buf[idx1 + 1];
                    double br = buf[idx2],     bi = buf[idx2 + 1];

                    // Twiddle multiply: t = W * b
                    double tr = wr * br - wi * bi;
                    double ti = wr * bi + wi * br;

                    // Butterfly
                    buf[idx1]     = ar + tr;
                    buf[idx1 + 1] = ai + ti;
                    buf[idx2]     = ar - tr;
                    buf[idx2 + 1] = ai - ti;
                }
            }
        }
    }

    // ---------------------------------------------------------------
    //  Getters
    // ---------------------------------------------------------------

    /** Returns the real FFT length N. */
    public int getLength() { return n; }
}
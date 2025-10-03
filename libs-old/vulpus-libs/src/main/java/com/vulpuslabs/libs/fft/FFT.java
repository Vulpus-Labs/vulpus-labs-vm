package com.vulpuslabs.libs.fft;

import com.vulpuslabs.libs.maths.Complex;

public class FFT {

    private final int binSize;
    private final int shift;
    private final double scale;
    private final double[] tao = new double[2];
    private final double[][][] twiddles; // [stage][j][re,im]

    public FFT(int binSize) {
        this.binSize = binSize;
        this.shift = 1 + Integer.numberOfLeadingZeros(binSize);
        this.scale = 1.0 / binSize;
        this.twiddles = computeTwiddles(binSize);
    }

    private double[][][] computeTwiddles(int binSize) {
        int numStages = Integer.numberOfTrailingZeros(binSize);
        double[][][] twiddles = new double[numStages][][];

        int halfSize = 1;
        double thetaDelta = Math.PI;

        for (int stage = 0; stage < numStages; stage++) {
            twiddles[stage] = new double[halfSize][2];
            double theta = 0.0;

            for (int j = 0; j < halfSize; j++) {
                twiddles[stage][j][0] = Math.cos(theta);
                twiddles[stage][j][1] = -Math.sin(theta);
                theta += thetaDelta;
            }

            halfSize <<= 1;
            thetaDelta *= 0.5;
        }

        return twiddles;
    }

    public void transform(double[][] x) {
        permutateInPlace(x);
        transformPermutated(x);
    }

    public void transformPermutated(double[][] x) {
        int sliceCount = binSize >> 1;
        int halfSize = 1;
        int sliceSize = 2;
        double thetaDelta = Math.PI;
        int stage = 0;

        while (sliceSize <= binSize) {
            for (int j = 0; j < halfSize; j++) {
                double[] w = twiddles[stage][j];

                int lIndex = j;
                int rIndex = lIndex + halfSize;

                for (int k=0; k < sliceCount; k++) {

                    double[] l = x[lIndex];
                    double[] r = x[rIndex];
                    Complex.multiply(w, r, tao); // tao = w * r
                    Complex.subtract(l, tao, r); // r = l - tao
                    Complex.add(l, tao);         // l += tao

                    lIndex += sliceSize;
                    rIndex += sliceSize;
                }
            }

            halfSize = sliceSize;
            sliceSize = sliceSize << 1;
            sliceCount = sliceCount >> 1;
            stage++;
        }
    }

    public void reverseTransform(double[][] x) {
        // Conjugate
        for (double[] c : x) {
            c[1] = -c[1];
        }

        transform(x);

        // Scale down and conjugate
        for (double[] c : x) {
            c[0] *= scale;
            c[1] *= -scale;
        }
    }

   public void circularConvolve(double[][] x, double[][] y, double[][] target) {
       for (int i=0; i < x.length; i++) {
           Complex.multiply(x[i], y[i], target[i], scale);
       }
   }

    public void circularConvolve(double[][] x, double[][] y) {
        for (int i=0; i < x.length; i++) {
            Complex.multiply(x[i], y[i], scale);
        }
    }

    private void permutateInPlace(double[][] x) {
        for (int k = 0; k < binSize; k++) {
            int j = Integer.reverse(k) >>> shift;
            if (j > k) {
                Complex.swap(x[j], x[k]);
            }
        }
    }

}

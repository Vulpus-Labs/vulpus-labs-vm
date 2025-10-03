package com.vulpuslabs.libs.maths;

import com.vulpuslabs.libs.fft.FFT;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FFTTest {

    @Test
    public void testZeroPaddedPermutation() {
        double[] source = new double[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        double[][] target = new double[16][2];

        FFT.fillPermutatedZeroPadded(source, target);

        for (double[] c : target) {
            System.out.println(c[0] + ", " + c[1]);
        }
        assertArrayEquals(target, new double[][] {
                new double[] { 1.0, 0.0 },
                new double[] { 0.0, 0.0 },
                new double[] { 5.0, 0.0 },
                new double[] { 0.0, 0.0 },
                new double[] { 3.0, 0.0 },
                new double[] { 0.0, 0.0 },
                new double[] { 7.0, 0.0 },
                new double[] { 0.0, 0.0 },
                new double[] { 2.0, 0.0 },
                new double[] { 0.0, 0.0 },
                new double[] { 6.0, 0.0 },
                new double[] { 0.0, 0.0 },
                new double[] { 4.0, 0.0 },
                new double[] { 0.0, 0.0 },
                new double[] { 8.0, 0.0 },
                new double[] { 0.0, 0.0 },
        });
    }

    @Test
    public void testFFTRoundtrip() {
        Random random = new Random();
        double[] source = new double[4096];
        for (int i=0; i<4096; i++) {
            source[i] = random.nextDouble(-1.0, 1.0);
        }

        FFT fft = new FFT();

        double[][] buckets = new double[4096][2];
        FFT.fillPermutated(source, buckets);
        fft.transformPermutated(buckets);
        fft.reverseTransform(buckets);

        double totalDelta = 0.0;
        for (int i=0; i<4096; i++) {
            totalDelta += Math.abs(source[i] - buckets[i][0]);
        }
        System.out.println(totalDelta);
    }
}

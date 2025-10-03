package com.vulpuslabs.libs.maths;

import com.vulpuslabs.libs.fft.FFT;
import org.junit.jupiter.api.Test;

public class ApproximateTest {

    @Test
    public void sinIsAccurate() {
        var maxInaccuracy = 0.0;
        var totalInaccuracy = 0.0;

        for (int i = 0; i < 1000; i++) {
            double theta = (double) i * (2.0 * Math.PI / 1000.0);
            var accurate = Math.sin(theta);
            var approximate = Approximate.sinUnit(theta * Approximate.UNIT_FROM_RADIANS);
            var inaccuracy = Math.abs(accurate - approximate);
            maxInaccuracy = Math.max(maxInaccuracy, inaccuracy);
            totalInaccuracy += inaccuracy;
        }

        System.out.println("Max inaccuracy: " + maxInaccuracy);
        System.out.println("Avg inaccuracy: " + totalInaccuracy / 1000.0);
    }

    @Test
    public void harmonicDistortion() {
        double[][] window = new double[1024][2];
        var fft = new FFT();
        for (int i = 0; i < 1024; i++) {
            double theta = (double) i * (2.0 * Math.PI / 32.0);
            Complex.set(window[i], Approximate.sinRadians(theta), 0.0);
            //window[i] = new Complex(Approximate.sinUnit(theta * Approximate.UNIT_FROM_RADIANS) * 5.0, 0.0);
        }

        fft.transform(window);

        double[] polar = new double[2];
        for (int i = 0; i < 512; i++) {
            Complex.toPolar(window[i], polar);
            if (polar[Polar.MAGNITUDE] > 0.0001) {
                System.out.println(i + ": " + polar[Polar.MAGNITUDE]);
            }
        }
    }
}

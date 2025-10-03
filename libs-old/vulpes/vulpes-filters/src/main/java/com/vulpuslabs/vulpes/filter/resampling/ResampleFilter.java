package com.vulpuslabs.vulpes.filter.resampling;

import com.vulpuslabs.vulpes.values.api.DoubleTransformer;

public class ResampleFilter implements DoubleTransformer {

    private static final int A1 = 0;
    private static final int A2 = 1;
    private static final int B0 = 2;
    private static final int B1 = 3;
    private static final int B2 = 4;
    private static final int X = 5;
    private static final int Y = 6;
    private static final double[] RESONANCE_FACTORS = new double[] {
            0.50316379,
            0.52972649,
            0.59051105,
            0.70710678,
            0.93979296,
            1.5138713,
            4.4657021
    };

    private final double[][] biquads;

    public ResampleFilter(double sampleRate, double freq) {
        double k = Math.tan(Math.PI * (freq / sampleRate));
        double kSquared = k * k;

        biquads = new double[RESONANCE_FACTORS.length][7];

        for (int i=0; i<RESONANCE_FACTORS.length; i++) {
            double resonanceFactor = k / RESONANCE_FACTORS[i];
            double a0 = 1.0 / (1.0 + resonanceFactor + kSquared);

            double[] biquad = biquads[i];
            biquad[A1] = kSquared * a0;
            biquad[A2] = 2.0 * kSquared * a0;
            biquad[B0] = kSquared * a0;
            biquad[B1] = 2.0 * (kSquared - 1.0) * a0;
            biquad[B2] = (1.0 - resonanceFactor + kSquared) * a0;
        }
    }

    @Override
    public double apply(double value) {
        for (double[] biquad : biquads) {
            double newValue = value * biquad[A1] + biquad[X];

            biquad[X] = value * biquad[A2]
                    + biquad[Y]
                    - biquad[B1] * newValue;

            biquad[Y] = value * biquad[B0]
                    - biquad[B2] * newValue;
            value = newValue;
        }
        return value;
    }

}

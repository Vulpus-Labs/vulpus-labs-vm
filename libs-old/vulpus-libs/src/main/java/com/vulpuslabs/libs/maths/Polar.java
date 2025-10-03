package com.vulpuslabs.libs.maths;

public final class Polar {

    private Polar() {
    }

    public static final int MAGNITUDE = 0;
    public static final int THETA = 1;

    public static void set(double[] p, double magnitude, double theta) {
        p[MAGNITUDE] = magnitude;
        p[THETA] = theta;
    }

    public static void toComplex(double[] p, double[] c) {
        double magnitude = p[MAGNITUDE];
        double theta = p[THETA];
        Complex.set(c, magnitude * Math.cos(theta), magnitude * Math.sin(theta));
    }

}

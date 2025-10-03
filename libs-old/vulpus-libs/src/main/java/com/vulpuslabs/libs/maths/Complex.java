package com.vulpuslabs.libs.maths;

public final class Complex {

    private Complex() {
    }

    public static final int REAL = 0;
    public static final int IMAGINARY = 1;

    public static void set(double[] c, double real, double imaginary) {
        c[REAL] = real;
        c[IMAGINARY] = imaginary;
    }

    public static void add(double[] l, double[] r, double[] target) {
        target[REAL] = l[REAL] + r[REAL];
        target[IMAGINARY] = l[IMAGINARY] + r[IMAGINARY];
    }

    public static void add(double[] l, double[] r) {
        l[REAL] += r[REAL];
        l[IMAGINARY] += r[IMAGINARY];
    }

    public static void subtract(double[] l, double[] r, double[] target) {
        target[REAL] = l[REAL] - r[REAL];
        target[IMAGINARY] = l[IMAGINARY] - r[IMAGINARY];
    }

    public static void subtract(double[] l, double[] r) {
        l[REAL] -= r[REAL];
        l[IMAGINARY] -= r[IMAGINARY];
    }

    public static void multiply(double[] l, double[] r, double[] target) {
        target[REAL] = (l[REAL]  * r[REAL]) - (l[IMAGINARY] * r[IMAGINARY]);
        target[IMAGINARY] = (l[REAL] * r[IMAGINARY]) + (l[IMAGINARY] * r[REAL]);
    }

    public static void multiply(double[] l, double[] r) {
        double newReal = (l[REAL]  * r[REAL]) - (l[IMAGINARY] * r[IMAGINARY]);
        l[IMAGINARY] = (l[REAL] * r[IMAGINARY]) + (l[IMAGINARY] * r[REAL]);
        l[REAL] = newReal;
    }

    public static void conjugate(double[] l, double[] target) {
        target[REAL] = l[REAL];
        target[IMAGINARY] = -l[IMAGINARY];
    }

    public static void conjugate(double[] l) {
        l[IMAGINARY] = -l[IMAGINARY];
    }

    public static void multiplyReal(double[] l, double real, double[] target) {
        target[REAL] = l[REAL] * real;
        target[IMAGINARY] = l[IMAGINARY] * real;
    }

    public static void multiplyReal(double[] l, double real) {
        l[REAL] *= real;
        l[IMAGINARY] *= real;
    }

    public static void toPolar(double[] c, double[] p) {
        Polar.set(p, magnitude(c), phase(c));
    }

    public static double magnitude(double[] c) {
        return Math.sqrt((c[REAL] * c[REAL]) + (c[IMAGINARY] * c[IMAGINARY]));
    }

    public static double phase(double[] c) {
        return Math.atan2(c[IMAGINARY], c[REAL]);
    }

    public static void swap(double[] l, double [] r) {
        double lReal = l[REAL];
        double lImag = l[IMAGINARY];
        l[REAL] = r[REAL];
        l[IMAGINARY] = r[IMAGINARY];
        r[REAL] = lReal;
        r[IMAGINARY] = lImag;
    }

    public static void copyTo(double[] l, double[] r) {
        r[REAL] = l[REAL];
        r[IMAGINARY] = l[IMAGINARY];
    }

    public static void multiply(double[] l, double[] r, double[] target, double scale) {
        target[REAL] = scale * ((l[REAL]  * r[REAL]) - (l[IMAGINARY] * r[IMAGINARY]));
        target[IMAGINARY] = scale * ((l[REAL] * r[IMAGINARY]) + (l[IMAGINARY] * r[REAL]));
    }

    public static void multiply(double[] l, double[] r, double scale) {
        double newReal = scale * ((l[REAL]  * r[REAL]) - (l[IMAGINARY] * r[IMAGINARY]));
        l[IMAGINARY] = scale * ((l[REAL] * r[IMAGINARY]) + (l[IMAGINARY] * r[REAL]));
        l[REAL] = newReal;
    }
}

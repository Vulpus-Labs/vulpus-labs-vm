package com.vulpuslabs.vulpes.maths;

import java.util.function.DoubleUnaryOperator;

public class Range {

    public static final Range CV_BIPOLAR = new Range(-5.0, 5.0);
    public static final Range CV_UNIPOLAR = new Range(0, 5.0);

    public static final Range UNIT_UNIPOLAR = new Range(0.0, 1.0);
    public static final Range UNIT_BIPOLAR = new Range(-1.0, 1.0);

    private final double lowerBound;
    private final double upperBound;
    private final double size;

    public Range(double lowerBound, double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.size = upperBound - lowerBound;
    }

    public double clamp(double value) {
        return Math.max(lowerBound, Math.min(upperBound, value));
    }

    public DoubleUnaryOperator to(double otherLowerBound, double otherUpperBound) {
        final var otherSize = otherUpperBound - otherLowerBound;
        final var scaling = otherSize / size;
        final var boundShift = otherLowerBound - (lowerBound * scaling);
        return (value) -> boundShift + (value * scaling);
    }

    public DoubleUnaryOperator to(Range targetRange) {
        final var scaling = targetRange.size / this.size;
        final var boundShift = targetRange.lowerBound - (lowerBound * scaling);
        return (value) -> boundShift + (value * scaling);
    }

    public DoubleUnaryOperator clampTo(Range targetRange) {
        var scaling = targetRange.size / this.size;
        var boundShift = targetRange.lowerBound - (lowerBound * scaling);
        return value -> boundShift + (clamp(value) * scaling);
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public double getCentre() {
        return 0.5 * (lowerBound + upperBound);
    }
}

package com.vulpuslabs.modules.phantasmatic;

/**
 * High-fidelity phase distortion engine for the Phantasmatic module.
 *
 * Phantasmatic is a high-precision fork of the Prismatic module, using:
 * - Double precision floating point arithmetic (instead of single precision)
 * - 2048-entry lookup tables (instead of 256 bytes)
 *
 * This provides much higher audio quality and precision compared to
 * Prismatic's deliberately lo-fi design.
 */
public class PhaseDistortionEngine {

    private static final int TABLE_SIZE = 2048;
    private static final int TABLE_SIZE_MASK = TABLE_SIZE - 1;

    // Waveform profile constants
    public static final int PROFILE_SINE = 0;
    public static final int PROFILE_SAWTOOTH = 1;
    public static final int PROFILE_SQUARE = 2;

    // Sine wave table: 2048 double-precision values (high-fidelity)
    private final double[] sineTable;

    // Lookup tables: 2048-entry double-precision distortion curves (high-fidelity)
    private final double[][] profiles;


    private PhaseDistortionEngine(double[] sineTable, double[][] profiles) {
        this.sineTable = sineTable;
        this.profiles = profiles;
    }

    /**
     * Create a new PhaseDistortionEngine with initialized lookup tables
     */
    public static PhaseDistortionEngine create() {
        return new PhaseDistortionEngine(
                createSineTable(),
                new double[][] {
                	createSineProfile(),
                	createSawtoothProfile(),
                	createSquareProfile()
                });
    }

    private static double[] createSineTable() {
        double[] table = new double[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            double angle = (i / (double) TABLE_SIZE) * 2.0 * Math.PI;
            table[i] = Math.sin(angle);
        }

        return table;
    }
    
    private static double[] createSineProfile() {
       double[] profile = new double[TABLE_SIZE];
       for (int i=0; i<TABLE_SIZE; i++) {
          profile[i] = i / (double) TABLE_SIZE;
       }
       return profile;
    }

    private static double[] createSawtoothProfile() {
        // Slow gradual rise, smooth through top, fast fall
        double[][] breakpoints = {
                {0.0, 0.0},       // Start at zero crossing
                {0.4375, 0.25},    // Rise to peak
                {0.5, 0.5},       // Transition through zero
                {0.5625, 0.75},   // Rapid drop through zero to bottom
                {1.0, 1.0}    // Fast finish back to zero
        };

        return buildPiecewiseLinear(breakpoints);
    }

    private static double[] createSquareProfile() {
        // Smooth transitions through zero, hold at peaks
        double[][] breakpoints = {
                {0, 0},       // Start at zero crossing
                {0.0625, 0.234375},     // Rise smoothly to positive peak
                {0.4375, 0.265625},     // Hold near positive peak
                {0.5, 0.5},   // Transition smoothly through zero
                {0.5625, 0.734375},   // Down to negative peak
                {0.9375, 0.765625},   // Hold near negative peak
                {1.0, 1.0}    // Transition back to zero (wraps to start)
        };

        return buildPiecewiseLinear(breakpoints);
    }

    private static double[] buildPiecewiseLinear(double[][] breakpoints) {
        double[] profile = new double[TABLE_SIZE];

        for (int segment = 0; segment < breakpoints.length - 1; segment++) {
            int x0 = (int) (breakpoints[segment][0] * TABLE_SIZE);
            double y0 = breakpoints[segment][1];
            int x1 = (int) (breakpoints[segment + 1][0] * TABLE_SIZE);
            double y1 = breakpoints[segment + 1][1];
            if (x1 == x0) {
                profile[x0] = y0;
            } else {
                double segmentWidth = x1 - x0;
                double segmentHeight = y1 - y0;
                
                for (int x = x0; x < x1 && x < TABLE_SIZE; x++) {
                    profile[x] = y0 + ((x - x0) * segmentHeight / segmentWidth);
                }
            }
        }

        return profile;
    }

    public double getSine(double phaseAccumulator) {
        double doubleIndex = phaseAccumulator * TABLE_SIZE;
        int index = (int) doubleIndex;
        double fraction = doubleIndex - index;
        double a = sineTable[index];
        double b = sineTable[(index + 1) & TABLE_SIZE_MASK];

        return a + ((b - a) * fraction);
    }

    public double getInterpolated(int left, int right, double interpolation, double phaseAccumulator) {
        double[] sourceLookup = profiles[left];
        double[] targetLookup = profiles[right];
        
        return getInterpolated(sourceLookup, targetLookup, interpolation, phaseAccumulator);
    }

    private double getInterpolated(double[] sourceLookup, double[] targetLookup, double interpolation, double phaseAccumulator) {
        double source = getCurve(sourceLookup, phaseAccumulator);
        double target = getCurve(targetLookup, phaseAccumulator);

        double interpolated = source + ((target - source) * interpolation);
        
        return getSine(interpolated);
    }

    private double getCurve(double[] lookup, double phase) {
        double doublePhase = phase * TABLE_SIZE_MASK;
        int index = (int) doublePhase;
        double fraction = doublePhase - index;

        double a = lookup[index];
        double b = lookup[index + 1];

        return a + ((b - a) * fraction);
    }

}

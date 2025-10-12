package com.vulpuslabs.modules.prismatic;

public class PhaseDistortionEngine {

    // Waveform profile constants
    public static final int PROFILE_SINE = 0;
    public static final int PROFILE_SAWTOOTH = 1;
    public static final int PROFILE_SQUARE = 2;

    // Sine wave table: 256 values in range -128 to 127
    private final int[] sineTable;

    // Lookup tables: 256-byte distortion curves
    private final int[][] profiles;


    private PhaseDistortionEngine(int[] sineTable, int[][] profiles) {
        this.sineTable = sineTable;
        this.profiles = profiles;
    }

    /**
     * Create a new PhaseDistortionEngine with initialized lookup tables
     */
    public static PhaseDistortionEngine create() {
        return new PhaseDistortionEngine(
                createSineTable(),
                new int[][] {
                	createSineProfile(),
                	createSawtoothProfile(),
                	createSquareProfile()
                });
    }

    private static int[] createSineTable() {
        int[] table = new int[256];

        // Generate sine wave: values from -128 to 127
        for (int i = 0; i < 256; i++) {
            double angle = (i / 256.0) * 2.0 * Math.PI;
            double sineValue = Math.sin(angle);
            table[i] = (int) Math.round(sineValue * 127);
        }

        return table;
    }
    
    private static int[] createSineProfile() {
       int[] profile = new int[256];
       for (int i=0; i<256; i++) {
          profile[i] = i;
       }
       return profile;
    }

    private static int[] createSawtoothProfile() {
        // Slow gradual rise, smooth through top, fast fall
        int[][] breakpoints = {
                {0, 0},       // Start at zero crossing
                {112, 64},    // Rise to peak
                {144, 192},   // Rapid drop through zero to bottom
                {255, 255}    // Fast finish back to zero
        };

        return buildPiecewiseLinear(breakpoints);
    }

    private static int[] createSquareProfile() {
        // Smooth transitions through zero, hold at peaks
        int[][] breakpoints = {
                {0, 0},       // Start at zero crossing
                {16, 60},     // Rise smoothly to positive peak
                {112, 68},     // Hold near positive peak
                {128, 128},   // Transition smoothly through zero
                {144, 188},   // Down to negative peak
                {240, 196},   // Hold near negative peak
                {255, 255}    // Transition back to zero (wraps to start)
        };

        return buildPiecewiseLinear(breakpoints);
    }

    private static int[] buildPiecewiseLinear(int[][] breakpoints) {
        int[] profile = new int[256];

        for (int segment = 0; segment < breakpoints.length - 1; segment++) {
            int x0 = breakpoints[segment][0];
            int y0 = breakpoints[segment][1];
            int x1 = breakpoints[segment + 1][0];
            int y1 = breakpoints[segment + 1][1];

            for (int x = x0; x <= x1 && x < 256; x++) {
                if (x1 == x0) {
                    profile[x] = y0;
                } else {
                    // Linear interpolation
                    profile[x] = y0 + ((y1 - y0) * (x - x0)) / (x1 - x0);
                }
            }
        }

        return profile;
    }

    public int getSine(int phaseAccumulator, int fraction) {
        int a = getSine(phaseAccumulator);
        if (fraction == 0) return a;
        
        int b = getSine((phaseAccumulator + 1) & 0xFF);
        return (a * (256 - fraction) + b * fraction) >> 8;
    }

    public int getSine(int phaseAccumulator) {
        return sineTable[phaseAccumulator];
    }

    public int getInterpolated(int left, int right, int interpolation, int phaseAccumulator, int fraction) {
        int[] sourceLookup = profiles[left];
        int[] targetLookup = profiles[right];
        
        int a = getInterpolated(sourceLookup, targetLookup, interpolation, phaseAccumulator);
        if (fraction == 0) return a;
        
        int b = getInterpolated(sourceLookup, targetLookup, interpolation, (phaseAccumulator + 1) & 0xFF);
        return (a * (256 - fraction) + b * fraction) >> 8;
    }

    public int getInterpolated(int[] sourceLookup, int[] targetLookup, int interpolation, int phaseAccumulator) {
        int phase = phaseAccumulator;
        int source = sourceLookup[phase];
        int target = targetLookup[phase];

        // Interpolate between left and right profiles using DCW parameter
        // Fixed-point 8-bit interpolation
        int distortedPhase = (source * (255 - interpolation) + target * interpolation) >> 8;

        return sineTable[distortedPhase & 0xFF];
    }
}

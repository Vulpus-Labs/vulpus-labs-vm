package com.vulpuslabs.modules.phantasmatic;

/**
 * High-fidelity oscillator for Phantasmatic phase distortion synthesis.
 *
 * Part of the Phantasmatic module, a high-precision fork of Prismatic using
 * double precision arithmetic and larger lookup tables for improved audio quality.
 */
public final class Oscillator {

    private static final int SAW_SINE_SQUARE = 0;
    private static final int SQUARE_SAW_SINE = 1;
    private static final int SINE_SQUARE_SAW = 2;
    private static final int RESO = 3;

    // Reso mode frequency multiplier limits
    private static final double MAX_FREQ_MULT = 4.0;
    private static final double MIN_FREQ_MULT = 0.5;

    // DCW scaling for reso mode frequency modulation
    private static final double RESO_DCW_POSITIVE_SCALE = 3.0;  // Maps DCW [0,1] to freq mult [1,4]
    private static final double RESO_DCW_NEGATIVE_SCALE = 0.5;  // Maps DCW [-1,0] to freq mult [0.5,1]

    private static final double SAMPLE_SCALING = 5.0;
    public static final double VOCT_TO_INCREMENT = 65.40639132514966 / 48000.0;

    private final PhaseDistortionEngine engine;
    private final PitchControl pitchControl;
    private double phase;
    private double resoPhase;

    private int mode;

    // Frequency calculation caching
    private double cachedVOct = Double.NaN;
    private double cachedIncrement;

    // DCW calculation caching
    private double cachedDcw = Double.NaN;
    private int cachedDcwProfile;

    // Reso mode DCW caching
    private double cachedResoDcw = Double.NaN;
    private double cachedResoDcwDouble = 1.0;

    public Oscillator(PhaseDistortionEngine engine, PitchControl pitchControl) {
        this.engine = engine;
        this.pitchControl = pitchControl;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    private double calculateIncrement(double vOct, double fm) {
        // For exponential FM, fm affects pitch so vOct changes every sample - no caching benefit
        // For linear FM, fm doesn't affect vOct, so caching works
        if (vOct != cachedVOct) {
            cachedVOct = vOct;
            cachedIncrement = VOCT_TO_INCREMENT * Math.pow(2.0, vOct);
        }

        double increment = cachedIncrement;

        // Apply linear FM directly to increment (doesn't affect cache)
        increment += pitchControl.incrementModulation(fm);

        return increment;
    }

    private void updateDcw(double dcw) {
        if (dcw != cachedDcw) {
            cachedDcw = dcw;
            cachedDcwProfile = dcw > 0.0 ? 1 : -1;  // 1 for positive, -1 for negative
        }
    }

    private void updateResoDcw(double dcw) {
        if (dcw != cachedResoDcw) {
            cachedResoDcw = dcw;
            cachedResoDcwDouble = dcw > 0.0
                ? Math.min(MAX_FREQ_MULT, 1.0 + dcw * RESO_DCW_POSITIVE_SCALE)
                : Math.max(MIN_FREQ_MULT, 1.0 + dcw * RESO_DCW_NEGATIVE_SCALE);
        }
    }

    public double synthesize(double dcw, double vOct, double fm) {
        if (mode == RESO) {
            return synthesizeReso(dcw, vOct, fm);
        }

        updateDcw(dcw);

        double sample = switch(mode) {
            case SAW_SINE_SQUARE -> engine.getInterpolated(
                    PhaseDistortionEngine.PROFILE_SINE,
                    cachedDcwProfile > 0
                            ? PhaseDistortionEngine.PROFILE_SQUARE
                            : PhaseDistortionEngine.PROFILE_SAWTOOTH,
                    Math.abs(cachedDcw),
                    phase
                    );
            case SQUARE_SAW_SINE -> engine.getInterpolated(
                    PhaseDistortionEngine.PROFILE_SAWTOOTH,
                    cachedDcwProfile > 0
                            ? PhaseDistortionEngine.PROFILE_SINE
                            : PhaseDistortionEngine.PROFILE_SQUARE,
                    Math.abs(cachedDcw),
                    phase
                    );
            case SINE_SQUARE_SAW -> engine.getInterpolated(
                    PhaseDistortionEngine.PROFILE_SQUARE,
                    cachedDcwProfile > 0
                        ? PhaseDistortionEngine.PROFILE_SAWTOOTH
                        : PhaseDistortionEngine.PROFILE_SINE,
                    Math.abs(cachedDcw),
                    phase
            );
            default -> 0;
        };

        // Advance phase
        phase += calculateIncrement(vOct, fm);
        phase -= (int) phase;

        return sample * SAMPLE_SCALING;
    }

    private double synthesizeReso(double dcw, double vOct, double fm) {
        updateResoDcw(dcw);

        double increment = calculateIncrement(vOct, fm);
        phase += increment;
        double resoIncrement = increment * cachedResoDcwDouble;
        resoPhase += resoIncrement;
        resoPhase -= (int) resoPhase;
        if (phase > 1.0) {
            phase -= (int) phase;
            resoPhase = 0;
        }

        double sample = engine.getSine(resoPhase);
        sample *= 1.0 - phase;
        return sample * SAMPLE_SCALING;
    }
}

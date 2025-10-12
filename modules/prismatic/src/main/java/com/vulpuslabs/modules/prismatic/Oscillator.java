package com.vulpuslabs.modules.prismatic;

public final class Oscillator {

    private static final double ONE_THIRD = 1.0 / 3.0;
    private static final double TWO_THIRDS = 2.0 / 3.0;

    private static final int SAW_SINE_SQUARE = 0;
    private static final int SQUARE_SAW_SINE = 1;
    private static final int SINE_SQUARE_SAW = 2;
    private static final int RESO = 3;
    private static final int MAX_FREQ_MULT = 256 * 3;

    private static final double SAMPLE_SCALING = 5.0 / 128.0;
    public static final double VOCT_TO_INCREMENT = (65.40639132514966 / 16000.0) * 65536.0;

    private final PhaseDistortionEngine engine;
    private final ButterworthLPF lpf = new ButterworthLPF(48000, 7000.0);
    private final PitchControl pitchControl;
    private int phase;
    private int resoPhase;
    private int count;
    private double previous;
    private double latest;
    private boolean highRes;
    private boolean linearInterpolate;
    private boolean filter;

    private int mode;

    // Frequency calculation caching
    private double cachedVOct = Double.NaN;
    private int cachedIncrement;

    // DCW calculation caching
    private double cachedDcw = Double.NaN;
    private int cachedDcwInt;
    private int cachedDcwProfile;

    // Reso mode DCW caching
    private double cachedResoDcw = Double.NaN;
    private int cachedResoDcwInt;

    public Oscillator(PhaseDistortionEngine engine, PitchControl pitchControl) {
        this.engine = engine;
        this.pitchControl = pitchControl;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
    
    public void setNastiness(int nastiness) {
       highRes = nastiness > 0;
       linearInterpolate = nastiness > 1;
       filter = nastiness > 2;
    }

    private int calculateIncrement(double vOct, double fm) {
        // For exponential FM, fm affects pitch so vOct changes every sample - no caching benefit
        // For linear FM, fm doesn't affect vOct, so caching works
        if (vOct != cachedVOct) {
            cachedVOct = vOct;
            cachedIncrement = (int) Math.round(VOCT_TO_INCREMENT * Math.pow(2.0, vOct));
        }

        int increment = cachedIncrement;

        // Apply linear FM directly to increment (doesn't affect cache)
        increment += pitchControl.incrementModulation(fm);

        return increment;
    }

    private void updateDcw(double dcw) {
        if (dcw != cachedDcw) {
            cachedDcw = dcw;
            cachedDcwInt = Math.min(255, (int) Math.round(Math.abs(dcw) * 255));
            cachedDcwProfile = dcw > 0.0 ? 1 : -1;  // 1 for positive, -1 for negative
        }
    }

    private void updateResoDcw(double dcw) {
        if (dcw != cachedResoDcw) {
            cachedResoDcw = dcw;
            cachedResoDcwInt = dcw > 0.0
                ? Math.min(MAX_FREQ_MULT, 256 + (int) Math.round(dcw * 768.0))
                : Math.max(128, 256 - (int) Math.round(-dcw * 128));
        }
    }

    public double synthesize(double dcw, double vOct, double fm) {
        if (count > 0) {
           count--;
        } else {
           previous = latest;
           latest = synthesizeRaw(dcw, vOct, fm);
           count = 2;
        }

        if (!linearInterpolate) return latest;

        double interpolated = switch (count) {
           case 0 -> previous;
           case 1 -> previous * TWO_THIRDS + latest * ONE_THIRD;
           case 2 -> previous * ONE_THIRD + latest * TWO_THIRDS;
           default -> 0;
        };

        return filter ? lpf.process(interpolated) : interpolated;
    }

    // dcw is in range [-1, 1]
    public double synthesizeRaw(double dcw, double vOct, double fm) {
        if (mode == RESO) {
            return synthesizeReso(dcw, vOct, fm);
        }

        updateDcw(dcw);

        int phaseIndex = (phase >> 8) & 0xFF;
        int fractionalIndex = highRes ? phase & 0xff : 0;

        int sample = switch(mode) {
            case SAW_SINE_SQUARE -> engine.getInterpolated(
                    PhaseDistortionEngine.PROFILE_SINE,
                    cachedDcwProfile > 0
                            ? PhaseDistortionEngine.PROFILE_SQUARE
                            : PhaseDistortionEngine.PROFILE_SAWTOOTH,
                    cachedDcwInt,
                    phaseIndex,
                    fractionalIndex
                    );
            case SQUARE_SAW_SINE -> engine.getInterpolated(
                    PhaseDistortionEngine.PROFILE_SAWTOOTH,
                    cachedDcwProfile > 0
                            ? PhaseDistortionEngine.PROFILE_SINE
                            : PhaseDistortionEngine.PROFILE_SQUARE,
                    cachedDcwInt,
                    phaseIndex,
                    fractionalIndex
                    );
            case SINE_SQUARE_SAW -> engine.getInterpolated(
                    PhaseDistortionEngine.PROFILE_SQUARE,
                    cachedDcwProfile > 0
                        ? PhaseDistortionEngine.PROFILE_SAWTOOTH
                        : PhaseDistortionEngine.PROFILE_SINE,
                    cachedDcwInt,
                    phaseIndex,
                    fractionalIndex
            );
            default -> 0;
        };

        // Advance phase
        phase = (phase + calculateIncrement(vOct, fm)) & 0xFFFF;

        return sample * SAMPLE_SCALING;
    }

    private double synthesizeReso(double dcw, double vOct, double fm) {
        updateResoDcw(dcw);

        int increment = calculateIncrement(vOct, fm);
        phase += increment;
        int resoIncrement = (increment * cachedResoDcwInt) >> 8;
        resoPhase = (resoPhase + resoIncrement) & 0xFFFF;
        if (phase > 0xFFFF) {
            phase = phase & 0xFFFF;
            resoPhase = 0;
        }

		  int resoPhaseIndex = (resoPhase >> 8);
		  int resoPhaseFractionalIndex = highRes ? resoPhase & 0xFF : 0;
        int sample = engine.getSine(resoPhaseIndex, resoPhaseFractionalIndex);
        sample = (sample * (256 - (phase >> 8))) >> 8;
        return sample * SAMPLE_SCALING;
    }
}

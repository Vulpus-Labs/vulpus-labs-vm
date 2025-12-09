package com.vulpuslabs.modules.phantasmatic;

/**
 * Sound engine for Phantasmatic phase distortion module.
 *
 * Manages mono and polyphonic oscillators for the Phantasmatic module,
 * a high-precision fork of Prismatic using double precision arithmetic
 * and larger lookup tables for improved audio quality.
 */
public class SoundEngine {

    // Smoothing coefficient for DCW parameter changes (exponential smoothing)
    // Higher value = faster response, lower value = smoother but slower
    // 0.005 gives smooth transitions without noticeable lag
    private static final double DCW_SMOOTHING_COEFF = 0.005;

    private double baseDcw;
    private double dcwModAmount;
    private boolean oversamplingEnabled;

    private final PhaseDistortionEngine engine;
    private final Oscillator monoOsc;
    private final Oscillator[] polyOsc;
    private final PitchControl pitchControl;

    // Oversampling processors (one per voice + mono)
    private final OversamplingProcessor monoOversampler;
    private final OversamplingProcessor[] polyOversampler;

    // Smoothed DCW values (one per voice + mono)
    private double smoothedMonoDcw;
    private final double[] smoothedPolyDcw;

    public SoundEngine(PitchControl pitchControl) {
        this.pitchControl = pitchControl;
        this.engine = PhaseDistortionEngine.create();
        this.monoOsc = new Oscillator(engine, pitchControl);
        this.polyOsc = makeOscillators(engine, pitchControl);
        this.monoOversampler = new OversamplingProcessor();
        this.polyOversampler = makeOversamplers();
        this.oversamplingEnabled = false;
        this.smoothedMonoDcw = 0.0;
        this.smoothedPolyDcw = new double[16];
    }

    public void setBaseDcw(double baseDcw) {
        this.baseDcw = baseDcw;
    }

    public void setDcwModAmount(double dcwModAmount) {
        this.dcwModAmount = dcwModAmount;
    }

    public void setOversamplingEnabled(boolean enabled) {
        this.oversamplingEnabled = enabled;
    }

    private static Oscillator[] makeOscillators(PhaseDistortionEngine engine, PitchControl pitchControl) {
        Oscillator[] result = new Oscillator[16];
        for (int i=0; i<16; i++) {
            result[i] = new Oscillator(engine, pitchControl);
        }
        return result;
    }

    private static OversamplingProcessor[] makeOversamplers() {
        OversamplingProcessor[] result = new OversamplingProcessor[16];
        for (int i=0; i<16; i++) {
            result[i] = new OversamplingProcessor();
        }
        return result;
    }

    public void setMode(int newMode) {
        monoOsc.setMode(newMode);
        for (Oscillator osc : polyOsc) {
            osc.setMode(newMode);
        }
    }

    public double processMono(double voct, double fm, double dcw) {
        double monoPitch = pitchControl.adjustPitch(voct, fm);
        double targetDcw = Math.max(-1.0, Math.min(1.0, baseDcw + (dcwModAmount * dcw)));

        // Apply exponential smoothing to DCW to eliminate zipper noise
        smoothedMonoDcw += (targetDcw - smoothedMonoDcw) * DCW_SMOOTHING_COEFF;

        if (oversamplingEnabled) {
            return monoOversampler.process(monoOsc, smoothedMonoDcw, monoPitch, fm);
        } else {
            return monoOsc.synthesize(smoothedMonoDcw, monoPitch, fm);
        }
    }

    public double processPoly(int channel, double voct, double fm, double dcw) {
        double polyPitch = pitchControl.adjustPitch(voct, fm);
        double targetDcw = Math.max(-1.0, Math.min(1.0, baseDcw + (dcwModAmount * dcw)));

        // Apply exponential smoothing to DCW to eliminate zipper noise
        smoothedPolyDcw[channel] += (targetDcw - smoothedPolyDcw[channel]) * DCW_SMOOTHING_COEFF;

        if (oversamplingEnabled) {
            return polyOversampler[channel].process(polyOsc[channel], smoothedPolyDcw[channel], polyPitch, fm);
        } else {
            return polyOsc[channel].synthesize(smoothedPolyDcw[channel], polyPitch, fm);
        }
    }

}

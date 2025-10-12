package com.vulpuslabs.modules.prismatic;

public class SoundEngine {

    private double baseDcw;
    private double dcwModAmount;

    private final PhaseDistortionEngine engine;
    private final Oscillator monoOsc;
    private final Oscillator[] polyOsc;
    private final PitchControl pitchControl;

    public SoundEngine(PitchControl pitchControl) {
        this.pitchControl = pitchControl;
        this.engine = PhaseDistortionEngine.create();
        this.monoOsc = new Oscillator(engine, pitchControl);
        this.polyOsc = makeOscillators(16, engine, pitchControl);
    }

    public void setBaseDcw(double baseDcw) {
        this.baseDcw = baseDcw;
    }

    public void setDcwModAmount(double dcwModAmount) {
        this.dcwModAmount = dcwModAmount;
    }

    private static Oscillator[] makeOscillators(int count, PhaseDistortionEngine engine, PitchControl pitchControl) {
        Oscillator[] result = new Oscillator[count];
        for (int i=0; i<count; i++) {
            result[i] = new Oscillator(engine, pitchControl);
        }
        return result;
    }

    public void setMode(int newMode) {
        monoOsc.setMode(newMode);
        for (Oscillator osc : polyOsc) {
            osc.setMode(newMode);
        }
    }
    
    public void setNastiness(int nastiness) {
       monoOsc.setNastiness(nastiness);
       for (Oscillator osc : polyOsc) {
            osc.setNastiness(nastiness);
        }
    }

    public double processMono(double voct, double fm, double dcw) {
        double monoPitch = pitchControl.adjustPitch(voct, fm);
        double monoDcw = baseDcw + (dcwModAmount * dcw);
        return monoOsc.synthesize(monoDcw, monoPitch, fm);
    }

    public double processPoly(int channel, double voct, double fm, double dcw) {
        double polyPitch = pitchControl.adjustPitch(voct, fm);
        double polyDcw = baseDcw + (dcwModAmount * dcw);
        return polyOsc[channel].synthesize(polyDcw, polyPitch, fm);
    }

}

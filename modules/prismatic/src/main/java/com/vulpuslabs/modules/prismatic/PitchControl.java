package com.vulpuslabs.modules.prismatic;

public class PitchControl {

    private static final double SEMITONE = 1.0 / 12.0;
    private static final double CENT = 1.0 / 1200.0;
    private static final double EXP_FM_SCALE = 0.2;  // ±5V * 0.2 = ±1 octave max

    // Linear FM scale - converted to increment units
    private static final double LINEAR_FM_SCALE = Oscillator.VOCT_TO_INCREMENT * 0.04;  // Scale FM to increment units

    private double adjustment;
    private double octave;
    private double semitones;
    private double cents;
    private double fmAmt;
    private double linearFmAmt;
    private boolean isExp;

    public int incrementModulation(double fm) {
        return isExp ? 0 : (int) Math.round(fm * linearFmAmt);
    }

    public void setOctave(double octave) {
        this.octave = octave;
        recalculateAdjustment();
    }

    public void setSemitones(double semitones) {
        this.semitones = semitones;
        recalculateAdjustment();
    }

    public void setCents(double cents) {
        this.cents = cents;
        recalculateAdjustment();
    }

    public void setIsExp(boolean isExp) {
        this.isExp = isExp;
    }

    public void setFmAmt(double fmAmt) {
        this.fmAmt = fmAmt;
        this.linearFmAmt = fmAmt * LINEAR_FM_SCALE;
    }

    public void recalculateAdjustment() {
        adjustment = octave + (semitones * SEMITONE) + (cents * CENT);
    }

    public double adjustPitch(double pitch, double fm) {
        pitch += adjustment;

        if (isExp) {
            // Exponential FM: modulate pitch directly (±1 octave at fmAmt=1.0, fm=±5V)
            pitch += fm * fmAmt * EXP_FM_SCALE;
        }
        // Linear FM is handled in Oscillator by modulating the increment directly
        return pitch;
    }
}

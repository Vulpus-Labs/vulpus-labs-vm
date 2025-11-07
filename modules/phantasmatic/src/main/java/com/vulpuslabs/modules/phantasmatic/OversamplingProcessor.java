package com.vulpuslabs.modules.phantasmatic;

/**
 * 2x oversampling processor for high-fidelity anti-aliasing.
 *
 * Runs the oscillator at 96kHz, applies aggressive low-pass filtering
 * to remove frequencies that would alias when decimating back to 48kHz,
 * then decimates to the output sample rate.
 *
 * The anti-aliasing filter is designed to cut off aggressively before
 * Nyquist (24kHz) to prevent aliasing artifacts.
 */
public class OversamplingProcessor {

    private static final int OVERSAMPLE_FACTOR = 2;
    private static final double SAMPLE_RATE = 48000.0;
    private static final double OVERSAMPLED_RATE = SAMPLE_RATE * OVERSAMPLE_FACTOR;

    // Anti-aliasing filter cutoff at ~20kHz (well before Nyquist at 24kHz)
    private static final double AA_FILTER_CUTOFF = 20000.0;

    private final ButterworthLPF aaFilter;

    public OversamplingProcessor() {
        // Create anti-aliasing filter at oversampled rate
        this.aaFilter = new ButterworthLPF(OVERSAMPLED_RATE, AA_FILTER_CUTOFF);
    }

    /**
     * Process one output sample by running the oscillator at 2x rate,
     * filtering, and decimating.
     *
     * @param oscillator The oscillator to process
     * @param dcw Digital Control Waveform parameter
     * @param vOct Pitch in volts per octave
     * @param fm Frequency modulation input
     * @return The decimated output sample
     */
    public double process(Oscillator oscillator, double dcw, double vOct, double fm) {
        // Adjust pitch down by 1 octave to compensate for 2x sample rate
        // (at 96kHz, we need half the increment, which is -1 octave in V/Oct)
        double adjustedVOct = vOct - 1.0;

        // Generate first oversampled sample and filter it
        double sample1 = oscillator.synthesize(dcw, adjustedVOct, fm);
        aaFilter.process(sample1);

        // Generate second oversampled sample, filter, and return it
        double sample2 = oscillator.synthesize(dcw, adjustedVOct, fm);
        return aaFilter.process(sample2);
    }

    /**
     * Reset the anti-aliasing filter state.
     * Call this when voices are reset or phase is discontinuous.
     */
    public void reset() {
        aaFilter.reset();
    }
}

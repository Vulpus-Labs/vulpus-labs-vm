# Chebysynth

## Overview
Chebysynth is a 16-note polyphonic MIDI synthesizer using additive synthesis to generate timbres by adding nine harmonics to a base frequency at different levels. It features dual ADSR envelopes (volume and harmonic modulation), multiple oscillator voices per note with pitch/stereo spreading, and Chebyshev polynomial-based feedback for FM-like tones.

## How It Works
Uses additive synthesis with Chebyshev polynomials (like the Chebz oscillator) to generate harmonics. Each note can use up to 8 oscillator voices with controllable pitch spread, stereo spread, and drift for rich timbres.

**Dual envelopes:**
- Volume ADSR: Controls amplitude of each note
- Harmonic ADSR: Modulates boost/cut of individual harmonics via knobs beneath harmonic sliders

**Modulation:**
- Vibrato with controllable speed and depth
- Feedback: Feeds harmonic-enriched signal back into fundamental for FM-like metallic tones
- MIDI mod wheel assignable to feedback, vibrato depth, or harmonic modulation amount

## Key Controls
- **MIDI IN**: Receives MIDI signals
- **VOLUME ADSR**: Amplitude envelope controls
- **HARMONIC ADSR**: Timbre modulation envelope
- **Harmonic sliders** (0-9): Set level of fundamental and 9 harmonics (-100% to +100%)
- **Harmonic knobs** (0-9): Control how much harmonic envelope affects each harmonic
- **VOICES COUNT**: Number of oscillators per note (1-8)
- **PITCH SPREAD**: Pitch variation across voices
- **STEREO SPREAD**: Stereo positioning spread (only works if both L/R outputs connected)
- **DRIFT**: Random pitch variation per voice
- **VIBRATO SPEED/DEPTH**: Global vibrato parameters
- **FEEDBACK**: Level of self-modulation for FM-like tones
- **MOD WHEEL**: Assigns MIDI mod wheel to feedback, vibrato, or harmonics
- **AUDIO OUT L/R**: Stereo outputs

## Implementation Notes
- Stereo processing disabled if only L output connected
- Harmonics are bidirectional: center = silent, up = in-phase, down = inverted
- If harmonic modulation knobs at 0%, harmonic ADSR has no effect
- Uses Chebyshev polynomials for efficient harmonic generation (same as Chebz)

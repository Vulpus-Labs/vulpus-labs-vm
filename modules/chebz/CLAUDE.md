# Chebz

## Overview
Chebz is a waveform synthesis toolbox that builds complex tones by stacking sine waves at different frequencies using Chebyshev polynomials. It efficiently generates a fundamental sine wave plus 9 harmonics, with controllable blending, optional wave-folding, and individual outputs for each harmonic.

## How It Works
Uses Chebyshev polynomials to efficiently generate harmonics (fundamental + 1st through 9th) from a base frequency. The blend of harmonics can be controlled and modulated, along with the balance of odd vs even harmonics.

**Harmonic numbering (potentially confusing):**
- "Even" harmonics (1, 3, 5, 7, 9) = even multiples of fundamental
- "Odd" harmonics (0, 2, 4, 6, 8) = odd multiples of fundamental

Each harmonic has dedicated volume control with optional modulation input, plus individual output jack (can output either modulated or unmodulated signal via MOD BYPASS switch).

**Optional processing:**
- Wave-folding for values outside -5v to +5v range
- 8x oversampling (for heavy audio-rate modulation)
- Smoothing (none/medium/high) for modulation inputs to reduce clicks
- Visual scope shows resulting waveform

## Key Controls
- **FREQUENCY**: Base pitch control (centered on C2/65.41Hz)
- **V/OCT**: Standard 1V/octave pitch input
- **FM**: Exponential frequency modulation (±6 semitones)
- **Harmonic volume controls** (0-9): Each has knob, mod input, and output
- **ODD/EVEN/ALL outputs**: Summed outputs of respective harmonic groups
- **FOLDING switch**: Enables/disables wave-folding
- **ODD/EVEN BALANCE**: Controls mix sent to ALL output (with smoothing option)
- **SMOOTHING**: Filter for volume modulation (none/medium/high)
- **MOD BYPASS**: Sends unmodulated harmonics (full volume) to outputs
- **OVER SAMPLE**: 8x oversampling toggle

## Implementation Notes
- Cross-patching harmonic outputs to other harmonics' mod inputs creates complex interactions
- Smoothing prevents clicks from fast transitions (like square waves) but filters audio-rate sine modulation
- Inspired by Squinky Labs' Chebyshev module
- Uses Chris Neuberger's IIR resampling filter (via R_Ware) for oversampling
- Scope visualizes ALL output waveform

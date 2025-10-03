# Glow Up

## Overview
Glow Up is a spectral shaping module that detects prominent frequencies in its input and boosts the 1st, 2nd, and 3rd harmonics above those frequencies by controllable amounts. Similar to an octave-up pedal but achieved entirely through spectral processing using FFT. Introduces adjustable latency to accommodate processing time.

## How It Works
Uses Fast Fourier Transform (FFT) to divide input into frequency bands via overlapping windows. Detects prominent frequencies (higher than average energy) and boosts harmonics:
- 1st harmonic (+12 semitones): One octave up
- 2nd harmonic (+19 semitones): Octave + fifth up
- 3rd harmonic (+24 semitones): Two octaves up

Boosted frequencies are passed through a filter (cuts lows, boosts highs around center frequency), then recombined and written to output buffer.

**Quality settings:**
- Low: 512-sample windows
- Medium: 1024-sample windows
- High: 2048-sample windows (better for complex harmonic content like chords)

## Key Controls
- **IN**: Input jack
- **OUT**: Output jack
- **QUALITY**: FFT window size (512/1024/2048 samples)
- **+12 knob**: Boost amount for 1st harmonic (octave up)
- **+19 knob**: Boost amount for 2nd harmonic (octave + fifth)
- **+24 knob**: Boost amount for 3rd harmonic (two octaves)
- **Latency LED**: Double-click to increase latency if flashing red (indicates buffer underrun)

## Implementation Notes
- Introduces processing latency (adjust if LED flashes red indicating glitches)
- Higher quality = better for complex signals (polyphonic synths, chords) but more latency
- Lower quality = faster processing, suitable for monophonic/simple signals
- Uses Will C. Pirkle's FFT techniques from "Designing Audio Effect Plugins in C++"
- Pay attention to latency indicator: red flash means increase latency setting
- Not a real-time pitch shifter; operates in frequency domain

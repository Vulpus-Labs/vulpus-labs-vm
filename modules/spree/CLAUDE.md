# Spree

## Overview
Spree is a polyphonic chorus effect with per-channel randomized parameter drift. Each polyphonic voice gets a slightly different chorus modulation character, creating dynamic, phase-shifting textures across polyphonic chords and pads. The drift causes modulation cycles to move in and out of phase between voices, producing a complex, musical quality.

## How It Works
Standard chorus is applied to each polyphonic channel: signal captured to buffer, delayed and rate-modulated voice extracted and blended with original, with optional feedback. Four parameters (TIME, WIDTH, SPEED, FEEDBACK) drift slowly by random amounts (80-120% of control value). SPREAD parameter controls drift range: 0% = no drift (synchronized), 100% = maximum drift (wide variation between channels).

## Key Controls
- **IN**: Polyphonic input jack
- **OUT**: Polyphonic output jack
- **TIME**: Delay length (4-50ms) + CV input/attenuator
- **DEPTH** (WIDTH): Rate-modulation width (pitch wobble amount) + CV input/attenuator
- **SPEED**: Rate-modulation speed (0.12-8Hz, wobble rate) + CV input/attenuator + range switch (high: 1-8Hz, low: 0.12-1Hz)
- **FBCK**: Feedback amount (0-99%) + CV input/attenuator
- **MIX**: Wet/dry balance + CV input/attenuator
- **SPREAD**: Drift range (0-100%, no drift to maximum drift)

## Implementation Notes
- More CPU-intensive than monophonic chorus; not recommended for single voices
- Best used when dynamic phasing between polyphonic channels is desired
- Alternative: mix polyphonic down to mono/stereo first, then use standard chorus
- Drift creates "chorus of instruments" effect vs uniform modulation
- High shelving filter + soft-clipping on feedback enables higher FBCK without ringing

# Curvaceous

## Overview
Curvaceous is a polyphonic oscillator that plays waveforms formed of up to seven curve segments. It uses the same waveform controls as Curvature but generates its own internal sawtooth wave for each polyphonic channel, functioning as a dedicated oscillator rather than a voltage-to-voltage converter. Includes standard polyphonic oscillator controls (V/OCT, FM, sync, octave selection).

## How It Works
Internally generates a sawtooth wave (-5v to +5v) at the desired frequency for each polyphonic channel. This sawtooth is fed through a Curvature-style curve generator that maps input "x" values to output "y" values based on up to 8 points with configurable segment shapes.

**Curve definition:**
- Start point (x = -5v) and end point (x = +5v) have fixed x values, controllable y values
- Up to 6 intermediate points with controllable x and y values
- Segment shapes between points: Step, Linear, Quarter sine, Inverse quarter cosine, Sinusoid
- For smooth waveforms, start and end y values should match (avoid discontinuity)

Built-in oscilloscope shows resulting waveform.

## Key Controls
**Oscillator section (left):**
- **PITCH/SYNC**: Polyphonic V/OCT and hard sync inputs
- **FREQ MOD**: Poly and mono FM (LIN/EXP switchable, with attenuvertors)
- **PITCH knob**: ±7 semitone offset
- **Range buttons**: Base octave selection (organ pipe convention)
- **AUDIO OUT**: Polyphonic output

**Waveform section (right):**
- **X START/Y START**: Start point (x fixed at -5v)
- **Point rows** (6x): X position, Y level, and CURVE shape for intermediate points
- **X END/Y END**: End point (x fixed at +5v)
- **CV inputs**: Override knob values when connected

## Implementation Notes
- Exists because Curvature is commonly used as oscillator, but polyphonic would be cumbersome
- Curvature is voltage-to-voltage converter; Curvaceous is dedicated oscillator
- Intermediate points ignored if x value not greater than previous point
- CV inputs completely override manual knobs
- Use Curvature manual examples for waveform design (sine wave, variations)
- Segment curve knob selects from 5 shapes affecting transition between points

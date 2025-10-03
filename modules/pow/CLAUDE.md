# Pow!

## Overview
Pow! is a non-linear voltage-to-voltage converter applying a power function to shape input signals. Maps 0v→0v and +5v→+5v through a controllable midpoint (x, y) where +xV→+yV. Supports three rectification modes for negative voltages: inverse curve, rectification, or rectification with scaling/bias correction. Good for waveshaping, harmonic distortion, and dynamic modulation effects.

## How It Works
Input voltages (-5v to +5v) are mapped to -1 to +1 range, transformed via power function y = |x|^n where exponent n is derived from midpoint (x, y) coordinates. Negative voltages handled three ways: inverse curve mapping -5v→-5v and -xV→-yV; rectified mapping -5v→+5v and -xV→+yV; or rectified with scaling/bias (10y-5). Midpoint coordinates can be set via knobs, clicked on display, or modulated by CV. Mono/stereo/polyphonic processing supported.

## Key Controls
**Top (IN section)**:
- **L / R / POLY jacks**: Signal inputs (L only = mono→stereo, L+R = stereo, POLY = polyphonic processing)

**Center**:
- **Curve display**: Visual representation of power curve, click to set midpoint position
- **MID POINT X / Y knobs**: Set midpoint coordinates (0.001-0.999 for each)
- **MOD IN X / Y**: CV inputs for midpoint modulation
- **MOD AMT X / Y**: Modulation amount attenuators

**Bottom**:
- **RECTIFICATION knob**: Three-position selector (left = no rectification/inverse curve, middle = rectified, right = rectified + scaled/bias corrected)
- **OUT L / R / POLY**: Signal outputs

## Implementation Notes
- Power function exponent ranges from log(0.999)/log(0.001) to log(0.001)/log(0.999), equals 1 when midX = midY
- Controllable midpoint enables interesting modulation combinations where midX affects midY's influence on curve shape and vice versa
- At midpoint (0.5, 0.5), signal passes through unchanged
- Modulating midX/midY with envelopes or oscillators creates complex waveforms and dynamic timbral changes
- Rectification modes: frequency doubling (middle), DC-shifted output (right)
- Good for "thinning" (midX > midY) or "fattening" (midX < midY) waveforms

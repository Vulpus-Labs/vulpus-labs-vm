# Swirl

## Overview
Swirl is a dual-mode polyphonic module that converts polar coordinates (angle/radius) to Cartesian coordinates (X/Y). In "drift" mode, it generates two correlated randomly-drifting CV values per polyphonic channel. In "processing" mode, it acts as a polyphonic wave-shaper combining wave-folding and ring modulation effects. Includes visual scope showing polar coordinate positions.

## How It Works
**Drift Mode** (default, no inputs connected): Emits X/Y coordinates of points slowly moving through polar space toward random targets. Points "swirl" clockwise/anticlockwise, spiraling in/out from origin. X/Y values (±5v) rise/fall non-linearly, slowing at extremes. Auto-retrig or manual/CV trigger for new targets. Combined amplitude never exceeds 5.0.

**Processing Mode** (angle/radius inputs connected): Converts polyphonic angle (θ) and radius (r) inputs to X/Y outputs. At 100% drive: +2.5v = North, -2.5v = South, 0v = East, ±5v = West. Radius determines distance from origin (unipolar or bipolar mode). Drive amplifies angle input for wave-wrapping distortion. Radius variation creates ring modulation-like effects at audio rate.

## Key Controls
**Processing Mode (left side)**:
- **r in**: Polyphonic radius input + unipolar/bipolar switch
- **θ in**: Polyphonic angle input
- **DRIVE**: Angle amplification knob + CV input/attenuator (creates wave-wrapping distortion)

**Drift Mode (bottom)**:
- **START DRIFT**: Manual trigger button
- **TRIGGER DRIFT**: Trigger input jack
- **DRIFT LENGTH**: Duration knob + range switch (fast/slow)
- **AUTO RETRIG**: Auto-trigger new targets when reached
- **DESYNC**: Random variation in drift length

**Output (bottom right)**:
- **X OUT**: X-coordinate output (polyphonic)
- **Y OUT**: Y-coordinate output (polyphonic)
- **DC bias correction switch**: Enable in processing mode if points cluster in one scope region

## Implementation Notes
- Visual scope displays polar coordinates in both modes (drift points or audio-rate plotting)
- Drift mode: good for introducing variance/movement in polyphonic synth parameters
- Processing mode: audio-rate wave-shaping, prettier scope patterns often = better sound
- DC bias correction disabled in drift mode (would eliminate slow-moving signals)
- Two modes use same underlying polar→Cartesian conversion function

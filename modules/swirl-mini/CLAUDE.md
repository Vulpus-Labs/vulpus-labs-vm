# Swirl Mini

## Overview
Swirl Mini is a compact version of Swirl with identical behavior but no visual scope. Dual-mode polyphonic module converting polar coordinates to Cartesian: "drift" mode generates correlated randomly-drifting CV pairs per channel; "processing" mode provides polyphonic wave-shaping. Smaller footprint, more CPU-efficient than Swirl. If behavior seems opaque, try Swirl first to visualize what's happening.

## How It Works
**Drift Mode** (no inputs): Emits X/Y coordinates of points moving through polar space toward random targets. Points swirl clockwise/anticlockwise, spiraling in/out. X/Y values (±5v) move non-linearly, slowing at extremes. Auto-retrig or manual/CV trigger for new targets.

**Processing Mode** (inputs connected): Converts polyphonic angle (θ) and radius (r) to X/Y outputs. At 100% drive: +2.5v angle = North, 0v = East, ±5v = West. Radius sets distance (unipolar/bipolar). Drive creates wave-wrapping. Radius modulation produces ring mod effects at audio rate.

## Key Controls
**Left strip (Processing Mode)**:
- **r in**: Polyphonic radius input + unipolar/bipolar switch above
- **θ in**: Polyphonic angle input
- **DRIVE**: Angle amplification knob + CV input/attenuator

**Right strip (Drift Mode)**:
- **START DRIFT**: Manual trigger button
- **TRIGGER DRIFT**: Trigger input jack
- **DRIFT LENGTH**: Duration knob + range switch
- **AUTO RETRIG**: Auto-trigger toggle
- **DESYNC**: Drift length randomization toggle

**Bottom**:
- **X OUT / Y OUT**: Polyphonic coordinate outputs
- **DC bias correction switch**: Enable in processing mode if needed

## Implementation Notes
- Identical function to Swirl, but no visual scope (smaller, more efficient)
- Use for drift: variance/movement in polyphonic synth modulation
- Use for processing: audio-rate wave-shaping/distortion effects
- DC bias disabled in drift mode (preserves slow-moving signals)
- Refer to Swirl manual/scope for visual understanding of operation

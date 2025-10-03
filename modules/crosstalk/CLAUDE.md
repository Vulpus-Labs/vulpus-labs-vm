# Crosstalk

## Overview
Crosstalk is a polyphonic module that propagates signals across polyphonic channels, mixing and muddying pristine separation. It has two modes (usable simultaneously): Bleed mode (imitates capacitative coupling) and Ring Modulation mode (multiplies channels for ringing distortion). Good for dirtying-up polyphonic synths and adding cohesion to stereo-separated signals.

## How It Works
For each polyphonic channel, Crosstalk generates a "crossed" signal containing:
- Low-level noise (if noise generator enabled)
- Attenuated "bleed" from other channels
- Sum of ring modulation products (channel × all other channels)

This crossed signal is filtered (cuts lows, boosts highs around center frequency), then mixed back into the target channel.

## Key Controls
- **IN**: Polyphonic input
- **OUT**: Polyphonic output
- **BLEED knob**: Level of cross-channel bleed (CV modulatable)
- **RING knob**: Level of ring modulation (CV modulatable)
- **FILTER knob**: Center frequency for high-pass/boost filter (CV modulatable)
- **Noise switch**: Toggles low-level noise generator on/off
- **MIX knob**: Wet/dry balance
- **CV inputs + attenuators**: For BLEED, RING, and FILTER modulation

## Implementation Notes
- Works on polyphonic channels (typical use: after Poly Stereo Spread)
- Bleed simulates hardware capacitative coupling
- Ring modulation creates intermodulation between all channel pairs
- Filter emphasizes high frequencies in the "dirt"
- All three effects (noise, bleed, ring mod) can be used together
- Pay-for-what-you-use CPU: zero-level effects are bypassed

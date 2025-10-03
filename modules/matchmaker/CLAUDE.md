# MatchMaker

## Overview
MatchMaker is a gain-matched effects loop utility that automatically compensates for volume differences between the dry signal sent to an effect and the wet signal returned. Uses envelope-following RMS analysis to match the output gain to the input level, ensuring consistent volume regardless of effect processing. Features configurable attack/release times, send gain control, and wet/dry mix. Good for maintaining consistent levels when using external effects or creating parallel processing chains.

## How It Works
Input signal is analyzed for RMS level with separate attack/release envelope followers. Signal is sent to effect via SEND output with optional gain adjustment. RETURN input is analyzed for RMS level. Gain correction is calculated as sqrt(inputRMS / outputRMS) and applied to the returned signal to match the input level. Mixed return (wet/dry blend) is gain-matched and sent to output. Stereo operation: L input copied to R when R disconnected; L circuit copied to R output when R jacks unused but R output connected. Smoothed send gain prevents zipper noise.

## Key Controls
**Top (IN section)**:
- **L / R INPUT**: Stereo inputs (L only = mono copied to both)

**Center**:
- **ATTACK**: Envelope follower attack time (1-50ms, default 5ms) - how quickly gain matching responds to level increases
- **RELEASE**: Envelope follower release time (1-50ms, default 5ms) - how quickly gain matching responds to level decreases
- **SEND GAIN**: Pre-effect gain adjustment (-24dB to +24dB, default 0dB) - compensate for effect input sensitivity

**Bottom (EFFECT LOOP section)**:
- **SEND L / R**: Effect loop send outputs
- **RETURN L / R**: Effect loop return inputs
- **EFFECT MIX**: Wet/dry balance (0-100%, default 100%) - blend between send signal and returned signal before gain matching

**Bottom (OUT section)**:
- **L / R OUTPUT**: Gain-matched outputs

## Implementation Notes
- Gain matching uses sqrt(sendMS / returnMS) to preserve energy rather than simple ratio
- RMS threshold of 0.001 prevents divide-by-zero and excessive gain on silence
- Attack/release use exponential decay: alpha = exp(-1 / (timeMs * sampleRate))
- Send gain smoothed with 99% pole filter to prevent zipper noise
- Gain matching occurs after wet/dry mix, not before - mix control blends before correction
- Module name "MatchMaker" but class name "GainMatcher" - focuses on automatic gain compensation for effect loops
- Stereo routing intelligence: copies L→R input when needed, copies L→R output only if R jacks unused but R output connected

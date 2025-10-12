# Magnus

## Overview
Magnus is a stereo maximizer/limiter with automatic gain control, soft-knee gating, high-pass filtered RMS detection, and configurable ceiling limiting. Analyzes input signal RMS with separate attack/release envelopes and high-pass filtering for more perceptual accuracy, applies gain to reach target volume level, gates quiet signals to reduce noise, and applies soft limiting with adjustable ceiling to prevent clipping. Features cubic-curve gate transition, adjustable target volume, configurable ceiling threshold, and asymptotic peak limiting. Good for mastering, loudness maximization, and dynamic range control.

## How It Works
Input signal (±5v normalized to ±1) processed per-channel: (1) High-pass filtering: configurable 1-pole HPF (20-200Hz) applied to side-chain for RMS calculation only, (2) RMS calculation with attack/release envelope followers using filtered signal (faster attack, slower release), (3) Gate: signals below threshold-10dB = 0% gain, above threshold = 100% gain, transition uses cubic curve, (4) Gain: calculates dB difference between current RMS and target, applies gain to original signal interpolated by gate factor, (5) Soft limiting: signals above configurable ceiling threshold compressed with asymptotic curve (position / (1 + position * rangeReciprocal)), output renormalized to ±5v. Attack follows rising levels, release follows falling levels. Mono input automatically copied to right channel.

## Key Controls
**Top (INPUT section)**:
- **L (M) / R**: Stereo inputs (L only = mono copied to both channels)

**Center**:
- **ATTACK**: RMS envelope attack time (0.5-50ms, default 5ms) - how quickly maximizer responds to level increases
- **RELEASE**: RMS envelope release time (20-200ms, default 50ms, midpoint 50ms) - how quickly maximizer responds to level decreases
- **GATE**: Gate threshold (-60 to -12 dBFS, default -60 dBFS) - signals quieter than this get reduced gain, 10dB transition range below threshold
- **TARGET**: Target output volume (-12 to 0 dBFS, default -6 dBFS) - desired output level, gain applied to reach this

**Bottom**:
- **CEILING**: Peak limiting threshold (-6 to -0.1 dBFS, default -1 dBFS) - maximum output level, signals above this are soft-limited
- **HP**: High-pass filter frequency (20-200Hz, default 20Hz) - filters RMS side-chain to reduce low-frequency dominance

**Bottom (OUTPUT section)**:
- **L / R**: Maximized stereo outputs

## Implementation Notes
- Peak limiting threshold: configurable via Ceiling knob (default -1dB)
- High-pass filter: 1-pole HPF with alpha = rc / (rc + dt) where rc = 1/(2πf), dt = 1/48000
- HPF applied to RMS side-chain only: gain applied to original unfiltered signal
- Gate uses cubic curve for smooth transition: position³ over 10dB range
- Gain calculation: gainDb = targetDbfs - currentDbfs, converted to linear via 10^(gainDb/20)
- Gain interpolated by gate factor: gain = 1 + gateFactor * (fullGain - 1)
- RMS alpha calculation: 1 - exp(-1 / (timeMs * 48.0)) - attack/release switch based on sample > meanSquare
- Soft limiter uses asymptotic compression: position / (1 + position * rangeReciprocal) where rangeReciprocal = 1 / (1.0 - peakThreshold)
- Input scaled by 0.2, output scaled by 5.0 (±5v to ±1 normalization)
- Zero-crossing protection: if meanSquare == 0, return sample unchanged
- Module type: Utility (not Effect) - indicates gain staging / mastering tool

# Beverley

## Overview
Beverley is an advanced bitcrusher and harmonic distortion module combining intelligent gain control, gamma correction, and smoothed quantization. Unlike traditional bitcrushers that simply quantize input signals, Beverley creates harmonically rich distortion suitable for guitars, drums, synths, and other audio sources. Features interpolated bit depth, automatic peak-controlled gain compensation, and asymmetric/symmetric crush modes.

## How It Works
Input signal (-5v to +5v) normalized to -1 to +1, then processed through nine stages: (1) Gain (fixed 0-20dB or auto-detected envelope-following), (2) Hard clipping to ±1, (3) Gamma power-law transform shifting amplitude distribution, (4) Quantization to chosen bit depth (fractional depths interpolated between adjacent whole-number depths), (5) Smoothing (0 = fully quantized, 0.5 = S-shaped smoothstep transitions, 1.0 = transparent reconstruction), (6) Reverse gamma, (7) Reverse gain, (8) Reverse normalization to -5v to +5v. Auto-gain enables quieter signals to use full quantization range. Gamma affects dynamic impact by redistributing which amplitude levels get most quantization levels.

## Key Controls
**Top**:
- **L / R IN**: Stereo inputs (L only = mono copied to both channels)
- **L / R OUT**: Stereo outputs

**Center**:
- **(AUTO) GAIN**: Toggle for envelope-following gain correction + yellow knob for fixed gain (0-20dB)
- **GAMMA**: Blue knob for power-law transform amount + CV input/attenuator at bottom
- **BIT DEPTH**: Purple knob for quantization levels + CV input/attenuator (DEPTH) at bottom
- **SMOOTHING**: Green knob (0 = hard quantization, 0.5 = smoothstep, 1.0 = transparent)
- **CRUSH MODE**: Two-position switch (asymmetrical = entire signal range quantized, symmetrical = positive/negative ranges independently quantized)

**Bottom**:
- **GAMMA CV input + modulation knob**: Modulate gamma amount
- **DEPTH CV input + modulation knob**: Modulate bit depth

## Implementation Notes
- Smoothing preserves rapid transitions between quantization levels while mathematically smoothing out steps
- Auto-gain follows envelope so quieter/louder parts use same number of quantization intervals
- Gamma shifts amplitude distribution: affects behavior on attack transients vs sustained parts
- Interpolated bit depth enables smooth parameter sweeps without zipper noise
- Best understood by feeding sine wave and viewing output in oscilloscope
- Symmetric crush mode independently quantizes positive/negative signal halves

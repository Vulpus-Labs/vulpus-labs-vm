# Torment Nexus

## Overview
Torment Nexus is a signal mangler offering six modes of combination between two inputs (sum, amplitude modulation, ring modulation, analog ring modulation, delta amplitude modulation, delta ring modulation). Extensive signal shaping at input and output stages: ampliversion (±200% gain/inversion), feedback mixing, clipping/folding/saturation, and optional rectification. Good for extreme modulation and distortion effects.

## How It Works
Each input is ampliverted (±200% gain, negative inverts), mixed with feedback, shaped (clip/fold/saturate to ±5v range), optionally rectified (negative→positive). Shaped inputs feed the torment circuit (one of six combination modes). Output is ampliverted again, shaped, then sent to feedback lines and main output. Optional 8x oversampling and DC bias correction.

**Six Torment Modes**:
1. **Sum**: Inputs added (÷2 to stay in range)
2. **Amplitude Modulation**: Carrier × Modulation (mod scaled 0-1v)
3. **Ring Modulation**: Carrier × Modulation (mod scaled -1 to +1v)
4. **Analog Ring Modulation**: Emulates nonlinear 4-diode analog circuit
5. **Delta Amplitude Modulation**: (Carrier_delta × Mod[0-1v]) + previous_out
6. **Delta Ring Modulation**: (Carrier_delta × Mod[-1 to +1v]) + previous_out (50% mix with carrier if mod not rectified)

## Key Controls
**Top (CARRIER and MODULATION sections, identical)**:
- **IN**: Input jack
- **Shape selector**: CLIP / FOLD / SAT (applied after gain + feedback)
- **AMP knob + AMP CV input + CV Amount**: Gain/inversion control (±200%)
- **RECTIFY switch**: Converts negative to positive voltage
- **Gain meter**: Visual feedback

**Center**:
- **TORMENT SELECTOR**: Choose combination mode (Sum/AM/RM/Analog RM/Delta AM/Delta RM)
- **8X button**: Toggle 8x oversampling
- **DC BIAS switch**: Toggle DC bias correction

**Bottom**:
- **FEEDBACK (Carrier/Modulation)**: CV input + Amount + Gain knobs controlling feedback to each input
- **OUTPUT section**: Shape selector (CLIP/FOLD/SAT) + AMP controls + OUT jack + Gain meter

## Implementation Notes
- Extensive signal shaping enables extreme but controlled distortion
- Feedback paths create self-modulating effects
- Delta modes use sample-to-sample differences for unique modulation character
- 8x oversampling reduces aliasing in harsh modulation/distortion
- Ampliversion (amplify + invert) allows phase inversion and boost/cut

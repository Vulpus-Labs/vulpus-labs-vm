# Catkins Stereo

## Overview
Catkins Stereo is functionally identical to Catkins, but with stereo I/O. It's a digital multi-tap delay with six controllable read heads in a circular buffer, designed for true modular-style control without tape emulation.

## How It Works
Same core operation as Catkins: input is captured into a rolling buffer with six read heads. Each read head position is controlled manually and via CV, with send/return loops for each tap. The wet signal (summed returns) is mixed with dry input and can be fed back.

The stereo version duplicates IN, OUT, SEND, and RET jacks with L and R channels, enabling stereo effects like ping-pong delay.

## Key Controls
- **IN L/R**: Stereo input jacks
- **OUT L/R**: Stereo output jacks
- **MIX**: Dry/wet balance (CV modulatable)
- **FBCK**: Feedback amount (CV modulatable)
- **POS knobs** (6x): Read head position/delay amount
- **MOD inputs** (6x): CV modulation of delay (0-5v adds delay)
- **SND L/R, RET L/R** (6x pairs): Stereo send/return for each tap
- **RANGE**: Maximum delay (10ms to 10s)
- **QUALITY**: Interpolation algorithm (LOW/HIGH)

## Ping-Pong Usage
For ping-pong delay with mono input:
- Patch input to IN L
- Cross-wire send/return: SND L → RET R, SND R → RET L

## Implementation Notes
- All Catkins functionality applies
- Send/return loops can be cross-patched for creative stereo effects
- Feedback circuit includes DC correction, shelving EQ, and saturation
- Related module: Rapscallion (designed to work with Catkins/Stereo for pitch-shifted/reversed delay effects)

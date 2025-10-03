# Catkins

## Overview
Catkins is a digital multi-tap delay module that behaves like a tape echo unit with multiple read heads, without attempting to emulate tape character. It isolates the circular buffer component of effects like chorus/flanger/vibrato and multi-tap delay, making it available for modular-style control.

## How It Works
The input signal is captured into a rolling buffer with six read heads positioned behind the write head. Each read head position is controlled by a manual knob and CV modulation, with a maximum delay of 20 seconds. Each read head has a send/return loop, with returns summed into the "wet" signal which is mixed with the dry input.

The wet signal can be fed back through a feedback circuit that applies DC bias correction, gentle low/high frequency shelving, and saturation to prevent runaway amplification.

Delay range is set via a five-position switch (10ms to 10s). A quality switch selects between linear interpolation (low) and cubic Hermite interpolation (high) for fractional delay values.

## Key Controls
- **IN**: Input signal jack
- **OUT**: Mixed dry/wet output
- **MIX**: Controls dry/wet balance (CV modulatable)
- **FBCK**: Controls feedback amount (CV modulatable)
- **POS knobs** (6x): Set read head position/delay amount
- **MOD inputs** (6x): CV modulation of delay time (0-5v adds delay)
- **SEND/RET jacks** (6x pairs): Send/return loops for each tap
- **RANGE**: Sets maximum delay (10ms, 100ms, 1s, 5s, 10s)
- **QUALITY**: Interpolation algorithm (LOW/HIGH)

## Implementation Notes
- MOD inputs are unipolar: negative values are inverted to positive
- Each tap can be processed independently via send/return loops
- Feedback circuit includes saturation to prevent runaway gain
- Can be used for chorus/flanger (short delays) or multi-tap delay (longer delays)
- Related module: Catkins Stereo provides stereo I/O with separate L/R send/return pairs for ping-pong effects

# Scapegrace

## Overview
Scapegrace is a randomizing stereo delay effect that maintains a rolling 16-second memory and, when triggered, selects random slices to replay. Up to 16 slices can play simultaneously with randomized length, pitch, panning, and optional reverse/double-speed playback. Replays can be fed back into the buffer, creating continuously varying soundscapes from input material.

## How It Works
Continuously records input into 16-second circular buffer. On trigger, spawns a "voice" (up to 16 simultaneous) that replays a random slice with randomized effects:

**Randomized parameters:**
- Slice position in buffer
- Slice length (within controllable range)
- Pitch modification (±0.5 semitone max)
- Stereo panning (within controllable width)
- Reverse playback (probabilistic)
- Double-speed playback (probabilistic, +1 octave)

All slices fade in/out (min 100ms, controllable up to 100% of slice length) to avoid clicks. Voices can be fed back into recording buffer, creating recursive effects.

## Key Controls
- **INPUT L/R**: Stereo inputs
- **TRIG**: Trigger to spawn new voice
- **SIZE**: Random slice length range
- **FADE**: Fade in/out duration (percentage of slice)
- **WIDTH**: Stereo panning range
- **FBCK**: Feedback level (voices → buffer)
- **MIX**: Dry/wet balance
- **REV**: Probability of reverse playback (0-100%)
- **DBL**: Probability of double-speed/octave-up (0-100%)
- **MOD**: Maximum random pitch modification amount
- **OUTPUT L/R**: Stereo outputs

## Implementation Notes
- All parameters have both knob and CV input (CV scales from minimum to knob value)
- Maximum 16 simultaneous voices
- Intended for continuously varying soundscapes, not deterministic delays
- Pay-for-what-you-use CPU: zero-amount effects are bypassed
- Stereo processing always active internally (even with mono input)
- Inspired by "drifting looper" discussion
- Feedback can create wall of sound (use sparingly)
- Feedback circuit filtered and limited at 0dB to prevent runaway

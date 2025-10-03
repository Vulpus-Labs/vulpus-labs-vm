# Cumulonimbus

## Overview
Cumulonimbus is a granular delay effect that emits short "grains" (10ms-1s segments) from a chosen position in a recording buffer when triggered. Up to 64 grains can play simultaneously, with controllable position offset, replay speed, length, and envelope shape. Enables effects from pitch-shifting and texture generation to diffused/glitchy delays. Buffer can be frozen for static granular processing.

## How It Works
Continuously records input into a buffer. On trigger, emits a grain starting from a position in the buffer. Each grain has:
- Controllable/modulatable position (where in buffer to read)
- Controllable/modulatable length (10ms-1s)
- Controllable/modulatable pitch (playback speed)
- Fade in/out envelope (percentage of grain length)
- Random panning (stereo)

Buffer can be frozen (manually or via gate) to lock current contents for granular processing. Feedback circuit routes grain playback back into recording buffer.

Visual display shows buffer contents (green) and active grain positions (yellow stripes).

## Key Controls
- **INPUT L/R**: Stereo inputs
- **TRIGGER IN**: Trigger input (or manual button) to spawn grain
- **FREEZE GATE**: Input/button to freeze buffer
- **POSITION**: Where in buffer to start grain (CV modulatable)
- **LENGTH**: Grain duration (CV modulatable)
- **PITCH**: Playback speed/pitch shift (CV modulatable)
- **FADE**: Percentage of grain spent fading in/out (CV modulatable)
- **PAN**: Stereo position modulation (CV modulatable)
- **FEEDBACK**: Amount fed back to buffer (CV modulatable)
- **LEVEL**: Input signal level
- **MIX**: Dry/wet balance
- **OUTPUT L/R**: Stereo outputs

## Implementation Notes
- Trigger on positive voltage crossing (connect sine LFO for constant rate, S&H for random)
- Freeze LED shows buffer frozen state
- Trigger LED glows red as active grains approach maximum (64)
- Grains always fade in/out to avoid clicks
- CV inputs completely override knob values when connected
- Maximum 64 simultaneous grains

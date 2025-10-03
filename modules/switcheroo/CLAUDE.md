# Switcheroo

## Overview
Switcheroo is a pattern-based step sequencer that switches between four inputs, smoothly crossfading when switching. 16-step programmable pattern, controllable crossfade length, per-input volume control (with CV modulation), and trigger outputs per input. External clock driven, 2-16 configurable step count. Good for rhythmic switching, source interleaving, and trance-gapper effects.

## How It Works
Each step, the sequencer selects one of four inputs based on a 16x4 grid pattern. When input changes, it crossfades (2-50ms) between old and new sources. Each input has independent volume control (0-200%) with CV modulation. Four trigger outputs fire when corresponding input is selected (only on switch, not repeated for consecutive steps). Up to 16 overlapping crossfades can be active simultaneously with fast tempo + long crossfade.

## Key Controls
**Top**:
- **Four INPUT jacks**: Signal sources to switch between (unconnected = silent/0v)
- **VOLUME 1-4 knobs**: Per-input gain (0-200%) + CV inputs with attenuators (CV at -5v = 0%, +5v = knob value)

**Center**:
- **16x4 STEP SEQUENCER grid**: Click cells to set input per step (rows = inputs, columns = steps, current step illuminated)
- **STEP COUNT**: Number of steps before loop (2-16)

**Bottom Left**:
- **CLOCK**: Trigger input to advance step (trigger or LFO rising edge)
- **RESET**: Trigger input to jump to first step
- **CROSSFADE**: Crossfade length (2-50ms) + CV input/attenuator

**Bottom Right**:
- **OUTPUT**: Main signal output
- **TRIGGER OUT 1-4**: Trigger outputs (5v when corresponding input selected on switch)

## Implementation Notes
- Minimum ~2ms crossfade prevents audio clicking when switching
- Can be used as pure trigger sequencer (no inputs connected)
- Trigger outputs only fire on input switch, not for consecutive identical steps
- Suggested uses: trance gapper (same source, rhythmic volume patterns), rhythmic modulation (effect chain switching), source interleaving (e.g., 5-step sequence × 7-step sequence switched over 9 steps = 315-step combined pattern)

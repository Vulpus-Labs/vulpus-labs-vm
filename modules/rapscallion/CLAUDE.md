# Rapscallion

## Overview
Rapscallion has two functions: (1) Gates stereo input with controllable length, panning, and fade, and (2) generates a modulation signal for Catkins/Catkins Stereo delay taps to create pitch-shifted/reversed playback effects. Designed to work alongside Catkins to produce Scapegrace-like effects with greater control.

## How It Works
**Audio gate (red controls):**
When triggered, opens gate for controllable duration. While open, input is faded in/out and panned before passing to output. T/OUT sends trigger when fade-out begins (for chaining overlapping gates). AUTO mode retriggers on gate close.

**Mod signal generation (lilac controls):**
Generates CV signal sent to Catkins/Stereo MOD input to move read head during playback, creating pitch-shift and/or reverse effects. IMPORTANT: Lilac controls don't affect Rapscallion's audio - only the MOD output for Catkins.

**Typical routing:**
Connect Catkins send/return loop through Rapscallion IN/OUT, and Rapscallion M/OUT to Catkins MOD input. Match RANGE switches on both modules.

## Key Controls
**Audio gate (red):**
- **IN L/R, OUT L/R**: Stereo I/O
- **TRIGGER IN**: Trigger input (or manual button)
- **LENGTH**: Gate open duration (CV modulatable)
- **FADE**: Percentage of gate time spent fading in/out (CV modulatable)
- **BALANCE**: Stereo panning (sampled at trigger, held during gate)
- **T/OUT**: Trigger output when fade-out begins
- **AUTO**: Automatic retriggering

**Mod signal (lilac):**
- **PITCH**: Pitch shift amount for Catkins playback (±7 semitones, CV modulatable)
- **8ve UP**: Double playback speed (octave up)
- **REV**: Reverse playback direction
- **M/OUT**: Mod CV output to Catkins MOD input

## Implementation Notes
- Designed as companion to Catkins/Catkins Stereo
- BALANCE value sampled at trigger, not continuously modulated
- T/OUT enables overlapping gates for continuous signal
- Lilac section only affects M/OUT, not audio path
- RANGE switch must match Catkins for correct pitch behavior
- More controllable alternative to Scapegrace's random granular approach

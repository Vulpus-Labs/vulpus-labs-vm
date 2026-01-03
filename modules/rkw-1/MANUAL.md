# RKW-1 - ZX Spectrum Beeper Emulator Module

## Overview

RKW-1 is a Voltage Modular module that emulates the iconic sound of the ZX Spectrum's piezo beeper. It accurately recreates the timing behavior, multi-channel mixing modes, and sonic character of the Spectrum's 1-bit audio output system.

## What is the ZX Spectrum Beeper?

The ZX Spectrum (1982-1992) was a British home computer that used a simple piezo beeper for audio output. Unlike chip-tune synthesizers with dedicated sound hardware, the Spectrum's beeper was controlled directly by the CPU:

- **1-bit output**: The beeper could only be ON or OFF (no volume control)
- **CPU timing**: Sound generation competed with program execution for CPU cycles
- **Creative limitations**: These constraints led to innovative multi-channel techniques

This module emulates both the technical behavior of the beeper hardware and the characteristic sound of how it was heard in the real world.

---

## Module Interface

### Inputs (4 Channels)

The module provides 3 identical voice channels and one noise channel. Each voice channel has three inputs:

#### V/Oct In (1-4)
- Standard 1V/octave pitch control
- Frequency range: ~65Hz (C2) to audible spectrum
- Defaults to C2 when nothing connected

#### Gate In (1-4)
- Enables/disables the channel
- High (>0V) = channel active
- Low (≤0V) = channel silent

#### Pulse Width In (1-3)
- Controls the duty cycle of the square wave
- Range: CV input scaled to 16-bit internal resolution
- Default: 50% duty cycle (0x7FFF)
- Affects timbre and perceived brightness

The noise channel has _V/Oct In_ and _Gate In_ inputs, but no pulse width control.

### Output

#### Audio Out
- Single mono output
- Filtered through selectable acoustic profile (BP for piezo beeper, TV for television speaker)

---

## Spectrum Timing Emulation

The module accurately emulates the ZX Spectrum's CPU-synchronized audio timing:

### Frame Sync
- **PAL**: 50Hz (20ms per frame) - standard European Spectrum
- **NTSC**: 60Hz (16.67ms per frame) - rare NTSC models
- Sound parameters update once per frame, matching original hardware behavior

### Tick Length

- Measured in Z80 CPU cycles
- Default: 50 cycles (~14.3μs @ 3.5MHz)
- Controls the time resolution of audio updates (i.e. beeper on/off)

### Audio Budget
- Percentage of CPU time allocated to audio (0-100%)
- Simulates the trade-off between sound quality and program execution when playing in-game music

### Phase Reset
- When enabled: All channels reset to phase 0 at each frame sync
- When disabled: Phases run continuously (more musical)

---
## Mix Modes

The module offers four mixing strategies that replicate real ZX Spectrum techniques:

### XOR (Exclusive OR)
```
Output = Ch0 ⊕ Ch1 ⊕ Ch2 ⊕ Ch3
```
- Classic beeper technique used in many games
- Creates complex waveforms through phase cancellation
- Produces sum/difference frequencies
- Can create unexpected harmonic content and metallic tones

### OR (Logical OR)
```
Output = Ch0 | Ch1 | Ch2 | Ch3
```
- Output is HIGH if any channel is HIGH
- Simpler mixing, less timbral variety
- More "on/off" character than XOR

### INTERLEAVE
```
One active channel per frame, rotating
```
- Plays one channel at a time
- Cycles through active channels each frame
- Simulates time-slicing multiple sounds
- Creates rapid switching between tones
- Used in games to simulate polyphony

### QUAD (Independent Mix)
```
Output = sum of all channels (0V to 5V). Simulates having one ZX Spectrum per channel
```
- Each channel contributes 0V or 1.25V
- Simple additive mixing
- Most "modern" sounding
- Less authentic but more predictable
- Useful for layering

---

## Filter Profiles

The module provides two acoustic profiles that shape the 1-bit square wave output:

### PIEZO (Default)
**Emulates the direct piezo beeper sound**

- **High-pass @ 300Hz**: Removes sub-bass rumble that the tiny piezo element couldn't reproduce
- **Peak @ 2500Hz** (Q=1.5, +6dB): Strong resonant "beep" character from the piezo cone's physical resonance
- **Low-pass @ 5000Hz**: Simulates the physical bandwidth limitations of the small piezo element

### TV_SPEAKER
**Emulates a 1980s TV speaker reproduction**

- **High-pass @ 200Hz**: Gentle bass roll-off typical of small TV speakers
- **Peak @ 800Hz** (Q=1.0, +3dB): Cabinet/cone resonance in the lower midrange
- **Low-pass @ 8000Hz**: Limited treble extension characteristic of period TV speakers

---

## Credits

The ZX Spectrum was designed by Sir Clive Sinclair and his team at Sinclair Research Ltd. This module is a loving tribute to the creativity of Spectrum programmers who pushed 1-bit audio to incredible heights. (Although the most incredible were reached using still other techniques, to be explored in a future module...)

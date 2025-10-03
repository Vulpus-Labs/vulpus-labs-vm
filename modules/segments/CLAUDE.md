# Segments

## Overview
Segments is a CV signal generator that creates timed segments between start and end CV levels. You set start and end values, specify the duration, trigger the segment, and it outputs a CV signal that moves from start to end over the specified time. Useful for envelope generation, drum frequency sweeps, and read-head position control (originally developed for Catkins).

## How It Works
When triggered, Segments generates a CV signal that moves from a start voltage to an end voltage over a specified duration. The segment can follow one of four curves (linear, quarter sine, inverse quarter cosine, or sinusoid). A gate signal is emitted for a controllable percentage of the segment duration, and an end trigger fires when the segment completes.

Two modes available:
- **Sample and Hold**: Start/end values are captured at trigger time and held until segment completes
- **Continuous**: Start/end values can change during playback, modulating intermediate values in real-time

## Key Controls
- **Trig section**: Start/End trigger jacks, manual trigger button
- **Start section**: IN jack (or knob) sets start CV voltage, OUT emits current start value
- **End section**: IN jack (or knob) sets end CV voltage, OUT emits current end value
- **Len section**: IN jack (or knob) sets segment length, range switch (10ms-10s), OUT passes through length CV
- **Gate section**: Knob controls gate duration (% of segment), Link jack for chaining, OUT emits gate signal
- **CV section**: Shape knob (Linear/Quarter Sine/Inverse Quarter Cosine/Sinusoid), Link jack for chaining, OUT emits CV segment
- **Mode switch**: S&H (Sample and Hold) or CONT (Continuous)

## Implementation Notes
- Not intended as audio-rate oscillator (loses pitch accuracy at high frequencies due to whole-sample length quantization)
- Good for long-running/non-standard envelope curves, drum frequency sweeps, and modulation sources
- Multiple instances can be chained: end trigger → next start trigger, CV outputs linked through Link jacks
- Can create looping sequences by connecting final end trigger back to first start trigger
- To hold final value after segment ends, connect End OUT to CV Link IN

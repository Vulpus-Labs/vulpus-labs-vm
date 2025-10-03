# Speccy

## Overview
Speccy is a spectral delay effect that divides an input signal into frequency bands using FFT analysis, applies randomized delays of different lengths to each band, then recombines them. Creates unique time-smeared and filtered delay effects by delaying frequencies independently rather than delaying the time-domain signal directly.

## How It Works
Speccy splits the input into overlapping windows and performs Fast Fourier Transform on each to separate frequency bands. Each band can be delayed by up to 256 windows, with delay lengths randomized per band (controlled by random seed). The delayed frequency information is mixed back into later windows, then inverse FFT recombines them into the output. Includes feedback control and wet/dry mix.

Note: Introduces latency due to FFT processing. User-adjustable latency amount, with LED warning if more latency needed to prevent glitches.

## Key Controls
- **IN**: Audio input jack
- **OUT**: Audio output jack (with latency indicator LED)
- **WIN SIZE**: FFT window size (64-2048 samples = 32-1024 frequency bands). Larger = more latency, finer frequency resolution
- **SEED**: Random seed determining delay amount per frequency band. Match seeds for stereo, differ for variation
- **BAND SIZE**: Number of bands per delay line. Smaller = more "smeared" effect, larger = "tinkling" filtered delay taps
- **FEEDBACK**: Amount of output fed back to input
- **MIX**: Wet/dry balance (0% = fully dry, 100% = fully wet)
- **Latency LED**: Double-click to adjust latency if red LED flashes (indicates glitching)

## Implementation Notes
- Window size affects both frequency resolution and latency
- Random seed allows stereo correlation control or variation
- Band size trades between frequency smearing and discrete delay tap effects
- Pay-for-what-you-use CPU through adjustable latency
- Double-click latency LED to increase if experiencing audio glitches

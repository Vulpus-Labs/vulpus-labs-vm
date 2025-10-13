# Vulpus Labs Magnus

## Introduction

Magnus is a stereo maximiser and gating utility module with high-pass filtered RMS detection and configurable ceiling limiting. It analyzes the RMS (Root Mean Square) level of incoming audio using a high-pass filter for more perceptual accuracy, applies dynamic gain to bring quiet signals up to a target volume level, and uses configurable soft limiting to prevent clipping. A built-in gate silences signals that fall below a user-defined threshold.

Magnus can operate in mono or stereo mode. When only the left input is connected, the same processing is applied to both outputs for convenient mono-to-stereo conversion.

## Theory of Operation

Magnus uses RMS-based level detection with separate attack and release time constants, enhanced by a configurable high-pass filter. The high-pass filter is applied only to the side-chain signal used for RMS calculation, reducing the influence of low frequencies and DC offset on the level detection while leaving the audio path unfiltered. This results in more perceptually accurate loudness detection that responds primarily to mid and high frequencies.

When the input level is below the target volume, gain is applied to bring it up. The attack time controls how quickly the module responds to increases in signal level, while the release time controls how quickly it responds to decreases.

The gate feature smoothly fades signals in and out based on their RMS level. When the signal drops below the gate threshold, it is progressively attenuated. A 10dB transition zone below the threshold uses a cubic curve to smoothly fade between full level and complete silence, preventing abrupt clicks.

To prevent clipping, Magnus applies configurable soft limiting. The ceiling control sets the limiting threshold (-6 to -0.1 dBFS), above which signals are compressed using an asymptotic curve. This compression ensures that signals never exceed the hard clipping point of ±5V (0 dBFS), maintaining a natural sound while providing absolute clipping protection.

Each channel is processed independently, with identical settings applied to both left and right channels.

## Controls

**INPUT** - Connect audio sources to the L (M) and R input jacks at the top of the module. If only the left input is connected, it will be used for both channels (mono operation).

**ATTACK** (0.5ms - 50ms, default 5ms) - Controls how quickly the maximiser responds to increases in signal level. Faster attack times produce tighter, more aggressive maximization but may introduce pumping artifacts. Slower attack times allow transients to pass through with less processing.

**RELEASE** (20ms - 200ms, default 50ms) - Controls how quickly the maximiser responds to decreases in signal level. Faster release times make the module track the audio more closely but may cause breathing or pumping effects. Slower release times produce smoother, more transparent gain changes.

**GATE** (-60 dBFS to -12 dBFS, default -60 dBFS) - Sets the RMS threshold below which signals are attenuated. Signals 10dB or more below this threshold are completely silenced. Signals between the threshold and 10dB below it are progressively faded out using a smooth cubic curve. At the default setting of -60 dBFS, the gate is effectively disabled.

**TARGET** (-12 dBFS to 0 dBFS, default -6 dBFS) - Sets the target RMS level that the maximiser aims to achieve. The module applies gain to bring quiet signals up to this level. Setting this closer to 0 dBFS produces louder output but leaves less headroom for transients.

**CEILING** (-6 dBFS to -0.1 dBFS, default -1 dBFS) - Sets the soft limiting threshold. Signals above this level are compressed using an asymptotic curve that prevents them from ever reaching the hard clipping point of ±5V (0 dBFS). Lower settings provide more headroom and gentler limiting, while higher settings allow louder output with more aggressive limiting.

**HP** (20Hz to 200Hz, default 20Hz) - Controls the high-pass filter frequency applied to the RMS detection side-chain. Higher frequencies reduce the influence of bass content on the loudness detection, making the maximizer more responsive to mid and high frequencies. At the default 20Hz setting, the filter primarily removes DC offset and subsonic content.

**OUTPUT** - Connect the processed L and R outputs at the bottom of the module to your mixer or other destination.

## Tips and Techniques

- Use a fast attack (1-2ms) and medium release (50-100ms) for transparent loudness maximization on mix buses
- For drum processing, try a slower attack (10-20ms) to let transients punch through before maximization kicks in
- The gate can be used to clean up noisy signals - set it just above the noise floor
- On percussive material, match the release time to the decay of the sound for natural-sounding results
- When processing stereo signals, ensure both inputs are connected to maintain proper stereo imaging
- Set the ceiling to -0.5 dBFS or lower to leave headroom for intersample peaks in digital systems
- Use higher HP filter frequencies (50-100Hz) on bass-heavy material to prevent low-end from dominating the loudness detection
- For mastering applications, try a moderate ceiling setting (-2 to -1 dBFS) with conservative target levels (-8 to -6 dBFS)

## Credits and Acknowledgements

Magnus was written by Dominic Fox in 2024.

Thanks to Cherry Audio for Voltage Modular, which makes modules like this possible.

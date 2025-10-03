# Vulpus Labs Magnus

## Introduction

Magnus is a stereo maximiser and gating utility module. It analyzes the RMS (Root Mean Square) level of incoming audio and applies dynamic gain to bring quiet signals up to a target volume level, while using soft limiting to prevent clipping. A built-in gate silences signals that fall below a user-defined threshold.

Magnus can operate in mono or stereo mode. When only the left input is connected, the same processing is applied to both outputs for convenient mono-to-stereo conversion.

## Theory of Operation

Magnus uses RMS-based level detection with separate attack and release time constants. When the input level is below the target volume, gain is applied to bring it up. The attack time controls how quickly the module responds to increases in signal level, while the release time controls how quickly it responds to decreases.

The gate feature smoothly fades signals in and out based on their RMS level. When the signal drops below the gate threshold, it is progressively attenuated. A 10dB transition zone below the threshold uses a cubic curve to smoothly fade between full level and complete silence, preventing abrupt clicks.

To prevent clipping, Magnus applies soft limiting above -1 dBFS. Signals that exceed this threshold are compressed using a saturating curve that asymptotically approaches 0 dBFS, ensuring the output never clips while maintaining a natural sound.

Each channel is processed independently, with identical settings applied to both left and right channels.

## Controls

**INPUT** - Connect audio sources to the L (M) and R input jacks at the top of the module. If only the left input is connected, it will be used for both channels (mono operation).

**ATTACK** (0.5ms - 50ms, default 5ms) - Controls how quickly the maximiser responds to increases in signal level. Faster attack times produce tighter, more aggressive maximization but may introduce pumping artifacts. Slower attack times allow transients to pass through with less processing.

**RELEASE** (20ms - 200ms, default 50ms) - Controls how quickly the maximiser responds to decreases in signal level. Faster release times make the module track the audio more closely but may cause breathing or pumping effects. Slower release times produce smoother, more transparent gain changes.

**GATE** (-60 dBFS to -12 dBFS, default -60 dBFS) - Sets the RMS threshold below which signals are attenuated. Signals 10dB or more below this threshold are completely silenced. Signals between the threshold and 10dB below it are progressively faded out using a smooth cubic curve. At the default setting of -60 dBFS, the gate is effectively disabled.

**TARGET** (-12 dBFS to 0 dBFS, default -6 dBFS) - Sets the target RMS level that the maximiser aims to achieve. The module applies gain to bring quiet signals up to this level. Setting this closer to 0 dBFS produces louder output but leaves less headroom for transients.

**OUTPUT** - Connect the processed L and R outputs at the bottom of the module to your mixer or other destination.

## Tips and Techniques

- Use a fast attack (1-2ms) and medium release (50-100ms) for transparent loudness maximization on mix buses
- For drum processing, try a slower attack (10-20ms) to let transients punch through before maximization kicks in
- The gate can be used to clean up noisy signals - set it just above the noise floor
- On percussive material, match the release time to the decay of the sound for natural-sounding results
- When processing stereo signals, ensure both inputs are connected to maintain proper stereo imaging

## Credits and Acknowledgements

Magnus was written by Dominic Fox in 2024.

Thanks to Cherry Audio for Voltage Modular, which makes modules like this possible.

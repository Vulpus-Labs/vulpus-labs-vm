# Vulpus Labs - Voltage Modular Modules

Monorepo for Vulpus Labs Voltage Modular plugins, including shared libraries and individual module implementations.

## Repository Structure

- **`libs-old/`** - Shared libraries (Gradle-based Java/Kotlin projects)
  - `libs-old/vulpes/` - Java libraries (20+ submodules: vulpes-values, vulpes-interface, vulpes-buffer, vulpes-filters, etc.)
  - `libs-old/vulpes-libs/` - Kotlin libraries (vulpes-values, vulpes-events, vulpes-maths, vulpes-interface, vulpes-controls)
  - `libs-old/vulpus-libs/` - Additional Kotlin libraries

- **`modules/`** - Individual Voltage Modular module implementations
  - Each module contains a `.java` implementation file and `.vmod` binary module definition

- **`module-docs/`** - PDF user manuals for modules

## Modules

### Synthesis & Oscillators

- **Chebysynth** - 16-note polyphonic MIDI synthesizer using additive synthesis with 9 harmonics, dual ADSR envelopes, pitch/stereo spreading, and Chebyshev feedback for FM-like tones
- **Chebz** - Waveform synthesis toolbox stacking sine waves via Chebyshev polynomials (fundamental + 9 harmonics), with wave-folding and individual harmonic outputs
- **Curvaceous** - Polyphonic oscillator playing waveforms formed of up to 7 curve segments, with V/OCT, FM, sync, and octave selection

### Delay & Echo Effects

- **Catkins** - Digital multi-tap delay with 6 controllable read heads in circular buffer, modular-style control without tape emulation (mono)
- **Catkins Stereo** - Stereo version of Catkins with identical functionality
- **Cumulonimbus** - Granular delay emitting 10ms-1s "grains" from buffer positions, up to 64 simultaneous grains, with pitch-shifting and texture generation
- **Scapegrace** - Randomizing stereo delay with 16-second memory, replays random slices (up to 16 simultaneous) with randomized length/pitch/panning/reverse

### Distortion & Waveshaping

- **Beverley** - Advanced bitcrusher with gamma correction, smoothed quantization, interpolated bit depth, and auto-gain compensation
- **Pow!** - Non-linear voltage converter applying power functions through controllable midpoint, three rectification modes, mono/stereo/polyphonic
- **Torment Nexus** - Signal mangler with 6 combination modes (sum/AM/RM/analog RM/delta AM/delta RM), extensive signal shaping at input/output stages

### Spectral Processing

- **Glow Up** - Spectral harmonic enhancer boosting 1st/2nd/3rd harmonics above detected frequencies via FFT processing
- **Speccy** - Spectral delay applying frequency-band-specific delays (0-2000ms per band) with randomization and adjustable latency

### Modulation & CV Processing

- **Crosstalk** - Polyphonic channel mixer with Bleed mode (capacitative coupling simulation) and Ring Modulation mode
- **Distributor** - Random gate generator following binomial distribution via trigger propagation tree (Galton board simulation)
- **Segments** - CV signal generator producing timed segments with 4 curve shapes (linear/S-curve/ease-in/ease-out), chainable for envelopes
- **Swirl** - Dual-mode polyphonic module: drift mode (randomly-drifting CV pairs) / processing mode (polar→Cartesian wave-shaper), with visual scope
- **Swirl Mini** - Compact Swirl without visual scope, identical behavior but smaller/more CPU-efficient
- **Switcheroo** - Pattern-based step sequencer switching between 4 inputs with crossfade, 16-step programmable pattern, trigger outputs

### Stereo & Spatial Effects

- **Crosstalk** - Polyphonic signal propagation across channels with bleed and ring modulation modes
- **Rapscallion** - Dual-function: (1) stereo gate with length/panning/fade control, (2) Catkins modulation signal generator for pitch-shifted/reversed effects
- **Spree** - Polyphonic chorus with per-channel randomized drift (time/width/speed/feedback), creating phase-shifting textures across polyphonic voices

### Utilities & Mastering

- **Magnus** - Stereo maximizer/limiter with auto-gain, soft-knee gating, cubic-curve gate transition, and asymptotic peak limiting
- **MatchMaker** - Gain-matched effects loop with envelope-following RMS analysis, automatic volume compensation, and configurable attack/release

### Not Yet Documented

- **Ranges** - (no manual/CLAUDE.md available)
- **Ratios** - (no manual/CLAUDE.md available)

## Building

All library collections use Gradle:

```bash
# Build Java libraries
cd libs/vulpes
./gradlew build

# Build Kotlin libraries
cd libs/vulpes-libs
./gradlew build

# Run tests
./gradlew test
```

## Development

- Module implementations follow the Voltage SDK pattern: `VoltageModule` subclass with `InitializeControls()`, `Initialize()`, `Notify()`, and `ProcessSample()`
- Libraries organized by domain: values, interface, buffer, filters, events, maths, controls
- Each module has a `CLAUDE.md` documentation file in its directory (except ranges/ratios)

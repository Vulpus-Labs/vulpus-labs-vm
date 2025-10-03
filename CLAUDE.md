# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a monorepo for Vulpus Labs / Voltage Modular plugins. Voltage Modular is a modular synthesizer platform, and this repository contains both reusable libraries and individual module implementations.

**Important:** The library code is mostly uncommented with very few tests. Think of this as a collection of utilities and components extracted from working modules.

## Project Structure

The repository is organized into three main directories:

### `libs` - Shared libraries (not populated yet)

### `libs-old/` - (Old) Shared Libraries

Contains three Gradle-based library collections:

- **`libs-old/vulpes/`** - Java libraries (Gradle, Java)
  - Multi-module Gradle project with 20+ submodules
  - Package: `com.vulpuslabs.vulpes.*`
  - Submodules include: `vulpes-values`, `vulpes-interface`, `vulpes-buffer`, `vulpes-filters`, `vulpes-catkins`, `vulpes-cumulonumbus`, etc.
  - Each submodule has its own `build.gradle` and can be built independently
  - Core library is `vulpes-interface` which provides Voltage Modular SDK classes

- **`libs-old/vulpes-libs/`** - Kotlin libraries (Gradle, Kotlin)
  - Contains: `vulpes-values`, `vulpes-events`, `vulpes-maths`, `vulpes-interface`, `vulpes-controls`

- **`libs-old/vulpus-libs/`** - Additional Kotlin libraries (Gradle, Kotlin)
  - Minimal configuration

### `modules/` - Individual Voltage Modular Modules

Contains 20+ individual module implementations. Each module has:
- A `.java` file (e.g., `Catkins.java`) - the module implementation
- A `.vmod` file - binary module definition/skin data

Modules include: `catkins`, `catkins-stereo`, `chebysynth`, `chebz`, `crosstalk`, `cumulonimbus`, `curvaceous`, `distributor`, `glow-up`, `ranges`, `rapscallion`, `ratios`, `scapegrace`, `segments`, `speccy`, `spree`, `swirl`, `swirl-mini`, `switcheroo`, `torment-nexus`

## Build System

### Building Libraries

All three library collections use Gradle:

```bash
# Build the Java libraries
cd libs/vulpes
./gradlew build

# Build vulpes-libs (Kotlin)
cd libs/vulpes-libs
./gradlew build

# Build vulpus-libs (Kotlin)
cd libs/vulpus-libs
./gradlew build

# Run tests
./gradlew test
```

### Working with Submodules

The `libs/vulpes/` project has many submodules defined in `settings.gradle`. To build a specific submodule:

```bash
cd libs/vulpes
./gradlew :vulpes-values:build
./gradlew :vulpes-catkins:test
```

## Architecture

### Voltage Modular Module Pattern

Module implementations (in `modules/`) follow this pattern:

1. **Module Class**: Extends `VoltageModule` from the Voltage SDK
2. **UI Initialization**: `InitializeControls()` creates knobs, jacks, labels, switches
3. **Module Initialization**: `Initialize()` sets up the DSP logic and wires up UI components
4. **Event Handling**: `Notify()` receives UI events (knob changes, jack connections, etc.)
5. **Audio Processing**: `ProcessSample()` is called 48,000 times per second to process audio

### Library Organization

Libraries are organized by domain:
- **values**: Value handling, CV modulation, smoothing, ranges
- **interface**: Voltage Modular SDK classes and interfaces
- **buffer**: Audio buffering and delay line implementations
- **filters**: DSP filter implementations
- **events**: Event handling and notification system
- **maths**: Mathematical utilities
- **controls**: UI control abstractions

### Key Patterns

**NotificationReceiver Pattern**: Used to handle Voltage Modular's event system
- Registers components (knobs, jacks, switches) with callbacks
- Handles connection/disconnection events
- Manages smoothed values for knobs

Example from `modules/catkins/Catkins.java:674-724`:
```java
receiver.registerInput(feedbackModCv, feedbackModCv::GetValue)
receiver.registerSmoothedKnob(feedbackKnob, feedbackKnob.GetValue())
receiver.registerTwoStateSwitch(qualitySwitch, controller::setInterpolationQuality)
```

**CV Modulation Pattern**: `CvModulatableKnob` combines a knob, CV input, and modulation amount
- When CV is connected, it modulates the knob value
- Modulation amount controls the range of CV influence (bidirectional)

**Controller Pattern**: Modules typically have a `Controller` class that handles DSP logic
- Separates UI handling from audio processing
- Called from `ProcessSample()` for real-time audio processing

## Development Notes

- Java files are in `com.vulpuslabs.vulpes.*` package namespace
- Kotlin files use the same namespace
- Module implementations import both Voltage SDK classes (`voltage.*`) and library classes (`com.vulpuslabs.vulpes.*`)
- Tests use JUnit 5
- The Voltage SDK classes are in `libs/vulpes/vulpes-interface/src/main/java/voltage/`

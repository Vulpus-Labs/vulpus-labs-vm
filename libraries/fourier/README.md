# Fourier - Optimized FFT Library for Audio DSP

A high-performance, zero-allocation FFT library for Java, optimized for real-time audio digital signal processing.

## Features

- **Real-valued FFT**: Optimized for real audio signals (not general complex FFTs)
- **Packed format**: ~2x faster than naive real FFT via N/2 complex FFT trick
- **Zero allocation**: All arrays pre-allocated at construction time
- **Power-of-2 sizes**: Supports FFT sizes from 4 to unlimited (tested up to 16,384)
- **Pre-computed tables**: Twiddle factors and bit-reversal indices calculated once
- **In-place transforms**: Input arrays are modified in place (destructive)
- **CMSIS/ARM packed format**: Industry-standard frequency-domain representation

## Implementations

### RealPackedFFT (Recommended)

Optimized implementation using the N/2 complex FFT algorithm:

- Input: `double[N]` containing real time-domain samples
- Output: `double[N]` in packed format:
  - `[0]`: DC component (real)
  - `[1]`: Nyquist component (real)
  - `[2k, 2k+1]`: Real and imaginary parts of bin k (for k=1 to N/2-1)

### RealUnpackedFFT (Reference)

Standard implementation for comparison:

- Input: `double[2*N]` with interleaved `[real, imag]` pairs (imaginaries zeroed)
- Output: `double[2*N]` with full Hermitian-symmetric spectrum

## Performance

Benchmarked on **Apple M3 MacBook Air (8GB)** with **Oracle GraalVM 26-dev** (Java 26):

### Forward Transform

| FFT Size | Packed (ns/op) | Unpacked (ns/op) | Speedup |
|----------|----------------|------------------|---------|
| 256      | 1,086          | 2,154            | 2.0x    |
| 1,024    | 4,944          | 10,416           | 2.1x    |
| 4,096    | 22,113         | 46,749           | 2.1x    |

### Inverse Transform

| FFT Size | Packed (ns/op) | Unpacked (ns/op) | Speedup |
|----------|----------------|------------------|---------|
| 256      | 1,149          | 2,285            | 2.0x    |
| 1,024    | 5,018          | 10,727           | 2.1x    |
| 4,096    | 22,866         | 49,711           | 2.2x    |

### Round-Trip (Forward + Inverse)

| FFT Size | Packed (ns/op) | Unpacked (ns/op) | Speedup |
|----------|----------------|------------------|---------|
| 256      | 2,179          | 4,395            | 2.0x    |
| 1,024    | 10,470         | 21,190           | 2.0x    |
| 4,096    | 47,979         | 98,298           | 2.0x    |

**Key Findings:**
- Packed FFT is consistently **2x faster** across all sizes
- At 48kHz audio rate with 1024-point FFT: ~5µs per transform
- Suitable for real-time audio processing with low latency

## Usage

### Basic Example

```java
// Create FFT instance (size must be power of 2, >= 4)
RealPackedFFT fft = new RealPackedFFT(1024);

// Prepare input signal
double[] signal = new double[1024];
for (int i = 0; i < 1024; i++) {
    signal[i] = Math.sin(2.0 * Math.PI * 440.0 * i / 48000.0);
}

// Forward transform (destructive - modifies signal array)
double[] spectrum = fft.forward(signal);

// spectrum[0] = DC component
// spectrum[1] = Nyquist component
// spectrum[2k], spectrum[2k+1] = bin k (real, imag)

// Manipulate spectrum (example: remove DC offset)
spectrum[0] = 0.0;

// Inverse transform (destructive - modifies spectrum array)
double[] output = fft.inverse(spectrum);
```

### Spectrum Manipulation Examples

#### DC Removal (High-pass filter)

```java
spectrum[0] = 0.0;  // Zero the DC bin
```

#### Phase Normalization

```java
// Preserve magnitude, zero all phases
for (int k = 1; k < n/2; k++) {
    int idx = 2 * k;
    double re = spectrum[idx];
    double im = spectrum[idx + 1];
    double magnitude = Math.sqrt(re * re + im * im);
    spectrum[idx] = magnitude;     // Phase = 0
    spectrum[idx + 1] = 0.0;
}
```

#### Magnitude Spectrum

```java
double[] magnitudes = new double[n/2 + 1];
magnitudes[0] = Math.abs(spectrum[0]);           // DC
magnitudes[n/2] = Math.abs(spectrum[1]);         // Nyquist
for (int k = 1; k < n/2; k++) {
    double re = spectrum[2*k];
    double im = spectrum[2*k + 1];
    magnitudes[k] = Math.sqrt(re*re + im*im);
}
```

## Building and Testing

### Prerequisites

- Java 17 or later
- Maven 3.6+

### Build

```bash
mvn clean package
```

### Run Tests

```bash
mvn test
```

All tests should pass:
- 17 tests for `RealPackedFFT`
- 6 tests for `RealUnpackedFFT`

### Run Benchmarks

```bash
mvn test-compile exec:java -Dexec.mainClass="com.codepoetics.fourier.BenchmarkRunner" -Dexec.classpathScope="test"
```

Benchmarks test FFT sizes 256, 1024, and 4096 for both implementations.

**Note:** JMH warnings about non-forked runs are expected. The benchmarks run in the host VM to avoid classpath issues, which is acceptable for comparative performance testing.

## Algorithm Details

### Packed Real FFT

The packed implementation uses the following algorithm:

1. **Forward Transform:**
   - Interpret N real samples as N/2 complex samples
   - Perform N/2-point complex FFT
   - Post-process to extract N-point real DFT using symmetry properties

2. **Inverse Transform:**
   - Pre-process packed spectrum to reconstruct N/2-point complex spectrum
   - Perform N/2-point inverse complex FFT
   - Normalize by 1/(N/2)

3. **Complex FFT Engine:**
   - Cooley-Tukey radix-2 decimation-in-time algorithm
   - Physical bit-reversal permutation (not on-the-fly)
   - Pre-computed twiddle factors (sin/cos tables)

### Memory Layout

For an N-point real FFT, the packed format stores N doubles:

```
Index:  [0]   [1]      [2]    [3]    [4]    [5]    ...  [N-2]    [N-1]
Value:  DC    Nyquist  Re[1]  Im[1]  Re[2]  Im[2]  ...  Re[N/2-1] Im[N/2-1]
```

This exploits Hermitian symmetry: `X[N-k] = conj(X[k])` for real input.

## License

This library is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

This is a library for building Voltage Modular DSP modules. You are free to use, modify, and distribute this code in both open source and commercial projects.

## References

- Cooley-Tukey FFT algorithm
- CMSIS DSP Library (ARM) for packed format conventions
- Numerical Recipes in C, Press et al. (FFT algorithms)

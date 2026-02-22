package com.codepoetics.fourier;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * JMH benchmarks comparing RealPackedFFT vs RealUnpackedFFT performance.
 *
 * Run with: java -jar target/benchmarks.jar
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(2)
@State(Scope.Thread)
public class FFTBenchmark {

    @Param({"64", "256", "1024", "4096", "16384"})
    private int fftSize;

    private RealPackedFFT packedFFT;
    private RealUnpackedFFT unpackedFFT;

    private double[] packedInput;
    private double[] unpackedInput;

    private double[] packedSpectrum;
    private double[] unpackedSpectrum;

    @Setup(Level.Trial)
    public void setup() {
        packedFFT = new RealPackedFFT(fftSize);
        unpackedFFT = new RealUnpackedFFT(fftSize);

        // Prepare input signals with some frequency content
        packedInput = new double[fftSize];
        unpackedInput = new double[2 * fftSize];

        for (int i = 0; i < fftSize; i++) {
            double value = Math.sin(2.0 * Math.PI * 5 * i / fftSize) +
                          0.5 * Math.cos(2.0 * Math.PI * 13 * i / fftSize) +
                          0.3 * Math.sin(2.0 * Math.PI * 27 * i / fftSize);

            packedInput[i] = value;
            unpackedInput[2 * i] = value;      // Real part
            unpackedInput[2 * i + 1] = 0.0;    // Imaginary part (zero for real signal)
        }

        // Pre-compute spectra for inverse benchmarks
        packedSpectrum = new double[fftSize];
        unpackedSpectrum = new double[2 * fftSize];

        System.arraycopy(packedInput, 0, packedSpectrum, 0, fftSize);
        System.arraycopy(unpackedInput, 0, unpackedSpectrum, 0, 2 * fftSize);

        packedFFT.forward(packedSpectrum);
        unpackedFFT.forward(unpackedSpectrum);
    }

    @Benchmark
    public void packedForward(Blackhole bh) {
        double[] buf = new double[fftSize];
        System.arraycopy(packedInput, 0, buf, 0, fftSize);
        double[] result = packedFFT.forward(buf);
        bh.consume(result);
    }

    @Benchmark
    public void unpackedForward(Blackhole bh) {
        double[] buf = new double[2 * fftSize];
        System.arraycopy(unpackedInput, 0, buf, 0, 2 * fftSize);
        double[] result = unpackedFFT.forward(buf);
        bh.consume(result);
    }

    @Benchmark
    public void packedInverse(Blackhole bh) {
        double[] buf = new double[fftSize];
        System.arraycopy(packedSpectrum, 0, buf, 0, fftSize);
        double[] result = packedFFT.inverse(buf);
        bh.consume(result);
    }

    @Benchmark
    public void unpackedInverse(Blackhole bh) {
        double[] buf = new double[2 * fftSize];
        System.arraycopy(unpackedSpectrum, 0, buf, 0, 2 * fftSize);
        double[] result = unpackedFFT.inverse(buf);
        bh.consume(result);
    }

    @Benchmark
    public void packedRoundTrip(Blackhole bh) {
        double[] buf = new double[fftSize];
        System.arraycopy(packedInput, 0, buf, 0, fftSize);
        packedFFT.forward(buf);
        packedFFT.inverse(buf);
        bh.consume(buf);
    }

    @Benchmark
    public void unpackedRoundTrip(Blackhole bh) {
        double[] buf = new double[2 * fftSize];
        System.arraycopy(unpackedInput, 0, buf, 0, 2 * fftSize);
        unpackedFFT.forward(buf);
        unpackedFFT.inverse(buf);
        bh.consume(buf);
    }
}

package com.codepoetics.fourier;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Manual benchmark runner.
 * Run with: mvn test-compile exec:java -Dexec.mainClass="com.codepoetics.fourier.BenchmarkRunner" -Dexec.classpathScope="test"
 */
public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(FFTBenchmark.class.getSimpleName())
                .param("fftSize", "256", "1024", "4096")
                .forks(0) // Disable forking to avoid classpath issues
                .warmupIterations(3)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }
}

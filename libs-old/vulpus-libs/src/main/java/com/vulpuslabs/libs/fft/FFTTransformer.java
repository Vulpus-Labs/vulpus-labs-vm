package com.vulpuslabs.libs.fft;

@FunctionalInterface
public interface FFTTransformer {

    void transform(double[][] fftBins);

}

package com.vulpuslabs.libs.fft;

import java.util.concurrent.atomic.AtomicInteger;

public class WindowingInBuffer {

    private final int bufferSize;
    private final int windowSize;
    private final int windowInterval;
    private final int windowIntervalMask;
    private final int mask;
    private final double[] inBuffer;
    private int writePtr;
    private int windowPtr;
    private final AtomicInteger availableWindowCount = new AtomicInteger(0);
    private final double[] windowCoefficients;

    public WindowingInBuffer(int windowSize, int bufferSize) {
        this.windowSize = windowSize;
        this.bufferSize = bufferSize;
        this.windowInterval = windowSize >> 1;
        this.windowIntervalMask = windowInterval - 1;
        this.mask = bufferSize - 1;

        this.inBuffer = new double[bufferSize];
        this.windowPtr = bufferSize - windowInterval;
        this.windowCoefficients = new double[windowSize];
        for (int i=0; i < windowSize; i++) {
            this.windowCoefficients[i] = Math.sin(i * Math.PI / windowSize);
        }
    }

    /**
     * Write a sample into the buffer.
     * @param sample The sample to write into the buffer;
     * @return True if a window has been filled.
     */
    public boolean write(double sample) {
        inBuffer[writePtr++] = sample;
        writePtr &= mask;
        if ((writePtr & windowIntervalMask) == 0) {
            availableWindowCount.incrementAndGet();
            return true;
        }
        return false;
    }

    public boolean getFFTWindow(double[][] fftBins) {
        if (availableWindowCount.get() == 0) {
            return false;
        }

        int binSize = fftBins.length;
        int shift = 1 + Integer.numberOfLeadingZeros(binSize);
        int ptr = windowPtr;

        for (int i = 0; i < windowSize; i++) {
            int j = Integer.reverse(i) >>> shift;
            fftBins[j][0] = inBuffer[ptr++] * windowCoefficients[i];
            fftBins[j][1] = 0.0;
            ptr &= mask;
        }

        // Pad remaining samples up to full bin size
        for (int i = windowSize; i < binSize; i++) {
            int j = Integer.reverse(i) >>> shift;
            fftBins[j][0] = 0.0;
            fftBins[j][1] = 0.0;
        }

        windowPtr += windowInterval;
        windowPtr &= mask;
        availableWindowCount.decrementAndGet();
        return true;
    }

    public int getWindowInterval() {
        return windowInterval;
    }
}

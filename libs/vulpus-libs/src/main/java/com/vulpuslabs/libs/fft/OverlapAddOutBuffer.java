package com.vulpuslabs.libs.fft;

public class OverlapAddOutBuffer {

    private final int bufferSize;
    private final int windowSize;
    private final int windowInterval;
    private final int bufferMask;
    private final double[] outBuffer;
    private int readPtr;
    private int windowStart;
    private volatile boolean overflowWarning;
    private final int readOffset;
    private final double[] windowCoefficients;

    public OverlapAddOutBuffer(int windowSize, int bufferSize, int readOffset) {
        this.windowSize = windowSize;
        this.bufferSize = bufferSize;
        this.windowInterval = windowSize >> 1;
        this.bufferMask = bufferSize - 1;

        this.outBuffer = new double[bufferSize];
        this.readOffset = readOffset;
        this.windowStart = readOffset;
        this.windowCoefficients = new double[windowSize];
        for (int i=0; i<windowSize; i++) {
            windowCoefficients[i] = Math.sin(i * Math.PI / windowSize);
        }
    }

    public double read() {
        double sample = outBuffer[readPtr++];
        readPtr &= bufferMask;
        if (readPtr == windowStart) {
            overflowWarning = true;
        }
        return sample;
    }

    public boolean checkOverflowWarning() {
        var wasOverflowing = overflowWarning;
        overflowWarning = false;
        return wasOverflowing;
    }

    public void writeFFTWindow(double[][] fftBins) {
        int writePtr = windowStart;
        windowStart += windowInterval;
        windowStart = windowStart & bufferMask;

        for (int i=0; i<windowInterval; i++) {
            outBuffer[writePtr++] += fftBins[i][0] * windowCoefficients[i];
            writePtr &= bufferMask;
        }

        for (int i=windowInterval; i<windowSize; i++) {
            outBuffer[writePtr++] = fftBins[i][0] * windowCoefficients[i];
            writePtr &= bufferMask;
        }
    }

    public int getReadOffset() {
        return readOffset;
    }
}

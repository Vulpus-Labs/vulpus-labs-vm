package com.vulpuslabs.libs.fft;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FFTProcessor implements Runnable {

    private final WindowingInBuffer inBuffer;
    private final OverlapAddOutBuffer outBuffer;
    private final double[][] fftBins;
    private final FFT fft;
    private final FFTTransformer transformer;
    private volatile boolean stopping;
    private final Lock lock = new ReentrantLock();
    private final Condition windowsAvailable = lock.newCondition();

    public FFTProcessor(int windowSize, int bufferSize, int minReadOffset, FFTTransformer transformer) {
        this.inBuffer = new WindowingInBuffer(windowSize, bufferSize);
        this.outBuffer = new OverlapAddOutBuffer(
                windowSize,
                bufferSize,
                inBuffer.getWindowInterval() + minReadOffset);
        int binSize = windowSize << 1;
        this.fftBins = new double[binSize][2];
        this.fft = new FFT(binSize);
        this.transformer = transformer;
    }

    public double processSample(double sample) {
        boolean hasWindows = inBuffer.write(sample);
        
        if (hasWindows &! stopping) {
            lock.lock();
            try {
                windowsAvailable.signal();
            } finally {
                lock.unlock();
            }
        }

        return outBuffer.read();
    }

    public boolean checkOverflowWarning() {
        return outBuffer.checkOverflowWarning();
    }

    public int getOutputLatency() {
        return outBuffer.getReadOffset() + inBuffer.getWindowInterval();
    }

    public void stop() {
        stopping = true;
        lock.lock();
        try {
            windowsAvailable.signal();
        } finally {
            lock.unlock();
        }
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!stopping) {

            lock.lock();
            try {
                windowsAvailable.await();
            } catch (InterruptedException e) {
                return;
            } finally {
                lock.unlock();
            }

            while (!stopping && inBuffer.getFFTWindow(fftBins)) {
                fft.transformPermutated(fftBins);

                transformer.transform(fftBins);

                fft.reverseTransform(fftBins);
                outBuffer.writeFFTWindow(fftBins);
            }

        }
    }
}

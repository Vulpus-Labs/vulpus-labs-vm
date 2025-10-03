package com.vulpuslabs.vulpes.controls;

import java.util.function.DoubleConsumer;

public class DisconnectableOutput implements DoubleConsumer {

    private static final DoubleConsumer NO_OP = (x) -> {};
    private boolean isConnected;
    private final DoubleConsumer inputWriter;
    private DoubleConsumer valueConsumer;

    public DisconnectableOutput(DoubleConsumer inputWriter) {
        this.inputWriter = inputWriter;
        this.valueConsumer = NO_OP;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
        valueConsumer = isConnected ? inputWriter : NO_OP;
    }

    @Override
    public void accept(double value) {
        valueConsumer.accept(value);
    }

    public boolean isConnected() {
        return isConnected;
    }
}

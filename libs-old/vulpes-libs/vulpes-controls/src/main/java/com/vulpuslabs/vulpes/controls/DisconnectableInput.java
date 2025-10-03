package com.vulpuslabs.vulpes.controls;

import com.vulpuslabs.vulpes.events.EventBus;
import voltage.core.VoltageAudioJack;

import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

public class DisconnectableInput implements DoubleSupplier {

    public static DisconnectableInput connect(VoltageAudioJack jack, EventBus eventBus) {
        DisconnectableInput input = new DisconnectableInput(jack::GetValue);
        eventBus.registerBooleanObserver(jack, input::setIsConnected);
        return input;
    }

    public static DisconnectableInput connect(VoltageAudioJack jack, EventBus eventBus, DoubleUnaryOperator transformer) {
        DisconnectableInput input = new DisconnectableInput(() -> transformer.applyAsDouble(jack.GetValue()));
        eventBus.registerBooleanObserver(jack, input::setIsConnected);
        return input;
    }

    private static final DoubleSupplier CONSTANT_ZERO = () -> 0.0;
    private boolean isConnected;
    private final DoubleSupplier inputReader;
    private DoubleSupplier valueSupplier;

    public DisconnectableInput(DoubleSupplier inputReader) {
        this.inputReader = inputReader;
        this.valueSupplier = CONSTANT_ZERO;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
        valueSupplier = isConnected ? inputReader : CONSTANT_ZERO;
    }

    @Override
    public double getAsDouble() {
        return valueSupplier.getAsDouble();
    }

    public boolean isConnected() {
        return isConnected;
    }
}

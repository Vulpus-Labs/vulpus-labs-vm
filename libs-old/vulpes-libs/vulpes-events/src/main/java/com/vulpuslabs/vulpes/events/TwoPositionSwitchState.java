package com.vulpuslabs.vulpes.events;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public enum TwoPositionSwitchState {
    OFF,
    ON;

    public static DoubleConsumer toDoubleObserver(Consumer<TwoPositionSwitchState> observer) {
        return value -> observer.accept(value == 0.0 ? OFF : ON);
    }
}

package com.vulpuslabs.vulpes.events;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public enum ThreePositionSwitchState {
    LOW,
    MID,
    HIGH;

    public static DoubleConsumer toDoubleObserver(Consumer<ThreePositionSwitchState> observer) {
        return (value) -> observer.accept(value == 0.0 ? LOW : (
                value == 1.0 ? MID : HIGH));
    }
}

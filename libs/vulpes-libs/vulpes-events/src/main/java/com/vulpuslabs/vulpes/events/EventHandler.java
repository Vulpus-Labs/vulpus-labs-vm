package com.vulpuslabs.vulpes.events;

public class EventHandler {

    private final EventBus eventBus;

    public EventHandler(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public boolean onKnobValueChanged(Object component, double newValue) {
        return eventBus.onDouble(component, newValue);
    }

    public boolean onJackConnected(Object component) {
        return eventBus.onBoolean(component, true);
    }

    public boolean onJackDisconnected(Object component) {
        return eventBus.onBoolean(component, false);
    }

    public boolean onSwitchChanged(Object component, double newValue) {
        return eventBus.onDouble(component, newValue);
    }

    public boolean onButtonChanged(Object component, double newValue) {
        return eventBus.onDouble(component, newValue);
    }
}

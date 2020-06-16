package com.groep6.pfor.util;

import java.util.ArrayList;
import java.util.List;

public class ServerEvent {
    private final List<IEventCallback> listeners = new ArrayList<IEventCallback>();

    public void subscribe(IEventCallback listener) {
        listeners.add(listener);
    }

    public void unsubscribe(IEventCallback listener) {
        listeners.remove(listener);
    }

    public void fire(Object... eventData) {
        for (IEventCallback listener : listeners) listener.onEvent(eventData);
    }
}

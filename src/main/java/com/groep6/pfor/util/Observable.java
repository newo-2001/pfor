package com.groep6.pfor.util;

import java.util.ArrayList;
import java.util.List;

/**
 * An object who's state can be monitored by an {@link IObserver}.
 *
 * @author Owen Elderbroek
 */
public abstract class Observable {
    /** A list of observers observing this object. */
    private final List<IObserver> observers = new ArrayList<>();

    /**
     * Registers an observer to be notified once this object's state changes.
     * @param observer The observer to be notified.
     */
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from this object.
     * It will no longer receive updates about this object's state.
     * @param observer The observer to be removed.
     */
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    /** Notify all registered observer that this object's state has changed. */
    protected void notifyObservers() {
        for (IObserver observer : observers) observer.update();
    }
}

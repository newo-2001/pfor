package com.groep6.pfor.util;

public interface IObservable {
    void notifyObservers();
    void registerObserver();
    void removeObserver();
}

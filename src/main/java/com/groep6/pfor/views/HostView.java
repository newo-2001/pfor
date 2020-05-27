package com.groep6.pfor.views;

import com.groep6.pfor.util.IObserver;

/**
 * The view that show's the screen to create a lobby as a host
 * @author Mathijs
 */
public class HostView implements IObserver {
    /** The hostController */
    private HostController hostController;

    /**
     * The constructor
     * @param hostController The hostController
     */
    public HostView(HostController hostController) {
        this.hostController = hostController;
    }

    @Override
    public void update() {

    }
}

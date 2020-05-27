package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;

/**
 * @author Bastiaan Jansen
 */
public abstract class Controller {

    protected ViewController viewController;

    public Controller() {
        viewController = ViewController.getInstance();
    }

    /**
     * Go back to the previous View
     */
    public void goBack() {
        viewController.showPreviousView();
    }

    /**
     * Every controller should have a registerObserver method so the view can call the method and register to models
     * @param view
     */
    public abstract void registerObserver(IObserver view);
}

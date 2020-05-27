package com.groep6.pfor.views;

import com.groep6.pfor.controllers.JoinController;
import com.groep6.pfor.util.IObserver;

/**
 * The view where you can join a lobby using a code and a password if required
 * @author Mathijs
 */
public class JoinView implements IObserver {
    /** The joinController */
    private JoinController joinController;

    /**
     * The constructor
     * @param joinController The joinController
     */
    public JoinView(JoinController joinController) {
        this.joinController = joinController;
    }

    @Override
    public void update() {

    }
}

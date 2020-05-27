package com.groep6.pfor.views;

import com.groep6.pfor.controllers.MoveController;
import com.groep6.pfor.util.IObserver;

/**
 * The move view
 * @author Mathijs
 */
public class MoveView implements IObserver {
    /** The moveController */
    private MoveController moveController;

    /**
     * The constructor
     * @param moveController The moveController
     */
    public MoveView(MoveController moveController) {
        this.moveController = moveController;
    }

    @Override
    public void update() {

    }
}

package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LoseController;

/**
 * The view that shows that you lost the game :(
 * @author Mathijs
 */
public class LoseView {
    /** The loseController */
    private LoseController loseController;

    /**
     * The constructor
     * @param loseController The loseController
     */
    public LoseView(LoseController loseController) {
        this.loseController = loseController;
    }
}

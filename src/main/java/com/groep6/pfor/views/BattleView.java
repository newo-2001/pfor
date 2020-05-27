package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BattleController;
import com.groep6.pfor.util.IObserver;

/**
 * The battleView
 * @author Mathijs
 */
public class BattleView implements IObserver {
    /** The battleController */
    private BattleController battleController;

    /**
     * The constructor
     * @param battleController The battleController
     */
    public BattleView(BattleController battleController) {
        this.battleController = battleController;
    }

    @Override
    public void update() {

    }
}

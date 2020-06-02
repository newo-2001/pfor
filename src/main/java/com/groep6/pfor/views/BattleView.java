package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BattleController;
import com.groep6.pfor.util.IObserver;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * The battleView
 * @author Mathijs
 */
public class BattleView extends View implements IObserver {
    /** The battleController */
    private BattleController battleController;
    private BorderPane root;

    /**
     * The constructor
     * @param battleController The battleController
     */
    public BattleView(BattleController battleController) {
        this.battleController = battleController;

        root = new BorderPane();
    }

    @Override
    public void update(Object... data) {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

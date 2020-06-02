package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BattleController;
import com.groep6.pfor.util.IObserver;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * BattleView. Shows the result of a passed battle.
 * @author Mathijs
 * @author Mitchell van Rijswijk
 */
public class BattleView extends View implements IObserver {
    /** The battleController */
    private BattleController battleController;
    private BorderPane root;
    private int[] battleResult;

    /**
     * The constructor
     * @param battleController The battleController
     */
    public BattleView(BattleController controller, int[] result) {
        battleController = controller;
        battleController.registerObserver(this);
        battleResult = result;
        createView();
        update();
    }
    
    public void createView() {
    	root = new BorderPane();
    	VBox log = new VBox();
    	Label legionsLost = new Label(battleResult[0] + " Legions were killed");
    	Label barbariansLost = new Label(battleResult[1] + " Barbarians were killed");
    	log.getChildren().addAll(legionsLost, barbariansLost);
    	root.setCenter(log);
    }

    @Override
    public void update(Object... data) {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

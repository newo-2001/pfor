package com.groep6.pfor.views;

import com.groep6.pfor.controllers.TradeController;
import com.groep6.pfor.util.IObserver;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * The view where you can trade cards with the trade deck
 * @author Mathijs
 */
public class TradeView extends View implements IObserver {
    /** The tradeController */
    private TradeController tradeController;

    private BorderPane root;

    /**
     * The constructor
     * @param tradeController the tradeController
     */
    public TradeView(TradeController tradeController) {
        this.tradeController = tradeController;

        root = new BorderPane();
    }

    @Override
    public void update() {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

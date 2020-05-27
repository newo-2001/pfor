package com.groep6.pfor.views;

import com.groep6.pfor.controllers.TradeController;
import com.groep6.pfor.util.IObserver;

/**
 * The view where you can trade cards with the trade deck
 * @author Mathijs
 */
public class TradeView implements IObserver {
    /** The tradeController */
    private TradeController tradeController;

    /**
     * The constructor
     * @param tradeController the tradeController
     */
    public TradeView(TradeController tradeController) {
        this.tradeController = tradeController;
    }

    @Override
    public void update() {

    }
}

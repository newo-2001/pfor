package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.TradeView;

public class TradeController extends Controller {

    public TradeController() {
        viewController.showView(new TradeView(this));
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

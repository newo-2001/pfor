package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.BattleView;

public class BattleController extends Controller {

    public BattleController() {
        viewController.showView(new BattleView(this));
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

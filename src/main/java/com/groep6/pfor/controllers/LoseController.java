package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.LoseView;

public class LoseController extends Controller {

    public LoseController() {
        viewController.showView(new LoseView(this));
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

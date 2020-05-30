package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.JoinView;

public class JoinController extends Controller {

    public JoinController() {
        viewController.showView(new JoinView(this));
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

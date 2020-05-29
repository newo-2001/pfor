package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.MenuView;

public class WinController extends Controller {

    public void goToMenuView() {
        viewController.showView(new MenuView());
    }

    @Override
    public void registerObserver(IObserver view) {}
}

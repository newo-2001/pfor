package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.WinView;

public class WinController extends Controller {

    public WinController() {
        viewController.showView(new WinView(this));
    }

    public void goToMenuView() {
        new MenuController();
    }

    @Override
    public void registerObserver(IObserver view) {}
}

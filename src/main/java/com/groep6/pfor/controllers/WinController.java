package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.MenuView;

public class WinController extends Controller {

    public void goToMenuView() {
        new MenuController();
    }

    @Override
    public void registerObserver(IObserver view) {}
}

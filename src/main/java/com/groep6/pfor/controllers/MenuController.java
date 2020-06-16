package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.MenuView;

/**
 * @author Bastiaan Jansen
 */
public class MenuController extends Controller {

    public MenuController() {
        viewController.showView(new MenuView(this));
    }

    public void goToHostView() {
        new HostController();
    }

    public void goToJoinView() {
        new JoinController();
    }

    @Override
    public void registerObserver(IObserver view) {}
}

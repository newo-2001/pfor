package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.WinView;

public class WinController extends Controller {

    public WinController() {
    	MusicManager.getInstance().addToQueue("src/main/resources/sounds/music/To_fight_another_day.mp3");	// Change to loop just in this view.
        viewController.showView(new WinView(this));
    }

    public void goToMenuView() {
        new MenuController();
    }

    @Override
    public void registerObserver(IObserver view) {}
}

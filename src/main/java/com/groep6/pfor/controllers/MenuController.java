package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.*;

/**
 * @author Bastiaan Jansen
 */
public class MenuController extends Controller {

    public MenuController() {
        viewController.showView(new MenuView(this));
        MediaController.play("src/main/resources/sound/music/Last_stand_of_an_Empire.mp3", true);
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

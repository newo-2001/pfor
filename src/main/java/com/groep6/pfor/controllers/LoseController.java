package com.groep6.pfor.controllers;

import com.groep6.pfor.Main;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.GameState;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.LoseView;

public class LoseController extends Controller {

    public LoseController() {
    	changeMusic();
        viewController.showView(new LoseView(this));
    }

    public void goToMenuView() {
    	viewController.getVisitedViews().clear();
    	Game.setGameState(GameState.MENU);
        new MenuController();
    }
    
    public void changeMusic() {
    	Main.musicManager.stop();
    	Main.musicManager.play("src/main/resources/sounds/music/The_End_of_an_Era.mp3", 0.2, false);
    }

    @Override
    public void registerObserver(IObserver view) {}
}

package com.groep6.pfor.controllers;

import com.groep6.pfor.Main;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.GameState;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.OptionsView;

public class OptionController extends Controller {

	public OptionController() {
		viewController.showView(new OptionsView(this));
	}
	
	public GameState checkGameState() {
		return Game.getGameState();
	}
	
	public void toMainMenu() {
		viewController.getVisitedViews().clear();
		changeMusic();
		Game.setGameState(GameState.MENU);
        new MenuController();
	}
	
	public void handleFullscreen() {
		ViewController.getInstance().toggleFullscreen();
	}
	
	public void handleMute() {
		Main.musicManager.toggleMute();
	}
	
	public void goToInstructions() {
		new InstructionController();
	}
	
	public void changeMusic() {
    	Main.musicManager.stop();
    	Main.musicManager.play("src/main/resources/sounds/music/Last_stand_of_an_Empire.mp3", 0.2, true);
    }
	
	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
	}

}

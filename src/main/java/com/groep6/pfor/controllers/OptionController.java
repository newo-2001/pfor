package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.OptionsView;

public class OptionController extends Controller {

	public OptionController() {
		viewController.showView(new OptionsView(this));
	}
	
	public GameState checkGameState() {
		return game.getGameState();
	}
	
	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
	}

}

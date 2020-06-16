package com.groep6.pfor.controllers;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RecruitLegionView;

/**
 * @author Nils van der Velden
 */

public class RecruitLegionController extends Controller {
	
	private final Game game = Game.getInstance();
	private final Player player;
	private final City city;
	
    public RecruitLegionController() {
    	player = game.getPlayerTurn();
    	city = player.getCity();
    	viewController.showView(new RecruitLegionView(this));
    }

    public void recruit(int amount) {
		if (city.hasFort()) city.addLegions(amount);
		player.decreaseActionsRemaining();
		goBack();
	}

	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
	}

}

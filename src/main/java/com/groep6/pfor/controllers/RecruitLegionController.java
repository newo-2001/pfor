package com.groep6.pfor.controllers;

import java.util.List;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.services.GameService;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RecruitLegionView;

/**
 * @author Nils van der Velden
 */

public class RecruitLegionController extends Controller {
	
	private Game game = Game.getInstance();
	private Player player;
	private City city;
	
    public RecruitLegionController() {
    	player = game.getPlayerTurn();
    	city = player.getCity();
    	viewController.showView(new RecruitLegionView(this));
    }

    public void recruit(int amount) {
		if (city.hasFort()) city.addLegions(amount);
		player.decreaseActionsRemaining();
		new BoardController();
	}

	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
	}

}

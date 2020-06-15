package com.groep6.pfor.controllers;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RecruitBarbarianView;

public class RecruitBarbarianController extends Controller {

    private Game game = Game.getInstance();
    private Player player;
    private City city;
	
    public RecruitBarbarianController() {
        player = game.getPlayerTurn();
        city = player.getCity();
        viewController.showView(new RecruitBarbarianView(this));
    }
    
    public int getAmountOfBarbariansCurrently() {
    	return city.getBarbarians().size();
    }
    
    public void recruit(int amount) {
        Faction[] factions = city.getFactions();

        for (Faction faction: factions) {
            if (game.isFriendlyFaction(faction)) {
                if (city.getTotalBarbarianCount() <= 0) return;
                city.removeBarbarians(faction.getFactionType(), amount);
                city.addLegions(amount);
                player.decreaseActionsRemaining();
                goBack();
                return;
            }
        }
    }

	@Override
	public void registerObserver(IObserver view) {
		
	}

}

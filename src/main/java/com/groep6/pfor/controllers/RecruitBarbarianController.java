package com.groep6.pfor.controllers;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RecruitBarbarianView;

public class RecruitBarbarianController extends Controller {

    private Game game = Game.getInstance();
    private Player player;
    private City city;
    private FactionType friendlyFaction;
	
    public RecruitBarbarianController() {
        player = game.getPlayerTurn();
        city = player.getCity();
        viewController.showView(new RecruitBarbarianView(this));
        initBarbarianFaction();
    }
    
    public int getAmountOfBarbariansInCurrentCity() {
    	int amount = city.getBarbarianCount(friendlyFaction, city.getBarbarians());
    	return amount;
    }
    
    public void recruit(int amount) {
    	city.removeBarbarians(friendlyFaction, amount);
        city.addLegions(amount);
        player.decreaseActionsRemaining();
        goBack();
        return;
    }
    
    public void initBarbarianFaction() {
    	Faction[] factions = city.getFactions();

        for (Faction faction : factions) {
            if (game.isFriendlyFaction(faction)) {
                friendlyFaction = faction.getFactionType();
                return;
            }
        }
    }

	@Override
	public void registerObserver(IObserver view) {
		
	}

}

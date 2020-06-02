package com.groep6.pfor.controllers;

import java.util.List;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Vector2f;
import com.groep6.pfor.views.TradeView;

public class TradeController extends Controller {
	
	private Game game = Game.getInstance();

    public TradeController() {
        Faction[] factions = new Faction[] {};
        FactionFactory factionFactory = FactionFactory.getInstance();
    	game.getTradeDeck().addCards(new CityCard("Card 1", new City("City 1", false, new Vector2f(), factions), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
    	game.getTradeDeck().addCards(new CityCard("Card 2", new City("City 1", false, new Vector2f(), factions), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
    	game.getTradeDeck().addCards(new CityCard("Card 3", new City("City 1", false, new Vector2f(), factions), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
    	game.getTradeDeck().addCards(new CityCard("Card 4", new City("City 1", false, new Vector2f(), factions), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
    	
    	viewController.showView(new TradeView(this));
    }
    
    public List<Card> getTradeCard() {
        return game.getTradeDeck().getCards();
    }

    @Override
    public void registerObserver(IObserver view) {
    }
}

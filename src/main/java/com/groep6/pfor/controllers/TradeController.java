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
    private Card selectedCard;

    public TradeController() {
//    	game.setLocalPlayer(new Player(new LobbyPlayer("Bastiaan", RoleCardFactory.getInstance().pickRandomRoleCard(), true, true, "")));
        Faction[] factionTypes = new Faction[] {};
        FactionFactory factionFactory = FactionFactory.getInstance();
        game.getTradeCardsDeck().addCards(new CityCard("Card 1", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
        game.getTradeCardsDeck().addCards(new CityCard("Card 2", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.OSTROGOTHS)));
        game.getTradeCardsDeck().addCards(new CityCard("Card 3", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.VISIGOTHS)));
        game.getTradeCardsDeck().addCards(new CityCard("Card 4", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.HUNS)));
        game.getTradeCardsDeck().addCards(new CityCard("Card 5", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.VANDALS)));
        game.getTradeCardsDeck().addCards(new CityCard("Card 6", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.VISIGOTHS)));
    	game.getTradeCardsDeck().addCards(new CityCard("Card 8", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.VISIGOTHS)));
    	
    	viewController.showView(new TradeView(this));
    }
    
    public List<Card> getTradeCard() {
        return game.getTradeCardsDeck().getCards();
    }

    @Override
    public void registerObserver(IObserver view) {
    	game.getTradeCardsDeck().registerObserver(view);
        game.getLocalPlayer().getHand().registerObserver(view);
    }
    
    public void selectCard(Card card) {
    	this.selectedCard = card;
    }
    
    public void withdrawCard() {
    	System.out.println("Kaart is verwijderd");
        game.getTradeCardsDeck().removeCard(selectedCard);
        game.getLocalPlayer().getHand().addCards(selectedCard);
    	System.out.println(game.getTradeCardsDeck());
    }
    
    public void depositeCard() {
    	new HandController();
    }
    
    public Card getCard(Card card) {
    	return card;
    }
}

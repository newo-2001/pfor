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

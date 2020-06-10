package com.groep6.pfor.controllers;

import java.util.List;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.services.GameService;
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
        Player player = game.getPlayerTurn();
        if (player.getActionsRemaining() <= 0) return;

        game.getTradeCardsDeck().removeCard(selectedCard);
        game.getLocalPlayer().getHand().addCards(selectedCard);
    	player.decreaseActionsRemaining();

        GameService gameService = new GameService();
        gameService.setGame(game);
    }
    
    public Card getCard(Card card) {
    	return card;
    }

    public Player getLocalPlayer() {
        return game.getLocalPlayer();
    }
}

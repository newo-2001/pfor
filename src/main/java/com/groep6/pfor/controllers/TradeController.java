package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.SoundEffectManager;
import com.groep6.pfor.views.TradeView;

import java.util.List;

public class TradeController extends Controller {
	
	private final Game game = Game.getInstance();
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

        SoundEffectManager.play("/sounds/effects/DrawCardSound.mp3");
    	
    	refresh();
    }
    
    public Card getCard(Card card) {
    	return card;
    }

    public Player getLocalPlayer() {
        return game.getLocalPlayer();
    }
    
    public void refresh() {
    	goBack();
    	new TradeController();
    }
}

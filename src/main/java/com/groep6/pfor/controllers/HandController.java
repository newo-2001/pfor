package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.cards.EventCard;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.SoundEffectManager;
import com.groep6.pfor.views.HandView;

import java.util.List;

public class HandController extends Controller {

    private final Game game = Game.getInstance();
    private Card selectedCard;

    public HandController() {
    
        viewController.showView(new HandView(this));
    }

    public List<Card> getCards() {
        return game.getLocalPlayer().getHand().getCards();
    }

    @Override
    public void registerObserver(IObserver view) {
        game.getLocalPlayer().getHand().registerObserver(view);
    }

    public void selectCard(Card card) {
    	this.selectedCard = card;
    }
    
    public void playCard() {
        if (selectedCard == null) return;
        if (!game.getLocalPlayer().isTurn()) return;

        if (selectedCard instanceof EventCard) {
            game.getLocalPlayer().getHand().removeCard(selectedCard);
        	game.getInvasionCardsDiscardPile().addCards(selectedCard);
        	((EventCard) selectedCard).executeEvent();
        }

        SoundEffectManager.play("/sounds/effects/DrawCardSound.mp3");
        
        refresh();
    }

    public Card getSelectedCard() {
        return selectedCard;
    }
    
    public Card getCard(Card card) {
    	return card;
    }

	public void depositCard() {
        if (selectedCard == null) return;
        
        Player localPlayer = game.getLocalPlayer();
        Deck tradeDeck = game.getTradeCardsDeck();
        Player player = game.getPlayerTurn();

        if (player.getActionsRemaining() <= 0) return;

        localPlayer.getHand().removeCard(selectedCard);
		tradeDeck.addCards(selectedCard);
		
        player.decreaseActionsRemaining();
        SoundEffectManager.play("/sounds/effects/DrawCardSound.mp3");

        refresh();
        
        //new HandController();
        
	}
	
    public void removeSelectedCard() {
        if (selectedCard == null) return;
        Player localPlayer = game.getLocalPlayer();

        localPlayer.getHand().removeCard(selectedCard);

        if (selectedCard instanceof CityCard) {
        	game.getCityCardsDiscardPile().addCards(selectedCard);
        } else if (selectedCard instanceof EventCard) {
        	game.getInvasionCardsDiscardPile().addCards(selectedCard);
        }

        SoundEffectManager.play("/sounds/effects/DrawCardSound.mp3");
        
        refresh();
    }
    
    public void goToBoard() {
    	goBack();
    }
    
    public void refresh() {
    	goBack();
    	new HandController();
    }

	public Player getLocalPlayer() {
        return game.getLocalPlayer();
    }
}

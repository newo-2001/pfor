package com.groep6.pfor.controllers;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.*;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.cards.EventCard;
import com.groep6.pfor.models.cards.actions.eventActions.FestinaLenteAction;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Vector2f;
import com.groep6.pfor.views.HandView;

import java.util.List;

public class HandController extends Controller {

    private Game game = Game.getInstance();
    private Card selectedCard;

    public HandController() {
        game.setLocalPlayer(new Player(new LobbyPlayer("Bastiaan", RoleCardFactory.getInstance().pickRandomRoleCard(), true, true)));
        Player localPlayer = game.getLocalPlayer();
        Faction[] factionTypes = new Faction[] {};
        FactionFactory factionFactory = FactionFactory.getInstance();
        localPlayer.getHand().addCards(new CityCard("Card 1", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
        localPlayer.getHand().addCards(new CityCard("Card 2", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.OSTROGOTHS)));
        localPlayer.getHand().addCards(new CityCard("Card 3", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.VISIGOTHS)));
        localPlayer.getHand().addCards(new CityCard("Card 4", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.HUNS)));
        localPlayer.getHand().addCards(new CityCard("Card 5", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.VANDELS)));
        localPlayer.getHand().addCards(new CityCard("Card 6", new City("City 1", false, new Vector2f(), factionTypes), factionFactory.getFaction(FactionType.VISIGOTHS)));
        localPlayer.getHand().addCards(new EventCard("Event Card 1", new FestinaLenteAction()));

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
    
    public void removeSelectedCard() {
        if (selectedCard == null) return;

        game.getLocalPlayer().getHand().removeCard(selectedCard);
        
        if (selectedCard instanceof CityCard) {
        	game.getCityDiscardPile().addCards(selectedCard);
        }
        if (selectedCard instanceof EventCard) {
        	game.getInvasionDiscardPile().addCards(selectedCard);
        }
    }
    
    public void playCard(Card card) {
    	game.getLocalPlayer().getHand();
    }
    
    public Card getCard(Card card) {
    	return card;
    }
}

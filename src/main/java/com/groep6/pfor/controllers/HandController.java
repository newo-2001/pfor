package com.groep6.pfor.controllers;

import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.*;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Vector2f;
import com.groep6.pfor.views.HandView;

import java.util.ArrayList;
import java.util.List;

public class HandController extends Controller {

    private Game game = Game.getInstance();

    public HandController() {
        game.setLocalPlayer(new Player(new LobbyPlayer("Bastiaan", RoleCardFactory.getInstance().pickRandomRoleCard(), true, true)));
        Player localPlayer = game.getLocalPlayer();
        Faction[] factions = new Faction[] {};
        localPlayer.getHand().addCards(new CityCard("Card 1", new City("City 1", false, new Vector2f(), factions), Faction.ANGLO_SAXSONS_FRANKS));
        localPlayer.getHand().addCards(new CityCard("Card 2", new City("City 1", false, new Vector2f(), factions), Faction.ANGLO_SAXSONS_FRANKS));
        localPlayer.getHand().addCards(new CityCard("Card 3", new City("City 1", false, new Vector2f(), factions), Faction.ANGLO_SAXSONS_FRANKS));
        localPlayer.getHand().addCards(new CityCard("Card 4", new City("City 1", false, new Vector2f(), factions), Faction.ANGLO_SAXSONS_FRANKS));
        localPlayer.getHand().addCards(new CityCard("Card 5", new City("City 1", false, new Vector2f(), factions), Faction.ANGLO_SAXSONS_FRANKS));
        localPlayer.getHand().addCards(new CityCard("Card 6", new City("City 1", false, new Vector2f(), factions), Faction.ANGLO_SAXSONS_FRANKS));
        localPlayer.getHand().addCards(new CityCard("Card 7", new City("City 1", false, new Vector2f(), factions), Faction.ANGLO_SAXSONS_FRANKS));

        viewController.showView(new HandView(this));
    }

    public List<Card> getCards() {
        return game.getLocalPlayer().getHand().getCards();
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

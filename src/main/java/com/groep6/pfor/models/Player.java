package com.groep6.pfor.models;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import com.groep6.pfor.models.cards.RoleCard;

/**
 * @author Bastiaan Jansen
 */
public class Player extends Observable {

    private Hand hand = new Hand();
    private RoleCard roleCard;
    private City city;
    private String username;
    private boolean turn = false;
    private int actionsRemaining = 0;
    private boolean isLocal;

    /**
     * The Player constructor clones all necessary the information from LobbyPlayer to Player
     * @param player
     */
    public Player(LobbyPlayer player) {
        roleCard = player.getRoleCard();
        username = player.getUsername();
        isLocal = player.isLocal();
    }

    public Player(String username, City city, RoleCard roleCard, boolean turn, boolean isLocal) {
        this.roleCard = roleCard;
        this.city = city;
        this.username = username;
        this.isLocal = isLocal;
        if (turn) setTurn();
    }
    
    public boolean isTurn() {
        return turn;
    }

    /**
     * Set the player turn to true
     * The player can now perform 4 actions
     */
    public void setTurn() {
        turn = true;
        actionsRemaining = 4;
    }

    public int getActionsRemaining() {
        return actionsRemaining;
    }

    public void decreaseActionsRemaining() {
        if (actionsRemaining <= 0) return;
        actionsRemaining--;
    }

    public Hand getHand() {
        return hand;
    }

    public RoleCard getRoleCard() {
        return roleCard;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString () {
        return String.format("Player: %s, role: %s, city: %s, turn: %b, actions: %d", username, roleCard.getName(), city.getName(), turn, actionsRemaining);
    }
    
    // Actions
    
    public int[] battle() {
    	
    	Dice dice = new Dice();
    	Stack<Legion> legionsBefore = city.getLegions();
    	Stack<Barbarian> barbariansBefore = city.getBarbarians();
    	int diceAmount = 3;
    	
    	// Decide amount of dice to roll.
    	if (legionsBefore.size() < 3 && !legionsBefore.empty()) {
    		diceAmount = legionsBefore.size();
    	}
    	
    	for (int i = 0; i < diceAmount; i++) {
    		dice.roll(city);
    	}
    	
    	int legionsLost = legionsBefore.size() - city.getLegions().size();
    	int barbariansLost = barbariansBefore.size() - city.getBarbarians().size();

    	int[] battleResults = {legionsLost, barbariansLost};
    	return battleResults;
    }

    /**
     * Add more actions
     * @param amount
     */
    public void addActions(int amount) {
        actionsRemaining += amount;
        notifyObservers();
    }

    public City getCity() {
        return city;
    }

    public void notTurn() {
        turn = false;
    }

    public boolean isLocal() {
        return isLocal;
    }
    
}

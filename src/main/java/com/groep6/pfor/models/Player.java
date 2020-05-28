package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.RoleCard;

/**
 * @author Bastiaan Jansen
 */
public class Player {

    private Hand hand = new Hand();
    private RoleCard roleCard;
    private City city;
    private String username;
    private boolean turn = false;
    private int actionsRemaining = 0;

    /**
     * The Player constructor clones all necessary the information from LobbyPlayer to Player
     * @param player
     */
    public Player(LobbyPlayer player) {
        roleCard = player.getRoleCard();
        username = player.getUsername();
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
}

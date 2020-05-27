package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.RoleCard;

/**
 * @author Bastiaan Jansen
 */
public class Player {

    private Hand hand;
    private RoleCard roleCard;
    private City city;
    private Color color;
    private String username;
    private boolean turn;
    private int actionCount;

    public Player(LobbyPlayer player) {

    }

    public boolean isTurn() {
        return turn;
    }
}

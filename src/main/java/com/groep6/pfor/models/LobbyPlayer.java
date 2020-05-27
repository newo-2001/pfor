package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.RoleCard;

/**
 * Represents a lobby player
 * @author Bastiaan Jansen
 */
public class LobbyPlayer {

    private String username;
    private RoleCard roleCard;
    private boolean isHost;


    /**
     * @param username
     * @param isHost
     */
    public LobbyPlayer(String username, RoleCard roleCard, boolean isHost) {
        this.username = username;
        this.roleCard = roleCard;
        this.isHost = isHost;
    }

    /**
     * @return RoleCard
     */
    public RoleCard getRoleCard() {
        return roleCard;
    }
}

package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.util.Observable;

/**
 * Represents a lobby player
 * @author Bastiaan Jansen
 */
public class LobbyPlayer extends Observable {

    private String username;
    private RoleCard roleCard;
    private boolean isHost;
    private boolean isLocal;

    public LobbyPlayer() {}

    /**
     * @param username
     * @param isHost
     */
    public LobbyPlayer(String username, RoleCard roleCard, boolean isHost, boolean isLocal) {
        this.username = username;
        this.roleCard = roleCard;
        this.isHost = isHost;
        this.isLocal = isLocal;
    }

    public LobbyPlayer(String username, boolean isHost) {
        this.username = username;
        this.isHost = isHost;
    }

    /**
     * @return RoleCard
     */
    public RoleCard getRoleCard() {
        return roleCard;
    }

    public void setRoleCard(RoleCard roleCard) {
        this.roleCard = roleCard;
        notifyObservers();
    }

    /**
     * @return Whether lobbyPlayer is a host of a lobby or not
     */
    public boolean isHost() {
        return isHost;
    }

    /**
     * @return Username of lobbyPlayer
     */
    public String getUsername() {
        return username;
    }

    public boolean isLocal() {
        return isLocal;
    }
}

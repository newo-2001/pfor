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
    private String lobby;

    /**
     * @param username
     * @param isHost
     * @param isLocal
     * @param lobby
     */
    public LobbyPlayer(String username, RoleCard roleCard, boolean isHost, boolean isLocal, String lobby) {
        this.username = username;
        this.roleCard = roleCard;
        this.isHost = isHost;
        this.isLocal = isLocal;
        this.lobby = lobby;
    }

    public LobbyPlayer(String username, boolean isHost, String lobby) {
        this.username = username;
        this.isHost = isHost;
        this.lobby = lobby;
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

    /**
     * @return The lobby code of the lobby that the player is in
     */
    public String getLobby() {
        return lobby;
    }
}

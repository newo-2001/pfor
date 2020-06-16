package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.util.Observable;

/**
 * Represents a lobby player
 * @author Bastiaan Jansen
 */

public class LobbyPlayer extends Observable {

    private final String username;
    private RoleCard roleCard;
    private final boolean isHost;
    private boolean isLocal;
    private final String lobby;

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

    public void setLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }

    /**
     * @return The lobby code of the lobby that the player is in
     */
    public String getLobby() {
        return lobby;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LobbyPlayer)) return false;

        LobbyPlayer player = (LobbyPlayer) o;

        return player.getUsername().equals(this.username);
    }
}

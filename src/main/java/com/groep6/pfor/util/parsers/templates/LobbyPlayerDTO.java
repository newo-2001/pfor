package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.LobbyPlayer;

/**
 * The Data Transfer Object that represents a LobbyPlayer in Firebase
 *
 * @author Owen Elderbroek
 */
public class LobbyPlayerDTO {
    /** This player's username */
    public String username;

    /** The name of the rolecard the player has */
    public String role;

    /** Whether this player is the host of lobby */
    public boolean host;

    public LobbyPlayerDTO() {}

    /**
     * Make A Data Transfer Object with the specified fields
     *
     * @param username The username of the player
     * @param role     The role of the player
     * @param host     Whether the player is the host of the lobby
     */
    private LobbyPlayerDTO(String username, String role, boolean host) {
        this.username = username;
        this.role = role;
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public boolean getHost() {
        return host;
    }

    /**
     * Converts this Data Transfer Object to the model it represents
     * @return The model this DTO represents
     */
    public LobbyPlayer toModel(String lobby) {
        return new LobbyPlayer(username, RoleCardFactory.getInstance().getCardByName(role), host, false, lobby);
    }

    /**
     * Constructs a Data Transfer Object from a model
     * @param player The model to construct the DTO of
     * @return The DTO of the model
     */
    public static LobbyPlayerDTO fromModel(LobbyPlayer player) {
        return new LobbyPlayerDTO(player.getUsername(), player.getRoleCard().getName(), player.isHost());
    }
}

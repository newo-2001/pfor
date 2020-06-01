package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;

/**
 * The Data Transfer Object that represents a Lobby in Firebase.
 *
 * @author Owen Elderbroek
 */
public class LobbyDTO extends DTO {
    /** The lobby code that is required to join a lobby */
    public String code;

    /** The list of players that are in the lobby */
    public LobbyPlayerDTO[] players;

    /** The password that is required to join the lobby */
    public String password;

    /**
     * Construct a Data Transfer Object with the specified fields
     * @param code The lobby code
     * @param password The password for the lobby
     * @param players The players in the lobby
     */
    private LobbyDTO(String code, String password, LobbyPlayerDTO[] players) {
        this.code = code;
        this.password = password;
        this.players = players;
    }

    /**
     * Converts this Data Transfer Object to its corresponding business model
     * @return The lobby object that this instance represents
     */
    public Lobby toModel() {
        LobbyPlayer[] players = new LobbyPlayer[this.players.length];
        for (int i = 0; i < this.players.length; i++) players[i] = this.players[i].toModel();
        return new Lobby(code, password, players);
    }

    /**
     * Constructs a Data Transfer Object from a model
     * @param lobby The model to construct the DTO of
     * @return The DTO of the model
     */
    public static LobbyDTO fromModel(Lobby lobby) {
        LobbyPlayer[] players = lobby.getPlayers().toArray(new LobbyPlayer[0]);
        LobbyPlayerDTO[] playerData = new LobbyPlayerDTO[players.length];
        for (int i = 0; i < players.length; i++) playerData[i] = LobbyPlayerDTO.fromModel(players[i]);
        return new LobbyDTO(lobby.getCode(), lobby.getPasswordHash(), playerData);
    }
}

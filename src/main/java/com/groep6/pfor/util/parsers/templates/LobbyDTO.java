package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Data Transfer Object that represents a Lobby in Firebase.
 *
 * @author Owen Elderbroek
 */
public class LobbyDTO {
    /** The lobby code that is required to join a lobby */
    public String code;

    /** The password that is required to join the lobby */
    public String password;

    /** The players in this lobby */
    public Map<String, LobbyPlayerDTO> players;

    public boolean started;

    public LobbyDTO() {}

    /**
     * Construct a Data Transfer Object with the specified fields
     * @param code The lobby code
     * @param password The password for the lobbies
     * @param players The players in the lobby
     */
    private LobbyDTO(String code, String password, Map<String, LobbyPlayerDTO> players) {
        this.code = code;
        this.password = password;
        this.players = players;
    }

    /**
     * Converts this Data Transfer Object to its corresponding business model
     * @return The lobby object that this instance represents
     */
    public Lobby toModel() {
        List<LobbyPlayer> players = new ArrayList<>();
        for (LobbyPlayerDTO player : this.players.values()) players.add(player.toModel(code));
        return new Lobby(code, password, players);
    }

    /**
     * Constructs a Data Transfer Object from a model
     * @param lobby The model to construct the DTO of
     * @return The DTO of the model
     */
    public static LobbyDTO fromModel(Lobby lobby) {
        Map<String, LobbyPlayerDTO> players = new HashMap<>();
        for (LobbyPlayer player : lobby.getPlayers()) players.put(player.getUsername(), LobbyPlayerDTO.fromModel(player));
        return new LobbyDTO(lobby.getCode(), lobby.getPasswordHash(), players);
    }
}

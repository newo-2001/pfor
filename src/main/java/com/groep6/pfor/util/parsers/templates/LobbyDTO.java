package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Data Transfer Object that represents a Lobby in Firebase.
 *
 * @author Owen Elderbroek
 */
public class LobbyDTO extends DTO {
    /** The lobby code that is required to join a lobby */
    public String code;

    /** The password that is required to join the lobby */
    public String password;

    /**
     * Construct a Data Transfer Object with the specified fields
     * @param code The lobby code
     * @param password The password for the lobbys
     */
    private LobbyDTO(String code, String password) {
        this.code = code;
        this.password = password;
    }

    /**
     * Converts this Data Transfer Object to its corresponding business model
     * @return The lobby object that this instance represents
     */
    public Lobby toModel(LobbyPlayer[] players) {
        return new Lobby(code, password, players);
    }

    /**
     * Constructs a Data Transfer Object from a model
     * @param lobby The model to construct the DTO of
     * @return The DTO of the model
     */
    public static LobbyDTO fromModel(Lobby lobby) {
        return new LobbyDTO(lobby.getCode(), lobby.getPasswordHash());
    }
}

package com.groep6.pfor.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.*;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.Observable;
import com.groep6.pfor.util.parsers.templates.LobbyDTO;
import com.groep6.pfor.util.parsers.templates.LobbyPlayerDTO;
import com.sun.xml.internal.bind.v2.model.core.TypeRef;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The LobbyService class acts as a gateway to Firebase for all lobby related actions
 *
 * @author Owen Elderbroek
 */
public class LobbyService extends Observable {
    /**
     * Obtain the list of players in a lobby
     * @param code The code of the lobby
     * @return The list of players in that lobby
     */
    public List<LobbyPlayer> getPlayers(String code) throws NoDocumentException {
        return Firebase.requestDocument("lobbies/" + code).toObject(LobbyDTO.class).toModel().getPlayers();
    }

    /**
     * Obtain a lobby using its lobby code
     * @param code The lobby code of the requested lobby
     * @return The lobby that has that code
     * @throws NoDocumentException If the query had no results
     */
    public Lobby get(String code) throws NoDocumentException {
        return Firebase.requestDocument("lobbies/" + code).toObject(LobbyDTO.class).toModel();
    }

    /**
     * Update a lobby's data on server to this new data
     * Warning! This will overwrite the entire lobby, Only use if you have good reason to!
     * @param lobby The new lobby data that will override the old data
     */
    public void set(Lobby lobby) {
        Firebase.setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
    }

    /**
     * Create a lobby on the server.
     * All the players in this lobby will automagically be joined
     * It will be assumed that all these players belong to this client (should really ever only be 1 player!)
     * @param lobby The lobby to be created
     */
    public void create(Lobby lobby) {
        for (LobbyPlayer player : lobby.getPlayers()) Firebase.registerListener("lobbies/" + player.getLobby(), onLobbyChange);
        Firebase.setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
    }

    /**
     * Sync a player's rolecard with firebase
     * @param player The player to change, note: the card to sync with is the card
     *               that the this instance has
     */
    public void updateRoleCard(LobbyPlayer player) {
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + player.getLobby());
        doc.update(FieldPath.of("players", player.getUsername(), "role"), player.getRoleCard().getName());
    }

    /**
     * Make a player join a lobby
     * @param player The player to join a lobby, note: The lobby to join is specified
     *               in the player instance.
     */
    public void join(LobbyPlayer player) {
        Firebase.registerListener("lobbies/" + player.getLobby(), onLobbyChange);
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + player.getLobby());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> kv = mapper.convertValue(LobbyPlayerDTO.fromModel(player), new TypeReference<Map<String, Object>>() {});
        doc.update("players." + player.getUsername(), kv);
    }

    /**
     * Remove a player from the firebase lobby,
     * The lobby to leave is specified in the player's lobby field
     * @param player The player that should leave
     */
    public void leave(LobbyPlayer player) {
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + player.getLobby());
        doc.update(FieldPath.of("players", player.getUsername()), null);
    }

    private EventListener<DocumentSnapshot> onLobbyChange = new EventListener<DocumentSnapshot>() {
        @Override
        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirestoreException e) {
            if (e != null) e.printStackTrace();
            else notifyObservers(documentSnapshot.toObject(LobbyDTO.class).toModel());
        }
    };
}

package com.groep6.pfor.services;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.Query;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.Observable;
import com.groep6.pfor.util.parsers.templates.LobbyDTO;
import com.groep6.pfor.util.parsers.templates.LobbyPlayerDTO;

import javax.annotation.Nullable;

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
    public LobbyPlayer[] getPlayers(String code) {
        DocumentSnapshot[] docs = Firebase.requestCollection("lobbies/" + code + "/players");
        LobbyPlayer[] players = new LobbyPlayer[docs.length];
        for (int i = 0; i < docs.length; i++) players[i] = docs[i].toObject(LobbyPlayerDTO.class).toModel(code);
        return players;
    }

    /**
     * Obtain a lobby using its lobby code
     * @param code The lobby code of the requested lobby
     * @return The lobby that has that code
     * @throws NoDocumentException If the query had no results
     */
    public Lobby get(String code) throws NoDocumentException {
        LobbyPlayer[] players = getPlayers(code);
        return Firebase.requestDocument("lobbies/" + code).toObject(LobbyDTO.class).toModel(players);
    }

    /**
     * Create the lobby on the server using an already existing lobby object
     * @param lobby The object to create on the server
     */
    public void create(Lobby lobby) {
        Firebase.setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
        join(lobby.getPlayers().get(0));
    }

    /**
     * Make a player join the lobby that is defined in its lobby field
     * @param player The player in question
     */
    public void join(LobbyPlayer player) {
        Firebase.addDocument("lobbies/" + player.getLobby() + "/players", LobbyPlayerDTO.fromModel(player));
        Firebase.registerListener("lobbies/" + player.getLobby(), onLobbyChange);
    }

    /**
     * Delete a lobby from the database
     * @param lobby The lobby to be deleted
     */
    public void remove(Lobby lobby) {
        Firebase.removeDocument("lobbies/" + lobby.getCode());
    }

    /**
     * Make a player leave the lobby he is in.
     * This lobby will be derived from the player's lobby field
     * @param player The player in question
     */
    public void leave(LobbyPlayer player) throws NoDocumentException {
        Firebase.queryOne(getPlayerQuery(player)).getReference().delete();
    }

    /**
     * Update a player's data on server to this new data
     * @param player The new player data that will override the old data
     */
    public void updatePlayer(LobbyPlayer player) throws NoDocumentException {
        Firebase.queryOne(getPlayerQuery(player)).getReference().set(LobbyPlayerDTO.fromModel(player));
    }

    /**
     * A helper method to construct a query for player related actions
     * @param player The player on whom the query is to be executed
     * @return A partial query that can be extended
     */
    private Query getPlayerQuery(LobbyPlayer player) {
        return Firebase.collRefFromPath("lobbies/" + player.getLobby() + "/players"); //.whereEqualTo("username", player.getUsername());
    }

    private EventListener<DocumentSnapshot> onLobbyChange = new EventListener<DocumentSnapshot>() {
        @Override
        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirestoreException e) {
            System.out.println("aangeropen");
            if (e != null) e.printStackTrace();
            else {
                System.out.println("aangeropen 2");
                LobbyDTO dto = documentSnapshot.toObject(LobbyDTO.class);
                notifyObservers(dto.toModel(getPlayers(dto.code)));
            }
        }
    };
}

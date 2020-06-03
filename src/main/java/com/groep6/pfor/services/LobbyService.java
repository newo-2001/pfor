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
import java.util.List;

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
        return get(code).getPlayers();
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
     * @param lobby The new lobby data that will override the old data
     */
    public void set(Lobby lobby) {
        Firebase.setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
    }

    public void registerListener(Lobby lobby) {
        Firebase.registerListener("lobbies/" + lobby.getCode(), onLobbyChange);
    }

    private EventListener<DocumentSnapshot> onLobbyChange = new EventListener<DocumentSnapshot>() {
        @Override
        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirestoreException e) {
            if (e != null) e.printStackTrace();
            else notifyObservers(documentSnapshot.toObject(LobbyDTO.class).toModel());
        }
    };
}

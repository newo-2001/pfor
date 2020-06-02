package com.groep6.pfor.services;

import com.google.cloud.firestore.Query;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.parsers.templates.LobbyDTO;
import com.groep6.pfor.util.parsers.templates.LobbyPlayerDTO;

public class LobbyService {
    public Lobby get(String code) throws NoDocumentException {
        return Firebase.requestDocument("lobbies/" + code).toObject(LobbyDTO.class).toModel();
    }

    public void create(Lobby lobby) {
        Firebase.setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
    }

    public void join(LobbyPlayer player) {
        Firebase.addDocument("lobbies/" + player.getLobby(), LobbyPlayerDTO.fromModel(player));
    }

    public void remove(Lobby lobby) {
        Firebase.removeDocument("lobbies/" + lobby.getCode());
    }

    public void leave(LobbyPlayer player) {
        Firebase.queryOne(getPlayerQuery(player)).getReference().delete();
    }

    public void updatePlayer(LobbyPlayer player) {
        Firebase.queryOne(getPlayerQuery(player)).getReference().set(LobbyPlayerDTO.fromModel(player));
    }

    private Query getPlayerQuery(LobbyPlayer player) {
        return Firebase.collRefFromPath("lobbies/" + player.getLobby() + "/players").whereEqualTo("username", player.getUsername());
    }
}

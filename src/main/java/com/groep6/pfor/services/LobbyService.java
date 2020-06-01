package com.groep6.pfor.services;

import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.parsers.templates.LobbyDTO;
import com.groep6.pfor.util.parsers.templates.LobbyPlayerDTO;

public class LobbyService extends Service {
    public Lobby get(String code) throws NoDocumentException {
        return requestDocument("lobbies/" + code).toObject(LobbyDTO.class).toModel();
    }

    public void create(Lobby lobby) {
        setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
    }

    public void join(String code, LobbyPlayer player) {
        addDocument("lobbies/" + code, LobbyPlayerDTO.fromModel(player));
    }

    @Override
    public void subscribe(String documentID) {

    }
}

package com.groep6.pfor.services;

import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.parsers.templates.PlayerDTO;

public class PlayerService {

    private static final String COLLECTION = "players";

    public Player get(String playerId) throws NoDocumentException {
        return Firebase.requestDocument("players/" + playerId).toObject(PlayerDTO.class).toModel();
    }

    public void create() {

    }
}

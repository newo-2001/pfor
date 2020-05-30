package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.util.IObserver;

public class LobbyController extends Controller {

    private Game game = Game.getInstance();

    public Lobby getLobby() {
        return game.getLobby();
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

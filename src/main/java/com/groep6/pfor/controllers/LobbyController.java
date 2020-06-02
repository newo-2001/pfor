package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.LobbyView;
import com.groep6.pfor.views.RoleCardInfoView;

import java.util.List;

public class LobbyController extends Controller {
    private Game game = Game.getInstance();
    private Lobby lobby;

    public LobbyController(Lobby lobby) {
        this.lobby = lobby;
        viewController.showView(new LobbyView(this));
    }

    public String getLobbyCode() {
        return lobby.getCode();
    }

    public List<LobbyPlayer> getLobbyPlayers() {
        return lobby.getPlayers();
    }

    public void goToRoleCardInfoView() {
        new RoleCardInfoController();
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

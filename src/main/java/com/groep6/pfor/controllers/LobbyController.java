package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.services.LobbyService;
import com.groep6.pfor.util.IEventCallback;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.LobbyView;
import com.groep6.pfor.views.RoleCardInfoView;

import java.util.List;

public class LobbyController extends Controller {

    public static final int MIN_PLAYERS = 3;

    private Game game = Game.getInstance();
    private Lobby lobby;

    public LobbyController(Lobby lobby) {
        this.lobby = lobby;
        LobbyService.lobbyChangeEvent.subscribe(onLobbyChange);
        viewController.showView(new LobbyView(this));
    }

    public String getLobbyCode() {
        return lobby.getCode();
    }

    public List<LobbyPlayer> getLobbyPlayers() {
        return lobby.getPlayers();
    }

    public void goToRoleCardInfoView() {
        new RoleCardInfoController(lobby);
    }

    public void goToMenu() {
        // Delete from lobby
        LobbyService lobbyService = new LobbyService();
        lobbyService.leave(lobby.getLocalPlayer());

        new MenuController();
    }

    public void startGame() {

    }

    @Override
    public void registerObserver(IObserver view) {
        lobby.registerObserver(view);
    }


    private IEventCallback onLobbyChange = new IEventCallback() {
        @Override
        public void onEvent(Object... eventData) {
            Lobby serverLobby = (Lobby) eventData[0];

            if (!serverLobby.equals(lobby)) return;

            lobby.updateLobby(serverLobby);
        }
    };
}

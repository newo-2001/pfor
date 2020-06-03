package com.groep6.pfor.controllers;

import com.groep6.pfor.models.*;
import com.groep6.pfor.services.LobbyService;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.LobbyView;
import com.groep6.pfor.views.RoleCardInfoView;

import java.util.Arrays;
import java.util.List;

public class LobbyController extends Controller implements IObserver {

    public static final int MIN_PLAYERS = 3;

    private Game game = Game.getInstance();
    private LobbyService lobbyService = new LobbyService();
    private Lobby lobby;

    public LobbyController(Lobby lobby) {
        this.lobby = lobby;
        lobbyService.registerListener(lobby);
        lobbyService.registerObserver(this);
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

        new MenuController();
    }

    public void startGame() {

        game.setLocalPlayer(new Player(lobby.getLocalPlayer()));
        game.addPlayers(lobby.getPlayers().toArray(new LobbyPlayer[0]));

        new BoardController();

    }

    @Override
    public void registerObserver(IObserver view) {
        lobby.registerObserver(view);
    }

    @Override
    public void update(Object... data) {

        if (data.length > 0) {
            Lobby serverLobby = (Lobby) data[0];

            LobbyPlayer localPlayer = lobby.getLocalPlayer();

            lobby.updateLobby(serverLobby);
            lobby.update();

            for (LobbyPlayer player: lobby.getPlayers()) {
                if (player.equals(localPlayer)) {
                    player.setLocal(true);
                    break;
                }
            }
        }
    }
}

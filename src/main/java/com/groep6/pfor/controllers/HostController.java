package com.groep6.pfor.controllers;

import com.groep6.pfor.exceptions.EmptyFieldException;
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.HostView;
import com.groep6.pfor.views.LobbyView;

public class HostController extends Controller {

    private Game game = Game.getInstance();

    public HostController() {
        viewController.showView(new HostView(this));
    }

    public void createLobby(String username, String password) throws EmptyFieldException {
        if (username.isEmpty()) throw new EmptyFieldException("Username cannot be empty");

        // Create new lobby
        Lobby lobby = new Lobby(password);

        try {
            lobby.join(username, password);

            // Send to lobby service

            // Send user to lobby
            new LobbyController(lobby);



        } catch (IncorrentPasswordException error) {
            System.out.println("Error: " + error.getMessage());
        }

    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

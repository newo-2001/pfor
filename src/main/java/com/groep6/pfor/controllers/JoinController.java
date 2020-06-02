package com.groep6.pfor.controllers;

/**
 * The controller for joining lobby's
 * @author Nils van der Velden
 */

import com.groep6.pfor.exceptions.EmptyFieldException;
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.services.LobbyService;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.JoinView;

public class JoinController extends Controller {
	
    private Game game = Game.getInstance();

    public JoinController() {
        viewController.showView(new JoinView(this));
    }
    
    public void joinLobby(String code, String username, String password) throws EmptyFieldException {
        if (username.isEmpty()) throw new EmptyFieldException("Username cannot be empty");
        else if(code.isEmpty()) throw new EmptyFieldException("Unique code cannot be empty");

        
        try {

            LobbyService lobbyService = new LobbyService();
            Lobby lobby = lobbyService.get(code);
            LobbyPlayer lobbyPlayer = lobby.join(code, username, password, true);
            lobbyService.join(lobbyPlayer);
            lobby.update(lobby);

            new LobbyController(lobby);
        	
        } catch (IncorrentPasswordException | NoDocumentException error) {
            System.out.println("Error: " + error.getMessage());
        } 
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

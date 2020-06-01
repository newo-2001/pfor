package com.groep6.pfor.controllers;

/**
 * The controller for joining lobby's
 * @author Nils van der Velden
 */

import com.groep6.pfor.exceptions.EmptyFieldException;
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Lobby;
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
        
        Lobby lobby = new Lobby(password);
        
        try {
        	lobby.join(code, username, password);
        	
        	new LobbyController(lobby);
        	
        } catch (IncorrentPasswordException error) {
            System.out.println("Error: " + error.getMessage());
        } 
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}

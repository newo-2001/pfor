package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LobbyController;
import com.groep6.pfor.util.IObserver;

/**
 * The view that show's the lobby with players, before the game is started
 * @author Mathijs
 */
public class LobbyView implements IObserver {
    /** The lobbyController */
    private LobbyController lobbyController;

    /**
     * The constructor
     * @param lobbyController the lobbyController
     */
    public LobbyView(LobbyController lobbyController) {
        this.lobbyController = lobbyController;
    }

    @Override
    public void update() {

    }
}

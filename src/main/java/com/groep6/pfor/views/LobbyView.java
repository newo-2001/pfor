package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LobbyController;
import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

/**
 * The view that show's the lobby with players, before the game is started
 * @author Mathijs
 */
public class LobbyView extends View implements IObserver {

    private LobbyController lobbyController;

    public LobbyView() {
        lobbyController = new LobbyController();

        BorderPane root = new BorderPane();

        scene = new Scene(root);
    }

    @Override
    public void update() {

    }
}

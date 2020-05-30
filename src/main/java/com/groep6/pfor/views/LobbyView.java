package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LobbyController;
import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * The view that show's the lobby with players, before the game is started
 * @author Mathijs
 */
public class LobbyView extends View implements IObserver {

    private LobbyController lobbyController;

    public LobbyView() {
        lobbyController = new LobbyController();

        BorderPane root = new BorderPane();

        Text codeText = new Text(lobbyController.getLobby().getCode());

        root.setCenter(codeText);

        scene = new Scene(root);
    }

    @Override
    public void update() {

    }
}

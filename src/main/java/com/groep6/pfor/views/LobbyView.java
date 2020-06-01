package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LobbyController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * The view that show's the lobby with players, before the game is started
 * @author Bastiaan Jansen
 */
public class LobbyView extends View implements IObserver {

    private LobbyController lobbyController;

    public LobbyView(LobbyController controller) {
        lobbyController = controller;

        BorderPane root = new BorderPane();


        Text codeText = new Text(lobbyController.getLobbyCode());

        root.setCenter(codeText);

        scene = new Scene(root);
    }

    @Override
    public void update() {

    }
}

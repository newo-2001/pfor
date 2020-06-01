package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LobbyController;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UILobbyPlayerInfo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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


//        Text codeText = new Text(lobbyController.getLobbyCode());


//        root.setCenter(codeText);

        FlowPane playerContainer = new FlowPane();
        playerContainer.setHgap(50);
        playerContainer.setVgap(50);
        playerContainer.setAlignment(Pos.CENTER);

        for (LobbyPlayer player: lobbyController.getLobbyPlayers()) {
            UILobbyPlayerInfo uiLobbyPlayerInfo = new UILobbyPlayerInfo(1, player.getUsername(), player.getRoleCard());
            playerContainer.getChildren().add(uiLobbyPlayerInfo);
        }

        HBox bottomButtomBox = new HBox(20);
        bottomButtomBox.setAlignment(Pos.CENTER);
        BorderPane.setMargin(bottomButtomBox, new Insets(12,12,100,12));

        Button startGameButton = new UIButton("Start Spel");

        Button goBackButton = new UIButton("Terug");
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));


        bottomButtomBox.getChildren().addAll(startGameButton, goBackButton);
        root.setCenter(playerContainer);
        root.setBottom(bottomButtomBox);

        scene = new Scene(root);
    }

    @Override
    public void update() {

    }
}

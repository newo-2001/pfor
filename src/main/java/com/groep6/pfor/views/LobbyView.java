package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LobbyController;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UILobbyPlayerInfo;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The view that show's the lobby with players, before the game is started
 * @author Bastiaan Jansen
 */
public class LobbyView extends View implements IObserver {

    private LobbyController lobbyController;

    private BorderPane root;

    public LobbyView(LobbyController controller) {
        lobbyController = controller;

        root = new BorderPane();

        Text codeText = new Text("Lobby code: " + lobbyController.getLobbyCode());
        codeText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        codeText.setX(10);
        codeText.setY(30);

        HBox topBox = new HBox();
        BorderPane.setMargin(topBox, new Insets(100,12,12,12));
        topBox.setAlignment(Pos.CENTER);

        Button showCharacterInfoButton = new UIButton("Karakter informatie");
        showCharacterInfoButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHostView);

        topBox.getChildren().add(showCharacterInfoButton);

        HBox bottomButtomBox = new HBox(20);
        bottomButtomBox.setAlignment(Pos.CENTER);
        BorderPane.setMargin(bottomButtomBox, new Insets(12,12,100,12));

        Button startGameButton = new UIButton("Start Spel");

        Button goBackButton = new UIButton("Terug");
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));

        createPlayers();


        bottomButtomBox.getChildren().addAll(startGameButton, goBackButton);
        root.setTop(topBox);
        root.setBottom(bottomButtomBox);
        root.getChildren().add(codeText);

        scene = new Scene(root);
    }

    public void createPlayers() {
        FlowPane playerContainer = new FlowPane();
        playerContainer.setHgap(50);
        playerContainer.setVgap(50);
        playerContainer.setAlignment(Pos.CENTER);

        for (LobbyPlayer player: lobbyController.getLobbyPlayers()) {
            UILobbyPlayerInfo uiLobbyPlayerInfo = new UILobbyPlayerInfo(1, player.getUsername(), player.getRoleCard());
            playerContainer.getChildren().add(uiLobbyPlayerInfo);
        }

        root.setCenter(playerContainer);
    }

    EventHandler<MouseEvent> goToHostView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            lobbyController.goToRoleCardInfoView();
        }
    };

    @Override
    public void update() {
        createPlayers();
    }
}

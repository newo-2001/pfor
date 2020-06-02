package com.groep6.pfor.views;

import com.groep6.pfor.Config;
import com.groep6.pfor.controllers.LobbyController;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UILobbyPlayerInfo;
import com.groep6.pfor.views.components.UIText;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.List;

import java.util.ArrayList;

/**
 * The view that show's the lobby with players, before the game is started
 * @author Bastiaan Jansen
 */
public class LobbyView extends View implements IObserver {

    private LobbyController lobbyController;

    private BorderPane root;
    private Button startGameButton;
    private List<LobbyPlayer> players;

    public LobbyView(LobbyController controller) {
        lobbyController = controller;
        lobbyController.registerObserver(this);

        createView();

        update();
    }

    private void createView() {
        root = new BorderPane();

        UIText codeText = new UIText("Lobby code: " + lobbyController.getLobbyCode());
        codeText.setColor(Color.WHITE).setWeight(FontWeight.BOLD).setSize(20);
        codeText.setX(30);
        codeText.setY(50);

        HBox topBox = new HBox();
        BorderPane.setMargin(topBox, new Insets(100,12,12,12));
        topBox.setAlignment(Pos.CENTER);

        Button showCharacterInfoButton = new UIButton("Kiezen karakter");
        showCharacterInfoButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHostView);

        topBox.getChildren().add(showCharacterInfoButton);

        HBox bottomButtomBox = new HBox(20);
        bottomButtomBox.setAlignment(Pos.CENTER);
        BorderPane.setMargin(bottomButtomBox, new Insets(12,12,100,12));

        startGameButton = new UIButton("Start Spel");
        startGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, startGame);

        Button goBackButton = new UIButton("Terug");
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToMenu);


        bottomButtomBox.getChildren().addAll(startGameButton, goBackButton);
        root.setTop(topBox);
        root.setBottom(bottomButtomBox);
        root.getChildren().add(codeText);
    }

    private void createPlayers() {
        FlowPane playerContainer = new FlowPane();
        playerContainer.setHgap(50);
        playerContainer.setVgap(50);
        playerContainer.setAlignment(Pos.CENTER);

        players = lobbyController.getLobbyPlayers();

        for (int i = 0; i < players.size(); i++) {
            LobbyPlayer player = players.get(i);
            UILobbyPlayerInfo uiLobbyPlayerInfo = new UILobbyPlayerInfo(++i, player.getUsername(), player.getRoleCard());
            playerContainer.getChildren().add(uiLobbyPlayerInfo);
        }

        BackgroundImage backgroundImage = new BackgroundImage(new Image("images/lobby_background.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        root.setBackground(new Background(backgroundImage));
        root.setCenter(playerContainer);
    }

    EventHandler<MouseEvent> goToHostView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            lobbyController.goToRoleCardInfoView();
        }
    };
    
    EventHandler<javafx.scene.input.MouseEvent> goToMenu = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            lobbyController.goToMenu();
        }
    };

    EventHandler<javafx.scene.input.MouseEvent> startGame = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {

            lobbyController.startGame();

        }
    };

    @Override
    public void update(Object... data) {
        createPlayers();

        if (players.size() >= LobbyController.MIN_PLAYERS) startGameButton.setDisable(false);
        else startGameButton.setDisable(true);
    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

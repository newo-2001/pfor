package com.groep6.pfor.views;

import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.views.components.UIButton;
import javafx.application.Platform;
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
 * The view that show's the menu where you can control the game settings
 * @author Mathijs
 */
public class MenuView extends View {

    private MenuController menuController = new MenuController();

    public MenuView() {

        createView();
    }

    public void createView() {
        BorderPane root = new BorderPane();

        Text text = new Text("Menu");

        text.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 150));
        text.setFill(Color.BLACK);
        root.setCenter(text);

        HBox buttonBox = new HBox(30);
        buttonBox.setAlignment(Pos.CENTER);

        Button hostGameButton = new UIButton("Host Game");
        hostGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHostView);
        Button joinGameButton = new UIButton("Join Game");
        joinGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToJoinView);
        Button exitGameButton = new UIButton("Exit Game");
        exitGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, exitGame);

        buttonBox.getChildren().addAll(hostGameButton, joinGameButton, exitGameButton);

        BorderPane.setMargin(buttonBox, new Insets(12,12,100,12)); // optional
        root.setBottom(buttonBox);

        scene = new Scene(root);
    }

    EventHandler<MouseEvent> goToHostView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            menuController.goToHostView();
        }
    };

    EventHandler<MouseEvent> goToJoinView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            menuController.goToJoinView();
        }
    };

    EventHandler<MouseEvent> exitGame = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            Platform.exit();
            System.exit(0);
        }
    };
}

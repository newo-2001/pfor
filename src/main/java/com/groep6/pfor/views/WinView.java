package com.groep6.pfor.views;

import com.groep6.pfor.controllers.WinController;
import com.groep6.pfor.views.components.UIButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;

/**
 * The view that shows that you won the game :D
 * @author Mathijs
 */
public class WinView extends View {
    /** The winController */
    private WinController winController = new WinController();
    /** The scene */
    private Scene scene;

    /**
     * The constructor
     */
    public WinView() {
        createView();
    }


    /**
     * Create and fill the view with text and a background image
     */
    public void createView() {
        BorderPane root = new BorderPane();

        Text winText = new Text("GEWONNEN");
        winText.setFont(Font.font("Verdana", 60));
        winText.setStyle("-fx-fill: red; -fx-stroke: #ffce00; -fx-stroke-width: 1px; -fx-font-weight: bold");
        root.setCenter(winText);

        // TODO inladen achtergrond

        Button backToMenuButton = new UIButton("Hoofd Menu");
        backToMenuButton.setBackground(new Background(new BackgroundFill(Color.web("#7A787E"), CornerRadii.EMPTY, Insets.EMPTY)));
        backToMenuButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToMenuView);

        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(backToMenuButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setPadding(new Insets(20));
        root.setBottom(buttonBox);

        scene = new Scene(root);
    }

    EventHandler<MouseEvent> goToMenuView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            winController.goToMenuView();
        }
    };

    @Override
    public Scene getScene() {
        return scene;
    }
}

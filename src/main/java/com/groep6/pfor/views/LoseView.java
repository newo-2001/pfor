package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LoseController;
import com.groep6.pfor.views.components.UIBorderedText;
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

/**
 * The view that shows that you lost the game :(
 * @author Mathijs
 */
public class LoseView extends View {
    /** The loseController */
    private LoseController loseController;
    /** The scene */
    private Scene scene;

    /**
     * The constructor
     * @param loseController The loseController
     */
    public LoseView(LoseController loseController) {
        this.loseController = loseController;
        createView();
    }

    private void createView() {
        BorderPane root = new BorderPane();

        Text loseText = new UIBorderedText("VERLOREN", "#ffce00", 1, "red");
        loseText.setFont(Font.font("Verdana", 60));
        root.setCenter(loseText);

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
            loseController.goToMenuView();
        }
    };

    @Override
    public Scene getScene() {
        return scene;
    }
}

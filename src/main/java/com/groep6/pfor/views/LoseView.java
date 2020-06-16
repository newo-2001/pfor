package com.groep6.pfor.views;

import com.groep6.pfor.controllers.LoseController;
import com.groep6.pfor.views.components.UIBorderedText;
import com.groep6.pfor.views.components.UIButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private final LoseController loseController;

    private BorderPane root;

    /**
     * The constructor
     * @param loseController The loseController
     */
    public LoseView(LoseController loseController) {
        this.loseController = loseController;
        createView();
    }

    private void createView() {
        root = new BorderPane();

        Text loseText = new UIBorderedText("VERLOREN", "#ffce00", 1, "red");
        loseText.setFont(Font.font("Verdana", 60));
        root.setCenter(loseText);

        Button backToMenuButton = new UIButton("Sluit game");
        backToMenuButton.setBackground(new Background(new BackgroundFill(Color.web("#7A787E"), CornerRadii.EMPTY, Insets.EMPTY)));
        backToMenuButton.addEventFilter(MouseEvent.MOUSE_CLICKED, exitGame);

        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(backToMenuButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setPadding(new Insets(20));
        root.setBottom(buttonBox);
        setBackground(root, "/images/background-6.jpg");
    }

    EventHandler<MouseEvent> exitGame = new EventHandler<MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            loseController.exitGame();
        }
    };

    @Override
    public Pane getRoot() {
        return root;
    }
}

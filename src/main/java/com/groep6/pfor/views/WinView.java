package com.groep6.pfor.views;

import com.groep6.pfor.controllers.WinController;
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
 * The view that shows that you won the game :D
 * @author Mathijs
 */
public class WinView extends View {
    /** The winController */
    private final WinController winController;

    private BorderPane root;

    /**
     * The constructor
     */
    public WinView(WinController winController) {
        this.winController = winController;
        createView();
    }

    /**
     * Create and fill the view with text and a background image
     */
    private void createView() {
        root = new BorderPane();

        Text winText = new UIBorderedText("GEWONNEN", "#ffce00", 1, "red");
        winText.setFont(Font.font("Verdana", 60));
        root.setCenter(winText);

        Button backToMenuButton = new UIButton("Sluit game");
        backToMenuButton.setBackground(new Background(new BackgroundFill(Color.web("#7A787E"), CornerRadii.EMPTY, Insets.EMPTY)));
        backToMenuButton.addEventFilter(MouseEvent.MOUSE_CLICKED, exitGame);

        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(backToMenuButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setPadding(new Insets(20));
        root.setBottom(buttonBox);
        setBackground(root, "/images/win_background.jpg");
    }

    EventHandler<MouseEvent> exitGame = new EventHandler<MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            winController.exitGame();
        }
    };

    @Override
    public Pane getRoot() {
        return root;
    }
}

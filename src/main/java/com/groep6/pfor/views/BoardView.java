package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The view that shows the board
 * @author Bastiaan Jansen
 */
public class BoardView extends View implements IObserver {
    private BoardController boardController = new BoardController();

    private Text decayText;

    public BoardView() {
        boardController.registerObserver(this);

        createView();
        update();
    }

    public void createView() {
        BorderPane root = new BorderPane();

        decayText = new Text();

        decayText.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 30));
        decayText.setFill(Color.BLACK);
        root.setCenter(decayText);

        Button backButton = new UIButton("Go back");
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, menuButtonClicked);
        root.setTop(backButton);

        Button button = new UIButton("Click me to increase decay level");
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, increaseDecayButtonClicked);
        root.setBottom(button);

        scene = new Scene(root);
    }

    EventHandler<MouseEvent> menuButtonClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            boardController.goBack();
        }
    };
    EventHandler<MouseEvent> increaseDecayButtonClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            boardController.increaseDecayLevel();
        }
    };

    public void setDecayText() {
        decayText.setText("Decay: " + boardController.getDecayLevel());
    }

    @Override
    public void update() {
        setDecayText();
    }
}

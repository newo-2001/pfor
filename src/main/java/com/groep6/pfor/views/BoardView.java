package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.controllers.Controller;
import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.util.IObserver;
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
    private BoardController boardController;
    private Scene scene;

    public BoardView(Stage primaryStage) {
        super(primaryStage);
        this.boardController = BoardController.getInstance();

        createView();
    }

    public void createView() {
        BorderPane root = new BorderPane();

        Text text = new Text("Board");

        text.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 150));
        text.setFill(Color.BLACK);
        root.setCenter(text);

        Button button = new Button("Click me!");
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, buttonClicked);
        root.setBottom(button);

        scene = new Scene(root);
    }

    EventHandler<MouseEvent> buttonClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            boardController.goToMenu();
        }
    };

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void update() {

    }
}

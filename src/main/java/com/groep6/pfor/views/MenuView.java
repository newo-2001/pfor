package com.groep6.pfor.views;

import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.views.components.DefaultButton;
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
 * The view that show's the menu where you can control the game settings
 * @author Mathijs
 */
public class MenuView extends View {

    private MenuController menuController;
    private Scene scene;

    public MenuView(Stage stage) {
        super(stage);
        this.menuController = MenuController.getInstance();

        createView();
    }

    public void createView() {
        BorderPane root = new BorderPane();

        Text text = new Text("Menu");

        text.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 150));
        text.setFill(Color.BLACK);
        root.setCenter(text);

        Button button = new DefaultButton("Click me!");
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, buttonClicked);
        root.setTop(button);

        scene = new Scene(root);
    }

    EventHandler<MouseEvent> buttonClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            menuController.buttonClicked();
        }
    };

    @Override
    public Scene getScene() {
        return scene;
    }
}

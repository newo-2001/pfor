package com.groep6.pfor.views;

import com.groep6.pfor.controllers.MoveController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UIText;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

/**
 * The view where you can choose the amout of barbarians you want to recruit
 *
 * @author Nils van der Velden
 */

public class MoveView extends View implements IObserver {
    /** The recruitLegionController */
    private final MoveController moveController;

    private StackPane root;

    public MoveView(MoveController moveController) {
        this.moveController = moveController;

        createView();
        update();
    }



    public void createView() {
        root = new StackPane();

        VBox box = new VBox();
        box.setMaxSize(500, 300);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(40);
        box.setPadding(new Insets(50));
        box.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));

        UIText text = new UIText("Hoeveel legioenen wil je meenemen?");
        text.setSize(20).setWeight(FontWeight.BOLD).setColor(Color.WHITE);

        Button backButton = new UIButton("Go back");
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, menuButtonClicked);
        backButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));

        HBox buttonBox = new HBox(30);
        buttonBox.setAlignment(Pos.CENTER);

        Button moveZero = new UIButton("0");
        moveZero.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitZeroClicked);

        Button moveOne = new UIButton("1");
        moveOne.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitOneClicked);
        if (moveController.getAmountOfLegionsInCurrentCity() < 1) moveOne.setDisable(true);

        Button moveTwo = new UIButton("2");
        moveTwo.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitTwoClicked);
        if (moveController.getAmountOfLegionsInCurrentCity() < 2) moveTwo.setDisable(true);

        Button moveThree = new UIButton("3");
        moveThree.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitThreeClicked);
        if (moveController.getAmountOfLegionsInCurrentCity() < 3) moveThree.setDisable(true);

        buttonBox.getChildren().addAll(moveZero, moveOne, moveTwo, moveThree);

        box.getChildren().addAll(text, buttonBox, backButton);

        root.getChildren().add(box);

        setBackground(root, "/images/background-2.jpg");
    }

    EventHandler<MouseEvent> menuButtonClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            moveController.goBack();
        }
    };

    EventHandler<MouseEvent> recruitZeroClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            moveController.moveLegions(0);
        }
    };

    EventHandler<MouseEvent> recruitOneClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            moveController.moveLegions(1);
        }
    };

    EventHandler<MouseEvent> recruitTwoClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            moveController.moveLegions(2);
        }
    };

    EventHandler<MouseEvent> recruitThreeClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            moveController.moveLegions(3);
        }
    };

    @Override
    public void update() {}

    @Override
    public Pane getRoot() {
        return root;
    }
}

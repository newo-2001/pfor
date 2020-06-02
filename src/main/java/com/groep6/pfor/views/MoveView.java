package com.groep6.pfor.views;

import com.groep6.pfor.controllers.MoveController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The move view
 * @author Nils van der Velden
 */
public class MoveView extends View implements IObserver {
    private MoveController moveController;

    private BorderPane root;
    
    /**
     * The constructor
     * @param moveController The moveController
     */
    
    public MoveView(MoveController moveController) {
        this.moveController = moveController;
    	moveController.registerObserver(this);
    	
        createView();
        update();
    }
    
    public void createView() {
    	
        root = new BorderPane();
    	
    	Text text = new Text("Hoeveel legioenen wil je meenemen?");
    	
    	text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
    	text.setFill(Color.BLACK);
    	root.setCenter(text);
    	
        Button backButton = new UIButton("Go back");
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, menuButtonClicked);
        root.setTop(backButton);
        
        HBox buttonBox = new HBox(30);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button takeZero = new UIButton("0");
        takeZero.addEventFilter(MouseEvent.MOUSE_CLICKED, takeZeroClicked);
        
        Button takeOne = new UIButton("1");
        takeOne.addEventFilter(MouseEvent.MOUSE_CLICKED, takeOneClicked);
        
        Button TakeTwo = new UIButton("2");
        TakeTwo.addEventFilter(MouseEvent.MOUSE_CLICKED, takeTwoClicked);
        
        Button TakeThree = new UIButton("3");
        TakeThree.addEventFilter(MouseEvent.MOUSE_CLICKED, takeThreeClicked);
        
        buttonBox.getChildren().addAll(takeZero, takeOne, TakeTwo, TakeThree);
        
        BorderPane.setMargin(buttonBox, new Insets(12,12,100,12)); // optional
        root.setBottom(buttonBox);
}
    
    EventHandler<MouseEvent> menuButtonClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            moveController.goBack();
        }
    };
    
    EventHandler<MouseEvent> takeZeroClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	moveController.takeZero();
        }
    };
    
    EventHandler<MouseEvent> takeOneClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	moveController.takeOne();
        }
    };
    
    EventHandler<MouseEvent> takeTwoClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	moveController.takeTwo();
        }
    };
    
    EventHandler<MouseEvent> takeThreeClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	moveController.takeThree();
        }
    };



    @Override
    public void update(Object... data) {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

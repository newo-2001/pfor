package com.groep6.pfor.views;

import com.groep6.pfor.controllers.RecruitmentController;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The view where you can choose to recruit legions or barbarians
 * @author Nils van der Velden
 */
public class RecruitmentView extends View implements IObserver {
    /** The recruitmentController */
    private RecruitmentController recruitmentController = new RecruitmentController();

    /**
     * The constructor
     * @param stage
     */
    
    public RecruitmentView() {    	
    	recruitmentController.registerObserver(this);
    	
        createView();
        update();
    }
    
    public void createView() {
    	BorderPane root = new BorderPane();
    	
    	Text text = new Text("Hoeveel legioenen wil je rekruteren?");
    	
    	text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
    	text.setFill(Color.BLACK);
    	root.setCenter(text);
    	
        Button backButton = new UIButton("Go back");
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, menuButtonClicked);
        root.setTop(backButton);
        
        HBox buttonBox = new HBox(30);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button recruitOne = new UIButton("1");
        recruitOne.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitOneClicked);
        
        Button recruitTwo = new UIButton("2");
        recruitTwo.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitTwoClicked);
        
        Button recruitThree = new UIButton("3");
        recruitThree.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitThreeClicked);
        
        buttonBox.getChildren().addAll(recruitOne, recruitTwo, recruitThree);
        
        BorderPane.setMargin(buttonBox, new Insets(12,12,100,12)); // optional
        root.setBottom(buttonBox);
        
        scene = new Scene(root);
        
    }	
        EventHandler<MouseEvent> menuButtonClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                recruitmentController.goBack();
            }
        };
        
        EventHandler<MouseEvent> recruitOneClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	recruitmentController.oneClicked();
            }
        };
        
        EventHandler<MouseEvent> recruitTwoClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	recruitmentController.twoClicked();
            }
        };
        
        EventHandler<MouseEvent> recruitThreeClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	recruitmentController.threeClicked();
            }
        };

    @Override
    public void update() {

    }

	@Override
	public Scene getScene() {
		return scene;
	}
}

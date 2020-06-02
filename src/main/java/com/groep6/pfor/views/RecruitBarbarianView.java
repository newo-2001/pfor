package com.groep6.pfor.views;

import com.groep6.pfor.controllers.RecruitBarbarianController;

/**
 * The view where you can choose the amout of barbarians you want to recruit
 * @author Nils van der Velden
 */

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RecruitBarbarianView extends View implements IObserver {
    /** The recruitLegionController */
    private RecruitBarbarianController recruitBarbarianController;

    private BorderPane root;
    
    public RecruitBarbarianView(RecruitBarbarianController recruitBarbarianController) {
        this.recruitBarbarianController = recruitBarbarianController;
	    recruitBarbarianController.registerObserver(this);
	    
	    createView();
	    update();
    }
    
    
    
    public void createView() {
        root = new BorderPane();
    	
    	Text text = new Text("Hoeveel barbaren wil je rekruteren?");
    	
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
    }
    
    EventHandler<MouseEvent> menuButtonClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            recruitBarbarianController.goBack();
        }
    };
    
    EventHandler<MouseEvent> recruitOneClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	recruitBarbarianController.oneClicked();
        }
    };
    
    EventHandler<MouseEvent> recruitTwoClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	recruitBarbarianController.twoClicked();
        }
    };
    
    EventHandler<MouseEvent> recruitThreeClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	recruitBarbarianController.threeClicked();
        }
    };

	@Override
	public void update(Object... data) {
		// TODO Auto-generated method stub
		
	}


    @Override
    public Pane getRoot() {
        return root;
    }
}

package com.groep6.pfor.views;

/**
 * The view where you can choose the amout of legions you want to recruit
 * @author Nils van der Velden
 */

import com.groep6.pfor.controllers.RecruitLegionController;
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

public class RecruitLegionView extends View implements IObserver {
    /** The recruitLegionController */
    private final RecruitLegionController recruitLegionController;

    private StackPane root;
    
    public RecruitLegionView(RecruitLegionController recruitLegionController) {
        this.recruitLegionController = recruitLegionController;
    	recruitLegionController.registerObserver(this);
    	
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
    	
    	UIText text = new UIText("Hoeveel legioenen wil je rekruteren?");
    	text.setSize(20).setWeight(FontWeight.BOLD).setColor(Color.WHITE);
    	
    	
        Button backButton = new UIButton("Go back");
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, menuButtonClicked);
        backButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        HBox buttonBox = new HBox(30);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button recruitOne = new UIButton("1");
        recruitOne.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitOneClicked);
        
        Button recruitTwo = new UIButton("2");
        recruitTwo.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitTwoClicked);
        
        Button recruitThree = new UIButton("3");
        recruitThree.addEventFilter(MouseEvent.MOUSE_CLICKED, recruitThreeClicked);
        
        buttonBox.getChildren().addAll(recruitOne, recruitTwo, recruitThree);
        
        box.getChildren().addAll(text, buttonBox, backButton);
        
        root.getChildren().add(box);

        setBackground(root, "/images/background-2.jpg");
        
    }	
        EventHandler<MouseEvent> menuButtonClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                recruitLegionController.goBack();
            }
        };
        
        EventHandler<MouseEvent> recruitOneClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	recruitLegionController.recruit(1);
            }
        };
        
        EventHandler<MouseEvent> recruitTwoClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	recruitLegionController.recruit(2);
            }
        };
        
        EventHandler<MouseEvent> recruitThreeClicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	recruitLegionController.recruit(3);
            }
        };

    @Override
    public void update() {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

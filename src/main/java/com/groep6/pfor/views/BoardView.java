package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.util.IObserver;

import com.groep6.pfor.views.components.UIButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * The view that shows the board
 * @author Bastiaan Jansen
 * @author Mitchell van Rijswijk
 * 
 */
public class BoardView extends View implements IObserver {
    
	private BoardController boardController;

    public BoardView(BoardController controller) {
        boardController = controller;
        boardController.registerObserver(this);

        createView();
        update();
    }

    /**
     * Creates JavaFX Scene for the board. This is in the state where the game has
     * started. Buttons navigate to different actions a player can perform.
     * 
     */
    public void createView() {
        BorderPane root = new BorderPane();

        // Top - players
        
        // Center - board
        
        // Right - action buttons
        GridPane actionButtonLayout = createActionButtons();
        root.setRight(actionButtonLayout);
        
        scene = new Scene(root);
    }

    EventHandler<MouseEvent> goToTradeView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToBattleView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToAllianceView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToRecruitmentView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToFortBuildView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToHandView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            boardController.goToHand();
        }
    };
    
    EventHandler<MouseEvent> goToInstructionView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> nextTurn = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    public GridPane createActionButtons() {
    	GridPane actionButtonLayout = new GridPane();
        
        Button conspireButton = new UIButton("SAMENSPANNEN");
        conspireButton.setPrefSize(150, 60);
        conspireButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToTradeView);  
        actionButtonLayout.add(conspireButton, 0, 0);
        
        Button battleButton = new UIButton("VECHTEN");
        battleButton.setPrefSize(150, 60);
        battleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToBattleView);  
        actionButtonLayout.add(battleButton, 1, 0);
        
        Button allianceButton = new UIButton("ALLIANTIE SLUITEN");
        allianceButton.setPrefSize(150, 60);
        allianceButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToAllianceView); 
        actionButtonLayout.add(allianceButton, 0, 1);
        
        Button recruitBarbarianButton = new UIButton("BARBAREN INHUREN");
        recruitBarbarianButton.setPrefSize(150, 60);
        conspireButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitmentView);
        actionButtonLayout.add(recruitBarbarianButton, 1, 1);
        
        Button buildButton = new UIButton("FORT BOUWEN");
        buildButton.setPrefSize(150, 60);
        battleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToFortBuildView);
        actionButtonLayout.add(buildButton, 0, 2);
        
        Button recruitButton = new UIButton("LEGIOEN REKRUTEREN");
        recruitButton.setPrefSize(150, 60);
        recruitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitmentView);
        actionButtonLayout.add(recruitButton, 1, 2);
        
        Button showHandButton = new UIButton("BEKIJK HAND");
        showHandButton.setPrefSize(150, 60);
        showHandButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHandView);
        actionButtonLayout.add(showHandButton, 0, 7);
        
        Button helpButton = new UIButton("HELP");
        helpButton.setPrefSize(150, 60);
        helpButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToInstructionView);
        actionButtonLayout.add(helpButton, 1, 7);
        
        Button nextTurnButton = new UIButton("VOLGENDE BEURT");
        nextTurnButton.setPrefHeight(60);
        nextTurnButton.addEventFilter(MouseEvent.MOUSE_CLICKED, nextTurn);
        nextTurnButton.setPrefWidth(312);
        actionButtonLayout.add(nextTurnButton, 0, 8, 2, 1);

        actionButtonLayout.setHgap(12);
        actionButtonLayout.setVgap(12);
        actionButtonLayout.setAlignment(Pos.CENTER);
        actionButtonLayout.setPadding(new Insets(50, 50, 50, 50));
        actionButtonLayout.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        return actionButtonLayout;
    }

    @Override
    public void update() {
    	
    }
}

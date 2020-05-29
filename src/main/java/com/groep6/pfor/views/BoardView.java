package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.ActionButton;

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
import javafx.scene.text.Text;

/**
 * The view that shows the board
 * @author Bastiaan Jansen
 * @author Mitchell van Rijswijk
 * 
 */
public class BoardView extends View implements IObserver {
    
	private BoardController boardController = new BoardController();

    public BoardView() {
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
    
    /**
     * Creates a GridPane with the ActionButtons of the game.
     * @return GridPane layout of ActionButtons.
     * 
     */
    public GridPane createActionButtons() {
    	GridPane actionButtonLayout = new GridPane();
    	
    	Text actionCount = new Text("<X> Actions left");
    	actionButtonLayout.add(actionCount, 0, 0, 2, 1);
        
        Button conspireButton = new ActionButton("SAMENSPANNEN");
        conspireButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToTradeView);  
        actionButtonLayout.add(conspireButton, 0, 1);
        
        Button battleButton = new ActionButton("VECHTEN");
        battleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToBattleView);  
        actionButtonLayout.add(battleButton, 1, 1);
        
        Button allianceButton = new ActionButton("ALLIANTIE SLUITEN");
        allianceButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToAllianceView); 
        actionButtonLayout.add(allianceButton, 0, 2);
        
        Button recruitBarbarianButton = new ActionButton("BARBAREN INHUREN");
        conspireButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitmentView);
        actionButtonLayout.add(recruitBarbarianButton, 1, 2);
        
        Button buildButton = new ActionButton("FORT BOUWEN");
        battleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToFortBuildView);
        actionButtonLayout.add(buildButton, 0, 3);
        
        Button recruitButton = new ActionButton("LEGIOEN REKRUTEREN");
        recruitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitmentView);
        actionButtonLayout.add(recruitButton, 1, 3);
        
        Button showHandButton = new ActionButton("BEKIJK HAND");
        showHandButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHandView);
        actionButtonLayout.add(showHandButton, 0, 8);
        
        Button helpButton = new ActionButton("HELP");
        helpButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToInstructionView);
        actionButtonLayout.add(helpButton, 1, 8);
        
        Button nextTurnButton = new ActionButton("VOLGENDE BEURT");
        nextTurnButton.addEventFilter(MouseEvent.MOUSE_CLICKED, nextTurn);
        nextTurnButton.setPrefWidth(312);
        nextTurnButton.setBackground(new Background(new BackgroundFill(Color.web("#57b932"), CornerRadii.EMPTY, Insets.EMPTY)));
        actionButtonLayout.add(nextTurnButton, 0, 9, 2, 1);

        actionButtonLayout.setHgap(12);
        actionButtonLayout.setVgap(12);
        actionButtonLayout.setAlignment(Pos.CENTER);
        actionButtonLayout.setPadding(new Insets(20, 20, 20, 20));
        actionButtonLayout.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        return actionButtonLayout;
    }

    @Override
    public void update() {
    	
    }
}

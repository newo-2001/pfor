package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BattleController;
import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.controllers.HandController;
import com.groep6.pfor.controllers.RecruitBarbarianController;
import com.groep6.pfor.controllers.RecruitLegionController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.ActionButton;
import com.groep6.pfor.views.components.UIPlayerInfo;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The view that shows the board
 * @author Bastiaan Jansen
 * @author Mitchell van Rijswijk
 * 
 */
public class BoardView extends View implements IObserver {
    
	private BoardController boardController;
	private BorderPane root;

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
        root = new BorderPane();

        // Top - players
        HBox playerList = createPlayerList();
        root.setTop(playerList);
        
        // Center - board
        BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage board = new BackgroundImage(new Image("images/board.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                boardSize);
        Pane boardPane = new Pane();
        boardPane.setBackground(new Background(board));
        root.setCenter(boardPane);
        
        // Right - action buttons
        GridPane actionButtonLayout = createActionButtons();
        root.setRight(actionButtonLayout);
    }

    EventHandler<MouseEvent> goToTradeView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToBattleView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            new BattleController();
        }
    };
    
    EventHandler<MouseEvent> goToAllianceView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToRecruitBarbarianView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            new RecruitBarbarianController();
        }
    };
    
    EventHandler<MouseEvent> goToFortBuildView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            
        }
    };
    
    EventHandler<MouseEvent> goToRecruitLegionView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	new RecruitLegionController();
        }
    };
    
    EventHandler<MouseEvent> goToHandView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            new HandController();
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
    private GridPane createActionButtons() {
    	GridPane actionButtonLayout = new GridPane();
    	
    	actionButtonLayout.setHgap(12);
        actionButtonLayout.setVgap(12);
        actionButtonLayout.setAlignment(Pos.CENTER);
        actionButtonLayout.setPadding(new Insets(20, 20, 20, 20));
        actionButtonLayout.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
    	
    	Text actionCount = new Text("<X> Actions left");
    	actionCount.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 30));
        actionCount.setFill(Color.WHITE);
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
        recruitBarbarianButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitBarbarianView);
        actionButtonLayout.add(recruitBarbarianButton, 1, 2);
        
        Button buildButton = new ActionButton("FORT BOUWEN");
        buildButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToFortBuildView);
        actionButtonLayout.add(buildButton, 0, 3);
        
        Button recruitButton = new ActionButton("LEGIOEN REKRUTEREN");
        recruitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitLegionView);
        actionButtonLayout.add(recruitButton, 1, 3);
        
        Button showHandButton = new ActionButton("BEKIJK HAND");
        showHandButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHandView);
        actionButtonLayout.add(showHandButton, 0, 8);
        
        Button helpButton = new ActionButton("HELP");
        helpButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToInstructionView);
        actionButtonLayout.add(helpButton, 1, 8);
        
        Button nextTurnButton = new ActionButton("VOLGENDE BEURT");
        nextTurnButton.addEventFilter(MouseEvent.MOUSE_CLICKED, nextTurn);
        nextTurnButton.setPrefWidth((2 * nextTurnButton.getPrefWidth()) + actionButtonLayout.getHgap());
        nextTurnButton.setBackground(new Background(new BackgroundFill(Color.web("#57b932"), CornerRadii.EMPTY, Insets.EMPTY)));
        actionButtonLayout.add(nextTurnButton, 0, 9, 2, 1);
        
        return actionButtonLayout;
    }

    /**
     * Creates the list of players, shown on the top of the game screen.
     * @return HBox layout of the players.
     * 
     */
    private HBox createPlayerList() {
    	HBox playerList = new HBox();

    	// TODO implement player data recovery system to show instead of temp solution below.
    	UIPlayerInfo player1 = new UIPlayerInfo(Color.YELLOW, 1, "mitchvR609", "Magister Militum");
    	UIPlayerInfo player2 = new UIPlayerInfo(Color.GREEN, 2, "bastiaan350", "Consul");
    	UIPlayerInfo player3 = new UIPlayerInfo(Color.BLUE, 3, "nils2020", "Magister Militum");
    	
    	playerList.getChildren().addAll(player1, player2, player3);   
    	playerList.setAlignment(Pos.CENTER);
    	playerList.setPadding(new Insets(20, 20, 20, 20));
    	playerList.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        
    	return playerList;
    }
    
    @Override
    public void update() {
    	
    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

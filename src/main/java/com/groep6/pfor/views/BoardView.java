package com.groep6.pfor.views;

import com.groep6.pfor.controllers.*;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.ActionButton;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UIPlayerInfo;

import com.groep6.pfor.views.components.UIText;
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
import javafx.stage.Popup;

import java.util.List;

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
        Pane boardPane = createBoard();
        root.setCenter(boardPane);
        
        // Right - action buttons
        GridPane actionButtonLayout = createActionButtons();
        root.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        root.setRight(actionButtonLayout);
    }

    EventHandler<MouseEvent> goToTradeView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	new TradeController();
            
        }
    };
    
    EventHandler<MouseEvent> goToBattleView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	boardController.goToBattleView();
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
            boardController.goToInstructionView();
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
    	
    	UIText actionCount = new UIText("<X> Actions left");
    	actionCount.setWeight(FontWeight.BOLD).setSize(30).setColor(Color.WHITE);
    	actionButtonLayout.add(actionCount, 0, 0, 2, 1);
        
        Button conspireButton = new UIButton("RUILEN");
        conspireButton.setPrefSize(150, 60);
        conspireButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToTradeView);  
        actionButtonLayout.add(conspireButton, 0, 1);
        
        Button battleButton = new UIButton("VECHTEN");
        battleButton.setPrefSize(150, 60);
        battleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToBattleView);  
        actionButtonLayout.add(battleButton, 1, 1);
        
        Button allianceButton = new UIButton("ALLIANTIE SLUITEN");
        allianceButton.setPrefSize(150, 60);
        allianceButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToAllianceView); 
        actionButtonLayout.add(allianceButton, 0, 2);
        
        Button recruitBarbarianButton = new UIButton("BARBAREN INHUREN");
        recruitBarbarianButton.setPrefSize(150, 60);
        recruitBarbarianButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitBarbarianView);
        actionButtonLayout.add(recruitBarbarianButton, 1, 2);
        
        Button buildButton = new UIButton("FORT BOUWEN");
        buildButton.setPrefSize(150, 60);
        buildButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToFortBuildView);
        actionButtonLayout.add(buildButton, 0, 3);
        
        Button recruitButton = new UIButton("LEGIOEN REKRUTEREN");
        recruitButton.setPrefSize(150, 60);
        recruitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitLegionView);
        actionButtonLayout.add(recruitButton, 1, 3);
        
        Button showHandButton = new UIButton("BEKIJK HAND");
        showHandButton.setPrefSize(150, 60);
        showHandButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHandView);
        actionButtonLayout.add(showHandButton, 0, 8);
        
        Button helpButton = new UIButton("HELP");
        helpButton.setPrefSize(150, 60);
        helpButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToInstructionView);
        actionButtonLayout.add(helpButton, 1, 8);
        
        Button nextTurnButton = new UIButton("VOLGENDE BEURT");
        nextTurnButton.setPrefSize((2 * helpButton.getPrefWidth()) + actionButtonLayout.getHgap(), 60);
        nextTurnButton.addEventFilter(MouseEvent.MOUSE_CLICKED, nextTurn);
        nextTurnButton.setBackground(new Background(new BackgroundFill(Color.web("#57b932"), CornerRadii.EMPTY, Insets.EMPTY)));
        actionButtonLayout.add(nextTurnButton, 0, 9, 2, 1);
        
        return actionButtonLayout;
    }
    
    /**
     * Creates the image of the board.
     * @return Pane layout of the board.
     * 
     */
    private Pane createBoard() {
        BackgroundSize boardSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage board = new BackgroundImage(new Image("images/board.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                boardSize);
        Pane boardPane = new Pane();
        boardPane.setBackground(new Background(board));
        return boardPane;
    }

    /**
     * Creates the list of players, shown on the top of the game screen.
     * @return HBox layout of the players.
     * 
     */
    private HBox createPlayerList() {
    	HBox playerList = new HBox();

    	List<Player> players = boardController.getPlayers();

    	for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);

            UIPlayerInfo uiPlayerInfo = new UIPlayerInfo(player.getRoleCard().getColor(), ++i, player.getUsername(), player.getRoleCard().getName());
            playerList.getChildren().add(uiPlayerInfo);
        }

    	playerList.setAlignment(Pos.CENTER);
    	playerList.setPadding(new Insets(20, 20, 20, 20));
    	playerList.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        
    	return playerList;
    }
    
    @Override
    public void update(Object... data) {
    	
    }

    @Override
    public Pane getRoot() {
        return root;
    }
}

package com.groep6.pfor.views;

import com.groep6.pfor.Config;
import com.groep6.pfor.controllers.*;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.Tile;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Vector2f;
import com.groep6.pfor.views.components.ActionButton;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UIPlayerInfo;

import com.groep6.pfor.views.components.UIText;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
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
import java.util.Timer;
import java.util.TimerTask;

/**
 * The view that shows the board
 * @author Bastiaan Jansen
 * @author Mitchell van Rijswijk
 *
 */
public class BoardView extends View implements IObserver {
    
	private BoardController boardController;
	private BorderPane root;
	
	private static int canvasX = (int) (0.65 * ViewController.getInstance().getPrimaryStage().getWidth());
	private static int canvasY = Math.round(canvasX * (880f / 1200f));
	
	private static Vector2f CANVAS_SIZE = new Vector2f(canvasX, canvasY);
	private static final float CIRCLE_RADIUS = 20f / CANVAS_SIZE.y;


    private Button conspireButton;
    private Button battleButton;
    private Button allianceButton;
    private Button recruitBarbarianButton;
    private Button buildButton;
    private Button recruitButton;
    private Button showHandButton;
    private Button helpButton;
    private Button nextTurnButton;

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
        Canvas boardCanvas = createBoard();
        root.setCenter(boardCanvas);

        // Right - action buttons
        GridPane actionButtonLayout = createActionButtons();
        root.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        root.setRight(actionButtonLayout);

        // Change listeners
        root.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            	updateCanvasSize();
            }
        });
        
        root.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            	updateCanvasSize();
            }
        });
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

    EventHandler<MouseEvent> onCanvasClick = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if (event.getButton() != MouseButton.PRIMARY) return;

            for (Tile tile : boardController.getTiles()) {
                if (!(tile instanceof City)) continue;
                City city = (City) tile;
                Vector2f pos = new Vector2f(city.getPosition()).mul(CANVAS_SIZE);
                Vector2f mouse = new Vector2f((float) event.getX(), (float) event.getY());
                if (pos.distance(mouse) < CIRCLE_RADIUS * CANVAS_SIZE.y) {
                    boardController.cityPressed(city);
                    break;
                }
            }
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

        conspireButton = new UIButton("RUILEN");
        conspireButton.setPrefSize(150, 60);
        conspireButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToTradeView);
        conspireButton.setDisable(true);
        actionButtonLayout.add(conspireButton, 0, 1);

        battleButton = new UIButton("VECHTEN");
        battleButton.setPrefSize(150, 60);
        battleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToBattleView);
        battleButton.setDisable(true);
        actionButtonLayout.add(battleButton, 1, 1);

        allianceButton = new UIButton("ALLIANTIE SLUITEN");
        allianceButton.setPrefSize(150, 60);
        allianceButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToAllianceView);
        allianceButton.setDisable(true);
        actionButtonLayout.add(allianceButton, 0, 2);

        recruitBarbarianButton = new UIButton("BARBAREN INHUREN");
        recruitBarbarianButton.setPrefSize(150, 60);
        recruitBarbarianButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitBarbarianView);
        recruitBarbarianButton.setDisable(true);
        actionButtonLayout.add(recruitBarbarianButton, 1, 2);

        buildButton = new UIButton("FORT BOUWEN");
        buildButton.setPrefSize(150, 60);
        buildButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToFortBuildView);
        buildButton.setDisable(true);
        actionButtonLayout.add(buildButton, 0, 3);

        recruitButton = new UIButton("LEGIOEN REKRUTEREN");
        recruitButton.setPrefSize(150, 60);
        recruitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToRecruitLegionView);
        recruitButton.setDisable(true);
        actionButtonLayout.add(recruitButton, 1, 3);

        showHandButton = new UIButton("BEKIJK HAND");
        showHandButton.setPrefSize(150, 60);
        showHandButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToHandView);
        actionButtonLayout.add(showHandButton, 0, 8);

        helpButton = new UIButton("HELP");
        helpButton.setPrefSize(150, 60);
        helpButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToInstructionView);
        actionButtonLayout.add(helpButton, 1, 8);

        nextTurnButton = new UIButton("VOLGENDE BEURT");
        nextTurnButton.setPrefSize((2 * helpButton.getPrefWidth()) + actionButtonLayout.getHgap(), 60);
        nextTurnButton.addEventFilter(MouseEvent.MOUSE_CLICKED, nextTurn);
        nextTurnButton.setBackground(new Background(new BackgroundFill(Color.web("#57b932"), CornerRadii.EMPTY, Insets.EMPTY)));
        nextTurnButton.setDisable(true);
        actionButtonLayout.add(nextTurnButton, 0, 9, 2, 1);

        return actionButtonLayout;
    }

    /**
     * Creates the image of the board.
     * @return Pane layout of the board.
     *
     */
    private Canvas createBoard() {
        Canvas canvas = new Canvas(CANVAS_SIZE.x, CANVAS_SIZE.y);
        canvas.setOnMouseClicked(onCanvasClick);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(new Image("images/board.jpg"), 0, 0, CANVAS_SIZE.x, CANVAS_SIZE.y);

        return canvas;
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

    private Canvas getCanvas() {
        return (Canvas) root.getCenter();
    }

    public void updateCanvas() {
        GraphicsContext gc = getCanvas().getGraphicsContext2D();
        gc.drawImage(new Image("images/board.jpg"), 0, 0, canvasX, canvasY);

        // Draw city circles
        gc.setFill(Color.RED);
        for (Tile tile : boardController.getTiles()) {
            if (tile instanceof City) {
                City city = (City) tile;
                Vector2f pos = new Vector2f(city.getPosition()).mul(CANVAS_SIZE);
                float r = CIRCLE_RADIUS * CANVAS_SIZE.y;
                gc.fillOval(pos.x - r, pos.y - r, r * 2, r * 2);
            }
        }
    }

    @Override
    public void update() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                updateCanvas();
                createPlayerList();
            }
        });

        if (boardController.getLocalPlayer() != null && boardController.getLocalPlayer().isTurn()) {
            conspireButton.setDisable(false);
            battleButton.setDisable(false);
            allianceButton.setDisable(false);
            buildButton.setDisable(false);
            recruitButton.setDisable(false);
            nextTurnButton.setDisable(false);
        } else {
            conspireButton.setDisable(true);
            battleButton.setDisable(true);
            allianceButton.setDisable(true);
            buildButton.setDisable(true);
            recruitButton.setDisable(true);
            nextTurnButton.setDisable(true);
        }
    }
    
    public void updateCanvasSize() {
    	canvasX = (int) (0.65 * ViewController.getInstance().getPrimaryStage().getWidth());
    	canvasY = Math.round(canvasX * (880f / 1200f));
    	CANVAS_SIZE.x = canvasX;
    	CANVAS_SIZE.y = canvasY;
        getCanvas().setWidth(CANVAS_SIZE.x);
        getCanvas().setHeight(CANVAS_SIZE.y);
        updateCanvas();
        System.out.println(canvasX + " - " + canvasY);
    }

    @Override
    public Pane getRoot() {
        return root;
    }
}
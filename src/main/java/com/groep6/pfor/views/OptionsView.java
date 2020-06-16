package com.groep6.pfor.views;

import com.groep6.pfor.controllers.OptionController;
import com.groep6.pfor.models.GameState;
import com.groep6.pfor.views.components.UIBorderedText;
import com.groep6.pfor.views.components.UIButton;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

/**
 * Option screen to turn off music, switch to fullscreen and exit the game.
 * @author Mitchell van Rijswijk
 */
public class OptionsView extends View {

    private BorderPane root;
    private final OptionController optionController;
    private final int PREF_BUTTON_WIDTH = 200;
    private final int PREF_BUTTON_HEIGHT = 85;

    public OptionsView(OptionController optionController) {
    	this.optionController = optionController;
    	if (optionController.checkGameState().equals(GameState.MENU)) createMenuOptionView();
    	if (optionController.checkGameState().equals(GameState.GAME)) createGameOptionView(); 
    }

    // Create option screen for menu's 
    public void createMenuOptionView() {
        root = new BorderPane();

        Text text = new UIBorderedText("Options", "red", 1, "white");

        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 60));

        VBox options = new VBox(20);
        options.setAlignment(Pos.CENTER);

        Button backButton = new UIButton("Hervatten");
        backButton.setPrefSize(PREF_BUTTON_WIDTH, PREF_BUTTON_HEIGHT);
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);
        
        Button fullscreenButton = new UIButton("Toggle Fullscreen");
        fullscreenButton.setPrefSize(PREF_BUTTON_WIDTH, PREF_BUTTON_HEIGHT);
        fullscreenButton.addEventFilter(MouseEvent.MOUSE_CLICKED, toggleFullscreen);
        
        Button muteButton = new UIButton("Mute / Unmute");
        muteButton.setPrefSize(PREF_BUTTON_WIDTH, PREF_BUTTON_HEIGHT);
        muteButton.addEventFilter(MouseEvent.MOUSE_CLICKED, toggleMute);
        
        Button instructionButton = new UIButton("Help");
        instructionButton.setPrefSize(PREF_BUTTON_WIDTH,  PREF_BUTTON_HEIGHT);
        instructionButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goToInstructionView);

        options.getChildren().addAll(text, backButton, fullscreenButton, muteButton, instructionButton);
        BorderPane.setMargin(options, new Insets(12,12,100,12));
        setBackground(root, "/images/background.jpg");
        root.setCenter(options);
    }

    // Create option screen
    public void createGameOptionView() {
        root = new BorderPane();

        Text text = new UIBorderedText("Options", "red", 1, "white");

        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 60));

        VBox options = new VBox(20);
        options.setAlignment(Pos.CENTER);

        Button backButton = new UIButton("Hervatten");
        backButton.setPrefSize(PREF_BUTTON_WIDTH, PREF_BUTTON_HEIGHT);
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);

        Button fullscreenButton = new UIButton("Toggle Fullscreen");
        fullscreenButton.setPrefSize(PREF_BUTTON_WIDTH, PREF_BUTTON_HEIGHT);
        fullscreenButton.addEventFilter(MouseEvent.MOUSE_CLICKED, toggleFullscreen);

        Button muteButton = new UIButton("Mute / Unmute");
        muteButton.setPrefSize(PREF_BUTTON_WIDTH, PREF_BUTTON_HEIGHT);
        muteButton.addEventFilter(MouseEvent.MOUSE_CLICKED, toggleMute);
        
        Button exitGameButton = new UIButton("Exit Game");
        exitGameButton.setPrefSize(PREF_BUTTON_WIDTH, PREF_BUTTON_HEIGHT);
        exitGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, exitGame);

        options.getChildren().addAll(text, backButton, fullscreenButton, muteButton, exitGameButton);
        BorderPane.setMargin(options, new Insets(12,12,100,12));
        setBackground(root, "/images/background.jpg");
        root.setCenter(options);
    }
    
    EventHandler<MouseEvent> goBack = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
           optionController.goBack();
        }
    };
    
    EventHandler<MouseEvent> toggleFullscreen = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			optionController.handleFullscreen();
		}
    };
    
    EventHandler<MouseEvent> toggleMute = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			optionController.handleMute();
		}
    };
    
    EventHandler<MouseEvent> goToInstructionView = new EventHandler<MouseEvent>() {
    	@Override
    	public void handle(MouseEvent e) {
    		optionController.goToInstructions();
    	}
    };

    EventHandler<MouseEvent> exitGame = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            Platform.exit();
            System.exit(0);
        }
    };

    @Override
    public Pane getRoot() {
        return root;
    }
}

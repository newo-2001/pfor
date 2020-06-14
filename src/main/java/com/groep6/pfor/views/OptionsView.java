package com.groep6.pfor.views;

import com.groep6.pfor.Main;
import com.groep6.pfor.controllers.OptionController;
import com.groep6.pfor.controllers.ViewController;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Option screen to turn off music, switch to fullscreen and exit the game.
 * @author Mitchell van Rijswijk
 */
public class OptionsView extends View {

    private BorderPane root;
    private OptionController optionController;

    public OptionsView(OptionController optionController) {
    	this.optionController = optionController;
        createView();
    }

    // Create option screen
    public void createView() {
        root = new BorderPane();

        Text text = new UIBorderedText("Options", "#ffffff", 1, "white");

        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 60));

        VBox options = new VBox(30);
        options.setAlignment(Pos.CENTER);

        Button fullscreenButton = new UIButton("Toggle Fullscreen");
        fullscreenButton.setPrefSize(150, 75);
        fullscreenButton.addEventFilter(MouseEvent.MOUSE_CLICKED, toggleFullscreen);
        
        Button muteButton = new UIButton("Mute / Unmute");
        muteButton.setPrefSize(150, 75);
        muteButton.addEventFilter(MouseEvent.MOUSE_CLICKED, toggleMute);
        
        Button backButton = new UIButton("Ga terug");
        backButton.setPrefSize(150, 75);
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);
        
        Button exitGameButton = new UIButton("Exit Game");
        exitGameButton.setPrefSize(150, 75);
        exitGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, exitGame);


        options.getChildren().addAll(text, fullscreenButton, muteButton, backButton, exitGameButton);
        BorderPane.setMargin(options, new Insets(12,12,100,12));
//        root.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        setBackground(root, "images/background.jpg");
        root.setCenter(options);
    }
    
    EventHandler<MouseEvent> toggleFullscreen = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			ViewController.getInstance().toggleFullscreen();
		}
    };
    
    EventHandler<MouseEvent> toggleMute = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			Main.musicManager.toggleMute();
		}
    };
    
    EventHandler<MouseEvent> goBack = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
           optionController.goBack();
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

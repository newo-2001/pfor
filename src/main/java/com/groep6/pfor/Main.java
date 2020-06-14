package com.groep6.pfor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.controllers.OptionController;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.services.Firebase;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.util.Playlist;
import com.groep6.pfor.views.OptionsView;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static MusicManager musicManager;
	public ViewController viewController = ViewController.getInstance();
	public OptionsView options = new OptionsView(new OptionController());

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Setup logger
        Logger logger = LoggerFactory.getLogger(Main.class);
        Firebase.initialize();

        // Get ViewController instance and set primaryStage
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, keyListener);
        ViewController viewController = ViewController.getInstance();
        viewController.setPrimaryStage(primaryStage);

        // Start game music
        Playlist playlist = new Playlist();
        playlist.add("src/main/resources/sounds/music/Seeds_of_the_Past.mp3");		// In-game background music
        playlist.add("src/main/resources/sounds/music/Carpe_Diem.mp3");		// In-game background music

        musicManager = new MusicManager(playlist);
        musicManager.play("src/main/resources/sounds/music/Last_stand_of_an_Empire.mp3", 0.2, true);
  
        // Set default view
        new MenuController();
    }
    
    // TODO iemand help met if hel?
    EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent e) {
			if (e.getCode() == KeyCode.ESCAPE && !viewController.getVisitedViews().contains(options)) viewController.showView(options);
		}
    };
    
}

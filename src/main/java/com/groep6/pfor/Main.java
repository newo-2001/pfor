package com.groep6.pfor;

import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.controllers.OptionController;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.services.Firebase;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.views.OptionsView;
import com.groep6.pfor.views.View;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {
	
	public static MusicManager musicManager;
	public ViewController viewController = ViewController.getInstance();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Setup logger
        Logger logger = LoggerFactory.getLogger(Main.class);
        Firebase.initialize();
        
        // Set icon and title
        primaryStage.setTitle("Pandemic: Fall of Rome");
        Image icon = new Image(String.valueOf(getClass().getResource("/images/PFOR_icon.png")));
        primaryStage.getIcons().add(icon);

        // Get ViewController instance and set primaryStage
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, keyListener);
        ViewController viewController = ViewController.getInstance();
        viewController.setPrimaryStage(primaryStage);

        // Initialise music player and start menu music
        musicManager = new MusicManager();
        musicManager.play("/sounds/music/Last_stand_of_an_Empire.mp3", 0.2, true);
  
        // Set default view
        new MenuController();
    }
    
    EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent e) {
			if (e.getCode() == KeyCode.ESCAPE) {
				for (View view : viewController.getVisitedViews()) {
					if (view instanceof OptionsView) return;
				}
				new OptionController();
			}
		}
    };
    
}

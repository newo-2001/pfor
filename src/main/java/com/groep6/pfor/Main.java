package com.groep6.pfor;

import com.groep6.pfor.controllers.*;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.models.Board;
import com.groep6.pfor.services.Firebase;
import com.groep6.pfor.util.MusicManager;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Setup logger
        Logger logger = LoggerFactory.getLogger(Main.class);
        Firebase.initialize();

        // Get ViewController instance and set primaryStage
        ViewController viewController = ViewController.getInstance();
        viewController.setPrimaryStage(primaryStage);

        // Start game music
        MusicManager.getInstance().addToQueue("src/main/resources/sounds/music/Last_stand_of_an_Empire.mp3");	// Change to loop just in this view.
  
        // Set default view
        new MenuController();
    }
}

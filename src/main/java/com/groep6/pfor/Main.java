package com.groep6.pfor;

import com.groep6.pfor.controllers.*;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.services.PlayerService;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
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

        // Get ViewController instance and set primaryStage
        ViewController viewController = ViewController.getInstance();
        viewController.setPrimaryStage(primaryStage);

        // Start game music
        MediaController.play("src/main/resources/sound/music/Last_stand_of_an_Empire.mp3", 0.1, true);

        // Set default view
		new HandController();

        new PlayerService().get("CxDNFdDaJJNTEJkOmkQo");
    }
}

package com.groep6.pfor;

import com.groep6.pfor.controllers.*;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.models.Board;
import com.groep6.pfor.services.Firebase;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.util.Playlist;
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
        Playlist playlist = new Playlist();
        playlist.add("src/main/resources/sounds/music/Last_stand_of_an_Empire.mp3");
        playlist.add("src/main/resources/sounds/music/Seeds_of_the_Past.mp3");
        playlist.add("src/main/resources/sounds/music/To_fight_another_day.mp3");

        MusicManager musicManager = new MusicManager(playlist);
        musicManager.play();
  
        // Set default view
        // new BoardController();
        new MenuController();
    }
}

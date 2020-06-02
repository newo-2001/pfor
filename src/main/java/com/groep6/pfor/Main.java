package com.groep6.pfor;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.services.Firebase;
import com.groep6.pfor.services.PlayerService;

import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {
    private static final int WIDTH = 1080;
    private static final int HEIGHT = 720;

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
        viewController.setWidth(WIDTH);
        viewController.setHeight(HEIGHT);

        // Set default view
        Lobby lobby = new Lobby("");
        lobby.join(lobby.getCode(), "Bastiaan", "");
        lobby.join(lobby.getCode(), "Jan", "");

        new MenuController();

        // Setup service
        /*LobbyService lobbyService = new LobbyService();

        try {
            lobbyService.get("wIx400aFf61zIcl1cN6x");
        } catch (NoDocumentException e) {
            System.out.println(e.getMessage());
        }*/

        System.out.println(new PlayerService().get("CxDNFdDaJJNTEJkOmkQo"));
    }
}

package com.groep6.pfor;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.controllers.TradeController;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.services.PlayerService;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {
    private static final int MIN_WIDTH = 1080;
    private static final int MIN_HEIGHT = 720;

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
        primaryStage.setMinWidth(MIN_WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setFullScreen(true);

        // Set default view
        Lobby lobby = new Lobby("");
        lobby.join(lobby.getCode(), "Bastiaan", "");
        lobby.join(lobby.getCode(), "Jan", "");

        //new MenuController();
        new TradeController();

        // Setup service
        /*LobbyService lobbyService = new LobbyService();

        try {
            lobbyService.get("wIx400aFf61zIcl1cN6x");
        } catch (NoDocumentException e) {
            System.out.println(e.getMessage());
        }*/

        new PlayerService().get("CxDNFdDaJJNTEJkOmkQo");
    }
}

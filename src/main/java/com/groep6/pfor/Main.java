package com.groep6.pfor;

import com.google.cloud.firestore.DocumentSnapshot;
import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Board;
import com.groep6.pfor.services.GameService;
import com.groep6.pfor.services.LobbyService;
import com.groep6.pfor.services.PlayerService;
import com.groep6.pfor.services.Service;
import com.groep6.pfor.util.Renderer;
import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.HandView;
import com.groep6.pfor.views.HostView;
import com.groep6.pfor.views.MenuView;

import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.util.parsers.CityParser;

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

        // Get ViewController instance and set primaryStage
        ViewController viewController = ViewController.getInstance();
        viewController.setPrimaryStage(primaryStage);
        viewController.setWidth(WIDTH);
        viewController.setHeight(HEIGHT);

        // Set default view
        new MenuController();

        // Setup service
        LobbyService lobbyService = new LobbyService();

        try {
            lobbyService.get("wIx400aFf61zIcl1cN6x");
        } catch (NoDocumentException e) {
            System.out.println(e.getMessage());
        }

        City[] cities = new CityParser().parseFile("test.json");
        for (City city : cities) {
            System.out.println(city);
        }
    }
}

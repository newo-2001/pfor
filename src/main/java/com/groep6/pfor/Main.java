package com.groep6.pfor;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.controllers.HostController;
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

        // Set default view
        new MenuController();

        new PlayerService().get("CxDNFdDaJJNTEJkOmkQo");
    }
}

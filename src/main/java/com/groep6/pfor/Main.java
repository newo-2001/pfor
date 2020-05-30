package com.groep6.pfor;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.models.Board;
import com.groep6.pfor.util.Renderer;
import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.HandView;
import com.groep6.pfor.views.HostView;
import com.groep6.pfor.views.MenuView;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    private static final int WIDTH = 1080;
    private static final int HEIGHT = 720;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Get ViewController instance and set primaryStage
        ViewController viewController = ViewController.getInstance();
        viewController.setPrimaryStage(primaryStage);
        viewController.setWidth(WIDTH);
        viewController.setHeight(HEIGHT);

        // Set default view
        new MenuController();

    }
}

package com.groep6.pfor;

import com.groep6.pfor.models.City;
import com.groep6.pfor.util.parsers.CityParser;
import com.groep6.pfor.controllers.MenuController;
import com.groep6.pfor.controllers.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

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

        City[] cities = new CityParser().parseFile("test.json");
        for (City city : cities) {
            System.out.println(city);
        }
    }
}

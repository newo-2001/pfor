package com.groep6.pfor.controllers;

import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.View;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewController {

    private static final ViewController INSTANCE = new ViewController();

    private Stage primaryStage;

    private ViewController() {}

    public static ViewController getInstance() { return INSTANCE; }

    public static void setPrimaryStage(Stage primaryStage) {
        ViewController viewController = ViewController.getInstance();
        viewController.primaryStage = primaryStage;
    }

    public static void showView(View view) {
        ViewController viewController = ViewController.getInstance();
        Stage primaryStage = viewController.getPrimaryStage();
        Scene scene = view.getScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        ViewController viewController = ViewController.getInstance();
        return viewController.primaryStage;
    }
}

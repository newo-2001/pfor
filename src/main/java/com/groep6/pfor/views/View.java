package com.groep6.pfor.views;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class View {

    protected static final int WIDTH = 1080;
    protected static final int HEIGHT = 720;


    protected View(Stage primaryStage) {
        primaryStage.setTitle("Pandemic: Fall of Rome");
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
    }

    public abstract Scene getScene();
}

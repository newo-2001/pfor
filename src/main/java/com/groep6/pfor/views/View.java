package com.groep6.pfor.views;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Bastiaan Jansen
 */
public abstract class View {

    protected static final int WIDTH = 1080;
    protected static final int HEIGHT = 720;

    protected Stage primaryStage;

    protected View(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Pandemic: Fall of Rome");
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
    }

    public void setTitle(String title) {
        primaryStage.setTitle(title);
    }

    public abstract Scene getScene();
}

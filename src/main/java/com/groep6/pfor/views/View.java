package com.groep6.pfor.views;

import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Bastiaan Jansen
 */
public abstract class View {

//    protected static final int WIDTH = 1080;
//    protected static final int HEIGHT = 720;
//
//    protected Stage stage;
//
//    protected View(Stage stage) {
//        this.stage = stage;
//        stage.setTitle("Pandemic: Fall of Rome");
//        stage.setWidth(WIDTH);
//        stage.setHeight(HEIGHT);
//    }

//    public void setTitle(String title) {
//        stage.setTitle(title);
//    }

    public abstract Scene getScene();
}

package com.groep6.pfor.views;

import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Bastiaan Jansen
 */
public abstract class View {

    protected Scene scene;

    public Scene getScene() {
        return scene;
    }
}
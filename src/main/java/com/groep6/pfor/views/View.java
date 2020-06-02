package com.groep6.pfor.views;

import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * @author Bastiaan Jansen
 */
public abstract class View {

    protected Scene scene;

    public abstract Pane getRoot();

    protected void setBackground(Pane layer, String imagePath) {
        BackgroundImage backgroundImage = new BackgroundImage(new Image(imagePath),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        layer.setBackground(new Background(backgroundImage));
    }
}

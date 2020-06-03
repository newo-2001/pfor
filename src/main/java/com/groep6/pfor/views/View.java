package com.groep6.pfor.views;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

/**
 * @author Bastiaan Jansen
 */
public abstract class View {

    protected Scene scene;
    protected Rectangle2D viewport;
    
    public View() {
    	viewport = Screen.getPrimary().getBounds();
    	setBackground(getRoot(), Color.BLACK);
    	checkPillarBoxing();
    	checkLetterBoxing();
    }
    
    protected void checkPillarBoxing() {
    	if (getRoot().getHeight() > viewport.getHeight()) {
    		
    	}
    }
    
    protected void checkLetterBoxing() {
    	
    }

    public abstract Pane getRoot();

    protected void setBackground(Pane layer, String imagePath) {
        BackgroundImage backgroundImage = new BackgroundImage(new Image(imagePath),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        layer.setBackground(new Background(backgroundImage));
    }
    
    protected void setBackground(Pane layer, Color color) {
        layer.setBackground(new Background(new BackgroundFill(color, null, null)));
    }
    
}

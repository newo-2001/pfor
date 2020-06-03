package com.groep6.pfor.views;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

/**
 * Abstract class for each view in the app. Contains the scene, viewport and methods to decide
 * the background of a certain scene. Checks for pillar- and letterboxing.
 * @author Bastiaan Jansen
 * @author Mitchell van Rijswijk
 * 
 */
public abstract class View {

    protected Scene scene;
    protected Rectangle2D viewport;
    
    /**
     * Initialize a view. Preparation for potential pillar- and letterboxing.
     * @author Mitchell van Rijswijk
     * 
     */
    public View() {
    	viewport = Screen.getPrimary().getBounds();
    	setBackground(getRoot(), Color.BLACK);
    	checkPillarBoxing();
    	checkLetterBoxing();
    }
    
    /**
     * Compares root height with viewport height. Decides whether to pillarbox or not.
     * @author Mitchell van Rijswijk
     * 
     */
    protected void checkPillarBoxing() {
    	if (getRoot().getHeight() > viewport.getHeight()) {
    		double ratio = getRoot().getWidth() / getRoot().getHeight();
    		getRoot().setPrefSize(viewport.getHeight() * ratio, viewport.getHeight());
    	}
    }
    
    /**
     * Compares root width with viewport width. Decides whether to letterbox or not.
     * @author Mitchell van Rijswijk
     * 
     */
    protected void checkLetterBoxing() {
    	
    }

    public abstract Pane getRoot();

    /**
     * Fills the background of the layer pane with a passed background image.
     * @author Bastiaan Jansen
     * @param layer The pane that needs a background
     * @param imagePath Path to background image
     * 
     */
    protected void setBackground(Pane layer, String imagePath) {
        BackgroundImage backgroundImage = new BackgroundImage(new Image(imagePath),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        layer.setBackground(new Background(backgroundImage));
    }
    
    /**
     * Fills the background of the layer pane with a passed color.
     * @author Mitchell van Rijswijk
     * @param layer The pane that needs a background
     * @param color Background color
     * 
     */
    protected void setBackground(Pane layer, Color color) {
        layer.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
}

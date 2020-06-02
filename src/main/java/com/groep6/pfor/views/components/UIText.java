package com.groep6.pfor.views.components;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

/**
 * Abstracts the most used methods on the Text JavaFX class away with simple to use and chainable methods
 * @author Bastiaan Jansen
 */
public class UIText extends Text {

    private int size = 13;
    private FontWeight weight = FontWeight.NORMAL;
    private FontPosture posture = FontPosture.REGULAR;

    /**
     * Create a new UIText instance with text
     * @param text
     */
    public UIText(String text) {
        setStyles();
        setText(text);
    }

    /**
     * Create a new UIText instance without text
     */
    public UIText() {
        setStyles();
    }

    /**
     * Set font
     */
    private void setStyles() {
        setFont(Font.font("verdana", weight, posture, size));
    }

    /**
     * @param weight
     * @return UIText instance
     */
    public UIText setWeight(FontWeight weight) {
        this.weight = weight;
        setStyles();
        return this;
    }

    /**
     * @param size
     * @return UIText instance
     */
    public UIText setSize(int size) {
        this.size = size;
        setStyles();
        return this;
    }

    /**
     * @param posture
     * @return UIText instance
     */
    public UIText setPosture(FontPosture posture) {
        this.posture = posture;
        setStyles();
        return this;
    }

    /**
     * @param alignment
     * @return UIText instance
     */
    public UIText setAlignment(TextAlignment alignment) {
        setTextAlignment(alignment);
        return this;
    }

    /**
     * @param color
     * @return UIText instance
     */
    public UIText setColor(Color color) {
        setFill(color);
        return this;
    }


}

package com.groep6.pfor.views.components;

import com.sun.glass.ui.Cursor;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * @author Bastiaan Jansen
 */
public class DefaultButton extends Button {

    public DefaultButton(String text) {
        setText(text);
        setStyles();
    }

    public DefaultButton() {
        setStyles();
    }

    private void setStyles() {
        setBackground(new Background(new BackgroundFill(Color.web("#db8937"), CornerRadii.EMPTY, Insets.EMPTY)));
        setPadding(new Insets(10, 10, 10, 10));
        setStyle("-fx-text-fill: white");

        addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                setCursor(javafx.scene.Cursor.HAND);
            }
        });
    }
}

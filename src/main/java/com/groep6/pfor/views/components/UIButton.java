package com.groep6.pfor.views.components;

import com.sun.glass.ui.Cursor;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author Bastiaan Jansen
 */
public class UIButton extends Button {

    public UIButton(String text) {
        setText(text.toUpperCase());
        setStyles();
    }

    private void setStyles() {
        setBackground(new Background(new BackgroundFill(Color.web("#ef4140"), CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setPadding(new Insets(20, 20, 20, 20));
        setStyle("-fx-text-fill: white");
        setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        setWrapText(true);

        addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                setCursor(javafx.scene.Cursor.HAND);
            }
        });
    }
}

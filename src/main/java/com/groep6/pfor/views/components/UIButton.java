package com.groep6.pfor.views.components;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
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

    private final BorderWidths borderWidths;

    public UIButton(String text) {
        borderWidths = new BorderWidths(2);
        setText(text.toUpperCase());
        setStyles();
    }

    private void setStyles() {
		setBackground(new Background(new BackgroundFill(Color.web("#ef4140"), CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWidths)));
        setPadding(new Insets(20, 20, 20, 20));
        setTextFill(Color.WHITE);
        setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        setWrapText(true);
        setCursor(Cursor.HAND);

        addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWidths)));
            }
        });

        addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWidths)));
            }
        });
    }
}

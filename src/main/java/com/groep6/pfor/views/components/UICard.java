package com.groep6.pfor.views.components;

import com.groep6.pfor.models.cards.Card;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;

public abstract class UICard extends BorderPane {

    private static final int WIDTH = 220;
    private static final int HEIGHT = 300;

    private boolean selected = false;

    public UICard(String cardName) {
        setMinWidth(WIDTH);
        setMinHeight(HEIGHT);
        setMaxWidth(WIDTH);
        setMaxHeight(HEIGHT);
        setPadding(new Insets(20));

        BackgroundImage backgroundImage = new BackgroundImage(new Image("images/paper.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        setBackground(new Background(backgroundImage));

        setCursor(Cursor.HAND);
    }

    public void select() {
        selected = true;
        setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
    }

    public void deselect() {
        selected = false;
        setBorder(Border.EMPTY);
    }

    public boolean isSelected() {
        return selected;
    }

    public abstract Card getCard();

}

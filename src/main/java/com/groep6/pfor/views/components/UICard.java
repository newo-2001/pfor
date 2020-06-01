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

public class UICard extends BorderPane {

    private Card card;
    private boolean selected = false;

    public UICard(Card card) {
        this.card = card;

        setMinWidth(220);
        setMinHeight(300);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("images/paper.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        setBackground(new Background(backgroundImage));

        Text nameText = new Text(card.getName());
        nameText.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 18));

        setCursor(Cursor.HAND);

        setCenter(nameText);
    }

    public void select() {
        selected = true;
        setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(8))));
    }

    public void deselect() {
        selected = false;
        setBorder(Border.EMPTY);
    }

    public boolean isSelected() {
        return selected;
    }

    public Card getCard() {
        return card;
    }

}

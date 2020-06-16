package com.groep6.pfor.views.components;

import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CardType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public abstract class UICard extends BorderPane {

    private static final int WIDTH = 220;
    private static final int HEIGHT = 300;

    private boolean selected = false;

    protected CardType cardType;

    public UICard(CardType cardType) {
        this.cardType = cardType;

        setMinWidth(WIDTH);
        setMinHeight(HEIGHT);
        setMaxWidth(WIDTH);
        setMaxHeight(HEIGHT);
        setPadding(new Insets(20));
        setCursor(Cursor.HAND);

        createView();
    }

    private void createView() {
        BackgroundImage backgroundImage = new BackgroundImage(new Image(UICard.class.getResourceAsStream("/images/paper.jpg")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false));
        setBackground(new Background(backgroundImage));

        UIText cardTypeText = new UIText(cardType.toString().toUpperCase());
        cardTypeText.setAlignment(TextAlignment.CENTER).setWeight(FontWeight.BOLD).setSize(18);
        setTop(cardTypeText);

        setAlignment(cardTypeText, Pos.CENTER);
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

    public CardType getCardType() {
        return cardType;
    }

}

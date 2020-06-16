package com.groep6.pfor.views.components;

import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CardType;
import com.groep6.pfor.models.cards.CityCard;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.FontWeight;

public class UICityCard extends UICard {

    private static final CardType CARD_TYPE = CardType.CITY;
    private final CityCard card;

    public UICityCard(CityCard card) {
        super(CARD_TYPE);
        this.card = card;

        createView();
    }

    private void createView() {
        VBox centerBox = new VBox(5);
        centerBox.setAlignment(Pos.CENTER);


        UIText nameText = new UIText(card.getName());
        nameText.setWeight(FontWeight.BOLD).setSize(18).setColor(Color.web("#D5544F"));

        HBox factionBox = new HBox(5);
        factionBox.setAlignment(Pos.CENTER);

        UIText factionText = new UIText(card.getFaction().getFactionType().getName());

        Circle factionColorDot = new Circle();
        factionColorDot.setFill(card.getFaction().getColor());
        factionColorDot.setRadius(7);

        factionBox.getChildren().addAll(factionText, factionColorDot);

        centerBox.getChildren().addAll(nameText, factionBox);



        setCenter(centerBox);
    }

    @Override
    public Card getCard() {
        return card;
    }
}

package com.groep6.pfor.views.components;

import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CardType;
import com.groep6.pfor.models.cards.CityCard;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class UICityCard extends UICard {

    private static final CardType CARD_TYPE = CardType.CITY;
    private CityCard card;

    public UICityCard(CityCard card) {
        super(CARD_TYPE);
        this.card = card;

        createView();
    }

    private void createView() {
        UIText nameText = new UIText(card.getName());
        nameText.setWeight(FontWeight.BOLD).setSize(18).setColor(Color.web("#D5544F"));
        setCenter(nameText);
    }

    @Override
    public Card getCard() {
        return card;
    }
}
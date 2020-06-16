package com.groep6.pfor.views.components;

import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CardType;
import com.groep6.pfor.models.cards.RoleCard;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class UIRoleCard extends UICard {

    private static final CardType CARD_TYPE = CardType.ROLE;

    private final RoleCard card;

    public UIRoleCard(RoleCard card) {
        super(CARD_TYPE);
        this.card = card;

        createView();
    }

    private void createView() {
        UIText nameText = new UIText(card.getName());
        nameText.setWeight(FontWeight.BOLD).setSize(18).setColor(Color.web("#D5544F"));

        UIText descriptionText = new UIText(card.getAbility().getDescription());
        descriptionText.setAlignment(TextAlignment.CENTER);
        descriptionText.setWrappingWidth(super.getMaxWidth() - super.getPadding().getRight() * 2);

        setCenter(nameText);
        setBottom(descriptionText);
    }

    @Override
    public Card getCard() {
        return card;
    }
}

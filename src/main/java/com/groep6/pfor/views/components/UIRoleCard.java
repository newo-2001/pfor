package com.groep6.pfor.views.components;

import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.RoleCard;
import javafx.beans.binding.Bindings;
import javafx.scene.text.*;

public class UIRoleCard extends UICard {

    private static final String CARD_NAME = "Karakterkaart";

    private RoleCard card;

    public UIRoleCard(RoleCard card) {
        super(CARD_NAME);
        this.card = card;

        createView();
    }

    public void createView() {
        UIText nameText = new UIText(card.getName());
        nameText.setWeight(FontWeight.BOLD).setSize(18);

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

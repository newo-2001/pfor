package com.groep6.pfor.views;

import com.groep6.pfor.controllers.CardController;

/**
 * A view that represents a card
 * @author Mathijs
 */
public class CardView extends View {
    /** The cardController */
    private CardController cardController;

    /**
     * The constructor
     * @param cardController The cardController
     */
    public CardView(CardController cardController) {
        this.cardController = cardController;
    }
}

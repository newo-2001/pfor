package com.groep6.pfor.views;

import com.groep6.pfor.util.IObserver;

import java.util.ArrayList;

/**
 * The view that represents a player's hand with cards
 * @author Mathijs
 */
public class HandView implements IObserver {
    /** The handController */
    private HandController handController;

    /** The list of cards that the player has, as CardView's */
    private ArrayList<CardView> cards;

    /**
     * The constructor
     * @param handController The handController
     * @param cards A list of CardView's, the cards that the player currently has
     */
    public HandView(HandController handController, ArrayList<CardView> cards) {
        this.handController = handController;
        this.cards = cards;
    }

    @Override
    public void update() {

    }
}

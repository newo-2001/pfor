package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck(Card... cards) {
        this.addCards(cards);
    }

    public void addCards(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        int index = cards.size() - 1;
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    public Card draw(int index) {
        Card card = cards.get(index);
        cards.remove(0);
        return card;
    }

    public int getCardCount() {
        return cards.size();
    }

}

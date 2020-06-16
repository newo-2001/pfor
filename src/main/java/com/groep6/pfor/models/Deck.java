package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.util.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Deck with cards
 * @author Bastiaan Jansen
 * @author Nils van der Velden
 */
public class Deck extends Observable {

    private final List<Card> cards = new ArrayList<>();

    /**
     * @param cards
     */
    public Deck(Card... cards) {
        this.addCards(cards);
    }

    /**
     * Add one or multiple cards to deck
     * @param cards
     */
    public void addCards(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
    }
    
    public List<Card> getCards() {
        return cards;
    }
    
    public void removeCard(Card card) {
        int index = cards.indexOf(card);
        cards.remove(card);
        notifyObservers();
    }

    public void merge(Deck deck) {
        cards.addAll(deck.getCards());
    }

    /**
     * Shuffles deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draw a card from the top of the deck
     * @return Card
     */
    public Card draw() {
        if (cards.size() <= 0) return null;

        int index = cards.size() - 1;
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    /**
     * Draw a card from a specific index from the deck
     * @param index
     * @return Card
     */
    public Card draw(int index) {
        Card card = cards.get(index);
        cards.remove(0);
        return card;
    }

    /**
     * @return int
     */
    public int getCardCount() {
        return cards.size();
    }

}

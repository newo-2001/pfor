package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.util.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bastiaan Jansen
 * @author Nils van der Velden
 */
public class Hand extends Observable {

    private final List<Card> cards = new ArrayList<>();

    public Hand(Card... cards) {
        addCards(cards);
    }

    public boolean hasCard(Card card) {
        return cards.contains(card);
    }

    public void addCards(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
        notifyObservers();
    }

    public void removeCards(Card... cards) {
        this.cards.removeAll(Arrays.asList(cards));
        notifyObservers();
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card removeCard(int index) {
        Card removedCard = cards.get(index);
        cards.remove(index);
        notifyObservers();
        return removedCard;
    }

    public void removeCard(Card card) {
        //int index = cards.indexOf(card);
        //Card removedCard = cards.get(index);
        cards.remove(card);
        notifyObservers();
    }

    public Card getCard(int index) {
        return cards.get(index);
    }
    
    public int getCardCount() {
        return cards.size();
    }
}


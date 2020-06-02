package com.groep6.pfor.models;

import com.groep6.pfor.models.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.groep6.pfor.util.Observable;

/**
 * @author Bastiaan Jansen
 */
public class Hand extends Observable {

    private List<Card> cards = new ArrayList<>();
	private Card card;

    public Hand(Card... cards) {
        addCards(cards);
    }

    public boolean hasCard(Card card) {
        return cards.contains(card);
    }

    public void addCards(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
    }

    public void removeCards(Card... cards) {
        this.cards.removeAll(Arrays.asList(cards));
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card removeCard(int index) {
        Card removedCard = cards.get(index);
        cards.remove(index);
        return removedCard;
    }

    public Card removeCard(Card card) {
        int index = cards.indexOf(card);
        Card removedCard = cards.get(index);
        cards.remove(card);
        return removedCard;
    }

    public Card getCard(int index) {
        return cards.get(index);
    }
    
    public void setCard(Card card) {
        this.card = card;
        notifyObservers();
    }
}


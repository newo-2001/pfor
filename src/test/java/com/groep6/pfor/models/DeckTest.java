package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityCardFactory;
import com.groep6.pfor.models.cards.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Bastiaan Jansen
 */
class DeckTest {

    private Deck deck;
    private Card card1;
    private Card card2;

    @BeforeEach
    void setUp() {
        CityCardFactory cityCardFactory = CityCardFactory.getInstance();
        List<Card> cards = cityCardFactory.getCityCardDeck().getCards();
        this.deck = new Deck();
        this.card1 = cards.get(0);
        this.card2 = cards.get(1);
    }

    @AfterEach
    void tearDown() {
        this.deck = null;
        this.card1 = null;
        this.card2 = null;
    }

    @Test
    void addCards() {
        deck.addCards(card1);
        assertEquals(1, deck.getCardCount());
    }

    @Test
    void getCards() {
        deck.addCards(card1, card2);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        assertEquals(2, deck.getCardCount());
        assertEquals(cards, deck.getCards());
    }

    @Test
    void removeCard() {
        deck.addCards(card1, card2);
        deck.removeCard(card1);
        assertEquals(1, deck.getCardCount());
        assertEquals(card2, deck.draw());
    }

    @Test
    void merge() {
        deck.addCards(card1);
        Deck deck2 = new Deck(card2);
        deck.merge(deck2);
        assertEquals(2, deck.getCardCount());
    }

    @Test
    void draw() {
        deck.addCards(card1, card2);
        Card card = deck.draw();
        assertEquals(card2, card);
    }

    @Test
    void getCardCount() {
        deck.addCards(card1, card2);
        assertEquals(2, deck.getCardCount());
    }
}
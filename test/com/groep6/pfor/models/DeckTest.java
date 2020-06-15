package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityCardFactory;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import junit.framework.TestCase;
import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class DeckTest extends TestCase {

    private Deck deck;
    private Card card1;
    private Card card2;

    public void setUp() throws Exception {
        super.setUp();
        this.deck = new Deck();
        CityCardFactory cityCardFactory = CityCardFactory.getInstance();
        List<Card> cards = cityCardFactory.getCityCardDeck().getCards();
        this.card1 = cards.get(0);
        this.card2 = cards.get(1);
    }

    public void tearDown() throws Exception {
        this.deck = null;
        this.card1 = null;
        this.card2 = null;
    }

    public void testAddCards() {
        deck.addCards(card1);
        assertEquals(1, deck.getCardCount());
    }

    public void testMerge() {
        deck.addCards(card1);
        Deck deck2 = new Deck(card2);
        deck.merge(deck2);
        assertEquals(2, deck.getCardCount());
    }

    public void testDraw() {
        deck.addCards(card1, card2);
        Card card = deck.draw();
        assertEquals(card2, card);
    }

    public void testGetCardCount() {
        deck.addCards(card1, card2);
        assertEquals(2, deck.getCardCount());
    }
}
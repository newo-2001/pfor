package com.groep6.pfor.models;

import java.util.List;
import com.groep6.pfor.factories.CityCardFactory;
import com.groep6.pfor.models.cards.Card;
import junit.framework.TestCase;

/**
 * @author Nils van der Velden
 */

public class HandTest extends TestCase {
	
	private Hand hand;
	private Card card1;
	private Card card2;

    public void setUp() throws Exception {
        super.setUp();
        this.hand = new Hand();
        CityCardFactory cityCardFactory = CityCardFactory.getInstance();
        List<Card> cards = cityCardFactory.getCityCardDeck().getCards();
        this.card1 = cards.get(0);
        this.card2 = cards.get(1);
        this.hand = new Hand();
        hand.addCards(card1, card2);
    }

    public void tearDown() throws Exception {
        this.hand = null;
        this.card1 = null;
        this.card2 = null;
    }

    public void testRemoveCards() {
    	hand.removeCard(card1);
        assertEquals(1, hand.getCardCount());
    }
}
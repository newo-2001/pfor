package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityCardFactory;
import com.groep6.pfor.models.cards.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nils van der Velden
 */

public class HandTest {

	private Hand hand;
	private Card card1;
	private Card card2;

    @BeforeEach
    void setUp() {
        CityCardFactory cityCardFactory = CityCardFactory.getInstance();
        List<Card> cards = cityCardFactory.getCityCardDeck().getCards();
        this.card1 = cards.get(0);
        this.card2 = cards.get(1);
        this.hand = new Hand();
        hand.addCards(card1, card2);
    }

    @AfterEach
    void tearDown() {
        this.hand = null;
        this.card1 = null;
        this.card2 = null;
    }

    @Test
    void removeCards() {
        hand.removeCard(card1);
        assertEquals(1, hand.getCardCount());
    }
}
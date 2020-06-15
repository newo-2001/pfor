package com.groep6.pfor.factories;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.EventCard;
import com.groep6.pfor.models.cards.actions.eventActions.AudentesFortunaAction;
import com.groep6.pfor.models.cards.actions.eventActions.CarpeDiemAction;
import com.groep6.pfor.models.cards.actions.eventActions.FaberFortunaeAction;
import com.groep6.pfor.models.cards.actions.eventActions.VitaMeaAction;

/**
* @author Nils van der Velden
*/

public class EventCardFactory {
	private static final EventCardFactory SINGLE_INSTANCE = new EventCardFactory();
	private Deck eventCardDeck =  new Deck();
	
	private EventCardFactory() {
		eventCardDeck.addCards(new EventCard("Mors Tua, Vita Mea", new VitaMeaAction()));

		eventCardDeck.addCards(new EventCard("Homo Faber Fortunae Suae", new FaberFortunaeAction()));

		eventCardDeck.addCards(new EventCard("Audentes Fortuna Iuvat", new AudentesFortunaAction()));

		eventCardDeck.addCards(new EventCard("Carpe Diem", new CarpeDiemAction()));
		eventCardDeck.addCards(new EventCard("Carpe Diem", new CarpeDiemAction()));
		eventCardDeck.addCards(new EventCard("Carpe Diem", new CarpeDiemAction()));
		eventCardDeck.addCards(new EventCard("Carpe Diem", new CarpeDiemAction()));		
	}
	
    public static EventCardFactory getInstance() {
        return SINGLE_INSTANCE;
    }

	public Deck getEventCardDeck() {
		return eventCardDeck;
	}

	public EventCard getCardByName(String name) {
		for (Card card : eventCardDeck.getCards()) {
			if (card.getName().equals(name)) return (EventCard) card;
		}
		if (Config.DEBUG) System.out.printf("[WARNING] Event card with name %s not found!\n", name);
		return null;
	}
}
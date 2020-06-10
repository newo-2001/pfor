package com.groep6.pfor.factories;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.EventCard;
import com.groep6.pfor.models.cards.actions.eventActions.AbundansCautelaAction;
import com.groep6.pfor.models.cards.actions.eventActions.AleaIactaEstAction;
import com.groep6.pfor.models.cards.actions.eventActions.AudentesFortunaAction;
import com.groep6.pfor.models.cards.actions.eventActions.CarpeDiemAction;
import com.groep6.pfor.models.cards.actions.eventActions.DoUtDesAction;
import com.groep6.pfor.models.cards.actions.eventActions.FaberFortunaeAction;
import com.groep6.pfor.models.cards.actions.eventActions.FestinaLenteAction;
import com.groep6.pfor.models.cards.actions.eventActions.HicManebimusOptimeAction;
import com.groep6.pfor.models.cards.actions.eventActions.MeliusCavereAction;
import com.groep6.pfor.models.cards.actions.eventActions.MortuiNonMordentAction;
import com.groep6.pfor.models.cards.actions.eventActions.ParaBellumAction;
import com.groep6.pfor.models.cards.actions.eventActions.VaeVictisAction;
import com.groep6.pfor.models.cards.actions.eventActions.VeniVidiViciAction;
import com.groep6.pfor.models.cards.actions.eventActions.VitaMeaAction;

/**
* @author Nils van der Velden
*/

public class EventCardFactory {
	private static final EventCardFactory SINGLE_INSTANCE = new EventCardFactory();
	private Deck eventCardDeck =  new Deck();
	
	private EventCardFactory() {
		eventCardDeck.addCards(new EventCard("Mortui Non Mordent", new MortuiNonMordentAction()));
		eventCardDeck.addCards(new EventCard("Mors Tua, Vita Mea", new VitaMeaAction()));
		eventCardDeck.addCards(new EventCard("Hic Manebimus Optime", new HicManebimusOptimeAction()));
		eventCardDeck.addCards(new EventCard("Homo Faber Fortunae Suae", new FaberFortunaeAction()));
		eventCardDeck.addCards(new EventCard("Do Ut Des", new DoUtDesAction()));
		eventCardDeck.addCards(new EventCard("Audentes Fortuna Iuvat", new AudentesFortunaAction()));
		eventCardDeck.addCards(new EventCard("Vae Victis", new VaeVictisAction()));
		eventCardDeck.addCards(new EventCard("Alea Iactua Est", new AleaIactaEstAction()));
		eventCardDeck.addCards(new EventCard("Abundans Cautela Non Nocet", new AbundansCautelaAction()));
		eventCardDeck.addCards(new EventCard("Melius Cavere Quam Pavere", new MeliusCavereAction()));
		eventCardDeck.addCards(new EventCard("Festina Lente", new FestinaLenteAction()));
		eventCardDeck.addCards(new EventCard("Si Vis Pacem, Para Bellum", new ParaBellumAction()));
		eventCardDeck.addCards(new EventCard("Carpe Diem", new CarpeDiemAction()));
		eventCardDeck.addCards(new EventCard("Veni Vidi Vici", new VeniVidiViciAction()));
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
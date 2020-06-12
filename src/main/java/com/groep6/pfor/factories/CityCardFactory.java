package com.groep6.pfor.factories;

import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.parsers.CityCardParser;

/**
 *
 * @author Nils van der Velden
 */

import java.text.ParseException;
import java.util.function.Predicate;

public class CityCardFactory {
	
	private static final CityCardFactory INSTANCE = new CityCardFactory();
	private Deck cityCardDeck = new Deck();
	
	private CityCardFactory() {
		CityCardParser parser = new CityCardParser();
		try {
			cityCardDeck.addCards(parser.parseFile("citycards.json"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public CityCard getCardByName(String name, Faction faction) {
		for (Card card: cityCardDeck.getCards()) {
			if (card instanceof CityCard) {
				CityCard cityCard = (CityCard) card;
				if (cityCard.getName().equals(name) && cityCard.getFaction().equals(faction)) return cityCard;
			}
		}

		System.out.println("[ERROR] No city card found");
		return null;
	}

	public static CityCardFactory getInstance() {
		return INSTANCE;
	}

	public Deck getCityCardDeck() {
		return cityCardDeck;
	}
}

package com.groep6.pfor.factories;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.parsers.CityCardParser;

/**
 *
 * @author Nils van der Velden
 */

import java.text.ParseException;

/**
 * Creates CityCards
 *
 * @author Owen Elderbroek
 */
public class CityCardFactory {
	/** The instance of this singleton class */
	private static final CityCardFactory INSTANCE = new CityCardFactory();

	/** The list of available city cards */
	private Deck cityCardDeck = new Deck();

	/**
	 * Creates the CityCardFactory instance
	 * @return The new instance
	 */
	private CityCardFactory() {
		CityCardParser parser = new CityCardParser();
		try {
			cityCardDeck.addCards(parser.parseFile("/citycards.json"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtains a city card instance by its name
	 * @param name The name of the city card
	 * @return The city card instance or null if not found
	 */
	public CityCard getCardByName(String name, Faction faction) {
		for (Card card: cityCardDeck.getCards()) {
			if (card instanceof CityCard) {
				CityCard cityCard = (CityCard) card;
				if (cityCard.getName().equals(name) && cityCard.getFaction().equals(faction)) return cityCard;
			}
		}

		if (Config.DEBUG) System.out.println("[ERROR] No city card found");
		return null;
	}

	/**
	 * Returns the instance of the CityCardFactory
	 * @return The CityCardFactory instance
	 */
	public static CityCardFactory getInstance() {
		return INSTANCE;
	}

	/**
	 * Get a deck containing all city cards currently loaded into the game
	 * @return A deck of city cards
	 */
	public Deck getCityCardDeck() {
		return cityCardDeck;
	}
}

package com.groep6.pfor.factories;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.cards.InvasionCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.parsers.InvasionCardParser;

import java.text.ParseException;

/**
 * Creates InvasionCards
 *
 * @author Owen Elderbroek
 */
public class InvasionCardFactory {
    /** The instance of this singleton class */
    private static final InvasionCardFactory SINGLE_INSTANCE = new InvasionCardFactory();

    /** The list of available invasion cards */
    private InvasionCard[] cards;

    /** Creates the InvasionCardFactory instance */
    private InvasionCardFactory() {
        try {
            cards = new InvasionCardParser().parseFile("/invasions.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the instance of the InvasionCardFactory
     * @return The InvasionCardFactory instance
     */
    public static InvasionCardFactory getInstance() {
        return SINGLE_INSTANCE;
    }

    /**
     * Get an array of all the invasion cards currently loaded into the game
     * @return An array of available invasion cards
     */
    public InvasionCard[] getAllInvasionCards() {
        return cards;
    }

    /**
     * Get the amount of invasion cards in the game
     * @return The amount of invasion cards in the game
     */
    public int cardCount() {
        return cards.length;
    }

    /**
     * Obtains an invasion card instance by its name
     * @param name The name of the invasion card
     * @return The invasion card instance or null if not found
     */
    public InvasionCard getInvasionCardByName(String name, Faction faction) {
        for (InvasionCard card : cards) {
            if (card.getName().toUpperCase().equals(name.toUpperCase()) && card.getFaction().equals(faction)) return card;
        }
        if (Config.DEBUG) System.out.printf("[WARNING] No InvasionCard was found with the name '%s'\n", name);
        return null;
    }
}

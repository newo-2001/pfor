package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.FactionType;

/**
 * Represents a revolt card
 * @author Bastiaan Jansen
 */
public class RevoltCard extends Card {
    private final String name;
    private final City location;
    private final FactionType factionType;

    /**
     * @param name
     * @param location
     * @param factionType
     */
    public RevoltCard(String name, City location, FactionType factionType) {
        this.name = name;
        this.location = location;
        this.factionType = factionType;
    }

    /**
     * @return City
     */
    public City revolt() {
        // I. Increase

        // II. Revolt

        // III. Intensify

        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return City
     */
    public City getLocation() {
        return location;
    }

    /**
     * @return Faction
     */
    public FactionType getFactionType() {
        return factionType;
    }
}

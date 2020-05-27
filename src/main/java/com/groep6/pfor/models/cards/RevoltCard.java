package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Faction;

/**
 * Represents a revolt card
 * @author Bastiaan Jansen
 */
public class RevoltCard extends Card {
    private String name;
    private City location;
    private Faction faction;

    /**
     * @param name
     * @param location
     * @param faction
     */
    public RevoltCard(String name, City location, Faction faction) {
        this.name = name;
        this.location = location;
        this.faction = faction;
    }

    /**
     * @return City
     */
    public City revolt() {
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
    public Faction getFaction() {
        return faction;
    }
}

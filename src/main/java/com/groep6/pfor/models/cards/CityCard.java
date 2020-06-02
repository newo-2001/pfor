package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.FactionType;

/**
 * Represents a city card
 * @author Bastiaan Jansen
 */
public class CityCard extends Card {

    private String name;
    private City city;
    private FactionType factionType;

    /**
     * @param name
     * @param city
     * @param factionType
     */
    public CityCard(String name, City city, FactionType factionType) {
        this.name = name;
        this.city = city;
        this.factionType = factionType;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return City
     */
    public City getCity() {
        return city;
    }

    /**
     * @return Faction
     */
    public FactionType getFactionType() {
        return factionType;
    }
}

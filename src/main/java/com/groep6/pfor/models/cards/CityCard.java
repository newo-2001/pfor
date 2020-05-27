package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Faction;

/**
 * Represents a city card
 * @author Bastiaan Jansen
 */
public class CityCard extends Card {

    private String name;
    private City city;
    private Faction faction;

    /**
     * @param name
     * @param city
     * @param faction
     */
    public CityCard(String name, City city, Faction faction) {
        this.name = name;
        this.city = city;
        this.faction = faction;
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
    public Faction getFaction() {
        return faction;
    }
}

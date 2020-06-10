package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

/**
 * Represents a city card
 * @author Bastiaan Jansen
 */
public class CityCard extends Card {

    private String name;
    private City city;
    private Faction faction;

    /**
     * @param city
     * @param faction
     */
    public CityCard(City city, Faction faction) {
        this.city = city;
        this.faction = faction;
        this.name = this.city.getName();
    }

    @Override
    public String getName() {
        return city.getName();
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

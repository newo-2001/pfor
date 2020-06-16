package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.Faction;

import java.util.List;

/**
 * Represents an invasion card
 * @author Bastiaan Jansen
 */
public class InvasionCard extends Card {

    private final String name;
    private final List<City> route;
    private final Faction faction;

    /**
     * @param name
     * @param faction
     * @param route
     */
    public InvasionCard(String name, Faction faction, List<City> route) {
        this.name = name;
        this.route = route;
        this.faction = faction;
    }

    /**
     * @return City
     */
    public City invade() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return Faction
     */
    public Faction getFaction() {
        return faction;
    }

    /**
     * @return City
     */
    public City getDestination() {
        return route.get(route.size() - 1);
    }

    public List<City> getRoute() {
        return route;
    }
}

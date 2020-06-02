package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.FactionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an invasion card
 * @author Bastiaan Jansen
 */
public class InvasionCard extends Card {

    private String name;
    private List<City> route;
    private FactionType factionType;

    /**
     * @param name
     * @param factionType
     * @param route
     */
    public InvasionCard(String name, FactionType factionType, ArrayList<City> route) {
        this.name = name;
        this.route = route;
        this.factionType = factionType;
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
    public FactionType getFactionType() {
        return factionType;
    }

    /**
     * @return City
     */
    public City getDestination() {
        return route.get(route.size() - 1);
    }
}

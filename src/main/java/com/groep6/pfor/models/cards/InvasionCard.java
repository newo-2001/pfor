package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Faction;

import java.util.ArrayList;
import java.util.List;

public class InvasionCard extends Card {

    private String name;
    private List<City> route = new ArrayList<>();
    private Faction faction;

    public InvasionCard(String name, Faction faction, ArrayList<City> route) {
        this.name = name;
        this.route = route;
        this.faction = faction;
    }

    public City invade() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public Faction getFaction() {
        return faction;
    }

    public City getDestination() {
        return route.get(route.size() - 1);
    }
}

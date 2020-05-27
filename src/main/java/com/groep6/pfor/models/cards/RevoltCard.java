package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Faction;

public class RevoltCard extends Card {
    private String name;
    private City location;
    private Faction faction;

    public RevoltCard(String name, City location, Faction faction) {
        this.name = name;
        this.location = location;
        this.faction = faction;
    }

    public City revolt() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public City getLocation() {
        return location;
    }

    public Faction getFaction() {
        return faction;
    }
}

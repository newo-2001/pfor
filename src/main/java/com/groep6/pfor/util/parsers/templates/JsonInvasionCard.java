package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.cards.InvasionCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

import java.util.ArrayList;
import java.util.List;

/**
 * The Json representation of an Invasion card
 *
 * @author Owen Elderbroek
 */
public class JsonInvasionCard {
    /** The route the barbarians will follow */
    private String[] route;

    /** The name of this card */
    private String name;

    /** The faction that will move along this track */
    private String faction;

    /**
     * Convert this json object to the model that it represents
     * @return The InvasionCard instance this model represents
     */
    public InvasionCard toModel() {
        Faction faction = FactionFactory.getInstance().getFaction(FactionType.valueOf(this.faction));
        List<City> route = new ArrayList<>();
        for (String name : this.route) route.add(CityFactory.getInstance().getCityByName(name));
        return new InvasionCard(name, faction, route);
    }
}

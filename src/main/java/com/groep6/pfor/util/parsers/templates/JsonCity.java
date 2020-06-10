package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.Faction;

/**
 * The Data Transfer Object that represents a City in json
 *
 * @author Owen Elderbroek
 */
public class JsonCity {
    /** The tile that this city is based on, in its DTO form */
    @SerializedName("tile")
    private JsonTile tile;

    /** The name of city */
    @SerializedName("name")
    private String name;

    /** Whether the city has a harbour */
    @SerializedName("harbour")
    private boolean harbour;

    /**
     * Gets the model that is represented by this Data Transfer Object
     * @return The city that this object represents
     */
    public City toModel() {
        Faction[] factions = new Faction[this.tile.getFactions().length];
        for (int i = 0; i < this.tile.getFactions().length; i++) factions[i] = FactionFactory.getInstance().getFaction(this.tile.getFactions()[i]);
        return new City(name, harbour, tile.getPosition().toModel(), factions);
    }

    public String[] getNeighbours() {
        return tile.getNeighbours();
    }

    public String getName() {
        return name;
    }
}

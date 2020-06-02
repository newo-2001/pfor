package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.factions.Faction;

public class CityDTO {
    @SerializedName("tile")
    private TileDTO tile;

    @SerializedName("name")
    private String name;

    @SerializedName("harbour")
    private boolean harbour;

    public City toModel() {
        Faction[] factions = new Faction[this.tile.getFactions().length];
        for (int i = 0; i < this.tile.getFactions().length; i++) factions[i] = FactionFactory.getInstance().getFaction(this.tile.getFactions()[i]);
        return new City(name, harbour, tile.getPosition().toModel(), factions);
    }
}

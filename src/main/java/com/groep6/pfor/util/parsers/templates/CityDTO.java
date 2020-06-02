package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.models.City;

public class CityDTO {
    @SerializedName("tile")
    private TileDTO tile;

    @SerializedName("name")
    private String name;

    @SerializedName("harbour")
    private boolean harbour;

    public City toModel() {
        return new City(name, harbour, tile.getPosition().toModel(), tile.getFactionTypes());
    }
}

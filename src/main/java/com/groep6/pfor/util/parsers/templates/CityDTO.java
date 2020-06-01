package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.models.City;

/**
 * The Data Transfer Object that represents a City in json
 *
 * @author Owen Elderbroek
 */
public class CityDTO extends DTO {
    /** The tile that this city is based on, in its DTO form */
    @SerializedName("tile")
    private TileDTO tile;

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
        return new City(name, harbour, tile.getPosition().toModel(), tile.getFactions());
    }
}

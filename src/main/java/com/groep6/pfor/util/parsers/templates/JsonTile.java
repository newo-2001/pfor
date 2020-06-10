package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.models.factions.FactionType;

/**
 * The Data Transfer Object that represents a Tile in json
 *
 * @author Owen Elderbroek
 */
public class JsonTile {
    /** The position of the tile on the board in its DTO form */
    @SerializedName("position")
    private JsonVector2f position;

    /** The names of the neighbouring cities */
    @SerializedName("neighbours")
    private String[] neighbours;

    /** The factions that are allowed in the city */
    @SerializedName("factions")
    private FactionType[] factions;

    /**
     * Obtain the position vector of this city in its DTO form
     * @return The position Data Transfer Object
     */
    public JsonVector2f getPosition() {
        return position;
    }

    /**
     * Obtain the list of factions in this city
     * @return The list of factions in this city
     */
    public FactionType[] getFactions() {
        return factions;
    }

    /**
     * Obtain a list of names of the cities that neighbour this one
     * @return A list of names of neighbouring cities
     */
    public String[] getNeighbours() {
        return neighbours;
    }
}

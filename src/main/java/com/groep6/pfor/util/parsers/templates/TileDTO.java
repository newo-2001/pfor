package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.models.Faction;

/**
 * The Data Transfer Object that represents a Tile in json
 *
 * @author Owen Elderbroek
 */
public class TileDTO extends DTO {
    /** The position of the tile on the board in its DTO form */
    @SerializedName("position")
    private Vector2fDTO position;

    /** The names of the neighbouring cities */
    @SerializedName("neighbours")
    private String[] neighbours;

    /** The factions that are allowed in the city */
    @SerializedName("factions")
    private Faction[] factions;

    /**
     * Obtain the position vector of this city in its DTO form
     * @return The position Data Transfer Object
     */
    public Vector2fDTO getPosition() {
        return position;
    }

    /**
     * Obtain the list of factions in this city
     * @return The list of factions in this city
     */
    public Faction[] getFactions() {
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

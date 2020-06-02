package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.models.factions.FactionType;

public class TileDTO {
    @SerializedName("position")
    private Vector2fDTO position;

    @SerializedName("neighbours")
    private String[] neighbours;

    @SerializedName("factions")
    private FactionType[] factionTypes;

    public Vector2fDTO getPosition() {
        return position;
    }

    public FactionType[] getFactionTypes() {
        return factionTypes;
    }

    public String[] getNeighbours() {
        return neighbours;
    }
}

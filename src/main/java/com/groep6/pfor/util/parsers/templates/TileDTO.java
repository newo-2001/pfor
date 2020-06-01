package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.models.Faction;

public class TileDTO {
    @SerializedName("position")
    private Vector2fDTO position;

    @SerializedName("neighbours")
    private String[] neighbours;

    @SerializedName("factions")
    private Faction[] factions;

    public Vector2fDTO getPosition() {
        return position;
    }

    public Faction[] getFactions() {
        return factions;
    }

    public String[] getNeighbours() {
        return neighbours;
    }
}

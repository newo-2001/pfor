package com.groep6.pfor.models.factions;

import com.groep6.pfor.Config;
import javafx.scene.paint.Color;

public class Faction {

    private FactionType factionType;
    private Color color;

    public Faction(FactionType factionType, Color color) {
        this.factionType = factionType;
        this.color = color;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return factionType.name();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Faction)) {
            if (Config.DEBUG) System.out.println("[WARNING] Faction compare failed, because types were incompatible");
            return false;
        }
        return ((Faction) o).factionType == factionType;
    }
}

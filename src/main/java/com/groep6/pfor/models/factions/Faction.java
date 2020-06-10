package com.groep6.pfor.models.factions;

import com.groep6.pfor.models.Game;
import javafx.scene.paint.Color;

public class Faction {

    private FactionType factionType;
    private Color color;
    private int cardCountForAlliance;

    public Faction(FactionType factionType, Color color, int cardCountForAlliance) {
        this.factionType = factionType;
        this.color = color;
        this.cardCountForAlliance = cardCountForAlliance;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public Color getColor() {
        return color;
    }

    public int getCardCountForAlliance() {
        return cardCountForAlliance;
    }

    public void ally() {
        Game game = Game.getInstance();
        game.addFriendlyFaction(this);
    }

    @Override
    public String toString() {
        return factionType.name();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Faction)) return false;
        return ((Faction) o).factionType == factionType;
    }
}

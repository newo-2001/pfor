package com.groep6.pfor.models.factions;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.Vector2f;
import javafx.scene.paint.Color;

public class Faction {

    private final FactionType factionType;
    private final Color color;
    private final int cardCountForAlliance;
    private final Vector2f position;

    public Faction(FactionType factionType, Color color, int cardCountForAlliance, Vector2f position) {
        this.factionType = factionType;
        this.color = color;
        this.cardCountForAlliance = cardCountForAlliance;
        this.position = position;
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

    /**
     * Get position of the faction on the map (lower left)
     * @return A Vector2f object
     */
    public Vector2f getPosition() {
        return position;
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

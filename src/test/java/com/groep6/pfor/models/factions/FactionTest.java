package com.groep6.pfor.models.factions;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.Vector2f;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Bastiaan Jansen
 */
class FactionTest {

    private Faction faction;

    @BeforeEach
    void setUp() {
        this.faction = new Faction(FactionType.VISIGOTHS, Color.ORANGE, 3, new Vector2f(10, 20));
    }

    @AfterEach
    void tearDown() {
        this.faction = null;
    }

    @Test
    void getFactionType() {
        assertEquals(FactionType.VISIGOTHS, faction.getFactionType());
    }

    @Test
    void getColor() {
        assertEquals(Color.ORANGE, faction.getColor());
    }

    @Test
    void getCardCountForAlliance() {
        assertEquals(3, faction.getCardCountForAlliance());
    }

    @Test
    void ally() {
        Game game = Game.getInstance();
        faction.ally();
        assertEquals(faction, game.getFriendlyFactions().get(0));
    }

    @Test
    void getPosition() {
        assertEquals(new Vector2f(10, 20), faction.getPosition());
    }
}
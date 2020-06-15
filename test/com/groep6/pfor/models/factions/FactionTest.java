package com.groep6.pfor.models.factions;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.Vector2f;
import javafx.scene.paint.Color;
import junit.framework.TestCase;

/**
 * @author Bastiaan Jansen
 */
public class FactionTest extends TestCase {

    private Faction faction;
    private Game game;

    public void setUp() throws Exception {
        super.setUp();
        this.faction = new Faction(FactionType.VISIGOTHS, Color.ORANGE, 3, new Vector2f(10, 20));
        this.game = Game.getInstance();
    }

    public void tearDown() throws Exception {
        this.faction = null;
    }

    public void testGetFactionType() {
        assertEquals(FactionType.VISIGOTHS, faction.getFactionType());
    }

    public void testGetColor() {
        assertEquals(Color.ORANGE, faction.getColor());
    }

    public void testGetCardCountForAlliance() {
        assertEquals(3, faction.getCardCountForAlliance());
    }

    public void testAlly() {
        faction.ally();
        assertEquals(faction, game.getFriendlyFactions().get(0));
    }
}
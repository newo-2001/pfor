package com.groep6.pfor.factories;

import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.Vector2f;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class FactionFactory {

    private static final FactionFactory SINGLE_INSTANCE = new FactionFactory();

    List<Faction> factions = new ArrayList<>();

    private FactionFactory() {
        float y = 0.96662f;
        factions.add(new Faction(FactionType.ANGLO_SAXSONS_FRANKS, Color.ORANGE, 4, new Vector2f(0.20166f, y)));
        factions.add(new Faction(FactionType.VANDALS, Color.BLACK, 5, new Vector2f(0.0545f, y)));
        factions.add(new Faction(FactionType.HUNS, Color.GREEN, 4, new Vector2f(0.1483f, y)));
        factions.add(new Faction(FactionType.VISIGOTHS, Color.WHITE, 5, new Vector2f(0.10083f, y)));
        factions.add(new Faction(FactionType.OSTROGOTHS, Color.BLUE, 3, new Vector2f(0.25666f, y)));
    }

    public static FactionFactory getInstance() {
        return SINGLE_INSTANCE;
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public Faction getFaction(FactionType factionType) {
        for (Faction faction: factions) {
            if (faction.getFactionType() == factionType) return faction;
        }

        return null;
    }
}

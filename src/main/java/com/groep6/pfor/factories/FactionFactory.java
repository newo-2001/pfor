package com.groep6.pfor.factories;

import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class FactionFactory {

    List<Faction> factions = new ArrayList<>();

    public FactionFactory() {
        factions.add(new Faction(FactionType.ANGLO_SAXSONS_FRANKS, Color.ORANGE));
        factions.add(new Faction(FactionType.VANDELS, Color.PURPLE));
        factions.add(new Faction(FactionType.HUNS, Color.GREEN));
        factions.add(new Faction(FactionType.VISIGOTHS, Color.WHITE));
        factions.add(new Faction(FactionType.OSTROGOTHS, Color.BLUE));
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

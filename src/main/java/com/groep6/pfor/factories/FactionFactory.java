package com.groep6.pfor.factories;

import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

import java.util.ArrayList;
import java.util.List;

public class FactionFactory {

    List<Faction> factions = new ArrayList<>();

    public FactionFactory() {
        factions.add(new Faction(FactionType.));
    }

}

package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.Barbarian;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Legion;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Represents a City in Firebase
 *
 * @author OwenElderbroek
 */
public class CityDTO extends DTO {
    public String name;
    public boolean fort;
    public int legions;
    public Map<String, Integer> barbarians = new HashMap<>();

    public CityDTO() {}

    private CityDTO(String name, boolean fort, int legions, Map<String, Integer> barbarians) {
        this.name = name;
        this.fort = fort;
        this.legions = legions;
        this.barbarians = barbarians;
    }

    public static CityDTO fromModel(City city) {
        Map<String, Integer> barbarians = new HashMap<>();
        for (Faction faction : FactionFactory.getInstance().getFactions()) barbarians.put(faction.getFactionType().toString(), 0);
        for (Barbarian barbarian : city.getBarbarians())
            barbarians.put(barbarian.getFactionType().toString(), barbarians.get(barbarian.getFactionType().toString()) + 1);
        return new CityDTO(city.getName(), city.hasFort(), city.getLegionCount(), barbarians);
    }

    public City toModel() {
        Stack<Legion> legions = new Stack<>();
        for (int i = 0; i < this.legions; i++) legions.push(new Legion());
        Stack<Barbarian> barbarians = new Stack<>();
        for (String faction : this.barbarians.keySet())
            for (int i = 0; i < this.barbarians.get(faction); i++)
                barbarians.push(new Barbarian(FactionType.valueOf(faction)));
        return new City(name, legions, barbarians, fort);
    }
}

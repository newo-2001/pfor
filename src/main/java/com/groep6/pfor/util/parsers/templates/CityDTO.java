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
public class CityDTO {
    public String name;
    public boolean fort;
    public int legions;
    public int barbarians;

    public CityDTO() {}

    private CityDTO(String name, boolean fort, int legions, int barbarians) {
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

        int barbs = barbarians.get(FactionType.VISIGOTHS.toString());
        barbs |= barbarians.get(FactionType.VANDALS.toString()) * 64;
        barbs |= (int) (barbarians.get(FactionType.ANGLO_SAXSONS_FRANKS.toString()) * Math.pow(64, 2));
        barbs |= (int) (barbarians.get(FactionType.HUNS.toString()) * Math.pow(64, 3));
        barbs |= (int) (barbarians.get(FactionType.OSTROGOTHS.toString()) * Math.pow(64, 4));
        return new CityDTO(city.getName(), city.hasFort(), city.getLegionCount(), barbs);
    }

    public City toModel() {
        Stack<Legion> legions = new Stack<>();
        for (int i = 0; i < this.legions; i++) legions.push(new Legion());
        Stack<Barbarian> barbarians = new Stack<>();
        // Use fancy bitfields to save immense amounts of strain on the database
        addBarbarians(FactionType.VISIGOTHS, this.barbarians & 63, barbarians);
        addBarbarians(FactionType.VANDALS, (this.barbarians & (63 << 6)) >> 6, barbarians);
        addBarbarians(FactionType.ANGLO_SAXSONS_FRANKS, (this.barbarians & (63 << 12)) >> 12, barbarians);
        addBarbarians(FactionType.HUNS, (this.barbarians & (63 << 18)) >> 18, barbarians);
        addBarbarians(FactionType.OSTROGOTHS, (this.barbarians & (63 << 24)) >> 24, barbarians);
        return new City(name, legions, barbarians, fort);
    }

    private void addBarbarians(FactionType faction, int count, Stack<Barbarian> stack) {
        for (int i = 0; i < count; i++) stack.push(new Barbarian(faction));
    }
}

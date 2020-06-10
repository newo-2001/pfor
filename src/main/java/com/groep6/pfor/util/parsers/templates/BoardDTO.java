package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.*;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

import java.util.HashMap;
import java.util.Map;

/**
 * The Data Transfer Object that represents the board object in Firebase
 *
 * @author OwenElderbroek
 */
public class BoardDTO {
    public Map<String, CityDTO> cities = new HashMap<>();
    public Map<String, Integer> barbarianBases = new HashMap();
    public int legionBase;

    public BoardDTO() {}

    private BoardDTO(Map<String, CityDTO> cities, int legionBase, Map<String, Integer> barbarianBases) {
        this.cities = cities;
        this.legionBase = legionBase;
        this.barbarianBases = barbarianBases;
    }

    public Board toModel() {
        Legion[] legions = new Legion[legionBase];
        for (int i = 0; i < legionBase; i++) legions[i] = new Legion();
        Base<Legion> legionBase = new Base<>(new Faction[] {}, legions);
        Map<Faction, Base<Barbarian>> barbarianBases = new HashMap<>();
        for (String faction : this.barbarianBases.keySet()) {
            Barbarian[] barbarians = new Barbarian[this.barbarianBases.get(faction)];
            for (int i = 0; i < this.barbarianBases.get(faction); i++)
                barbarians[i] = new Barbarian(FactionType.valueOf(faction));
            Faction fact = FactionFactory.getInstance().getFaction(FactionType.valueOf(faction));
            Base<Barbarian> base = new Base<>(new Faction[]{fact}, barbarians);
            barbarianBases.put(fact, base);
        }

        Map<String, Tile> cities = new HashMap<>();
        for (CityDTO city : this.cities.values()) cities.put(city.name, city.toModel());
        
        return new Board(cities, legionBase, barbarianBases);
    }

    public static BoardDTO fromModel(Board board) {
        Map<String, CityDTO> cities = new HashMap<>();
        for (Tile tile : board.getTiles()) {
            City city = (City) tile;
            cities.put(city.getName(), CityDTO.fromModel(city));
        }
        Map<String, Integer> barbarianBases = new HashMap<>();
        for (Base<Barbarian> base : board.getBarbarianBases().values())
            barbarianBases.put(base.getFaction().getFactionType().toString(), base.getPieceCount());

        return new BoardDTO(cities, board.getLegionBase().getPieceCount(), barbarianBases);
    }
}

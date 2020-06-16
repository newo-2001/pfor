package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.Vector2f;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the board
 *
 * @author Nils van der Velden
 */
public class Board {
	private Map<String, Tile> tiles = new HashMap<>();
	private Map<Faction, Base<Barbarian>> barbarianBases = new HashMap<>();
	private Base<Legion> legionBase = new Base<Legion>(new Vector2f(0, 0), new Faction[] {});

	public Board() {
		for (City city : CityFactory.getInstance().getAllCities()) tiles.put(city.getName(), city);
		for (Faction faction : FactionFactory.getInstance().getFactions())
			barbarianBases.put(faction, new Base(new Vector2f(0, 0), new Faction[]{faction}));
	}

	/**
	 * Construct a base from firebase data
	 * @param legionBase The base with legions
	 * @param barbarianBases A map containing all factions with their respective bases
	 * @return A Firebase instance of the board
	 */
	public Board(Map<String, Tile> tiles, Base<Legion> legionBase, Map<Faction, Base<Barbarian>> barbarianBases) {
		this.tiles = tiles;
		this.legionBase = legionBase;
		this.barbarianBases = barbarianBases;
	}

	/**
	 * Update this board with data from a firebase board
	 * @param board A board containing data from firebase
	 */
	public void updateBoard(Board board) {
		this.legionBase.updateBase(board.getLegionBase());
		for (Base<Barbarian> base : barbarianBases.values()) base.updateBase(board.getBarbarianBase(base.getFaction()));
		for (Tile tile : this.tiles.values()) {
			City city = (City) tile;
			city.updateCity((City) board.getTileByName(city.getName()));
		}
	}

	public Tile[] getTiles() {
		return tiles.values().toArray(new Tile[0]);
	}

	public Tile getTileByName(String name) {
		return tiles.get(name);
	}

	public Base<Legion> getLegionBase() {
		return legionBase;
	}

	public Base<Barbarian> getBarbarianBase(Faction faction) {
		return barbarianBases.get(faction);
	}

	public Map<Faction, Base<Barbarian>> getBarbarianBases() {
		return barbarianBases;
	}
}

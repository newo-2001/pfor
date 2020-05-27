package com.groep6.pfor.models;

/**
 * Represents a tile 
 *
 * @author Nils van der Velden
 */

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
	
	protected Vector2f position;
	protected List<Faction> factions = new ArrayList<Faction>();
	protected List<City> neighbouringCities = new ArrayList<City>();
	
	public Tile(Vector2f position, List<Faction> factions, List<City> neighbouringCities) {
		this.position = position;
		this.factions = factions;
		this.neighbouringCities = neighbouringCities;
	}
	
	public Vector2f getPosition() {
		return position;
	}
		
	public List<City> getNeighbouringCities() {
		return neighbouringCities;
	}
}

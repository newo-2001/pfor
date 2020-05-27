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
	
	/**
	 * Initializes a abstract Tile with the given components.
	 * @param position The Vector2f (position) of a specific tile
	 * @param factions What factions are allowed in a specific tile
	 * @param neighbouringCities Which city's have a direct connection to this tile
	 */
	
	public Tile(Vector2f position, List<Faction> factions, List<City> neighbouringCities) {
		this.position = position;
		this.factions = factions;
		this.neighbouringCities = neighbouringCities;
	}
	
    /**
     * @returns the position of a tile
     */
	
	public Vector2f getPosition() {
		return position;
	}
	
    /**
     * @returns a List of of neighboring cities 
     */
		
	public List<City> getNeighbouringCities() {
		return neighbouringCities;
	}
}

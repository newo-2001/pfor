package com.groep6.pfor.models;

import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.Observable;
import com.groep6.pfor.util.Vector2f;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tile 
 *
 * @author Nils van der Velden
 */
public abstract class Tile extends Observable {
	protected Vector2f position;
	protected Faction[] factions;
	protected List<City> neighbouringCities = new ArrayList<>();

	/**
	 * Initializes a abstract Tile with the given components.
	 * @param position The Vector2f (position) of a specific tile
	 * @param factions What factions are allowed in a specific tile
	 */
	public Tile(Vector2f position, Faction[] factions) {
		this.position = position;
		this.factions = factions;
	}
	
    /**
     * @returns the position of a tile
     */
	public Vector2f getPosition() {
		return position;
	}
	
    /**
     * @returns an array of neighboring cities
     */
	public City[] getNeighbouringCities() {
		return neighbouringCities.toArray(new City[0]);
	}

	/**
	 * Add a neighbouring city to this tile
	 * @param neighbour
	 */
	public void addNeighbour(City neighbour) {
		neighbouringCities.add(neighbour);
	}
}

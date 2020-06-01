package com.groep6.pfor.models;

import com.groep6.pfor.util.Vector2f;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
	protected Vector2f position;
	protected Faction[] factions;
	protected List<City> neighbouringCities = new ArrayList<>();

	public Tile(Vector2f position, Faction[] factions) {
		this.position = position;
		this.factions = factions;
	}
	
	public Vector2f getPosition() {
		return position;
	}
		
	public List<City> getNeighbouringCities() {
		return neighbouringCities;
	}

	public void addNeighbour(City neighbour) {
		neighbouringCities.add(neighbour);
	}
}

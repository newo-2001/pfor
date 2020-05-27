package com.groep6.pfor.models;

import java.util.ArrayList;

public abstract class Tile {
	
	protected Vector2f position;
	protected ArrayList<Faction> factions = new ArrayList<Faction>();
	protected ArrayList<City> neighbouringCities = new ArrayList<City>();
	
	public Vector2f getPosition() {
		return position;
	}
		
	public ArrayList<City> getNeighbouringCities() {
		return neighbouringCities;
	}
}

package com.groep6.pfor.models;

/**
 * Represents a city tile 
 *
 * @author Nils van der Velden
 */

import java.util.ArrayList;
import java.util.List;

public class City extends Tile {
	
	private List<Barbarian> barbarians = new ArrayList<Barbarian>();
	private List<Legion> legions = new ArrayList<Legion>();
	private boolean fort = false;
	private boolean harbour;
	private String name;
	
    /**
     * Initializes a new City with the given components.
     * @param name The name of a specific city
     * @param harbour Whether or not a city has a harbour
     * @param position The Vector2f (position) of a specific city
     * @param factions What factions are allowed in a specific city
     * @param neighbouringCities Which city's have a direct connection to this city
     */
	
	public City(String name, boolean harbour, Vector2f position, List<Faction> factions, List<City> neighbouringCities) {
		super(position, factions, neighbouringCities);
		this.name = name;
		this.harbour = harbour;
	}
	
    /**
     * @returns a arrayList with factions that can access the city 
     */
	
	public List<Faction> getFaction() {
		return factions;
	}
	
    /**
     * @returns the name of a specific city
     */
	
	public String getName() {
		return name;
	}
	
    /**
     * @param faction
     * @returns the amount of barbarians in a specific city
     */
	
	public int getBarbarianCount(Faction faction) {			//moet ik hier wel een faction mee geven? De barbarian lijst is toch al van een specifieke faction? 
		return barbarians.size();
	}
	
    /**
     * @returns the amount of legions in a specific city
     */
	
	public int getLegionCount() {
		return legions.size();
	}
	
    /**
     * @returns a arrayList with barbarians in a specific city
     */
	
	public List<Barbarian> getBarbarians() {
		return barbarians;
	}
	
    /**
     * @returns a boolean that represents whether a specific city has a fort or not
     */
	
	public boolean hasFort() {
		return fort;
	}
	
    /**
     * @returns a boolean that represents whether a specific city has a harbour or not
     */
	
	public boolean hasHarbour() {
		return harbour;
	}
	
    /**
     * adds a barbarian to a specific city
     * @param faction
     */
	
	public void addBarbarian(Faction faction) {
		barbarians.add(new Barbarian(faction));
	}
	
    /**
     * adds a legion to a specific city
     */
	
	public void addLegion() {
		legions.add(new Legion());
	}
	
    /**
     * @param faction
     * @return a barbarian and removes that specific barbarian from a specific city
     */
	
	public Barbarian removeBarbarian(Faction faction) {
		for(int x = 0; x < barbarians.size(); x++) {
			Barbarian barbarian = barbarians.get(x);
			
			if (barbarian.getFaction() == faction) {
				barbarians.remove(x);
				return barbarian;
			} 
		}
		return null;
	}

    /**
     * @return a legion and removes that specific legion from a city
     */
	
	public Legion removeLegion() {
		Legion legion = legions.get(0);
		legions.remove(0);
		return legion;
	}
	
    /**
     * places a fort in a specific city
     */
	
	public void placeFort() {
		this.fort = true;
	}
	
    /**
     * removes a fort from a specific city
     */
	
	public void removeFort() {
		this.fort = false;
	}
	
}

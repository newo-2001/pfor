package com.groep6.pfor.models;

import java.util.Stack;

/**
 * Represents a city tile 
 *
 * @author Nils van der Velden
 */

import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.Vector2f;
import com.groep6.pfor.util.parsers.templates.FactionDTO;

public class City extends Tile {
	private Stack<Barbarian> barbarians = new Stack<Barbarian>();
	private Stack<Legion> legions = new Stack<Legion>();
	private boolean fort = false;
	private boolean harbour;
	private String name;

	/**
	 * Initializes a new City with the given components.
     * @param name The name of a specific city
     * @param harbour Whether or not a city has a harbour
     * @param position The Vector2f (position) of a specific city
     * @param factions What factions are allowed in a specific city
     */
	public City(String name, boolean harbour, Vector2f position, Faction[] factions) {
		super(position, factions);
		this.name = name;
		this.harbour = harbour;
	}

    /**
     * @returns An array with factions that can access the city
     */
	public Faction[] getFactions() {
		return factions;
	}

	/**
     * @returns the name of a specific city
     */
	public String getName() {
		return name;
	}
	
    /**
     * @param factionType The faction to count the barbarians of
     * @returns the amount of barbarians in this city of the specified faction
     */
    public int getBarbarianCount(FactionType factionType) {
		int count = 0;
		for (Faction f : factions) {
			if (f.getFactionType() == factionType) count++;
		}
		return count;
	}

	/**
	 * @return The total amount of barbarians in this city of all factions combined
	 */
	public int getTotalBarbarianCount() {
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
	
	public Stack<Barbarian> getBarbarians() {
		return barbarians;
	}
	
	/**
     * @returns a arrayList with legions in a specific city
     */
	
	public Stack<Legion> getLegions() {
		return legions;
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
     * @param factionType
     */
	
	public void addBarbarian(FactionType factionType) {
		barbarians.add(new Barbarian(factionType));
	}
	
    /**
     * adds a legion to a specific city
     */
	
	public void addLegion() {
		legions.add(new Legion());
	}
	
    /**
     * @param factionType
     * @return a barbarian and removes that specific barbarian from a specific city
     */
	
	public Barbarian removeBarbarian(FactionType factionType) {
		for(int x = 0; x < barbarians.size(); x++) {
			Barbarian barbarian = barbarians.get(x);
			
			if (barbarian.getFactionType() == factionType) {
				return barbarians.remove(x);
			} 
		}
		return null;
	}

	/**
	 * @param amount
	 * @return Removed barbarian
	 */
	public void removeBarbarians(int amount) {
		for (int i = 0; i < amount; i++) {
			if (!barbarians.empty()) barbarians.pop();
		}
	}

    /**
	 * @param amount
     * @return a legion and removes that specific legion from a city
     */
	
	public void removeLegions(int amount) {
		for (int i = 0; i < amount; i++) {
			if (!legions.empty()) legions.pop();
		}
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

	@Override
	public String toString() {
		String s = String.format("City: %s, harbour: %b, position: %s, factions: [", name, harbour, position);
		for (Faction f : factions) {
			s += f.getFactionType().name() + ", ";
		}
		if (factions.length > 0) s = s.substring(0, s.length()-2);
		s += "], neighbours: [";
		for (City neighbour : neighbouringCities) {
			s += neighbour.getName() + ", ";
		}
		if (neighbouringCities.size() > 0) s = s.substring(0, s.length()-2);
		return s + "]";
	}
	
}

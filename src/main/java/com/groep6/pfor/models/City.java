package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Represents a city tile
 *
 * @author Nils van der Velden
 */

public class City extends Tile {
	
	private List<Barbarian> barbarians = new ArrayList<>();
	private List<Legion> legions = new ArrayList<>();
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
	 * Constructs a new city with data from a city from the remote server
	 * @param name The name of the city
	 * @param legions The legions in this city
	 * @param barbarians The barbarians in this city
	 * @param fort whether this city has a fort in it
	 * @return A new city instance
	 */
	public City(String name, Stack<Legion> legions, Stack<Barbarian> barbarians, boolean fort) {
		super(CityFactory.getInstance().getCityByName(name).position, CityFactory.getInstance().getCityByName(name).getFactions());
		this.legions = legions;
		this.barbarians = barbarians;
		this.fort = fort;
	}

	/**
	 * Updates this model with data from a city from the remote server
	 * @param city The city to copy the data from
	 */
	public void updateCity(City city) {
		this.barbarians = city.barbarians;
		this.legions = city.legions;
		this.fort = city.fort;
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
	
	public List<Barbarian> getBarbarians() {
		return barbarians;
	}
	
	/**
     * @returns a arrayList with legions in a specific city
     */
	
	public List<Legion> getLegions() {
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
	 * Check if a city has a specific faction (barbarian) in it
	 * @param faction The faction you want to check for
	 * @return Whether the faction is in it or not
	 */
	public boolean hasFaction(Faction faction) {
		for (Barbarian barbarian : barbarians) {
			if (faction.getFactionType().equals(barbarian.getFactionType())) return true;
		}
		return false;
	}
	
    /**
     * adds barbarians to a specific city
     * @param factionType
     */
	public void addBarbarians(FactionType factionType, int amount) {
		for (int i = 0; i < amount; i++) {
			barbarians.add(new Barbarian(factionType));

			if (barbarians.size() >= 4) {
				barbarians.clear();
				Game game = Game.getInstance();
				
				if (game != null) game.increaseDecayLevel(1);
				return; 
			}
		}
	}
	
    /**
     * @param factionType The faction to count the barbarians of
     * @returns the amount of barbarians in this city of the specified faction
     */
	
    public int getBarbarianCount(FactionType factionType, List<Barbarian> barbarians) {
		int count = 0;

		for (Barbarian barbarian : barbarians) {
			if (factionType == barbarian.getFactionType()) count++;
		}
		
		return count;
	}

	public int getBarbarianCount(FactionType factionType) {
		int count = 0;

		for (Barbarian barbarian : barbarians) {
			if (factionType == barbarian.getFactionType()) count++;
		}

		return count;
	}
	
    /**
     * adds a legion to a specific city
     */
	public void addLegions(int amount) {
		for (int i = 0; i < amount; i++) {
			legions.add(new Legion());
		}

		notifyObservers();
	}
	
    /**
     * @param factionType
     * @return a barbarian and removes that specific barbarian from a specific city
     */
	
	public void removeBarbarians(FactionType factionType, int amount) {
		for (int x = 0; x < barbarians.size(); x++) {
			Barbarian barbarian = barbarians.get(x);
			for (int i = 0; i < amount; i++) {
				if (barbarian.getFactionType() == factionType) {
					barbarians.remove(x);
				}
			}
		}

		notifyObservers();
	}

	/**
	 * @param amount
	 * @return Removed barbarian
	 */
	public void removeBarbarians(int amount) {
		for (int i = 0; i < amount; i++) {
			if (barbarians.size() > 0) barbarians.remove(0);
		}

		notifyObservers();
	}

    /**
	 * @param amount
     */
	
	public void removeLegions(int amount) {
		for (int i = 0; i < amount; i++) {
			if (legions.size() > 0) legions.remove(0);
		}

		notifyObservers();
	}
	
    /**
     * places a fort in a specific city
     */
	public void placeFort() {
		this.fort = true;
		notifyObservers();
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

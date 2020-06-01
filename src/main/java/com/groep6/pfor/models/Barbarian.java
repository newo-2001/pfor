package com.groep6.pfor.models;

/**
 * Represents a barbarian
 *
 * @author Nils van der Velden
 */

public class Barbarian extends Piece {
	private Faction faction;
	
    /**
     * Initializes a new Barbarian with the given components.
     * @param faction The faction the barbarian belongs to
     */
	
	public Barbarian(Faction faction) {
		this.faction = faction;
	}
	
    /**
     * @return the faction a specific barbarian belongs to
     */
	
	public Faction getFaction() {
		return faction;
	}
}

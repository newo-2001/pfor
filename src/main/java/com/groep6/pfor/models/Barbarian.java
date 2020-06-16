package com.groep6.pfor.models;

import com.groep6.pfor.models.factions.FactionType;

/**
 * Represents a barbarian
 *
 * @author Nils van der Velden
 */

public class Barbarian extends Piece {
	private final FactionType factionType;
	
    /**
     * Initializes a new Barbarian with the given components.
     * @param factionType The faction the barbarian belongs to
     */
	
	public Barbarian(FactionType factionType) {
		this.factionType = factionType;
	}
	
    /**
     * @return the faction a specific barbarian belongs to
     */
	
	public FactionType getFactionType() {
		return factionType;
	}
}

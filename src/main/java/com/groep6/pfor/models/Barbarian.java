package com.groep6.pfor.models;

public class Barbarian extends Piece {
	private Faction faction;
	
	public Barbarian(Faction faction) {
		this.faction = faction;
	}

	public Faction getFaction() {
		return faction;
	}
}

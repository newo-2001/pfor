package com.groep6.pfor.models;

import java.util.ArrayList;

public class City extends Tile {
	
	private ArrayList<Barbarian> barbarians = new ArrayList<Barbarian>();
	private ArrayList<Legion> legions = new ArrayList<Legion>();
	private boolean fort;
	private boolean harbour;
	private String name;
	
	public City() {
		
	}
	
	public ArrayList<Faction> getFaction() {
		return factions;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBarbarianCount(Faction faction) {
		return barbarians.size();
	}
	
	public int getLegionCount() {
		return legions.size();
	}
	
	public ArrayList<Barbarian> getBarbarians() {
		return barbarians;
	}
	
	public boolean hasFort() {
		return fort;
	}
	
	public boolean hasHarbour() {
		return harbour;
	}
	
	public void addBarbarian(Faction faction) {
		barbarians.add(new Barbarian(faction));
	}
	
	public void addLegion() {
		legions.add(new Legion());
	}
	
	public Barbarian removeBarbarian(Faction faction) {
		Barbarian barbarian = barbarians.get(0);
		barbarians.remove(0);
		return barbarian;
	}
	
	public Legion removeLegion() {
		Legion legion = legions.get(0);
		legions.remove(0);
		return legion;
	}
	
	public void placeFort() {
		this.fort = true;
	}
	
	public void removeFort() {
		this.fort = false;
	}
	
}

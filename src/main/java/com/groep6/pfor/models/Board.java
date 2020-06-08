package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.util.parsers.CityParser;

import java.text.ParseException;

/**
 * Represents the board
 *
 * @author Nils van der Velden
 */
public class Board {
	private Tile[] tiles = new Tile[0];

	public Board() {
		tiles = CityFactory.getInstance().getAllCities();
	}

	public Tile[] getTiles() {
		return tiles;
	}
}

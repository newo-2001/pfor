package com.groep6.pfor.models;

/**
 * Represents a barbarian base
 *
 * @author Nils van der Velden
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base<T extends Piece> extends Tile {
	private List<T> pieces = new ArrayList<T>();
	
    /**
     * Initializes a new City with the given components.
     * @param position The Vector2f (position) of a specific base
     * @param factions What factions are allowed in a specific base
     * @param neighbouringCities Which city's have a direct connection to this base
     */
	
	public Base(Vector2f position, List<Faction> factions, List<City> neighbouringCities, T... pieces) {
		super(position, factions, neighbouringCities);
		addPieces(pieces);
	}
	
    /**
     * @returns what faction has acces to a specific base
     */
	
	public Faction getFaction() {
		return factions.get(0);
	}
	
    /**
     * @returns the amount of barbarians in a base
     */
	
	public int getPieceCount() {
		return pieces.size();
	}
	
    /**
     * @param T... pieces Ads a variable amount of pieces to base
     */
	
	public void addPieces(T... pieces) {
		this.pieces.addAll(Arrays.asList(pieces));
	}
	
    /**
     * @returns the piece that was removed
     */
	
	public T removePiece() {
		if (pieces.size() <= 0) return null;
		return pieces.remove(0);
	}
	
    /**
     * @param pieceCount The specified amount of pieces that need to be removed from a base
     * @returns a list with the pieces that where removed
     */
	
	public List<T> removePieces(int piecesCount) {
		List<T> removed = new ArrayList<T>();
		for(int i = 0; i < Math.min(piecesCount, pieces.size()); i++) removed.add(this.pieces.remove(0));
		return removed;
	}
}

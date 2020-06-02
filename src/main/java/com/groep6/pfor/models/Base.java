package com.groep6.pfor.models;

import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.Vector2f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Represents a barbarian base
 *
 * @author Nils van der Velden
 */

public class Base<T extends Piece> extends Tile {
	private List<T> pieces = new ArrayList<T>();

	/**
	 * Initializes a new City with the given components.
	 * @param position The Vector2f (position) of a specific base
	 * @param factionType What faction is allowed in a specific base
	 */
	public Base(Vector2f position, FactionType factionType, T... pieces) {
		super(position, new FactionType[]{factionType});
	}
	
    /**
     * @returns what faction has access to a specific base
     */
	
	public FactionType getFaction() {
		return factionTypes[0];
	}
	
    /**
     * @returns the amount of barbarians in a base
     */
	
	public int getPieceCount() {
		return pieces.size();
	}
	
    /**
     * @param pieces Adds a variable amount of pieces to base
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
	
	public List<T> removePieces(int pieceCount) {
		List<T> removed = new ArrayList<T>();
		for(int i = 0; i < Math.min(pieceCount, pieces.size()); i++) removed.add(this.pieces.remove(0));
		return removed;
	}
}

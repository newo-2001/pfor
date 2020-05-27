package com.groep6.pfor.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base<T extends Piece> extends Tile {
	private List<T> pieces = new ArrayList<T>();
	
	public Base(Vector2f position, List<Faction> factions, List<City> neighbouringCities, T... pieces) {
		super(position, factions, neighbouringCities);
		addPieces(pieces);
	}
	
	public Faction getFaction() {
		return factions.get(0);
	}
	
	public int getPieceCount() {
		return pieces.size();
	}
	
	public void addPieces(T... pieces) {
		this.pieces.addAll(Arrays.asList(pieces));
	}
	
	public T removePiece() {
		if (pieces.size() <= 0) return null;
		return pieces.remove(0);
	}
	
	public List<T> removePieces(int piecesCount) {
		List<T> removed = new ArrayList<T>();
		for(int i = 0; i < Math.min(piecesCount, pieces.size()); i++) removed.add(this.pieces.remove(0));
		return removed;
	}
}

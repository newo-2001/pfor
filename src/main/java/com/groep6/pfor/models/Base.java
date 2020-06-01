package com.groep6.pfor.models;

import com.groep6.pfor.util.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Base<T extends Piece> extends Tile {
	private List<T> pieces = new ArrayList<T>();
	
	public Base(Vector2f position, Faction faction, T... pieces) {
		super(position, new Faction[]{faction});
		addPieces(pieces);
	}
	
	public Faction getFaction() {
		return factions[0];
	}
	
	public int getPieceCount() {
		return pieces.size();
	}
	
	public void addPieces(T... pieces) {
		for (T piece : pieces) this.pieces.add(piece);
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

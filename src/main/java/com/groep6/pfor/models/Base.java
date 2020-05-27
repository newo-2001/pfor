package com.groep6.pfor.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base<T extends Piece> extends Tile {
	private List<T> pieces = new ArrayList<T>();
	
	public Base(T... pieces) {
		this.pieces = Arrays.asList(pieces);
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
	
	public T[] removePieces(int piecesCount) {
		piecesCount = Math.min(piecesCount, pieces.size());
		List<T> removed = new ArrayList<T>();
		for(int i = 0; i < piecesCount; i++) removed.add(this.pieces.remove(0));
		return (T[]) removed.toArray();
	}
}

package com.groep6.pfor.models;

import java.util.ArrayList;
import java.util.List;

public class Base<T extends Piece> extends Tile {
	
	private List<T> pieces = new ArrayList<T>();
	
	public Base(ArrayList<T> pieces) {
		this.pieces = pieces;
	}
	
	public Faction getFaction() {
		Faction faction = factions.get(0);
		return faction;
	}
	
	public int getPieceCount() {
		return pieces.size();
	}
	
	public void addPieces(ArrayList<T> pieces) {				//Dit klopt niet maar ik weet het even niet
		this.pieces.addAll(pieces);	
	}
	
	public T removePiece() {
		T piece = pieces.get(0);
		pieces.remove(0);
		return piece;
	}
	
	public List<T> removePieces(int pieces) {
		while(this.pieces.size() > 0) {
			for(int x = 0; x < pieces; x += 1) {
				this.pieces.remove(0);
		}
			return this.pieces;
		} 
		return this.pieces;
	}
}

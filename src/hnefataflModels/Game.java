package hnefataflModels;

import java.util.HashMap;

public class Game {
	private HashMap<Integer[][], Piece> pieces;

	public Game(HashMap<Integer[][], Piece> pieces) {
		super();
		this.setPieces(pieces);
	}

	public HashMap<Integer[][], Piece> getPieces() {
		return pieces;
	}

	public void setPieces(HashMap<Integer[][], Piece> pieces) {
		this.pieces = pieces;
	}
	
	public boolean movePiece(int startX, int startY, int endX, int endY) {
		return false;
		
	}
	
	public HashMap<Integer[][], Piece> update() {
		return null;
		
	}
	
	private void updateHashMap() {
		
	}
}

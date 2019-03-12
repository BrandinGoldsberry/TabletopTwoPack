package hnefataflModels;

import java.util.Arrays;

import controllers.Hnefatafl;

public class Game {
	private Piece[][] pieces;

	public Game(Piece[][] pieces) {
		super();
		this.setPieces(pieces);
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public void setPieces(Piece[][] pieces) {
		this.pieces = pieces;
	}

	public boolean movePiece(int startX, int startY, int endX, int endY) {
		boolean canMove = false;
		Piece toMove = null;

		if (startX != endX && startY != endY) {
			canMove = false;
		} else {
			toMove = pieces[startX][startY];

			if (toMove == null) {
				canMove = false;
			} else {
				canMove = true;

				if (startX == endX) {
					if (startY > endY) {
						for (int i = startY - 1; i >= endY; i--) {
							if (pieces[startX][i] != null) {
								canMove = false;
							}
						}
					}

					if (startY < endY) {
						for (int i = startY + 1; i <= endY; i++) {
							if (pieces[startX][i] != null) {
								canMove = false;
							}
						}
					}

				} else if (startY == endY) {
					if (startX > endX) {
						for (int i = startX - 1; i >= endX; i--) {
							if (pieces[i][startY] != null) {
								canMove = false;
							}
						}
					}

					if (startX < endX) {
						for (int i = startX + 1; i <= endX; i++) {
							if (pieces[i][startY] != null) {
								canMove = false;
							}
						}
					}
				}
			}
		}

		if (canMove) {

			pieces[endX][endY] = toMove;
			pieces[startX][startY] = null;
			Hnefatafl.SetKingIsDead(update());
			Hnefatafl.update();
		}

		return canMove;
	}

	public boolean update() { 
		boolean KingDied = false;
		
		for(int x = 0; x < 11; x++) {
			for(int y = 0; y < 11; y++) {
				if(x - 1 > -1 && y - 1 > -1 && x + 1 < 11 && y + 1 < 11) {
					Piece toCheck = pieces[x][y];
					if(toCheck != null) {
						if(toCheck.toString().equals("Attacker")) {
							if(pieces[x - 1][y] != null && pieces[x + 1][y] != null) {
								if(pieces[x - 1][y].toString().equals("Defender") || pieces[x - 1][y].toString().equals("King")) {
									if(pieces[x + 1][y].toString().equals("Defender") || pieces[x + 1][y].toString().equals("King")) {
										pieces[x][y] = null;
									}
								}
							}
							
							if(pieces[x][y - 1] != null && pieces[x][y + 1] != null) {
								if(pieces[x][y - 1].toString().equals("Defender") || pieces[x][y - 1].toString().equals("King")) {
									if(pieces[x][y + 1].toString().equals("Defender") || pieces[x][y + 1].toString().equals("King")) {
										pieces[x][y] = null;
									}
								}
							}
						}
						if(toCheck.toString().equals("Defender")) {
							if(pieces[x - 1][y] != null && pieces[x + 1][y] != null) {
								if(pieces[x - 1][y].toString().equals("Attacker")) {
									if(pieces[x + 1][y].toString().equals("Attacker")) {
										pieces[x][y] = null;
									}
								}
							}
							
							if(pieces[x][y - 1] != null && pieces[x][y + 1] != null) {
								if(pieces[x][y - 1].toString().equals("Attacker")) {
									if(pieces[x][y + 1].toString().equals("Attacker")) {
										pieces[x][y] = null;
									}
								}
							}
						}
						if(toCheck.toString().equals("King")) {
							if(pieces[x - 1][y] != null && pieces[x + 1][y] != null && pieces[x][y - 1] != null && pieces[x][y + 1] != null) {
								if(pieces[x - 1][y].toString().equals("Attacker")) {
									if(pieces[x + 1][y].toString().equals("Attacker")) {
										if(pieces[x][y - 1].toString().equals("Attacker")) {
											if(pieces[x][y + 1].toString().equals("Attacker")) {
												pieces[x][y] = null;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return KingDied;
	}

//	private HashMap<CoordinateKey, Piece> clonePieces() {
//		HashMap<CoordinateKey, Piece> ret = new HashMap<>();
//		
//		Set<CoordinateKey> keys = pieces.keySet();
//		
//		for(CoordinateKey k : keys) {
//			ret.put(k, pieces.get(k));
//		}
//		return ret;
//	}

//	private void updateHashMap() {
//		
//	}
}

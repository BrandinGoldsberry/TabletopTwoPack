package hnefataflModels;

import java.util.HashMap;
import java.util.Set;

public class Game {
	private HashMap<CoordinateKey, Piece> pieces;

	public Game(HashMap<CoordinateKey, Piece> pieces) {
		super();
		this.setPieces(pieces);
	}

	public HashMap<CoordinateKey, Piece> getPieces() {
		return pieces;
	}

	public void setPieces(HashMap<CoordinateKey, Piece> pieces) {
		this.pieces = pieces;
	}

	public boolean movePiece(int startX, int startY, int endX, int endY) {
		boolean canMove = false;

		Piece toMove = null;

		if (startX != endX && startY != endY) {
			canMove = false;
		} else {
			CoordinateKey CK = new CoordinateKey(startX, startY);
			toMove = pieces.get(CK);

			if (toMove == null) {
				canMove = false;
			} else {
				canMove = true;

				if (startX == endX) {
					if (startY > endY) {
						for (int i = startY + 1; i > endY; i--) {
							CK = new CoordinateKey(startX, i);
							if (pieces.get(CK) != null) {
								canMove = false;
							}
						}
					}

					if (startY < endY) {
						for (int i = startY + 1; i < endY; i++) {
							CK = new CoordinateKey(startX, i);
							if (pieces.get(CK) != null) {
								canMove = false;
							}
						}
					}

				} else if (startY == endY) {
					if (startX > endX) {
						for (int i = startX + 1; i > endX; i--) {
							CK = new CoordinateKey(startY, i);
							if (pieces.get(CK) != null) {
								canMove = false;
							}
						}
					}

					if (startX < endX) {
						for (int i = startX + 1; i < endX; i++) {
							CK = new CoordinateKey(startY, i);
							if (pieces.get(CK) != null) {
								canMove = false;
							}
						}
					}
				}
			}
		}

		if (canMove) {
			CoordinateKey start = new CoordinateKey(startX, startY);
			CoordinateKey end = new CoordinateKey(endX, endY);

			pieces.put(end, toMove);
			pieces.put(start, null);
			update(end);
		}

		return canMove;
	}

	public HashMap<CoordinateKey, Piece> update(CoordinateKey LastMoved) {
		HashMap <CoordinateKey, Piece> ret = clonePieces();
		
		CoordinateKey[] keys = { 
			new CoordinateKey(LastMoved.getY() - 1, LastMoved.getX()),
			new CoordinateKey(LastMoved.getY(), LastMoved.getX() - 1),
			new CoordinateKey(LastMoved.getY(), LastMoved.getX() + 1),
			new CoordinateKey(LastMoved.getY() + 1, LastMoved.getX()), 
		};

		for (CoordinateKey CK : keys) {
			Piece toCheck = pieces.get(CK);
			if (toCheck != null) {
				boolean[][] surroundings = new boolean[2][2];

				CoordinateKey North = new CoordinateKey(CK.getY() - 1, CK.getX());
				CoordinateKey West = new CoordinateKey(CK.getY(), CK.getX() - 1);
				CoordinateKey East = new CoordinateKey(CK.getY(), CK.getX() + 1);
				CoordinateKey South = new CoordinateKey(CK.getY() + 1, CK.getX());

				if (pieces.get(North) != null) {
					surroundings[0][0] = true;
				}
				if (pieces.get(South) != null) {
					surroundings[0][1] = true;
				}

				if (pieces.get(West) != null) {
					surroundings[1][0] = true;
				}
				if (pieces.get(East) != null) {
					surroundings[1][1] = true;
				}

				if (toCheck.IsSurrounded(surroundings)) {
					ret.put(CK, null);
				}
			}
		}

		return ret;
	}

	private HashMap<CoordinateKey, Piece> clonePieces() {
		HashMap<CoordinateKey, Piece> ret = new HashMap<>();
		
		Set<CoordinateKey> keys = pieces.keySet();
		
		for(CoordinateKey k : keys) {
			ret.put(k, pieces.get(k));
		}
		return ret;
	}

//	private void updateHashMap() {
//		
//	}
}

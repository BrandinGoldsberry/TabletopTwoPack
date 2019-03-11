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

	public boolean movePiece(int startX, int startY, int endX, int endY, boolean isAttacker) {
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
							System.out.println(pieces[startX][i] + " First, " + i);
							if (pieces[startX][i] != null) {
								canMove = false;
							}
						}
					}

					if (startY < endY) {
						for (int i = startY + 1; i <= endY; i++) {
							System.out.println(pieces[startX][i] + " Second, " + i);
							if (pieces[startX][i] != null) {
								canMove = false;
							}
						}
					}

				} else if (startY == endY) {
					if (startX > endX) {
						for (int i = startX - 1; i >= endX; i--) {
							System.out.println(pieces[i][startY] + " Third, " + i);
							if (pieces[i][startY] != null) {
								canMove = false;
							}
						}
					}

					if (startX < endX) {
						for (int i = startX + 1; i <= endX; i++) {
							System.out.println(pieces[i][startY] + " Fourth, " + i);
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
			Hnefatafl.SetKingIsDead(update(endX, endY, isAttacker));
			Hnefatafl.update();
		}

		return canMove;
	}

	public boolean update(int x, int y, boolean isAttacker) {
		boolean kingDied = false;
		boolean[][] enemiesNear = null;
		if (pieces[x + 1][y] != null) {
			enemiesNear = isAttacker ? setAttackerSurroundings(x + 1, y) : setDefenderSurroundings(x + 1, y);
			if (pieces[x + 1][y].IsSurrounded(enemiesNear)) {
				pieces[x + 1][y] = null;
			}
		}
		if (pieces[x - 1][y] != null) {
			enemiesNear = isAttacker ? setAttackerSurroundings(x - 1, y) : setDefenderSurroundings(x - 1, y);
			if (pieces[x - 1][y].IsSurrounded(enemiesNear)) {
				pieces[x - 1][y] = null;
			}
		}
		if (pieces[x][y + 1] != null) {
			enemiesNear = isAttacker ? setAttackerSurroundings(x, y + 1) : setDefenderSurroundings(x, y + 1);
			if (pieces[x][y + 1].IsSurrounded(enemiesNear)) {
				pieces[x][y + 1] = null;
			}
		}
		if (pieces[x][y - 1] != null) {
			enemiesNear = isAttacker ? setAttackerSurroundings(x, y - 1) : setDefenderSurroundings(x, y - 1);
			if (pieces[x][y - 1].IsSurrounded(enemiesNear)) {
				pieces[x][y - 1] = null;
			}
		}
		
		return kingDied;
	}

	public boolean[][] setAttackerSurroundings(int x, int y) {
		boolean[][] ret = new boolean[2][2];

		try {
			ret[0][0] = pieces[x + 1][y] != null
					&& !pieces[x + 1][y].getClass().getName().equals("hnefataflModels.Attacker");
			ret[0][1] = pieces[x - 1][y] != null
					&& !pieces[x - 1][y].getClass().getName().equals("hnefataflModels.Attacker");
			ret[1][0] = pieces[x][y + 1] != null
					&& !pieces[x][y + 1].getClass().getName().equals("hnefataflModels.Attacker");
			ret[1][1] = pieces[x][y - 1] != null
					&& !pieces[x][y - 1].getClass().getName().equals("hnefataflModels.Attacker");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			ret[0][0] = false;
			ret[0][1] = false;
			ret[1][0] = false;
			ret[1][1] = false;
		}
		return ret;
	}
	
	public boolean[][] setDefenderSurroundings(int x, int y) {
		boolean[][] ret = new boolean[2][2];

		try {
			ret[0][0] = pieces[x + 1][y] != null
					&& !pieces[x + 1][y].getClass().getName().equals("hnefataflModels.Defender");
			ret[0][1] = pieces[x - 1][y] != null
					&& !pieces[x - 1][y].getClass().getName().equals("hnefataflModels.Defender");
			ret[1][0] = pieces[x][y + 1] != null
					&& !pieces[x][y + 1].getClass().getName().equals("hnefataflModels.Defender");
			ret[1][1] = pieces[x][y - 1] != null
					&& !pieces[x][y - 1].getClass().getName().equals("hnefataflModels.Defender");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			ret[0][0] = false;
			ret[0][1] = false;
			ret[1][0] = false;
			ret[1][1] = false;
		}
		
		for(boolean[] a : ret) {
			System.out.println(Arrays.toString(a));
		}
		return ret;
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

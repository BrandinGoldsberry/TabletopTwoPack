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
			Hnefatafl.SetKingIsDead(update(endX, endY, isAttacker));
			Hnefatafl.update();
		}

		return canMove;
	}

	public boolean update(int x, int y, boolean isAttacker) {
		boolean kingDied = false;
		boolean[][] enemiesNear = null;
		
		if(pieces[x][y].toString().equals("Attacker")) {
			isAttacker = true;
		} else {
			isAttacker = false;
		}
		
		System.out.println("IsAttacker: " + isAttacker);
		
		if (x + 1 <= 11) {
			if (pieces[x + 1][y] != null) {
				enemiesNear = !isAttacker ? setAttackerSurroundings(x + 1, y) : setDefenderSurroundings(x + 1, y);
				System.out.println(pieces[x + 1][y].getId());
				if (pieces[x + 1][y].IsSurrounded(enemiesNear)) {
					pieces[x + 1][y] = null;
				}
			} 
		}
		if (x - 1 >= 0) {
			if (pieces[x - 1][y] != null) {
				enemiesNear = !isAttacker ? setAttackerSurroundings(x - 1, y) : setDefenderSurroundings(x - 1, y);
				System.out.println(pieces[x - 1][y].getId());
				if (pieces[x - 1][y].IsSurrounded(enemiesNear)) {
					pieces[x - 1][y] = null;
				}
			} 
		}
		if (y + 1 <= 11) {
			if (pieces[x][y + 1] != null) {
				enemiesNear = !isAttacker ? setAttackerSurroundings(x, y + 1) : setDefenderSurroundings(x, y + 1);
				System.out.println(pieces[x][y + 1].getId());
				if (pieces[x][y + 1].IsSurrounded(enemiesNear)) {
					pieces[x][y + 1] = null;
				}
			} 
		}
		if (y - 1 >= 0) {
			if (pieces[x][y - 1] != null) {
				enemiesNear = !isAttacker ? setAttackerSurroundings(x, y - 1) : setDefenderSurroundings(x, y - 1);
				System.out.println(pieces[x][y - 1].getId());
				if (pieces[x][y - 1].IsSurrounded(enemiesNear)) {
					pieces[x][y - 1] = null;
				}
			} 
		}
		return kingDied;
	}

	public boolean[][] setAttackerSurroundings(int x, int y) {
		boolean[][] ret = new boolean[2][2];

		try {
			if (x + 1 <= 11) {
				if (pieces[x + 1][y] != null) {
					ret[0][0] = (pieces[x + 1][y].toString().equals("Defender")
							|| pieces[x + 1][y].toString().equals("King"));
					System.out.println(pieces[x + 1][y].toString() + pieces[x + 1][y].getId());
				} 
			}
			if (x - 1 >= 0) {
				if (pieces[x - 1][y] != null) {
					ret[0][1] = (pieces[x - 1][y].toString().equals("Defender")
							|| pieces[x - 1][y].toString().equals("King"));
					System.out.println(pieces[x - 1][y].toString() + pieces[x - 1][y].getId());
				} 
			}
			if (y + 1 <= 11) {
				if (pieces[x][y + 1] != null) {
					ret[1][0] = (pieces[x][y + 1].toString().equals("Defender")
							|| pieces[x][y + 1].toString().equals("King"));
					System.out.println(pieces[x][y + 1].toString() + pieces[x][y + 1].getId());
				} 
			}
			if (y - 1 >= 0) {
				if (pieces[x][y - 1] != null) {
					ret[1][1] = (pieces[x][y - 1].toString().equals("Defender")
							|| pieces[x][y - 1].toString().equals("King"));
					System.out.println(pieces[x][y - 1].toString() + pieces[x][y - 1].getId());
				} 
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			ret[0][0] = false;
			ret[0][1] = false;
			ret[1][0] = false;
			ret[1][1] = false;
		}
		
		for(boolean[] b : ret) {
			System.out.println(Arrays.toString(b));
		}
		
		return ret;
	}
	
	public boolean[][] setDefenderSurroundings(int x, int y) {
		boolean[][] ret = new boolean[2][2];

		try {
			if (x + 1 <= 11) {
				if (pieces[x + 1][y] != null) {
					ret[0][0] = (pieces[x + 1][y].toString().equals("Attacker"));
					System.out.println(pieces[x + 1][y].toString() + pieces[x + 1][y].toString().equals("Attacker"));
				} 
			}
			if (x - 1 >= 0) {
				if (pieces[x - 1][y] != null) {
					ret[0][1] = (pieces[x - 1][y].toString().equals("Attacker"));
					System.out.println(pieces[x - 1][y].toString() + pieces[x - 1][y].toString().equals("Attacker"));
				} 
			}
			if (y + 1 <= 11) {
				if (pieces[x][y + 1] != null) {
					ret[1][0] = (pieces[x][y + 1].toString().equals("Attacker"));
					System.out.println(pieces[x][y + 1].toString() + pieces[x][y + 1].toString().equals("Attacker"));
				} 
			}
			if (y - 1 >= 0) {
				if (pieces[x][y - 1] != null) {
					ret[1][1] = (pieces[x][y - 1].toString().equals("Attacker"));
					System.out.println(pieces[x][y - 1].toString() + pieces[x][y - 1].toString().equals("Attacker"));
				} 
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			ret[0][0] = false;
			ret[0][1] = false;
			ret[1][0] = false;
			ret[1][1] = false;
		}
		
		for(boolean[] b : ret) {
			System.out.println(Arrays.toString(b));
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

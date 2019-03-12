package hnefataflModels;

import javafx.scene.image.Image;

public class Attacker extends Piece {
	
	public Attacker(Image sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean IsSurrounded(boolean[][] enemiesNear) {
		boolean ret = false;
		
		ret = (enemiesNear[0][0] && enemiesNear[0][1]) || (enemiesNear[1][0] && enemiesNear[1][1]);
		
		return ret;
	}

	@Override
	public String toString() {
		return "Attacker";
	}
	
}

package hnefataflModels;

import javafx.scene.image.Image;

public class Defender extends Piece {

	public Defender(Image sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean IsSurrounded(boolean[][] enemiesNear) {
		boolean ret = false;
		
		ret = enemiesNear[1][1] && enemiesNear[1][2] || enemiesNear[2][1] && enemiesNear[2][2];
		
		return ret;
	}

	@Override
	public String toString() {
		return "Defender";
	}
}

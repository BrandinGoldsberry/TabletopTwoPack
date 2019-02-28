package hnefataflModels;

import javafx.scene.image.Image;

public class Defender extends Piece {

	public Defender(Image sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean IsSurrounded(boolean[][] enemiesNear) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Defender";
	}
}

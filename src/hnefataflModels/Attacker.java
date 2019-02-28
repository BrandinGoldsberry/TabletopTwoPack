package hnefataflModels;

import javafx.scene.image.Image;

public class Attacker extends Piece {
	
	public Attacker(Image sprite) {
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
		return "Atacker";
	}
	
}

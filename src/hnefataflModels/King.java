package hnefataflModels;

import javafx.scene.image.Image;

public class King extends Defender {

	public King(Image sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean IsSurrounded(boolean[][] enemiesNear) {
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "King";
	}
}

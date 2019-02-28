package hnefataflModels;

import javafx.scene.image.Image;

public abstract class Piece {
	private final Image sprite;
	
	public Piece(Image sprite) {
		//constructor sets sprite
		this.sprite = sprite;
	}
	
	public Image GetSprite() {
		return this.sprite;
	}
	
	public boolean CheckMovement() {
		return false;
	}
	
	public abstract boolean IsSurrounded(boolean[][] enemiesNear);
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

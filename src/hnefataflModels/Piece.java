package hnefataflModels;

import javafx.scene.image.Image;

public abstract class Piece {
	private final Image sprite;
	private final int id;
	private static int lastid = 0;
	
	public Piece(Image sprite) {
		//constructor sets sprite
		this.sprite = sprite;
		this.id = lastid++;
	}
	
	public Image GetSprite() {
		return this.sprite;
	}
	
	public int getId() {
		return id;
	}

	public abstract boolean IsSurrounded(boolean[][] enemiesNear);
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

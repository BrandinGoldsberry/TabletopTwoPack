package models_RPG;

import enums.Tile;

public class Space {
	private Tile type;

	public Space(Tile type) {
		super();
		this.type = type;
	}

	public Tile getType() {
		return type;
	}

	public void setType(Tile type) {
		this.type = type;
	}
	
}

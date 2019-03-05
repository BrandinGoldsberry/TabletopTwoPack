package models_RPG;

public class Dungeon {
	private Space[][] floor;

	public Dungeon(Space[][] rooms) {
		super();
		this.setRooms(rooms);
	}

	public Space[][] getRooms() {
		return floor;
	}

	public void setRooms(Space[][] rooms) {
		this.floor = rooms;
	}
	
	public void generateRooms() {
		
	}
}

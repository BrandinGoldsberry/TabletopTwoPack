package models_RPG;

public class Dungeon {
	private Room[][] rooms;

	public Dungeon(Room[][] rooms) {
		super();
		this.setRooms(rooms);
	}

	public Room[][] getRooms() {
		return rooms;
	}

	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}
	
	public void generateRooms() {
		
	}
}

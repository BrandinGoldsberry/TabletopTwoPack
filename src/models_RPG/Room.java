package models_RPG;

public class Room {
	private Space[][] layout;

	public Room(Space[][] layout) {
		super();
		this.setLayout(layout);
	}

	public Space[][] getLayout() {
		return layout;
	}

	public void setLayout(Space[][] layout) {
		this.layout = layout;
	}
	
	public Space[][] useLayout1() {
		return layout;
		
	}
	
	public Space[][] useLayout2() {
		return layout;
		
	}
	
	public Space[][] useLayout3() {
		return layout;
		
	}
	
	public Space[][] useLayout4() {
		return layout;
		
	}
	
	public Space[][] useLayout5() {
		return layout;
		
	}
	
	public void chooseLayoutRNG(int rng ) {
		
	}
	
	public void chooseLayoutManual(int choice) {
		
	}
	
	
}

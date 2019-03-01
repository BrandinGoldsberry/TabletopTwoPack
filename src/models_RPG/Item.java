package models_RPG;

public class Item {
	private String name;

	public Item(String name) {
		super();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void use(BaseCharacter target) {
		
	}
}

package models_RPG;

public abstract class Item {
	private String name;
	private boolean offensiveItem;

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
	
	public boolean getOffensiveItem() {
		return offensiveItem;
	}
	
	public void setOffensiveItem(boolean offensiveItem) {
		this.offensiveItem = offensiveItem;
	}
	
	public abstract void use(BaseCharacter target);
}

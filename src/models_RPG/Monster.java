package models_RPG;

public class Monster extends BaseCharacter {
	private int defenseRating;
	private Item heldItem;
	
	public Monster(String name) {
		super();
	}

	public int getDefenseRating() {
		return defenseRating;
	}

	public void setDefenseRating(int defenseRating) {
		this.defenseRating = defenseRating;
	}

	public Item getHeldItem() {
		return heldItem;
	}

	public void setHeldItem(Item heldItem) {
		this.heldItem = heldItem;
	}
	
	public void takeDamage(int defenseRating) {
		
	}
	
	public Item calculateItemDrop() {
		return heldItem;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Monster [getDefenseRating()=").append(getDefenseRating()).append("]");
		return builder.toString();
	}
	
	
	
}

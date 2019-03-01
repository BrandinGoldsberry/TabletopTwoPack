package models_RPG;

public class Monster extends BaseCharacter {
	private int defenseRating;
	private Item heldItem;
	
	public Monster(String name, int baseHP, int currentHP, int baseMP, int currentMP, int str, int dex, int mag,
			int luc, int defenseRating, Item heldItem) {
		super(name, baseHP, currentHP, baseMP, currentMP, str, dex, mag, luc);
		this.defenseRating = defenseRating;
		this.heldItem = heldItem;
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

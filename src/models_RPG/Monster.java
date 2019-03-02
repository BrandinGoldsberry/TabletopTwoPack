package models_RPG;

import java.util.Random;

public class Monster extends BaseCharacter {
	private int defenseRating;
	private Item heldItem;
	private static Random rng = new Random();
	
	public Monster(String name, int str, int dex, int mag, int luc, int defenseRating, Item heldItem) {
		super(name, str, dex, mag, luc);
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
	
	public void takeDamage(int incomingDamage) {
		int takenDamage = incomingDamage - (this.defenseRating * 2);
		this.setCurrentHP(this.getCurrentHP() - takenDamage);
		
		if(this.determineIsAlive() == false) {
			this.setAlive(false);
		} else {
			this.setAlive(true);
		}
	}
	
	public boolean calculateItemDrop() {
		int dropChance = rng.nextInt(100) + 1;
		boolean itemDropped;
		
		if(dropChance > 85) {
			itemDropped = true;
		} else {
			itemDropped = false;
		}
		return itemDropped;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Monster [getDefenseRating()=").append(getDefenseRating()).append("]");
		return builder.toString();
	}
	
	
	
}

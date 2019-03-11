package models_RPG;

import java.util.Random;

public class Monster extends BaseCharacter {
	private int defenseRating;
	private Item heldItem;
	private int EXPValue;
	private static Random rng = new Random();
	
	public Monster(String name, int str, int dex, int mag, int luc, int defenseRating, Item heldItem) {
		super(name, str, dex, mag, luc);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.defenseRating = defenseRating;
		this.heldItem = heldItem;
	}
	
	public Monster() {
		super("Monster");
	}

	public int getEXPValue() {
		return this.EXPValue;
	}
	
	public void setEXPValue(int EXPValue) {
		this.EXPValue = EXPValue;
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
	
	public int calculateMonsterAttack() {
		int damage = this.getStr() * 4;
		float criticalChance = (float) (rng.nextInt(100) + 1 + (this.getLuc() * 0.2));
		
		if(criticalChance > 95) {
			damage += str * 2;
		}
		return damage;
	}
	
	public int calculateMonsterMagicAttack() {
		int damage = 0;
		if(this.currentMP - 10 < 0) {
			damage = calculateMonsterAttack();
		} else {
			this.currentMP -= 10;
			damage = 7 * mag;
		}
		
		return 0;
	}
	
	public void takeDamage(int incomingDamage) {
		int takenDamage = incomingDamage - (this.defenseRating * 2);
		if(takenDamage < 0) {
			takenDamage = 0;
		}
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

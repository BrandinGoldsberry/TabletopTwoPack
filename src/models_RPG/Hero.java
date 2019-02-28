package models_RPG;

import java.util.ArrayList;


public class Hero extends BaseCharacter {
	private int EXP;
	private int nextLevelEXP;
	private int level;
	//private Weapon weapon;
	//private Armor armor;
	//private Job job;
	private int weaponRating;
	private int armorRating;
	//private static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Hero() {
		
	}
	//public Hero(String name, Job job)

	public int getEXP() {
		return EXP;
	}

	public void setEXP(int eXP) {
		EXP = eXP;
	}

	public int getNextLevelEXP() {
		return nextLevelEXP;
	}

	public void setNextLevelEXP(int nextLevelEXP) {
		this.nextLevelEXP = nextLevelEXP;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getWeaponRating() {
		return weaponRating;
	}

	public void setWeaponRating(int weaponRating) {
		this.weaponRating = weaponRating;
	}

	public int getArmorRating() {
		return armorRating;
	}

	public void setArmorRating(int armorRating) {
		this.armorRating = armorRating;
	}
	
	public int calculateAttackWithWeapon(int str, int weaponRating) {
		return 0;
	}
	
	public void takeDamage(int armorRating) {
		
	}
	
	public int calculateNextLevelEXP(int level) {
		return 0;
	}
	
	
	
}

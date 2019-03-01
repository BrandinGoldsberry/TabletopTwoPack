package models_RPG;

import java.util.ArrayList;

import rpgenums.*;


public class Hero extends BaseCharacter {
	private int EXP;
	private int nextLevelEXP;
	private int level;
	private Weapon weapon;
	private Armor armor;
	private Job job;
	private int weaponRating;
	private int armorRating;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	
	
	
	public Hero(String name, int baseHP, int currentHP, int baseMP, int currentMP, int str, int dex, int mag, int luc,
			int eXP, int nextLevelEXP, int level, Weapon weapon, Armor armor, Job job, int weaponRating, int armorRating) {
		super(name, str, dex, mag, luc);
		EXP = eXP;
		this.nextLevelEXP = nextLevelEXP;
		this.level = level;
		this.setWeapon(weapon);
		this.setArmor(armor);
		this.setJob(job);
		this.weaponRating = weaponRating;
		this.armorRating = armorRating;
	}

	//public Hero(String name, Job job)

	public static ArrayList<Item> getInventory() {
		return inventory;
	}

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

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
}

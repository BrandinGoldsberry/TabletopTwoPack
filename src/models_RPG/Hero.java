package models_RPG;

import java.util.ArrayList;
import java.util.Random;

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
	private static Random rng = new Random();
	
	
	
	public Hero(String name, int str, int dex, int mag, int luc, int level, Weapon weapon, Armor armor, Job job, int weaponRating, int armorRating) {
		super(name, str, dex, mag, luc);
		EXP = 0;
		this.level = level;
		this.nextLevelEXP = calculateNextLevelEXP(this.level);
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
		int damage = this.getStr() * 10 + (this.weaponRating * 2);
		float criticalChance = rng.nextInt(100) + 1;
		
		if(this.job == Job.LUCKY_TED) {
			criticalChance += 0.35 * this.level;
		}
		
		if(criticalChance > 95) {
			damage += str * 4;
		}
		return damage;
	}
	
	public void takeDamage(int incomingDamage) {
		int takenDamage = incomingDamage - (armorRating * 2);
		this.setCurrentHP(this.getCurrentHP() - takenDamage);
		
		if(this.determineIsAlive() == false) {
			this.setAlive(false);
		} else {
			this.setAlive(true);
		}
		
	}
	
	public int calculateNextLevelEXP(int level) {
		int newEXP = 1000 + (this.level * 1000);
		
		if(this.job == Job.LUCKY_TED) {
			newEXP -= 100 * level;
		}
		
		return newEXP;
	}

	public void earnEXP(int incomingEXP) {
		this.EXP += incomingEXP;
		
		while(this.EXP > this.nextLevelEXP) {
			this.level++;
			this.nextLevelEXP = calculateNextLevelEXP(this.level);			
		}
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

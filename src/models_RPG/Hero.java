package models_RPG;

import java.util.ArrayList;
import java.util.Random;

import rpgenums.*;


public class Hero extends BaseCharacter {
	private static String defaultName = "Billy Herrington";
	private int EXP = 0;
	private int nextLevelEXP;
	private int level;
	private Weapon weapon;
	private Armor armor;
	private Job job;
	private int weaponRating;
	private int armorRating;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	private static Random rng = new Random();
	
	
	
	public Hero(String name, Job job) {
		super(name);
		this.setStr(3);
		this.setDex(3);
		this.setMag(3);
		this.setLuc(3);
		this.setBaseHP(100 + (8 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(50 + (6 * mag));
		this.setCurrentMP(this.getBaseMP());
		EXP = 0;
		this.level = 1;
		this.nextLevelEXP = calculateNextLevelEXP(this.level);
		this.setWeapon(null);
		this.setArmor(null);
		this.setJob(job);
		this.weaponRating = 0;
		this.armorRating = 0;
		
		if(job == Job.WARRIOR) {
			this.str += 3;
		} else if (job == Job.MAGE) {
			this.mag += 3;
		} else if (job == Job.ROGUE) {
			this.dex += 3;
		} else if (job == Job.LUCKY_TED) {
			this.luc += 3;
		}
		
	}

	public Hero() {
		super(defaultName);
		this.str = 6;
		this.dex = 3;
		this.mag = 3;
		this.luc = 3;
		this.job = Job.WARRIOR;
		this.setBaseHP(100 + (8 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(50 + (6 * mag));
		this.setCurrentMP(this.getBaseMP());
		EXP = 0;
		this.level = 1;
		this.nextLevelEXP = calculateNextLevelEXP(this.level);
		this.setWeapon(null);
		this.setArmor(null);
		this.setJob(job);
		this.weaponRating = 0;
		this.armorRating = 0;
	}

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
		float criticalChance = (float) (rng.nextInt(100) + 1 + (this.getLuc() * 0.2));
		
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
		int newEXP;
		if(level == 1) {
			newEXP = 1000;
		} else {
			newEXP = this.nextLevelEXP + (this.level * 1000);
			
			if(this.job == Job.LUCKY_TED) {
				newEXP -= 50 * level;
			}
			
		}
		
		
		return newEXP;
	}

	public void earnEXP(int incomingEXP) {
		this.EXP += incomingEXP;
		
		while(this.EXP > this.nextLevelEXP) {
			this.level++;
			assignStatPoints();
			this.nextLevelEXP = calculateNextLevelEXP(this.level);
			assignStatPoints();
			int tempBaseHP = this.getBaseHP();
			this.setBaseHP(tempBaseHP + 5 + (this.getStr() * 2));
			int tempBaseMP = this.getBaseMP();
			this.setBaseMP(tempBaseMP + 3 + (this.getMag() * 2));
		}
	}
	
	public void assignStatPoints() {
		int statPoints = 5;
		//GUi process to assign stat points
			//Don't allow players to allocate beyond 255
		
		//Do while that will have players continue to allocate points until the points left are zero
		
		//Parse input and allocate points
			//Do statPoints-- after each input
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hero: \n\t")
			   .append("Name: ").append(name).append("\n\t")
			   .append("Level: ").append(level).append("\n\t")
			   .append("Current EXP: ").append(EXP).append("/ ").append(nextLevelEXP).append("\n\t")
			   .append("Weapon: ").append(weapon).append("\n\t")
			   .append("Armor: ").append(armor).append("\n\t")
			   .append("Job: ").append(job).append("\n\t")
			   .append("Weapon Rating: ").append(weaponRating).append("\n\t")
			   .append("Armor Rating: ").append(armorRating).append("\n\t")
			   .append("Current Health: ").append(baseHP).append("/  ").append(currentHP).append("\n\t")
			   .append("Current MP: ").append(baseMP).append("/ ").append(currentMP).append("\n\t")
			   .append("Str: ").append(str).append("\n\t")
			   .append("Dex: ").append(dex).append("\n\t")
			   .append("Mag: ").append(mag).append("\n\t")
			   .append("Luc: ").append(luc);

		
		
		return builder.toString();
	}
	
	
	
}

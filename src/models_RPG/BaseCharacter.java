package models_RPG;

import java.util.Random;

public class BaseCharacter {
	protected String name;
	protected int baseHP;
	protected float currentHP;
	protected int baseMP;
	protected int currentMP;
	protected int str;
	protected int dex;
	protected int mag;
	protected int luc;
  
	private boolean isAlive;
	private static Random rng = new Random();
	
	public BaseCharacter(String name, int str, int dex, int mag, int luc) {
		
		this.name = name;
		this.baseHP = 100 + (8 * str);
		this.currentHP = this.baseHP;
		this.baseMP = 50 + (6 * mag);
		this.currentMP = this.baseMP;
		this.str = str;
		this.dex = dex;
		this.mag = mag;
		this.luc = luc;
		this.isAlive = true;
	}

	public BaseCharacter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBaseHP() {
		return baseHP;
	}


	public void setBaseHP(int baseHP) {
		this.baseHP = baseHP;
	}


	public float getCurrentHP() {
		return currentHP;
	}


	public void setCurrentHP(float currentHP) {
		this.currentHP = currentHP;
		if(this.currentHP > this.getBaseHP()) {
			this.currentHP = this.getCurrentHP();
		}
	}


	public int getBaseMP() {
		return baseMP;
	}


	public void setBaseMP(int baseMP) {
		this.baseMP = baseMP;
	}

	public int getCurrentMP() {
		return currentMP;
	}


	public void setCurrentMP(int currentMP) {
		this.currentMP = currentMP;
	}


	public int getStr() {
		return str;
	}


	public void setStr(int str) {
		this.str = str;
	}


	public int getDex() {
		return dex;
	}


	public void setDex(int dex) {
		this.dex = dex;
	}


	public int getMag() {
		return mag;
	}


	public void setMag(int mag) {
		this.mag = mag;
	}


	public int getLuc() {
		return luc;
	}


	public void setLuc(int luc) {
		this.luc = luc;
	}


	public boolean isAlive() {
		return isAlive;
	}


	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean calculateHit() {
		boolean hitConfirm = false;
		float hitChance = (float) (rng.nextInt(100) + 1 + (this.dex * 0.1));
		
		
		if(hitChance > 20) {
			hitConfirm = true;
		}
		
		return hitConfirm;
	}
	
	public int calculateAttack() {
		int damage = this.str * 10;
		return damage;
	}

	public int caclulateMagicAttack() {
		int damage = 0;
		if(this.currentMP - 10 < 0) {
			//Message for insufficient magic
			//TODO
		} else {
			this.currentMP -= 10;
			damage = 12 * mag;
		}
		return damage;
	}
	
	public boolean determineIsAlive() {
		boolean isInfactAlive;
		
		if(this.currentHP <= 0) {
			isInfactAlive = false;
		} else {
			isInfactAlive = true;
		}
		return isInfactAlive;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseCharacter\nName = ").append(name).append("\nBase HP=").append(baseHP).append("\nCurrent HP = ")
				.append(currentHP).append("\nBase MP = ").append(baseMP).append("\nCurrent MP = ").append(currentMP)
				.append("\nStr = ").append(str).append("\nDex = ").append(dex).append("\n Mag = ").append(mag).append("\n Luc = ")
				.append(luc).append("\n Is Alive=").append(isAlive);
		return builder.toString();
	}
	
	
}

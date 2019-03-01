package models_RPG;

public class BaseCharacter {
	private String name;
	private int baseHP;
	private int currentHP;
	private int baseMP;
	private int currentMP;
	private int str;
	private int dex;
	private int mag;
	private int luc;
	
	public BaseCharacter() {
		
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

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
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
	
	public int calculateAttack(int str) {
		return 0;
	}
	
	public int calculateMagic(int mag) {
		return 0;
	}
	
	public boolean determineIsAlive(int currentHP) {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseCharacter\nName = ").append(name).append("\n Base HP = ").append(baseHP).append("\n Current HP = ")
				.append(currentHP).append("\n Base MP = ").append(baseMP).append("\n Current MP = ").append(currentMP)
				.append("\nStr = ").append(str).append("\nDex = ").append(dex).append("\nMag = ").append(mag).append("\nLuc = ")
				.append(luc);
		return builder.toString();
	}
	
	
}

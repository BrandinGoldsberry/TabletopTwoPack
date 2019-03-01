package items;

import models_RPG.Item;

public class Javelin extends Item {
	private int damageValue;
	
	public Javelin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public int getDamageValue() {
		return damageValue;
	}

	public void setDamageValue(int damageValue) {
		this.damageValue = damageValue;
	}

	
	
}

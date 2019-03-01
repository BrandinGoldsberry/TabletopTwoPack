package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class Potion extends Item {
	private int healValue;
	
	public Potion(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public int getHealValue() {
		return healValue;
	}

	public void setHealValue(int healValue) {
		this.healValue = healValue;
	}
	
	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setCurrentHP(target.getCurrentHP() + healValue);
	}
}

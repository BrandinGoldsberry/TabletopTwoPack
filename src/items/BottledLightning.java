package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class BottledLightning extends Item {
	private int damageValue;

	public BottledLightning(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public int getDamageValue() {
		return damageValue;
	}

	public void setDamageValue(int damageValue) {
		this.damageValue = damageValue;
	}

	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setCurrentHP(target.getCurrentHP() - damageValue);
	}

}

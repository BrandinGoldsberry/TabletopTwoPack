package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class LifeStone extends Item {

	public LifeStone(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		float toHeal = target.getBaseHP() * (float)0.3;
		
		target.setCurrentHP(target.getBaseHP() + toHeal);
	}
	
}

package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class DexUp extends Item {

	public DexUp(String name) {
		super(name);
		this.setOffensiveItem(false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setDex(target.getDex()+1);
	}
	
}

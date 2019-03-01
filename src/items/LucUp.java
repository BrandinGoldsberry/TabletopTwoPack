package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class LucUp extends Item {

	public LucUp(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setLuc(target.getLuc()+1);
	}

}

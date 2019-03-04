package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class CursePaper extends Item {

	public CursePaper(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setCurrentHP(target.getCurrentHP() - (target.getStr() * target.getDex() * target.getMag() - target.getLuc() * 2));
	}

}

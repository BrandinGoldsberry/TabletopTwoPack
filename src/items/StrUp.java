package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class StrUp extends Item {

	public StrUp(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setStr(target.getStr()+1);
		target.setBaseHP(100 + (8 * target.getStr()));
	}
}

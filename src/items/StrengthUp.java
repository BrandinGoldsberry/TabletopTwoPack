package items;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class StrengthUp extends Item {

	public StrengthUp(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setStr(target.getStr()+1);
	}
}

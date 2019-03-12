package items;

import java.io.Serializable;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class StrUp extends Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StrUp(String name) {
		super(name);
		this.setOffensiveItem(false);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setStr(target.getStr()+1);
		target.setBaseHP(100 + (8 * target.getStr()));
	}
}

package items;

import java.io.Serializable;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class DexUp extends Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

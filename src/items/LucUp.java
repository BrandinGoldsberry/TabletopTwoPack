package items;

import java.io.Serializable;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class LucUp extends Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LucUp(String name) {
		super(name);
		this.setOffensiveItem(false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setLuc(target.getLuc()+1);
	}

}

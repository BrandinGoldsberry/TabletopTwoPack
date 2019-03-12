package items;

import java.io.Serializable;

import models_RPG.BaseCharacter;
import models_RPG.Item;

public class CursePaper extends Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CursePaper(String name) {
		super(name);
		this.setOffensiveItem(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BaseCharacter target) {
		// TODO Auto-generated method stub
		target.setCurrentHP(target.getCurrentHP() - (target.getStr() * target.getDex() * target.getMag() - target.getLuc() * 2));
		if(target.getCurrentHP() < 0) {
			target.setCurrentHP(0);
			target.setAlive(false);
		} else {
			
		}
	}

}

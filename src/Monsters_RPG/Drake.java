package Monsters_RPG;

import java.io.Serializable;

import items.StrUp;
import models_RPG.Item;
import models_RPG.Monster;

public class Drake extends Monster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Drake() {
		super();
		this.setName("Drake");
		this.setStr(5);
		this.setDex(11);
		this.setMag(11);
		this.setLuc(4);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(3);
		this.setHeldItem(new StrUp("Str Up"));
		this.setEXPValue(1400);
	}
	
	

}

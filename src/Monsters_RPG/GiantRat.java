package Monsters_RPG;

import java.io.Serializable;

import items.Potion;
import models_RPG.Item;
import models_RPG.Monster;

public class GiantRat extends Monster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GiantRat() {
		super();
		this.setName("Giant Rat");
		this.setStr(4);
		this.setDex(2);
		this.setMag(0);
		this.setLuc(2);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(0);
		this.setHeldItem(new Potion("Potion"));
		this.setEXPValue(120);
	}
	
}

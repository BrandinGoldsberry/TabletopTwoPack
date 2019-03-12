package Monsters_RPG;

import java.io.Serializable;

import items.DexUp;
import models_RPG.Monster;

public class Ghoul extends Monster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ghoul() {
		super();
		this.setName("Ghoul");
		this.setStr(4);
		this.setDex(3);
		this.setMag(3);
		this.setLuc(4);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(0);
		this.setHeldItem(new DexUp("Dex Up"));
		this.setEXPValue(290);
	}



}

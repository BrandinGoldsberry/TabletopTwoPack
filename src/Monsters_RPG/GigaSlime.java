package Monsters_RPG;

import java.io.Serializable;

import items.MagUp;
import models_RPG.Monster;

public class GigaSlime extends Monster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GigaSlime() {
		super();
		this.setName("Giga Slime");
		this.setStr(14);
		this.setDex(14);
		this.setMag(0);
		this.setLuc(0);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(1);
		this.setHeldItem(new MagUp("Mag Up"));
		this.setEXPValue(940);
	}


}

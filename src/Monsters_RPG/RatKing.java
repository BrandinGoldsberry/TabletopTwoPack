package Monsters_RPG;

import java.io.Serializable;

import items.BottledLightning;
import models_RPG.Monster;

public class RatKing extends Monster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RatKing() {
		super();
		this.setName("Rat King");
		this.setStr(8);
		this.setDex(8);
		this.setMag(8);
		this.setLuc(8);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(2);
		this.setHeldItem(new BottledLightning("Bottled Lightning"));
		this.setEXPValue(1400);
	}


}

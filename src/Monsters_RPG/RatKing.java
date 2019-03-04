package Monsters_RPG;

import items.BottledLightning;
import models_RPG.Item;
import models_RPG.Monster;

public class RatKing extends Monster {

	public RatKing(String name, int str, int dex, int mag, int luc, int defenseRating, Item heldItem) {
		super(name, str, dex, mag, luc);
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
		
	}


}

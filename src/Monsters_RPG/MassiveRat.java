package Monsters_RPG;

import items.HiPotion;
import models_RPG.Item;
import models_RPG.Monster;

public class MassiveRat extends Monster {

	public MassiveRat(String name, int str, int dex, int mag, int luc, int defenseRating, Item heldItem) {
		super(name, str, dex, mag, luc);
		this.setStr(8);
		this.setDex(4);
		this.setMag(0);
		this.setLuc(4);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(2);
		this.setHeldItem(new HiPotion("Hi-Potion"));
	}


}

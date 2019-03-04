package Monsters_RPG;

import items.DexUp;
import models_RPG.Item;
import models_RPG.Monster;

public class Ghoul extends Monster {

	public Ghoul(String name, int str, int dex, int mag, int luc, int defenseRating, Item heldItem) {
		super(name, str, dex, mag, luc);
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
	}



}

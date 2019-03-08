package Monsters_RPG;

import items.DexUp;
import models_RPG.Item;
import models_RPG.Monster;

public class DungeonLord extends Monster {

	public DungeonLord() {
		super();
		this.setName("Dungeon Lord");
		this.setStr(15);
		this.setDex(15);
		this.setMag(15);
		this.setLuc(18);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(10);
		this.setHeldItem(null);
		this.setEXPValue(5000);
	}

}

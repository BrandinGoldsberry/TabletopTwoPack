package Monsters_RPG;

import items.LifeStone;
import models_RPG.Item;
import models_RPG.Monster;

public class Slime extends Monster {

	public Slime() {
		super();
		this.setName("Slime");
		this.setStr(7);
		this.setDex(7);
		this.setMag(0);
		this.setLuc(0);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(0);
		this.setHeldItem(new LifeStone("Life Stone"));
		this.setEXPValue(400);
	}



}

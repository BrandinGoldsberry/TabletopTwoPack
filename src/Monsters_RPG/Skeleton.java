package Monsters_RPG;

import items.CursePaper;
import models_RPG.Item;
import models_RPG.Monster;

public class Skeleton extends Monster {

	public Skeleton() {
		super();
		this.setStr(8);
		this.setDex(6);
		this.setMag(6);
		this.setLuc(8);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(4);
		this.setHeldItem(new CursePaper("Curse Paper"));
		this.setEXPValue(900);
	}


}

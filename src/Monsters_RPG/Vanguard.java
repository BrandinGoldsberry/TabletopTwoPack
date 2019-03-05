package Monsters_RPG;

import items.LucUp;
import models_RPG.Item;
import models_RPG.Monster;

public class Vanguard extends Monster {

	public Vanguard() {
		super();
		this.setStr(8);
		this.setDex(10);
		this.setMag(2);
		this.setLuc(6);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(8);
		this.setHeldItem(new LucUp("Luc Up"));
		this.setEXPValue(1050);
	}

}

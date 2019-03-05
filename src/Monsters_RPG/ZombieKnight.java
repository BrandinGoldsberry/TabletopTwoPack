package Monsters_RPG;

import items.Javelin;
import models_RPG.Item;
import models_RPG.Monster;

public class ZombieKnight extends Monster {

	public ZombieKnight() {
		super();
		this.setStr(8);
		this.setDex(9);
		this.setMag(6);
		this.setLuc(8);
		this.setBaseHP(30 + (3 * str));
		this.setCurrentHP(this.getBaseHP());
		this.setBaseMP(20 + (2 * mag));
		this.setCurrentMP(this.getBaseMP());
		this.setDefenseRating(6);
		this.setHeldItem(new Javelin("Javelin"));
		this.setEXPValue(1240);
	}



}

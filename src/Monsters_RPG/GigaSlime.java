package Monsters_RPG;

import items.MagUp;
import models_RPG.Item;
import models_RPG.Monster;

public class GigaSlime extends Monster {

	public GigaSlime() {
		super();
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

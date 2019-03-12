package utils;

import java.io.Serializable;

import models_RPG.Hero;
import models_RPG.Item;
import models_RPG.Monster;
import rpgenums.Job;

public class SaveGame implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String campaignName;
	public final Hero player;
	public final Monster monster;
	public final int playerDungeonLocationX;
	public final int playerDungeomLocationY;
	public final int currentFloorNum;
	public final int dungeonFloorSteps;
	public final int playerSteps;
	public final int battleTurn;
	public final int playerDamage;
	public final int monsterDamage;
	public final Item playerItemUsed;
	public final int playerHealing;
	public final Job job;
	public final String mapPNG;
	public final boolean playerHitFlag;
	public final boolean monsterHitFlag;
	public final boolean combat;
	public final String saveName;
	public final Item item;
	public final String name;
	public final boolean dungeonLordDED;
	
	public SaveGame(String campaignName, Hero player, Monster monster, int playerDungeonLocationX,
			int playerDungeomLocationY, int currentFloorNum, int dungeonFloorSteps, int playerSteps, int battleTurn,
			int playerDamage, int monsterDamage, Item playerItemUsed, int playerHealing, Job job,
			String mapPNG, boolean playerHitFlag, boolean monsterHitFlag, boolean combat,
			String saveName, Item item, String name, boolean dungeonLordDED) {
		super();
		this.campaignName = campaignName;
		this.player = player;
		this.monster = monster;
		this.playerDungeonLocationX = playerDungeonLocationX;
		this.playerDungeomLocationY = playerDungeomLocationY;
		this.currentFloorNum = currentFloorNum;
		this.dungeonFloorSteps = dungeonFloorSteps;
		this.playerSteps = playerSteps;
		this.battleTurn = battleTurn;
		this.playerDamage = playerDamage;
		this.monsterDamage = monsterDamage;
		this.playerItemUsed = playerItemUsed;
		this.playerHealing = playerHealing;
		this.job = job;
		this.mapPNG = mapPNG;
		this.playerHitFlag = playerHitFlag;
		this.monsterHitFlag = monsterHitFlag;
		this.combat = combat;
		this.saveName = saveName;
		this.item = item;
		this.name = name;
		this.dungeonLordDED = dungeonLordDED;
	}
}

package controllers;

import java.util.HashMap;

import models_RPG.Dungeon;
import models_RPG.Hero;
import models_RPG.Monster;

public class RPG {
	private String campaignName;
	private Hero player;
	private int playerDungeonLocationX;
	private int playerDungeomLocationY;
	private int currentFloorNum;
	private Dungeon currentFloorDungeon;
	private int battleTurn;
	private HashMap<String, Monster> monsterList = new HashMap();
	
	public static void run() {
		
	}
	
	public static void movePlayer(int playerLocation) {
		//Get direction input
		//Do collision check
		//Move player if collision check returns false
	}
	
	public static boolean collisionCheck(int playerLocation) {
		boolean collision = true;
		
		//If up input
		
		//If down input
		
		//If right input
		
		//If left input
		
		return false;
		
	}
	
	public static void overworldInventory(Hero hero) {
		
	}
	
	public static boolean randomEncounter() {
		return false;
		
	}
	
	public static void initializeMonsterList() {
		
	}
	
	public static Monster generateMonster() {
		
		return null;
	}
	
	public static void battleProcessing() {
		
	}
	
	public static void playerTurn() {
		
	}
	
	public static void enemyTurn() {
		//RNG to decide if enemy does a normal or magic attack
			//if normal attack, do normal attack and damage calculation
			//if magic attack, check if the enemy would have enough MP to use magic
				//if they don't, use a normal attack instead
				//if they do, use the mp and perform a magic attack
	}
	
	public static void battleResults() {
		//Award EXP
			//Display EXP earned
			//Display previous EXP
				//Call level-up processing
					//If level up occurs, display a message, allow player to allocate their 5 stat points and continue
				//Display new EXP and new level/stats if applicable
	}
		
}

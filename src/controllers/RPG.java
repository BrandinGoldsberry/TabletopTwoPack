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
	private int playerLocationRoomX;
	private int playerLocationRoomY;
	private int currentFloorNum;
	private Dungeon currentFloorDungeon;
	private int battleTurn;
	private HashMap<String, Monster> monsterList = new HashMap();
	
	public static void run() {
		
	}
	
	public static void movePlayer(int playerLocation) {
		
	}
	
	public static boolean collisionCheck(int playerLocation) {
		return false;
		
	}
	
	public static boolean randomEncounter() {
		return false;
		
	}
	
	public static Monster generateMonster() {
		
		return null;
	}
	
	public static void battleProcessing() {
		
	}
	
	public static void playerTurn() {
		
	}
	
	public static void enemyTurn() {
		
	}
	
	public static void battleResults() {
		
	}
		
}

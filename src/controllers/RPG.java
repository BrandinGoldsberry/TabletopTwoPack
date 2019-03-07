package controllers;


import java.util.Random;

import Monsters_RPG.Drake;
import Monsters_RPG.Ghoul;
import Monsters_RPG.GiantRat;
import Monsters_RPG.GigaSlime;
import Monsters_RPG.MassiveRat;
import Monsters_RPG.Skeleton;
import Monsters_RPG.Slime;
import Monsters_RPG.Vanguard;
import Monsters_RPG.ZombieKnight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models_RPG.Dungeon;
import models_RPG.Hero;
import models_RPG.Monster;
import rpgenums.Job;

public class RPG {
	private static String campaignName;
	private static Hero player;
	private static int playerDungeonLocationX;
	private static int playerDungeomLocationY;
	private static int currentFloorNum;
	private static Dungeon currentFloorDungeon;
	private static int battleTurn;
	private static Job job;
	
	private static String name = null;
	private static Random rng = new Random();
	
	public static void run() {
		
		makeCharacter();
	
		
		
	}
	
	private static Job choseClass() {

		
		Stage stage = new Stage();
		
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(20, 80, 20, 80));
		
		Text text = new Text("Choose a Job");
		
		text.setTextAlignment(TextAlignment.CENTER);
		
		
		final ToggleGroup group = new ToggleGroup();
		

		RadioButton rb1 = new RadioButton("Warrior");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("Mage");
		rb2.setToggleGroup(group);
		 
		RadioButton rb3 = new RadioButton("Rogue");
		rb3.setToggleGroup(group);
		
		RadioButton rb4 = new RadioButton("Lucky Ted");
		rb4.setToggleGroup(group);
		
				
		Button button = new Button("submit");
		
		
		
		root.getChildren().addAll(box, text, rb1, rb2, rb3, rb4, button);
			
		Scene scene = new Scene(root, 400, 400);

        stage.setScene(scene);
        stage.setTitle("RPG");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
        	
        	@Override
        	public void handle(ActionEvent event) {
        		
        		if (rb1.isSelected() == true) {
        			
        			job = Job.WARRIOR;
        	        System.out.println(job);
        	        stage.close();
        			
        		} else if (rb2.isSelected() == true) {
        			
        			job = Job.MAGE;
        	        System.out.println(job);
        	        stage.close();
        			
        		} else if (rb3.isSelected() == true) {
        			
        			job = Job.ROGUE;
        	        System.out.println(job);
        	        stage.close();
        			
        		} else if (rb4.isSelected() == true) {
        			
        			job = Job.LUCKY_TED;
        	        System.out.println(job);
        	        stage.close();
        	        
        		} else {
        			
        			job = Job.WARRIOR;
        	        System.out.println(job);
        	        stage.close();
	    
        		}
        		
        		
        	}
        });
              	
        stage.showAndWait();
        	
        return job;
		
	}
	
	private static String makeName() {
		
		Stage stage = new Stage();
		
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(20, 80, 20, 80));
		
		Label label = new Label("Name:");
		
		TextField textField = new TextField ();
	
				
		Button button = new Button("submit");
	
		box.getChildren().addAll(label, textField);
		
		
		root.getChildren().addAll(box, button);
			
		Scene scene = new Scene(root, 400, 400);

        stage.setScene(scene);
        stage.setTitle("RPG");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
        	
        	@Override
        	public void handle(ActionEvent event) {
        		
        		name = textField.getText();
        		
        		if(textField.getText().isEmpty() == true) {
        			
        			name = "Are you too lazy to make a name?";
        		}
        		
        		stage.close();
        	}
        });
              	
        stage.showAndWait();
		
		
		return name;
		
	}
	
	
	private static void makeCharacter() {

		player = new Hero( makeName(), choseClass());

		if(name == null && job == null) {
			
			player = new Hero();
			
		}
		
			System.out.println(player.toString());
	}
	
	
	
	public static void movePlayer(int playerLocation) {
		//Get direction input
		//Do collision check
		//Move player if collision check returns false
		//Run randomEncounter method
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
		//Display list of items
			//Players can click on items to use them
		//Remove item from list when button is pressed
		//Update list to display the change
	}
	
	public static void randomEncounter() {
		int chance = rng.nextInt(100) + 1;
		
		if (chance > 90) {
			
			battleProcessing(generateMonster(determineMonsterToBattle(currentFloorNum)));
		}
		
	}
	
	public static int determineMonsterToBattle(int floorNumber) {
		int monsterKey;
		
		if(floorNumber == 1) {
			monsterKey = rng.nextInt(4) + 1;
			//1 giant rat
			//2 ghoul
			//3 slime
			//4 skeleton
		} else if(floorNumber == 2);
			monsterKey = rng.nextInt(6) + 4;
			//4 skeleton
			//5 massive rat
			//6 giga slime
			//7 zombie knight
			//8 vanguard
			//9 Drake
		return monsterKey;
	}
	
	public static Monster generateMonster(int monsterKey) {
		Monster monster = null;
		
		switch(monsterKey) {
		case 1:
			monster = new GiantRat();
			break;
		case 2:
			monster = new Ghoul();
			break;
		case 3:
			monster = new Slime();
			break;
		case 4:
			monster = new Skeleton();
			break;
		case 5:
			monster = new MassiveRat();
			break;
		case 6:
			monster = new GigaSlime();
			break;
		case 7:
			monster = new ZombieKnight();
			break;
		case 8:
			monster = new Vanguard();
			break;
		case 9:
			monster = new Drake();
			break;
		}
		
		
		
		return monster;
	}
	
	public static void battleProcessing(Monster monster) {
		
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
	
	public static void battleResults(Monster monster) {
		//Award EXP
			//Display EXP earned
			//Display previous EXP
				//Call level-up processing
					//If level up occurs, display a message, allow player to allocate their 5 stat points and continue
				//Display new EXP and new level/stats if applicable
	}
		
}

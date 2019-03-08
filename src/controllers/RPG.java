package controllers;


import java.util.Random;

import Monsters_RPG.Drake;
import Monsters_RPG.DungeonLord;
import Monsters_RPG.Ghoul;
import Monsters_RPG.GiantRat;
import Monsters_RPG.GigaSlime;
import Monsters_RPG.MassiveRat;
import Monsters_RPG.RatKing;
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
import models_RPG.Hero;
import models_RPG.Monster;
import rpgenums.Job;

public class RPG {
	private static String campaignName;
	private static Hero player;
	private static Monster monster;
	private static int playerDungeonLocationX;
	private static int playerDungeomLocationY;
	private static int currentFloorNum;
	private static int dungeonFloorSteps;
	private static int playerSteps;
	private static int battleTurn;
	private static int playerDamage;
	private static int monsterDamage;
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
              	
        
        stage.setScene(scene);
        stage.setTitle("RPG");
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
	
	
	
	public static void movePlayer() {
		playerSteps++;
		if(playerSteps == dungeonFloorSteps) {
			generateFloorBoss();
			battleProcessing();
			
		} else {
			randomEncounter();
		}
	}
	
	public static void inventory(Hero hero) {
		//Display list of items
			//Players can click on items to use them
		//Remove item from list when button is pressed
		//Update list to display the change
	}
	
	public static void randomEncounter() {
		int chance = rng.nextInt(100) + 1;
		
		if (chance > 90) {
			
			generateMonster(determineMonsterToBattle(currentFloorNum));
			battleProcessing();
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
	
	public static void generateMonster(int monsterKey) {
		monster = null;
		
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
	}
	
	public static void generateFloorBoss() {
		if(currentFloorNum == 1) {
			monster = new RatKing();
		} else if (currentFloorNum == 2) {
			monster = new DungeonLord();
		}
	}
	
	public static void battleProcessing() {
		
		do {
			playerTurn();
			enemyTurn();
			//Turns result pop-up
		} while (monster.isAlive() == true && player.isAlive() == true);
		
		if(player.isAlive() == false) {
			
		} else if(monster.isAlive() == false) {
			battleResults();							
		}
		
	}
	
	public static void playerTurn() {
		//Menu for player
		int attack = 0;
			
			//if(playerInput == attack) {
				//attack = player.calculateAttackWithWeapon(player.getStr(), player.getWeaponRating());
				//monster.takeDamage(attack);
			//} else if(playerInput == magicAttack) {
				//attack = player.caclulateMagicAttack();
				//monster.takeDamage(attack);
			//} else if(playerInput == useItem) {
				//inventory();
			//}
		playerDamage = attack;
		
	}
	
	public static void enemyTurn() {
		int attack = 0;
		
		if(player.isAlive() && monster.isAlive()) {
			int roll = rng.nextInt(2);
			if(roll == 0) {
				attack = monster.calculateAttack();
				player.takeDamage(attack);
			} else {
				attack = monster.caclulateMagicAttack();
				player.takeDamage(attack);
			}
		} else {
			
		}
		
		monsterDamage = attack;
	}
	
	public static void turnResults() {
		//Pop-up that shows:
			//Player action
				//If player attacked display "Player attacked Monster!"
				//If player used itme display "Player used X!"
			//Monster action
				//Display "Monster attacked Player!"
			//Display damage taken
				//Monster damage taken display as "Monster took X damage!"
				//Hero damage taken display as "Player took X damage!"
			//Display healing done if any
	}
	
	public static void battleResults() {
		player.earnEXP(monster.getEXPValue());
		//Award EXP
			//Display EXP earned
			//Display previous EXP
				//Call level-up processing
					//If level up occurs, display a message, allow player to allocate their 5 stat points and continue
				//Display new EXP and new level/stats if applicable
	}
	

	public static void gameOverLoss() {
		
	}
	
	public static void gameOverWin() {
		
	}

	public static String stats() {
		
		String playerStats = "Name: " + player.getName() + "\n" +
				 			 "Level: "	+ player.getLevel() + "\n" +
							 "Current Health: "  + player.getCurrentHP() + " / " + player.getBaseHP() + "\n" + 
							 "Current MP: " + player.getBaseMP() + " / " + player.getCurrentMP();
		
		
		
		
		return playerStats;
		
	}
		
}

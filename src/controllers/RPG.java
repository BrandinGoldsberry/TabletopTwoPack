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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models_RPG.Hero;
import models_RPG.Item;
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
	private static Item playerItemUsed;
	private static int playerHealing;
	private static Job job;
	
	private static String name = null;
	private static Random rng = new Random();
	
	public static void run() {
		makeCharacter();
		//generateFloor();
		
		generateMonster(9);
		
		//this method still needs to be finished i.e. combat stuff
		playerTurn();
		
		
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
        		
        		name = textField.getText().trim();
        		
        		if(textField.getText().isEmpty() == true || textField.getText().trim().isEmpty() == true) {
        			
        			name = "Billy Herrington";
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
			turnResults();
		
		} while (monster.isAlive() == true && player.isAlive() == true);

		if(player.isAlive() == false) {
			
			gameOverLoss();
			
		} else if(monster.isAlive() == false) {
			battleResults();							
		}
		

	}
	
	public static void playerTurn() {
		//Menu for player
		int attack = 0;
		int tempHeroHP = (int) player.getCurrentHP();
		int tempMonsterHP = (int) monster.getCurrentHP();
		playerItemUsed = null;
		playerHealing = 0;
		
		final String on = "-fx-background-color: red";

			
			//if(playerInput == attack) {
				//attack = player.calculateAttackWithWeapon(player.getStr(), player.getWeaponRating());
				//monster.takeDamage(attack);
			//} else if(playerInput == magicAttack) {
				//attack = player.caclulateMagicAttack();
				//monster.takeDamage(attack);
			//} else if(playerInput == useItem) {
				//inventory();
				//playerItemUsed = inventory.get(inventoryIndexForUsedItem);
				//if(tempHeroHP < player.getCurrentHP()){
					//playerHealing = player.getCurrentHP() - 
				//}
			//}
		if(tempMonsterHP > monster.getCurrentHP()) {
			attack = (int) (monster.getCurrentHP() - tempMonsterHP);
		} else {
			
		} 
		playerDamage = attack;
		
		Stage stage = new Stage();
		
		Label label = new Label();
		 label.setStyle(on);
	        
	     label.setMinSize(1600, 600);
	     label.setAlignment(Pos.TOP_CENTER);
		
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
		
		Text text = new Text();
        text.setTextAlignment(TextAlignment.LEFT);
        
       
        text.setText(stats() + "\n");
        
        Text monsterText = new Text();
        monsterText.setTextAlignment(TextAlignment.LEFT);
        monsterText.setText(monStats());
        
        Button[] buttons = new Button[3];
        
        buttons[0] = new Button("Attack"); 
        buttons[1] = new Button("Magic"); 
        buttons[2] = new Button("Item"); 
        
        buttons[0].setAlignment(Pos.CENTER_LEFT);
        buttons[1].setAlignment(Pos.CENTER_LEFT);
        buttons[2].setAlignment(Pos.CENTER_LEFT);
        
        VBox[] switchBox = new VBox[3];
        
        switchBox[0] = new VBox();
        switchBox[0].setAlignment(Pos.CENTER);
        switchBox[0].setPadding(new Insets(20, 80, 20, 80));
        switchBox[0].getChildren().addAll( label);
        
        switchBox[1] = new VBox();
        switchBox[1].setAlignment(Pos.CENTER_LEFT);
        switchBox[1].getChildren().addAll(text, monsterText);
        
        switchBox[2] = new VBox();
        switchBox[2].setAlignment(Pos.CENTER);
        switchBox[2].setPadding(new Insets(20, 80, 20, 80));
        switchBox[2].getChildren().addAll( buttons);
        
        
        
        root.getChildren().addAll(switchBox);
       // root.getChildren().addAll(buttons);
        
        Scene scene = new Scene(root, 1600, 750);

        stage.setScene(scene);
        stage.setTitle("Game");
      
        stage.show();

        buttons[0].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				//pass in basic bitch attack
				
				
				System.out.println("dong slap");
				
			}
		});	
        
        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				//pass in basic bitch magic attack
				
				System.out.println("wizard shit");
				
				
			}
		});	

        buttons[2].setOnAction(new EventHandler<ActionEvent>() {
	
        	@Override
        	public void handle(ActionEvent event) {

        		//pass in basic bitch magic attack
		
        		System.out.println("item shit");
		
		
			}
        });	
		
       
	
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
		Stage primaryStage = new Stage();				
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        
        Text playerAttack = new Text("Null field");
        Text monsterAttack = new Text("Null field");
        Text playerItem = new Text ("Null field");
        Text playerHealingDone = new Text("Null field");
        
        if(playerItemUsed != null) {
        	playerItem = new Text(player.getName() + " used " + playerItemUsed.getName());
        } else {
        	playerItem = new Text(player.getName() + " did not use an itme this round.");
        }
        
        if(playerDamage > 0) {
        	playerAttack = new Text(player.getName() + " attacked " + monster.getName() + " for " + playerDamage + " damage!");
        } else {
        	playerAttack = new Text(player.getName() + " did not do any damage this round.");
        }
        
        if(monsterDamage > 0) {
        	monsterAttack = new Text(monster.getName() + " attacked " + player.getName() + " for " + monsterDamage + " damage!");
        } else {
        	monsterAttack = new Text(monster.getName() + " did not do any damage this round.");
        }
        
        if(playerHealing > 0) {
        	playerHealingDone = new Text(player.getName() + " healed for " + playerHealing + " this round!");
        } else {
        	playerHealingDone = new Text(player.getName() + " did not do any healing this round.");
        }
        
        
        Button button = new Button("Okay");
        root.getChildren().addAll(playerItem, playerAttack, monsterAttack, playerHealingDone, button);
        
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				primaryStage.close();
			}
		});
        primaryStage.showAndWait();
		
		//Pop-up that shows:
			//Player action
				//If player attacked display "Player attacked Monster!"
				//If player used itme display "Player used X!"
			//Monster action
				//Display "Monster attacked Player!"
			//Display damage taken
				//Monster damage taken display as "Monster took X damage!"
				//Hero damage taken display as "Player took X damage!"
			//Display healing done if any as "Player healed X HP!"
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
		//Display pop-up graphic for gameOverLoss
		//Whatever is needed for game to exit
		Stage primaryStage = new Stage();				
				VBox root = new VBox();
	            root.setAlignment(Pos.CENTER);

	            Text text = new Text("You Are Dead.");
	            
	            Button button = new Button("Okay");
	            root.getChildren().addAll(text, button);
	            
	            Scene scene = new Scene(root, 150, 150);
	            primaryStage.setScene(scene);
	            
	            button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						
						primaryStage.close();
					}
				});
	            primaryStage.showAndWait();
	}
	
	public static void gameOverWin() {
		//display pop-up graphic for gameOverWin
			//Whatever is needed for game to exit
		Stage primaryStage = new Stage();				
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        Text text = new Text("You have shown the Dungeon Lord who's lord of this dungeon!");
        
        Button button = new Button("Okay");
        root.getChildren().addAll(text, button);
        
        Scene scene = new Scene(root, 150, 150);
        primaryStage.setScene(scene);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				primaryStage.close();
			}
		});
        primaryStage.showAndWait();
	}

	public static String stats() {
		
		String playerStats = "Name: " + player.getName() + "\n" +
				 			 "Level: "	+ player.getLevel() + "\n" +
							 "Current Health: "  + player.getCurrentHP() + " / " + player.getBaseHP() + "\n" + 
							 "Current MP: " + player.getBaseMP() + " / " + player.getCurrentMP();
		
		
		
		
		return playerStats;
		
	}
	
	public static String monStats() {
		
		
		String monsterStats = "Name: " + monster.getName() + "\n" +
							  "Current Hp: " + monster.getCurrentHP() + " / " + monster.getBaseHP();

		return monsterStats;
	}
	
	public static void generateFloor() {
		
		
		final String on = "-fx-background-color: red";
		
		Stage stage = new Stage();
		
		Text text = new Text();
		text.setText(RPG.stats());
		
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
		   
        Label label = new Label();
        
        label.setStyle(on);
        
        label.setMinSize(1600, 600);
        label.setAlignment(Pos.TOP_CENTER);
        
        VBox box = new VBox();
        
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(0, 80, 20, 80));
        
        Button[] buttons = new Button[3];
        
        buttons[0] = new Button("Items"); 
        buttons[1] = new Button("Step"); 
        buttons[2] = new Button("Save"); 
        
        buttons[0].setAlignment(Pos.CENTER_LEFT);
        buttons[1].setAlignment(Pos.CENTER_LEFT);
        buttons[2].setAlignment(Pos.CENTER_LEFT);
        
        GridPane gridPane = new GridPane();


        gridPane.add(buttons[0], 0, 0, 1, 1);
        gridPane.add(buttons[1], 1, 0, 1, 1);
        gridPane.add(buttons[2], 2, 0, 1, 1);
        gridPane.setAlignment(Pos.CENTER); 

        

        root.getChildren().addAll(label ,box);
        root.getChildren().addAll(gridPane);
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, 1600, 900);

        stage.setScene(scene);
        stage.setTitle("RPG");
       
        
        stage.show();
		
		
	}
}

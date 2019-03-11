package controllers;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Target;
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
import items.BottledLightning;
import items.Potion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models_RPG.BaseCharacter;
import models_RPG.Hero;
import models_RPG.Item;
import models_RPG.Monster;
import rpgenums.Job;

public class RPG implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String campaignName;
	private static Hero player;
	private static Monster monster;
	private static int playerDungeonLocationX;
	private static int playerDungeomLocationY;
	private static int currentFloorNum = 1;
	private static int dungeonFloorSteps = 100;
	private static int playerSteps;
	private static int battleTurn;
	private static int playerDamage;
	private static int monsterDamage;
	private static Item playerItemUsed;
	private static int playerHealing;
	private static Job job;
	private static FileInputStream inputStream = null ;
	private static String mapPNG;
	private static boolean playerHitFlag = true;
	private static boolean monsterHitFlag = true;
	private static boolean combat = false;

	private static String saveName;
	
	private static Item item;
	private static String name = null;
	private static Random rng = new Random();
	
	private static boolean dungeonLordDED = false;
	
	
	public static void run() {
		
		makeCharacter();
		
	
		
		for (int i = 0; i < 5; i++) {
		
		player.addToInventory(new Potion("Test Potion"));
		player.addToInventory(new BottledLightning("lighging test"));
		
		}
		
		
		do {
			
		generateFloor();
		
		} while (dungeonLordDED== false);
		
		//generateMonster(6);
		//combatWindow();
		
		//randomEncounter();
		
		//battleProcessing();
		
		//testWindow();

		
		//this method still needs to be finished i.e. combat stuff
		//playerTurn();
		
		
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
		
		Stage stage = new Stage();
		
		Button[] invButtons = new Button[player.getInventory().size()];
		
		ScrollPane scrollPane = new ScrollPane();
		
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		VBox root = new VBox();
		
		VBox inv = new VBox();
		
		
		for (int i = 0; i < player.getInventory().size(); i++) {
			
			invButtons[i] = new Button(player.getInventory().get(i).getName());
			
			invButtons[i].setId("id" +i);
			
			inv.getChildren().add(invButtons[i]);
			
			scrollPane.setContent(inv);
			
			int intI = i;
			
			invButtons[intI].setOnAction(new EventHandler<ActionEvent>() {
				
				
				
				@Override
				public void handle(ActionEvent event) {
					
					
					
					
					if(player.getInventory().get(intI).getOffensiveItem() == false) {
						
						System.out.println("item used on playef");
						player.getInventory().get(intI).use(player);
						
						player.getInventory().remove(intI);
						
					} else {
						
						if (combat == true) {
							
							System.out.println("item used on monster");
							player.getInventory().get(intI).use(monster);
							
							player.getInventory().remove(intI);
							
						}
						
					}
					
					stage.close();
					
				}
				
			});
			
		}
		
		root.getChildren().addAll(scrollPane, inv);
		
		Scene scene = new Scene(root, 300, 170);
		
		stage.setScene(scene);
		stage.setTitle("Inventory");
		
		
		
	
			
		stage.showAndWait();

		}
		
		
	
	
	public static void randomEncounter() {
		
		int chance = 0;
		
		chance = rng.nextInt(100) + 1;
		
		if (chance >= 90) {
			
			combat = true;
			
			generateMonster(determineMonsterToBattle(currentFloorNum));
			
			System.out.println(monStats());
			
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
			monsterKey = rng.nextInt(6) + 1;
			//4 skeleton
			//5 massive rat
			//6 giga slime
			//7 zombie knight
			//8 vanguard
			//9 Drake
		
		
		return monsterKey;
	}
	
	public static void generateMonster(int monsterKey) {
		
		mapPNG = "resources/RPG_Graphics/Dungeon_Skeleton.png";
		monster = new Skeleton();

		
		if(currentFloorNum == 1) {
			switch(monsterKey) {
			case 1:
				monster = new GiantRat();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_GiantRat.png";
				
				break;
			case 2:
				monster = new Ghoul();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Ghoul.png";
				
				break;
			case 3:
				monster = new Slime();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Slime.png";
				
				break;
			case 4:
				monster = new Skeleton();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Skeleton.png";
				
				System.out.println("skelebro");
				
				break;
			default:
				System.out.println("Default case hit");
				monster = new Skeleton();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Skeleton.png";
				
				break;
			}
		} else if (currentFloorNum == 2) {
			switch(monsterKey) {
			case 1:
				monster = new Skeleton();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Skeleton.png";
				
				System.out.println("skelebro");
				
				break;
			
			case 2:
				monster = new MassiveRat();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_MassiveRat.png";
				
				break;
			case 3:
				monster = new GigaSlime();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_GigaSlime.png";
				
				break;
			case 4:
				monster = new ZombieKnight();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_ZombieKnight.png";
				
				break;
			case 5:
				monster = new Vanguard();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Vanguard.png";
				
				break;
			case 6:
				monster = new Drake();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Drake.png";
				
				
				break;
			default:
				System.out.println("Default case hit");
				monster = new Skeleton();
				
				mapPNG = "resources/RPG_Graphics/Dungeon_Skeleton.png";
				
				break;
			}
		}
		
	}
	
	
	public static void generateFloorBoss() {
		if(currentFloorNum == 1) {
			monster = new RatKing();
			mapPNG = "resources/RPG_Graphics/Dungeon_RatKing.png";
		} else if (currentFloorNum == 2) {
			monster = new DungeonLord();
			mapPNG = "resources/RPG_Graphics/Dungeon_DungeonLord.png";
		}
		currentFloorNum = 2;
		dungeonFloorSteps = 240;
	}

	
	public static void battleProcessing() {
		
		do {
			//playerTurn(1);
			combatWindow();
			enemyTurn();
			turnResults();
		
		} while (monster.isAlive() == true && player.isAlive() == true);

		if(player.isAlive() == false) {
			
			gameOverLoss();
			
		} else if(monster.isAlive() == false) {
			battleResults();							
		}
		

	}
	
	public static void playerTurn(int playerInput) {
		//Menu for player
		int attack = 0;
		int tempHeroHP = (int) player.getCurrentHP();
		int tempMonsterHP = (int) monster.getCurrentHP();
		playerItemUsed = null;
		playerHealing = 0;
		playerHitFlag = true;
		
		if(playerInput == 1) {
			if(player.calculateHit() == true) {
				attack = player.calculateAttackWithWeapon(player.getStr(), player.getWeaponRating());
				monster.takeDamage(attack);
			} else {
				attack = 0;
				playerHitFlag = false;
			}
		} else if (playerInput == 2) {
			attack = player.caclulateMagicAttack();
			monster.takeDamage(attack);
		} else if (playerInput == 3) {
			inventory(player);
			if(tempHeroHP < player.getCurrentHP()) {
				playerHealing = (int) (player.getCurrentHP() - tempHeroHP);
			}
		}

		if(tempMonsterHP > monster.getCurrentHP()) {
			attack = tempMonsterHP - (int) (monster.getCurrentHP());
		} else {
			
		}
		
		playerDamage = attack;
		System.out.println(playerDamage);
		
		
//      if(playerInput == attack) {
//		attack = player.calculateAttackWithWeapon(player.getStr(), player.getWeaponRating());
//		monster.takeDamage(attack);
//	} else if(playerInput == magicAttack) {
//		attack = player.caclulateMagicAttack();
//		monster.takeDamage(attack);
//	} else if(playerInput == useItem) {
//		inventory();
//		playerItemUsed = inventory.get(inventoryIndexForUsedItem);
//		if(tempHeroHP < player.getCurrentHP()){
//			playerHealing = player.getCurrentHP() - 
//		}
//	}
	
	}
	
	public static void enemyTurn() {
		int attack = 0;
		monsterHitFlag = true;
		
		if(player.isAlive() && monster.isAlive()) {
			int roll = rng.nextInt(2);
			if(roll == 0) {
				if(monster.calculateHit() == true) {
					attack = monster.calculateAttack();
					player.takeDamage(attack);					
				} else {
					attack = 0;
					monsterHitFlag = false;
				}
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
        	playerItem = new Text(player.getName() + " did not use an item this round.");
        }
        
        if(playerHitFlag = true) {
        	if(playerDamage > 0) {
        		playerAttack = new Text(player.getName() + " attacked " + monster.getName() + " for " + playerDamage + " damage!");
        	} else {
        		playerAttack = new Text(player.getName() + " did not do any damage this round.");
        	}	
        } else {
        	playerAttack = new Text(player.getName() + " missed their attack!");
        }
        
        if(monsterHitFlag = true) {
        	if(monsterDamage > 0) {
        		monsterAttack = new Text(monster.getName() + " attacked " + player.getName() + " for " + monsterDamage + " damage!");
        	} else {
        		monsterAttack = new Text(monster.getName() + " did not do any damage this round.");
        	}        	
        } else {
        	monsterAttack = new Text(monster.getName() + " missed their attack!");
        }
        
        if(playerHealing > 0) {
        	playerHealingDone = new Text(player.getName() + " healed for " + playerHealing + " this round!");
        } else {
        	playerHealingDone = new Text(player.getName() + " did not do any healing this round.");
        }
        
        
        Button button = new Button("Okay");
        root.getChildren().addAll(playerItem, playerAttack, monsterAttack, playerHealingDone, button);
        
        Scene scene = new Scene(root, 250, 200);
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
		int roll = 0;
		boolean newWeapon = false;
		boolean newArmor = false;
		int tempLevel = player.getLevel();
		boolean itemDropped = false;
		
		if(monster.getName() == "Dungeon Lord") {
			dungeonLordDED = true;
		} else {
			
		}
		
		player.earnEXP(monster.getEXPValue());
		if(monster.calculateItemDrop() == true) {
			player.addToInventory(monster.getHeldItem());
			itemDropped = true;
		} else {
			
		}
		
		if(currentFloorNum == 1) {
			roll = rng.nextInt(100 + (player.getLuc() / 3)) + 1;
			if(roll > 40) {
				player.setWeaponRating(player.getWeaponRating() + rng.nextInt(3) + 1);
				player.randomWeapon();
				newWeapon = true;
			} else {
				
			}
			roll = rng.nextInt(100 + (player.getLuc() / 3)) + 1;
			if(roll > 40) {
				player.setArmorRating(player.getWeaponRating() + rng.nextInt(3) + 1);
				player.randomArmor();
			} else {
				
			}
			
		} else if (currentFloorNum == 2) {
			roll = rng.nextInt(100 + (player.getLuc() / 3)) + 1;
			if(roll > 40) {
				player.setWeaponRating(player.getWeaponRating() + rng.nextInt(5) + 1);
				player.randomWeapon();
				newWeapon = true;
			} else {
				
			}
			roll = rng.nextInt(100 + (player.getLuc() / 3)) + 1;
			if(roll > 40) {
				player.setArmorRating(player.getWeaponRating() + rng.nextInt(5) + 1);
				player.randomArmor();
			} else {
				
			}
		}
		
		Stage primaryStage = new Stage();				
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        
        Text expEarned = new Text(player.getName() + " has earned " + monster.getEXPValue() + " EXP from this encounter!");
        Text levelUp = new Text(player.getName() + " has not leveled up from this encounter.");
        Text weaponChange = new Text(player.getName() + " didn't find a new weapon after this battle.");
        Text armorChange = new Text(player.getName() + " didn't find a new set of armor after this battle.");
        Text itemObtained = new Text(player.getName() + " didn't find any items after this battle.");
        
        if(player.getLevel() > tempLevel) {
        	levelUp = new Text(player.getName() + " has gained " + (player.getLevel() - tempLevel) + " levels!");
        }
        
        if(newWeapon) {
        	weaponChange = new Text(player.getName() + " has obtained a new " + player.getWeapon() + " with a " + player.getWeaponRating() + " rating!");
        }
        
        if(newArmor) {
        	armorChange = new Text(player.getName() + " has obtained a new set of " + player.getArmor() + " with a " + player.getArmorRating());
        }
        
        if(itemDropped) {
        	itemObtained = new Text(player.getName() + " has obtained " + monster.getHeldItem().getName() + "!");
        }
        
        Button button = new Button("Okay");
        root.getChildren().addAll(expEarned, levelUp, weaponChange, armorChange, itemObtained, button);
        
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				primaryStage.close();
			}
		});
        primaryStage.showAndWait();
		//Award EXP
			//Display EXP earned
			//Display previous EXP
				//Call level-up processing
					//If level up occurs, display a message, allow player to allocate their 5 stat points and continue
				//Display new EXP and new level/stats if applicable
	}
	
	public static void levelUpScreen() {
		//TODO
	}
	
	public static void saveGame() {
		//TODO
Stage stage = new Stage();
		
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(20, 80, 20, 80));
		
		Label label = new Label("File Directory:");
		
		TextField textField = new TextField ();
	
		Button button = new Button("submit");
	
		box.getChildren().addAll(label, textField);
		
		
		root.getChildren().addAll(box, button);
			
		Scene scene = new Scene(root, 400, 400);

		
        stage.setScene(scene);
        stage.setTitle("Save Game");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
        	
        	@Override
        	public void handle(ActionEvent event) {
        		
        		saveName = textField.getText().trim() + ".ser";
    				try {
    					FileOutputStream file = new FileOutputStream(saveName);
    					ObjectOutputStream out = new ObjectOutputStream(file);
    					
    					//Finish this out.writeObject();
    					
    					out.close();
    					file.close();
    					
    					
    				} catch(IOException ioe) {
    				} 
        		stage.close();
        	}
        });
              	
        stage.showAndWait();

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
	            
	            dungeonLordDED = true;
	            
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
        
        dungeonLordDED = true;

        
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
		
		System.out.println(monster.toString());
		
		String monsterStats = "Name: " + monster.getName() + "\n" +
							  "Current Hp: " + monster.getCurrentHP() + " / " + monster.getBaseHP();

		return monsterStats;
	}
	
	public static void generateFloor() {
		
		combat = false;
		
		try {
			inputStream = new FileInputStream("resources/RPG_Graphics/Dungeon_Empty.png");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Image image = new Image(inputStream);
		
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setSmooth(true);
		imageView.setVisible(true);
		
		Stage stage = new Stage();
		
		Text text = new Text();
		text.setText(RPG.stats());
		
		Text text2 = new Text("Steps Taken: " + playerSteps);
		
		Text text3 = new Text("Current Floor: " + currentFloorNum);
		
		VBox root = new VBox();
       // root.setAlignment(Pos.CENTER);
		
        
        HBox box = new HBox();
   
        box.getChildren().add(imageView);
        
        
        
        Button[] buttons = new Button[4];
        
        buttons[0] = new Button("Items"); 
        buttons[1] = new Button("Step"); 
        buttons[2] = new Button("Save"); 
        buttons[3] = new Button("Exit");
        
        buttons[0].setAlignment(Pos.CENTER_LEFT);
        buttons[1].setAlignment(Pos.CENTER_LEFT);
        buttons[2].setAlignment(Pos.CENTER_LEFT);
        buttons[3].setAlignment(Pos.CENTER_LEFT);
        
        GridPane gridPane = new GridPane();


        gridPane.add(buttons[0], 0, 0, 1, 1);
        gridPane.add(buttons[1], 1, 0, 1, 1);
        gridPane.add(buttons[2], 2, 0, 1, 1);
        gridPane.add(buttons[3], 3, 0, 1, 1);
        
        gridPane.setAlignment(Pos.CENTER); 

        

        //box.getChildren().add(imageView);
        root.getChildren().addAll(box);
        root.getChildren().addAll(gridPane);
        root.getChildren().add(text);
        root.getChildren().add(text2);
        Scene scene = new Scene(root, 500, 700);
        
        
        stage.setScene(scene);
        stage.setTitle("RPG");
        
        
        buttons[0].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				System.out.println("look at yoour damn bag");
				
				inventory(player);
				
			}
			
		});
        
        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				

				movePlayer();
				stage.close();
				
			}
			
		});
        
        buttons[2].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				System.out.println("stop being a pussy by always saving");
				
				
				
			}
			
		}); 
        
        buttons[3].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				dungeonLordDED = true;
				stage.close();
				
			}
			
		});
        
        stage.showAndWait();
		
		
	}
	
	private static void combatWindow() {
		
		inputStream = null;
		
		combat = true;
		
		
		try {
			inputStream = new FileInputStream(mapPNG);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Stage stage = new Stage();
		
		Image image = new Image(inputStream);
		
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setSmooth(true);
		imageView.setVisible(true);
		
		
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
        switchBox[0].getChildren().add(imageView);
        
        switchBox[1] = new VBox();
        switchBox[1].setAlignment(Pos.CENTER_LEFT);
        switchBox[1].getChildren().addAll(text, monsterText);
        
        switchBox[2] = new VBox();
        switchBox[2].setAlignment(Pos.CENTER);
        switchBox[2].setPadding(new Insets(20, 80, 20, 80));
        switchBox[2].getChildren().addAll( buttons);
        
        
        
        root.getChildren().addAll(switchBox);
       // root.getChildren().addAll(buttons);
        
        Scene scene = new Scene(root, 500, 750);

        stage.setScene(scene);
        stage.setTitle("Game");
      
        
        buttons[0].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				//pass in basic attack
				//attack = player.calculateAttackWithWeapon(player.getStr(), player.getWeaponRating());
				//monster.takeDamage(attack);
				
				playerTurn(1);
				
				stage.close();
				
			}
		});	
        
        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				//pass in magic attack
				
				playerTurn(2);
				stage.close();
				
				
			}
		});	

        buttons[2].setOnAction(new EventHandler<ActionEvent>() {
	
        	@Override
        	public void handle(ActionEvent event) {

        		//pass in item
        		
				playerTurn(3);

				stage.close();
			}
        });	
        
        
        
		
        stage.showAndWait();
	}
	
	private static void testWindow() {
		
		for(int i = 1; i < 10; i++) {
			
			generateMonster(i);
			combatWindow();
			
		}
		
		
	}
	
}

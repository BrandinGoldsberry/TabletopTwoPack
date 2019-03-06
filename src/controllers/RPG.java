package controllers;


import java.util.HashMap;

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
	private static HashMap<String, Monster> monsterList = new HashMap();
	private static Job job;
	
	private static String name = null;
	
	
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
		
		
		
		root.getChildren().addAll(box, rb1, rb2, rb3, rb4, button);
			
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

		
		
		System.out.println(player.toString());
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

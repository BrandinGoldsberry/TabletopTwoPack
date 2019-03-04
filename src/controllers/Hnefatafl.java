package controllers;

import java.util.HashMap;

import hnefataflModels.Attacker;
import hnefataflModels.CoordinateKey;
import hnefataflModels.Defender;
import hnefataflModels.Game;
import hnefataflModels.King;
import hnefataflModels.Piece;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hnefatafl {
	
	private static Game game;
	private static int turn;
	private static boolean end = false;
	private static GridPane grid;
	
	public static void run() {
		init();
	}
	
	public static void createWindow() {
		Stage nhef = new Stage();
		HBox root = new HBox();
		root.setAlignment(Pos.CENTER);
		grid = new GridPane();
		grid.setGridLinesVisible(true);
		root.getChildren().add(grid);
		Scene SC = new Scene(root, 400, 400);
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				ImageView newImage = new ImageView();
				grid.add(newImage, j, i, 1, 1);
			}
		}
		System.out.println(grid.getChildren().size());
		nhef.setScene(SC);
		nhef.show();
	}
	
	private static void init() {
		createWindow();
		Image defenderImg = null;
		Image attackerImg = null;
		Image kingImg = null;
		defenderImg = new Image("file:resources/nhefetafl/defender.png", 100, 100, true, true);
		attackerImg = new Image("file:resources/nhefetafl/attacker.png", 100, 100, true, true);
		kingImg = new Image("file:resources/nhefetafl/King.png", 100, 100, true, true);
		
		CoordinateKey[] defenderPos;
		CoordinateKey[] attackerPos;
		
		Defender[] defenders = new Defender[12];
		Attacker[] attackers = new Attacker[24];
		
		defenderPos = initDef();
		attackerPos = initAtt();
		
		HashMap<CoordinateKey, Piece> pieces = new HashMap<>();
		
		defenderPos[10].equals(6, 6);
		defenderPos[11].equals(6, 6);
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				pieces.put(new CoordinateKey(i, j), null);
			}
		}
		
		for(int i = 0; i < 12; i++) {
			if(defenderPos[i].equals(6, 6)) {
				defenders[i] = new King(kingImg);
				pieces.put(defenderPos[i], defenders[i]);	
			} else {
				defenders[i] = new Defender(defenderImg);
				pieces.put(defenderPos[i], defenders[i]);				
			}
		}
		
		for(int i = 0; i < 24; i++) {
			attackers[i] = new Attacker(attackerImg);
			pieces.put(attackerPos[i], attackers[i]);
		}
		
		game = new Game(pieces);
		update();
	}
	
	private static CoordinateKey[] initAtt() {
		int ckCount = 0;
		CoordinateKey[] attackerPos = new CoordinateKey[24];
		
		for(int i = 4; i <= 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(1, i);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(2, 6);
		ckCount++;
		
		for(int i = 4; i <= 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(i, 1);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(6, 2);
		ckCount++;
		
		for(int i = 4; i <= 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(11, i);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(10, 6);
		ckCount++;
		
		for(int i = 4; i <= 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(i, 11);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(6, 10);
		ckCount++;
		System.out.println(ckCount);
		return attackerPos;
	}
	
	private static CoordinateKey[] initDef() {
		int ckCount = 0;
		
		CoordinateKey[] defenderPos = new CoordinateKey[13];
		
		defenderPos[ckCount] = new CoordinateKey(4, 6);
		ckCount++;
		
		for(int i = 5; i <= 7; i++) {
			defenderPos[ckCount] = new CoordinateKey(5, i);
			ckCount++;
		}
		
		for(int i = 4; i <= 8; i++) {
			defenderPos[ckCount] = new CoordinateKey(6, i);
			ckCount++;
		}
		
		for(int i = 5; i <= 7; i++) {
			defenderPos[ckCount] = new CoordinateKey(7, i);
			ckCount++;
		}
		
		defenderPos[ckCount] = new CoordinateKey(8, 6);
		return defenderPos;
	}
	
	private static void playGame() {

	}
	
	private static void update() {
		int pCount = 0;
		
		int d = 0;
		int a = 0;
		for(CoordinateKey key : game.getPieces().keySet()) {
			Piece toShow = game.getPieces().get(key);
			if(game.getPieces().get(key) != null) {
				if(toShow.getClass().getName().equals("hnefataflModels.Defender")) {
					d++;
				}
				if(toShow.getClass().getName().equals("hnefataflModels.Attacker")) {
					a++;
				}
				ImageView IV = (ImageView) getNodeFromGridPane(grid, key.getY(), key.getX());
				IV.setImage(game.getPieces().get(key).GetSprite());
			} else {
				ImageView IV = (ImageView) getNodeFromGridPane(grid, key.getY(), key.getX());
				IV.setImage(new Image("file:resources/nhefetafl/emptyWhite.png", 100, 100, true, true));
			}
			pCount++;
		}
		System.out.println(a);
		System.out.println(d);
		movePiece();
	}
	
	
	//Code orignally from Shreyas Dave - https://stackoverflow.com/questions/20655024/javafx-gridpane-retrieve-specific-cell-content
	//To be fair, this should be a native part of the GridPane... but its not
	private static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	    for (Node node : gridPane.getChildren()) {
	    	if(node.getClass().getName().equals("javafx.scene.image.ImageView")) {
	    		if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
	    			return node;
	    		}	    		
	    	}
	    }
	    return null;
	}
	
	private static void takeTurn() {
		checkForWin();
	}
	
	private static void movePiece() {
		
	}

//	private static void removePiece() {
//		
//	}
	
	private static void checkForWin() {
		declareWinner();
	}
	
	private static void declareWinner() {
		displayEndGameMenu();
	}
	
	private static void displayEndGameMenu() {
		
	}
}

package controllers;

import java.util.HashMap;

import hnefataflModels.Attacker;
import hnefataflModels.CoordinateKey;
import hnefataflModels.Defender;
import hnefataflModels.Game;
import hnefataflModels.King;
import hnefataflModels.Piece;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
		grid = new GridPane();
		Scene SC = new Scene(grid, 400, 400);
		
		for(int i = 1; i < 12; i++) {
			for(int j = 1; j < 12; j++) {
				ImageView newImage = new ImageView();
				grid.add(newImage, i, j);
			}
		}
		
		nhef.setScene(SC);
		nhef.show();
	}
	
	private static void init() {
		createWindow();
		Image defenderImg = null;
		Image attackerImg = null;
		Image kingImg = null;
		defenderImg = new Image("file:resources/nhefetafl/defender.png", 100, 100, true, true);
		attackerImg = new Image("file:attacker.png", 100, 100, true, true);
		kingImg = new Image("file:King.png", 100, 100, true, true);
		
		CoordinateKey[] defenderPos;
		CoordinateKey[] attackerPos;
		
		Defender[] defenders = new Defender[12];
		Attacker[] attackers = new Attacker[24];
		
		defenderPos = initDef();
		attackerPos = initAtt();
		
		HashMap<CoordinateKey, Piece> pieces = new HashMap<>();
		
		defenderPos[10].equals(6, 6);
		defenderPos[11].equals(6, 6);
		
		for(int i = 0; i < 12; i++) {
			if(defenderPos[i].equals(6, 6)) {
				defenders[i] = new King(kingImg);
				pieces.put(defenderPos[i], defenders[i]);	
			} else {
				defenders[i] = new Defender(defenderImg);
				pieces.put(defenderPos[i], defenders[i]);				
			}
		}
		
		for(int i = 0; i < 12; i++) {
			attackers[i] = new Attacker(attackerImg);
			pieces.put(attackerPos[i], attackers[i]);
		}
		
		game = new Game(pieces);
		update();
	}
	
	private static CoordinateKey[] initAtt() {
		int ckCount = 0;
		CoordinateKey[] attackerPos = new CoordinateKey[24];
		
		for(int i = 4; i < 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(1, i);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(2, 6);
		ckCount++;
		
		for(int i = 4; i < 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(i, 1);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(6, 2);
		ckCount++;
		
		for(int i = 4; i < 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(11, i);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(10, 6);
		ckCount++;
		
		for(int i = 4; i < 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(i, 11);
			ckCount++;
		}
		attackerPos[ckCount] = new CoordinateKey(6, 10);
		ckCount++;
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
		for(Piece p : game.getPieces().values()) {
//			ImageView IV = (ImageView) grid.get
//			IV.setImage(p.GetSprite());
			pCount++;
		}
		
		movePiece();
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

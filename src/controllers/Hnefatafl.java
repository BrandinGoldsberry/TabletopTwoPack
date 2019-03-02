package controllers;

import java.util.HashMap;

import hnefataflModels.Attacker;
import hnefataflModels.CoordinateKey;
import hnefataflModels.Defender;
import hnefataflModels.Game;
import hnefataflModels.King;
import hnefataflModels.Piece;
import javafx.scene.image.Image;

public class Hnefatafl {
	
	private static Game game;
	private static
	int turn;
	
	public static void run() {
		init();
	}
	
	private static void init() {
		Image defenderImg = new Image("/TabletopTwoPack/resources/nhefetafl/defender.png");
		Image attackerImg = new Image("/TabletopTwoPack/resources/nhefetafl/attacker.png");
		Image kingImg = new Image("/TabletopTwoPack/resources/nhefetafl/King.png");
		
		CoordinateKey[] defenderPos = new CoordinateKey[12];
		CoordinateKey[] attackerPos = new CoordinateKey[24];
		
		Defender[] defenders = new Defender[12];
		Attacker[] attackers = new Attacker[24];
		
		initDef(defenderPos);
		initAtt(attackerPos);
		
		HashMap<CoordinateKey, Piece> pieces = new HashMap<>();
		
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
		
		defenders[11] = new King(kingImg);
		
		game = new Game(pieces);
	}
	
	private static void initDef(CoordinateKey[] defenderPos) {
		int ckCount = 0;
		
		for(int i = 4; i < 8; i++) {
			defenderPos[ckCount] = new CoordinateKey(1, i);
			ckCount++;
		}
		defenderPos[ckCount] = new CoordinateKey(2, 6);
		ckCount++;
		
		for(int i = 4; i < 8; i++) {
			defenderPos[ckCount] = new CoordinateKey(i, 1);
			ckCount++;
		}
		defenderPos[ckCount] = new CoordinateKey(6, 2);
		ckCount++;
		
		for(int i = 4; i < 8; i++) {
			defenderPos[ckCount] = new CoordinateKey(11, i);
			ckCount++;
		}
		defenderPos[ckCount] = new CoordinateKey(10, 6);
		ckCount++;
		
		for(int i = 4; i < 8; i++) {
			defenderPos[ckCount] = new CoordinateKey(i, 11);
			ckCount++;
		}
		defenderPos[ckCount] = new CoordinateKey(6, 10);
		ckCount++;
	}
	
	private static void initAtt(CoordinateKey[] attackerPos) {
		int ckCount = 0;
		
		attackerPos[ckCount] = new CoordinateKey(4, 6);
		ckCount++;
		
		for(int i = 5; i < 7; i++) {
			attackerPos[ckCount] = new CoordinateKey(5, i);
			ckCount++;
		}
		
		for(int i = 4; i < 8; i++) {
			attackerPos[ckCount] = new CoordinateKey(6, i);
			ckCount++;
		}
		
		for(int i = 5; i < 7; i++) {
			attackerPos[ckCount] = new CoordinateKey(7, i);
			ckCount++;
		}
		
		attackerPos[ckCount] = new CoordinateKey(8, 6);
	}
	
	private static void playGame() {
		
	}
	
	private static void update() {
		
	}
	
	private static void takeTurn() {
		
	}
	
	private static void movePiece() {
		
	}

//	private static void removePiece() {
//		
//	}
	
	private static void checkForWin() {
		
	}
	
	private static void declareWinner() {
		
	}
	
	private static void displayEndGameMenu() {
		
	}
}

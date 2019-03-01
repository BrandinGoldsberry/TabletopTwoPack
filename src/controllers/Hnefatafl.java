package controllers;

import hnefataflModels.Attacker;
import hnefataflModels.CoordinateKey;
import hnefataflModels.Defender;
import hnefataflModels.Game;
import hnefataflModels.King;
import javafx.scene.image.Image;

public class Hnefatafl {
	
	private Game game;
	private int turn;
	
	public static void run() {
		
	}
	
	private static void init() {
		Image defenderImg = new Image("/TabletopTwoPack/resources/nhefetafl/defender.png");
		Image attackerImg = new Image("/TabletopTwoPack/resources/nhefetafl/attacker.png");
		Image kingImg = new Image("/TabletopTwoPack/resources/nhefetafl/King.png");
		
		CoordinateKey[] defenderPos = new CoordinateKey[24];
		CoordinateKey[] attackerPos = new CoordinateKey[12];
		
		Defender[] defenders = new Defender[12];
		Attacker[] attackers = new Attacker[24];
		
		for(CoordinateKey ck : defenderPos) {
			
		}
		
		for(Defender d : defenders) {
			d = new Defender(defenderImg);
		}
		
		for(Attacker a : attackers) {
			a = new Attacker(attackerImg);
		}
		
		defenders[11] = new King(kingImg);
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

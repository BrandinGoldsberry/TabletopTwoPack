package controllers;

import hnefataflModels.Attacker;
import hnefataflModels.Defender;
import hnefataflModels.Game;
import hnefataflModels.King;
import hnefataflModels.Piece;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Hnefatafl {
	
	private static Game game;
	private static int turn;
	private static GridPane grid;
	private static Piece[][] board;
	private static int turnCount = 0;
	
	private static int firstX;
	private static int firstY;
	private static int moveX;
	private static int moveY;
	private static boolean firstClick = false;
	
	private static ImageView lastClicked;
	private static ImageView lastHovered;
	
	private static boolean KingIsDead = false;
	
	public static void SetKingIsDead(boolean isDead) {
		KingIsDead = isDead;
	}
	
	public static void run() {
		init();
	}
	
	public static void createWindow() {
		Stage nhef = new Stage();
		HBox root = new HBox();
		VBox Misc = new VBox();
		Button instructions = new Button();
		Label TurnLabel = new Label();
//		root.setAlignment(Pos.CENTER);
		grid = new GridPane();
		grid.setGridLinesVisible(true);
		root.getChildren().add(grid);
		root.getChildren().add(Misc);
		Misc.getChildren().add(instructions);
		Misc.getChildren().add(TurnLabel);
		
		
		instructions.setText("How To Play");
		
		instructions.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				Stage HTP = new Stage();
				VBox root = new VBox();
				Label text = new Label();
				text.setText("Hnefatafl is a two-player game where each person is either the attackers or defenders.\r\n" + 
						"Hnefatafl is played with the attackers going first (black pieces). The goal of the attacker is to capture the King by surrounding it on all four cardinal sides (north, east, south, and west). \r\n" + 
						"The defenders win by getting the King to any of the four corners. Pieces can only be moved in the afore mentioned cardinal directions. \r\n" + 
						"Normal pieces are captured by surrounding them on two opposite sides (north and south or east and west).");
				root.getChildren().add(text);
				Scene HTPSC = new Scene(root);
				HTP.setScene(HTPSC);
				HTP.show();
			}
		});
		
		Scene SC = new Scene(root, 500, 500); 
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				ImageView newImage = new ImageView();
				Text debugId = new Text();
				newImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
					
					@Override
					public void handle(Event event) {
						if(!firstClick) {
							lastClicked = newImage;
							firstX = GridPane.getRowIndex(lastClicked);
							firstY = GridPane.getColumnIndex(lastClicked);
							int x = GridPane.getRowIndex(newImage);
							int y = GridPane.getColumnIndex(newImage);
							Piece hovered = game.getPieces()[x][y];
							if(hovered != null) {
								firstClick = true;
								debugId.setText(Integer.toString(hovered.getId()));								
							}
						} else {
							lastClicked = newImage;
							moveX = GridPane.getRowIndex(lastClicked);
							moveY = GridPane.getColumnIndex(lastClicked);
							if(moveX == firstX && moveY == firstY) {
							} else {
								firstClick = false;
								
								if(turnCount % 2 == 0) {
									if (board[firstX][firstY].toString().equals("Attacker")) {
										game.movePiece(firstX, firstY, moveX, moveY);
										update();
										turnCount++;
										TurnLabel.setText("It is Now Defender (White's) turn");
									}
								} else {
									if (board[firstX][firstY].toString().equals("Defender") || board[firstX][firstY].toString().equals("King")) {
										game.movePiece(firstX, firstY, moveX, moveY);
										update();
										turnCount++;
										TurnLabel.setText("It is Now Attacker (Black's) turn");
									}
								}
							}
						}
					}
				});
				
				newImage.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<Event>() {
					@Override
					public void handle(Event arg0) {
						// TODO Auto-generated method stub
						lastHovered = newImage;
						int x = GridPane.getRowIndex(newImage);
						int y = GridPane.getColumnIndex(newImage);
						Piece hovered = game.getPieces()[x][y];
						if(hovered != null) {
							debugId.setText(Integer.toString(hovered.getId()));
//							System.out.println(hovered.getId());						
						}
					}
				});
				grid.add(newImage, j, i, 1, 1);
				grid.add(debugId, j, i, 1, 1);
			}
		}
		nhef.setScene(SC);
		nhef.setFullScreen(true);
		nhef.show();
	}
	
	private static void init() {
		createWindow();
		board = new Piece[11][11];
		Image defenderImg = null;
		Image attackerImg = null;
		Image kingImg = null;
		defenderImg = new Image("file:resources/nhefetafl/defender.png", 75, 75, true, true);
		attackerImg = new Image("file:resources/nhefetafl/attacker.png", 75, 75, true, true);
		kingImg = new Image("file:resources/nhefetafl/King.png", 75, 75, true, true);

		Defender[] defenders = new Defender[13];
		Attacker[] attackers = new Attacker[24];
		
		board[0][3] = new Attacker(attackerImg);
		board[0][4] = new Attacker(attackerImg);
		board[0][5] = new Attacker(attackerImg);
		board[0][6] = new Attacker(attackerImg);
		board[0][7] = new Attacker(attackerImg);
		board[1][5] = new Attacker(attackerImg);
		
		board[10][3] = new Attacker(attackerImg);
		board[10][4] = new Attacker(attackerImg);
		board[10][5] = new Attacker(attackerImg);
		board[10][6] = new Attacker(attackerImg);
		board[10][7] = new Attacker(attackerImg);
		board[9][5] = new Attacker(attackerImg);
		
		board[3][0] = new Attacker(attackerImg);
		board[4][0] = new Attacker(attackerImg);
		board[5][0] = new Attacker(attackerImg);
		board[6][0] = new Attacker(attackerImg);
		board[7][0] = new Attacker(attackerImg);
		board[5][1] = new Attacker(attackerImg);
		
		board[3][10] = new Attacker(attackerImg);
		board[4][10] = new Attacker(attackerImg);
		board[5][10] = new Attacker(attackerImg);
		board[6][10] = new Attacker(attackerImg);
		board[7][10] = new Attacker(attackerImg);
		board[5][9] = new Attacker(attackerImg);
		
		board[5][5] = new King(kingImg);
		board[4][5] = new Defender(defenderImg);
		board[6][5] = new Defender(defenderImg);
		board[7][5] = new Defender(defenderImg);
		board[3][5] = new Defender(defenderImg);
		board[4][4] = new Defender(defenderImg);
		board[4][6] = new Defender(defenderImg);
		board[5][4] = new Defender(defenderImg);
		board[6][4] = new Defender(defenderImg);
		board[5][6] = new Defender(defenderImg);
		board[5][7] = new Defender(defenderImg);
		board[5][3] = new Defender(defenderImg);
		board[6][6] = new Defender(defenderImg);
		
		for(int x = 0; x<board.length; x++) {
			for(int y = 0; y<board[x].length; y++) {
				if (board[x][y] == null) {
					Piece toShow = board[x][y];
					if(toShow != null) {
						ImageView IV = (ImageView) getNodeFromGridPane(grid, y, x);
						IV.setImage(board[x][y].GetSprite());
					} else {
						ImageView IV = (ImageView) getNodeFromGridPane(grid, y, x);
						IV.setImage(new Image("file:resources/nhefetafl/emptyWhite.png", 75, 75, true, true));
					}
				}
			}
		}
		
		game = new Game(board);
		update();
	}

	
	private static void playGame() {

	}
	
	public static void update() {
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board = game.getPieces();
				Piece toShow = board[i][j];
				if(toShow != null) {
					ImageView IV = (ImageView) getNodeFromGridPane(grid, j, i);
					IV.setImage(board[i][j].GetSprite());
				} else {
					ImageView IV = (ImageView) getNodeFromGridPane(grid, j, i);
					IV.setImage(new Image("file:resources/nhefetafl/emptyWhite.png", 75, 75, true, true));
				}
			}
		}
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

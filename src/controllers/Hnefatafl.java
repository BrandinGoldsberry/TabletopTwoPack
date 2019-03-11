package controllers;

import hnefataflModels.Attacker;
import hnefataflModels.Defender;
import hnefataflModels.Game;
import hnefataflModels.King;
import hnefataflModels.Piece;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Hnefatafl {

	private static Game game;
	private static int turn;
	private static GridPane grid;
	private static Piece[][] board = new Piece[11][11];

	private static int firstX;
	private static int firstY;
	private static int moveX;
	private static int moveY;
	private static boolean firstClick = false;

	private static ImageView lastClicked;
	private static ImageView lastHovered;

	private static Image defenderImg = new Image("file:resources/nhefetafl/defender.png", 75, 75, true, true);
	private static Image attackerImg = new Image("file:resources/nhefetafl/attacker.png", 75, 75, true, true);
	private static Image kingImg = new Image("file:resources/nhefetafl/King.png", 75, 75, true, true);

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
		Scene SC = new Scene(root, 500, 500);

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				ImageView newImage = new ImageView();
				Text debugId = new Text();
				newImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
					@Override
					public void handle(Event event) {
						if (!firstClick) {
							lastClicked = newImage;
							firstX = GridPane.getRowIndex(lastClicked);
							firstY = GridPane.getColumnIndex(lastClicked);
							int x = GridPane.getRowIndex(newImage);
							int y = GridPane.getColumnIndex(newImage);
							Piece hovered = game.getPieces()[x][y];
							if (hovered != null) {
								firstClick = true;
								debugId.setText(Integer.toString(hovered.getId()));
							}
						} else {
							lastClicked = newImage;
							moveX = GridPane.getRowIndex(lastClicked);
							moveY = GridPane.getColumnIndex(lastClicked);
							if (moveX == firstX && moveY == firstY) {
							} else {
								System.out.println(game.movePiece(firstX, firstY, moveX, moveY));
								firstClick = false;
								int x = GridPane.getRowIndex(newImage);
								int y = GridPane.getColumnIndex(newImage);
								Piece hovered = game.getPieces()[x][y];
								debugId.setText(Integer.toString(hovered.getId()));
								update();
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
						if (hovered != null) {
							debugId.setText(Integer.toString(hovered.getId()));
							System.out.println(hovered.getId());
						}
					}
				});
				grid.add(newImage, j, i, 1, 1);
				grid.add(debugId, j, i, 1, 1);
			}
		}
		nhef.setScene(SC);
		nhef.show();
	}

	private static void init() {
		createWindow();

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

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					Piece toShow = board[i][j];
					if (toShow != null) {
						ImageView IV = (ImageView) getNodeFromGridPane(grid, j, i);
						IV.setImage(board[i][j].GetSprite());
					} else {
						ImageView IV = (ImageView) getNodeFromGridPane(grid, j, i);
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
			for (int j = 0; j < board[i].length; j++) {
				board = game.getPieces();
				Piece toShow = board[i][j];
				if (toShow != null) {
					ImageView IV = (ImageView) getNodeFromGridPane(grid, j, i);
					IV.setImage(board[i][j].GetSprite());
				} else {
					ImageView IV = (ImageView) getNodeFromGridPane(grid, j, i);
					IV.setImage(new Image("file:resources/nhefetafl/emptyWhite.png", 75, 75, true, true));
				}
			}
		}
	}

	// Code orignally from Shreyas Dave -
	// https://stackoverflow.com/questions/20655024/javafx-gridpane-retrieve-specific-cell-content
	// To be fair, this should be a native part of the GridPane... but its not
	private static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren()) {
			if (node.getClass().getName().equals("javafx.scene.image.ImageView")) {
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
		String winner = "";
		
		if (board[0][0].GetSprite().equals(kingImg) || board[0][10].GetSprite().equals(kingImg) || board[10][0].GetSprite().equals(kingImg) || board[10][10].GetSprite().equals(kingImg)) {
			winner = "Defender wins!";
		}else if(kingIsDead) {
			winner = "Attacker wins!";
		} else {
			return;
		}
		
		declareWinner(winner);
	}

	private static void declareWinner(String winner) {
		System.out.println(winner);
		displayEndGameMenu();
	}

	private static void displayEndGameMenu() {

	}
}

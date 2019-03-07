package models_RPG;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateNameHelper;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Dungeon {
//	private Space[][] floor;
//
//	public Dungeon(Space[][] rooms) {
//		super();
//		this.setRooms(rooms);
//	}
//
//	public Space[][] getRooms() {
//		return floor;
//	}
//
//	public void setRooms(Space[][] rooms) {
//		this.floor = rooms;
//	}
	
	private boolean[][] grid = new boolean[17][17];
	
	public void generateFloor(int dungeonFloor) {
		
		Stage stage = new Stage();
		
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
		        
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20, 80, 20, 80));
        
        GridPane gridPane = new GridPane();
        

        gridPane.setMaxSize(500, 500);
        
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        gridPane.setVgap(5); 
        gridPane.setHgap(5);    
        gridPane.setAlignment(Pos.CENTER);
        
        for(int q = 0; q < 17; q++) {
        	
        	for(int x = 0; x < 17; x++) {
        		
        		grid[q][x] = false;
        		
        	}
        	
        }
        
        for(int i = 0; i < 17; i++) {
        	
        	for(int j = 0; j < 17; j++) {
        		
        		Button button = new Button();		
        		
        		if ( grid[j][i] == false) {
        		
        			grid[j][i] = true;
        			gridPane.add(button, j, i, 1, 1);
        		
        		} else {
        			
        			System.out.println(i + " , " + j + "was already taken");
        			
        		}
        		
        		try {
        			button.getClass().newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        	
        }
        
        VBox switchBox = new VBox();
        switchBox.setAlignment(Pos.CENTER);
        switchBox.setPadding(new Insets(20, 80, 20, 80));
        switchBox.getChildren().addAll( box);

        root.getChildren().addAll(switchBox, gridPane);
        
        Scene scene = new Scene(root, 400, 400);

        stage.setScene(scene);
        stage.setTitle("RPG");
       
        
        stage.show();
		
		
	}
}


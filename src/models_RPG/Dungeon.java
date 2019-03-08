package models_RPG;



import controllers.RPG;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dungeon {
	
	public void generateFloor() {
		
	
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


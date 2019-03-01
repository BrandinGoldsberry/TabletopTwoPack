package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

//Test Commit

	
public class Main extends Application implements EventHandler<ActionEvent> {
		
		//private VBox root;
		private GridPane boardGrid;
		private Label AttName;
		private Label DefName;
		//private Game gameBoard

		private Label bulb = new Label();
		private boolean isOn = false;
		private final String ON = "-fx-background-color: red";
		private final String OFF = "-fx-background-color: blue";
		

		@Override
		public void start(Stage primaryStage) {
		
				
				try {
				
					VBox root = new VBox();
		            root.setAlignment(Pos.CENTER);

		        

		            Button button = new Button("Start game");
		            button.setOnAction(this);

		            VBox switchBox = new VBox();
		            switchBox.setAlignment(Pos.CENTER);
		            switchBox.setPadding(new Insets(20, 80, 20, 80));
		            switchBox.getChildren().add(button);
		            
		           Text text = new Text();
		           text.setTextAlignment(TextAlignment.CENTER);
		          
		           text.setText("Group 8 Rpg");

		            root.getChildren().addAll(bulb, text, switchBox );

		            Scene scene = new Scene(root, 400, 400);
		            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		            primaryStage.setScene(scene);
		            primaryStage.setTitle("RPG");
		            primaryStage.show();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
	
	private void Input() {
		
	}
	
	private void Update() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

public void handle(ActionEvent event) {
		
		Stage stage = new Stage();
		
		Label label = new Label();
		
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
		
		Text text = new Text();
        text.setTextAlignment(TextAlignment.LEFT);
       
        text.setText("wow");
        
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20, 80, 20, 80));
        box.getChildren().add(text);
        
        VBox switchBox = new VBox();
        switchBox.setAlignment(Pos.CENTER);
        switchBox.setPadding(new Insets(20, 80, 20, 80));
        switchBox.getChildren().addAll(label, text, box);

        root.getChildren().addAll(switchBox);
        
        Scene scene = new Scene(root, 400, 400);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Game");
       
        
        stage.show();
        	
	}
	
}




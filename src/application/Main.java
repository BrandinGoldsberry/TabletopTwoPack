package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

//Test Commit
public class Main extends Application {
	private VBox root;
	private GridPane boardGrid;
	private Label AttName;
	private Label DefName;
	//private Game gameBoard
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
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

	
	
}




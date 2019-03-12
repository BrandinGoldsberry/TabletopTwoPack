package application;
	
import controllers.Hnefatafl;
import controllers.RPG;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

//Test Commit

	
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {				
			VBox root = new VBox();
            root.setAlignment(Pos.CENTER);

            Button button = new Button("Start RPG");
            
            Button startHnefaltafl = new Button("Start Hnefaltafl");
            
            startHnefaltafl.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Hnefatafl.run();
				}
			});
            
            button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
				
					primaryStage.close();
					RPG.run();
				}
			});

            VBox switchBox = new VBox();
            switchBox.setAlignment(Pos.CENTER);
            switchBox.setPadding(new Insets(20, 80, 20, 80));
            switchBox.getChildren().add(button);
            
            Text text = new Text();
           	text.setTextAlignment(TextAlignment.CENTER);
          
           	text.setText("Group 8 Table Games");

            root.getChildren().addAll(text, switchBox, startHnefaltafl);

            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Tabletop Two Pack");
            primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
// This is the wrong way to do this, it limits our ability to make handles
//	public void handle(ActionEvent event) {
//		
//		Stage stage = new Stage();
//		
//		Label label = new Label();
//		
//		VBox root = new VBox();
//        root.setAlignment(Pos.CENTER);
//		
//		Text text = new Text();
//        text.setTextAlignment(TextAlignment.LEFT);
//       
//        text.setText("wow");
//        
//        VBox box = new VBox();
//        box.setAlignment(Pos.CENTER);
//        box.setPadding(new Insets(20, 80, 20, 80));
//        box.getChildren().add(text);
//        
//        VBox switchBox = new VBox();
//        switchBox.setAlignment(Pos.CENTER);
//        switchBox.setPadding(new Insets(20, 80, 20, 80));
//        switchBox.getChildren().addAll(label, text, box);
//
//        root.getChildren().addAll(switchBox);
//        
//        Scene scene = new Scene(root, 400, 400);
//        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//
//        stage.setScene(scene);
//        stage.setTitle("Game");
//       
//        
//        stage.show();
//        	
//	}
	
}




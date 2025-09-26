package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Button btn = new Button("Click me");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					System.out.println("Hello World!");
					
				}
			});
			
			Button btnExit = new Button("Exit");
			btnExit.setOnAction(e -> System.exit(0));
			
			VBox root = new VBox();
			root.getChildren().addAll(btn, btnExit);
			Scene scene = new Scene(root, 500, 300);
			primaryStage.setTitle("My title");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

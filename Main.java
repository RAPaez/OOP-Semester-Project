// Ricardo Paez, Semester Project for OOP, run from here 

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) { // Method to start javafx on MainView - primaryStage means window, what will be shown to the user
		try {
			// Load the main FXML Layout
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
			Parent root = loader.load();
			
			// Set up the scene and stage
			Scene scene = new Scene(root);
			
			// Sets the bar thingy at the top as the string
			primaryStage.setTitle("Flashy - Flashcard App");
			
			primaryStage.setScene(scene); // Sets the scene on the window
			primaryStage.show(); // Shows the window
			
		} catch(Exception e) {
			System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); // Launch a standalone application
	}
}

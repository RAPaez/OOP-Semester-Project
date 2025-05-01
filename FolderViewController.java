package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

import java.util.Optional;

public class FolderViewController {
	
	// @FXML associates variable names from this class to objects described in the FXML file
	
		@FXML private FlowPane flashcardFlowPane;
	    @FXML private Button addFlashcardButton;
	    @FXML private ScrollPane scrollPane;
	    
	    private Folder currentFolder;
	    
	    public void setFolder(Folder folder) {
	    	this.currentFolder = folder;
	    	refreshFlashcards();
	    }
	    
	    @FXML
	    private void refreshFlashcards() {
	    	
	    	flashcardFlowPane.getChildren().clear(); // Clears the screen
	    	
	    	for (Flashcard flashcard : currentFolder.getFlashcards()) {
	    		Button cardButton = new Button(flashcard.getFront());
	    		cardButton.setMinSize(100, 100);
	    		cardButton.setStyle("-fx-background-color: lightyellow; -fx-font-size: 14px");
	    		
	    		cardButton.setOnMouseClicked((MouseEvent e) -> {
	    			if (e.getClickCount() == 2) {
	    				showFlashcardDetails(flashcard);
	    			}
	    		});
	    		
	    		flashcardFlowPane.getChildren().add(cardButton);
	    	}
	    	
	    	flashcardFlowPane.getChildren().add(addFlashcardButton);
	    }
	    
	    @FXML
	    private void handleAddFlashcard() {
	    	
	        TextInputDialog frontDialog = new TextInputDialog(); // Creates a new TextInputDialog box
	        frontDialog.setTitle("New Flashcard"); // Sets the thingy on top to "New Flashcard"
	        frontDialog.setHeaderText("Enter front of flashcard:");

	        Optional<String> front = frontDialog.showAndWait(); // Shows the dialog and waits for the user response, the user has to press the enter key to continue
	        
	        TextInputDialog backDialog = new TextInputDialog(); // Creates a new TextInputDialog box
	        backDialog.setTitle("New Flashcard"); // Sets the thingy on top to "New Flashcard"
	        backDialog.setHeaderText("Enter back of flashcard:");
	         
	        Optional<String> back = backDialog.showAndWait(); // Shows the dialog and waits for the user response, the user has to press the enter key to continue
	   	        
	        Flashcard flashcard = new Flashcard(front.get(), back.get());
	        currentFolder.addFlashcard(flashcard);
	        refreshFlashcards();
	    }
	    
	    private void showFlashcardDetails(Flashcard card) {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("FlashcardView.fxml"));
	            Parent root = loader.load();

	            FlashcardViewController controller = loader.getController();
	            controller.setFlashcard(card);

	            Stage stage = new Stage();
	            stage.setTitle("Flashcard");

	            // Setting default size
	            Scene scene = new Scene(root, 500, 400); // <-- default size
	            stage.setScene(scene);
	            
	            //Prevent too-small resizing
	            stage.setMinWidth(400);  
	            stage.setMinHeight(300); 
	            stage.show();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
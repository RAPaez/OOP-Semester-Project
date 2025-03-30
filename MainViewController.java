// Ricardo Paez, Semester Project: MainViewController class

package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainViewController { // Manages user input for MainView.fxml
	
	// @FXML associates variable names from this class to objects described in the FXML file
	
	@FXML private FlowPane folderFlowPane;
    @FXML private Button addFolderButton;
    @FXML private ScrollPane scrollPane;
    
    private List<Folder> folders = new ArrayList<>(); // Creates an ArrayList for all the potential folders

    /*@FXML
    public void initialize() {
        // Will load saved data and populate folders
    }
    */
    
    @FXML
    private void handleAddFolder() {
        TextInputDialog dialog = new TextInputDialog(); // Creates a new TextInputDialog box
        dialog.setTitle("New Folder"); // Sets the thingy on top to "New Folder"
        dialog.setHeaderText("Create a new folder");
        dialog.setContentText("Folder name:"); // Sets the text in the box the user enters information in

        Optional<String> result = dialog.showAndWait(); // Shows the dialog and waits for the user response, the user has to press the enter key to continue
        result.ifPresent(name -> {
            Folder folder = new Folder(name); // Creates a folder
            folders.add(folder); // Adds the folder to big ArrayList of folders

            Button folderTile = new Button(name); // Creates a Button with the name of the folder
            folderTile.setMinSize(100, 100); // Sets the dimensions of the Button
            folderTile.setStyle("-fx-background-color: lightgray; -fx-font-size: 14px;"); // Sets the style of the button
            
            folderTile.setOnMouseClicked((MouseEvent e) -> { // If the button is clicked
                if (e.getClickCount() == 2) { // If the Button is clicked twice 
                    openFolderView(folder); // Implement navigation to flashcard view
                }
            }); 
         // Creates another folder button
            int addIndex = folderFlowPane.getChildren().indexOf(addFolderButton); // Gets the index of the folder button 
            folderFlowPane.getChildren().add(addIndex, folderTile);  // Replaces the old Button with the folder button at the given index and shifts the add folder button to the right
        });
    }
    
    private void openFolderView(Folder folder) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Open Folder");
    	alert.setHeaderText(null);
    	alert.setContentText("Would open folder: " + folder.getName());
    	alert.showAndWait();
    	
    }
}

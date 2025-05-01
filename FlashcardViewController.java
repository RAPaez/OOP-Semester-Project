package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FlashcardViewController {

	@FXML private Label cardText;
	
	private Flashcard flashcard;
	
	private boolean showingFront = true;
	
	public void setFlashcard(Flashcard flashcard) {
		this.flashcard = flashcard;
		cardText.setText(flashcard.getFront());
	}
	
	@FXML 
	private void handleFlip() {
		if (flashcard == null) {
			return;
		}
		
		if (showingFront) {
			cardText.setText(flashcard.getBack());
		} else {
			cardText.setText(flashcard.getFront());
		}
		showingFront = !showingFront;
	}
}
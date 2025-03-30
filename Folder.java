// Ricardo Paez, Semester Project: Folder Class

package application;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	
	private String name; // Name of the folder
	private List<Flashcard> flashcards; // Flash-card array, one for each folder
	
	public Folder(String name) { // Constructor for folder class
		this.name = name;
		this.flashcards = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Flashcard> getFlashcards() { // Returns all the flash-cards in the folder
		return flashcards;
	}

	public void addFlashcard(Flashcard flashcard) { // Adds a flash-card to a folder
		flashcards.add(flashcard);
	}
	
	public void removeFlashcard(Flashcard flashcard) { // Removes a flash-card from a folder
		flashcards.remove(flashcard);
	}
}

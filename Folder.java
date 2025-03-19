import java.util.ArrayList;

public class Folder {
	private String name;
	private ArrayList<Flashcard> flashcards;
	
	public Folder(String name) {
		this.name = name;
		this.flashcards = new ArrayList<>();
	}
	
	public void addFlashcard(Flashcard flashcard) {
		flashcards.add(flashcard);
	}
	
	public void removeFlashcard(Flashcard flashcard) {
		flashcards.remove(flashcard);
	}
	
	public ArrayList<Flashcard> getFlashcards(){
		return flashcards;
	}
	
	public String getName() {
		return name;
	}
	
	public void displayFlashcards() {
		for (Flashcard flashcard : flashcards) {
			flashcard.displayFlashcard();
		}
	}
	
}

// Ricardo Paez, Semester Project: Flashcard Class

package application;

public class Flashcard {
	
	private String front; // Front of flash-card
	private String back; // Back of flash-card
	
	public Flashcard(String front, String back) { // Constructor for flash-card
		this.front = front;
		this.back = back;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}
	
	public void editFlashcard(String front, String back) { // Method for editing the front and backs of flashcards - to be implemented in further versions
		this.front = front;
		this.back = back;
	}
		
}

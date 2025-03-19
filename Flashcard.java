
public class Flashcard{
	private String front;
	private String back;
	
	public Flashcard(String front, String back) {
		this.front = front;
		this.back = back;
	}
	
	public Flashcard() {
		return;
	}
	
	public String getFront() {
		return front;
	}
	
	public String getBack() {
		return back;
	}
	
	public void setFront(String front) {
		this.front = front;
	}
	
	public void setBack(String back) {
		this.back = back;
	}
	
	public void editFlashcard(String front, String back) {
		this.front = front;
		this.back = back;
	}
	
	public void displayFlashcard() {
		System.out.println("Front: " + front);
		System.out.println("Back: " + back);
	}
}

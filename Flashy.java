// Version (1.0.0 - alpha)
import java.util.ArrayList;
import java.util.Scanner;

public class Flashy{
	
	private ArrayList<Folder> folders = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Flashy flashy = new Flashy();
		flashy.run();
	}
	
	public void run() {
		System.out.println("Flashy - Flashcard System");
		while(true) {
			System.out.println("'1' to create Flashcard, '2' to create Folder, '3' to start study session, '4' to exit");
			String input = scanner.nextLine().trim(); // Read as a string and remove extra spaces, to avoid scanner error
			int choice = Integer.parseInt(input); // Convert input to int
			
			if (choice == 1) {
				createFlashcard();
			}
			else if (choice == 2) {
				createFolder();
			}
			else if (choice == 3) {
				startStudySession();	
				
			}
			else if (choice == 4) {
				System.out.println("Exiting");
				return;
			}
			else {
				System.out.println("You're wrong");
			}
		}
	}
	
	private void createFlashcard() {
		System.out.println("Creating Flashcard:");
		System.out.println("Front: ");
		String front = scanner.next();
		System.out.println("Back: ");
		String back = scanner.next();
		Flashcard flashcard = new Flashcard(front, back);
		
		if (folders.isEmpty()) {
			System.out.println("No folders available. Creating a folder.");
			Folder newFolder = createFolder();
			newFolder.addFlashcard(flashcard);
			return;
		}
		else {
			System.out.println("Choose a folder to add the flashcard: ");
			for (int i = 0; i < folders.size(); i++) {
				System.out.println(i + 1 + " - " + folders.get(i).getName());
			}
			
			String input = scanner.nextLine().trim();
			int folderChoice = Integer.parseInt(input);
			
			if (folderChoice > 0 && folderChoice <= folders.size()) {
				folders.get(folderChoice - 1).addFlashcard(flashcard);
				System.out.println("Flashcard added to folder.");
			}
			else {
				System.out.println("Invalid folder selection.");
			}
		}
		
	}
	
	private Folder createFolder() {
		System.out.println("Enter folder name:");
		String name = scanner.nextLine();
		Folder newFolder = new Folder(name);
		folders.add(newFolder);
		System.out.println("Folder created.");
		return newFolder;
	}
	private void startStudySession() {
		if (folders.isEmpty()) {
			System.out.println("No folders available to study from.");
			return;
		}
		
		System.out.println("Choose a folder to study from:");
		for (int i = 0; i < folders.size(); i++) {
			System.out.println(i + 1 + " - " + folders.get(i).getName());
		}
		
		int folderChoice = scanner.nextInt();
		scanner.nextLine();
		
		if (folderChoice > 0 && folderChoice <= folders.size()) {
			Folder selectedFolder = folders.get(folderChoice - 1);
			ArrayList<Flashcard> flashcards = selectedFolder.getFlashcards();
			
			if (flashcards.isEmpty()) {
				System.out.println("No flashcards in this folder.");
				return;
			}
			
			for (Flashcard flashcard : flashcards) {
				System.out.println("Front: " + flashcard.getFront());
				System.out.println("Press Enter to reveal the answer");
				scanner.nextLine();
				System.out.println("Back: " + flashcard.getBack());
				System.out.println();
			}
		}
		else {
			System.out.println("Wrong");
		}
	}
}

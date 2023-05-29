package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println(authorName + " has been added!");
		}
		else {
			System.out.println(authorName + " already in the list. Cannot be added");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println(authorName + " has been removed!");
		}
		else {
			System.out.println(authorName + " not in the list. Cannot be removed");
		}
	}
	
	public String toString() {
		return "Book - Id: " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory()  + " : " + this.getCost() + " $";
	}

}

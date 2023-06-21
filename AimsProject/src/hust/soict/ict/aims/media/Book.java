package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.ict.aims.exception.AlreadyExistedException;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.exception.NotExistedException;

public class Book extends Media{
	private List<String> authors = new ArrayList<>();
	
	public Book(int id, String title, String category, float cost) throws NegativeException {
		super(id, title, category, cost);
	}

	public Book(int id, String title, String category, float cost, ArrayList<String> authors) throws NegativeException {
		super(id, title, category, cost);
		this.authors = authors;
	}

	public void addAuthor(String authorName) throws AlreadyExistedException {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println(authorName + " has been added!");
		}
		else {
			throw new AlreadyExistedException(authorName + " already in the list. Cannot be added");
		}
	}
	
	public void removeAuthor(String authorName) throws NotExistedException {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println(authorName + " has been removed!");
		}
		else {
			throw new NotExistedException(authorName + " not in the list. Cannot be removed");
		}
	}
	
	public String toString() {
		return "Book - Id: " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory()  + " : " + this.getCost() + " $";
	}

}

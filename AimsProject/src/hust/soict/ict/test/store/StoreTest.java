package hust.soict.ict.test.store;
import javax.naming.LimitExceededException;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) throws Exception {
		Store store = new Store(3);
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("Harry Potter", "Animation", "Roger Allers", 87, 19.95f);
	    Book book = new Book(0, "Harry Potter", "Science Fiction", 9.9f);
	    CompactDisc cd = new CompactDisc(10, "Greatest Hits", "Rock", 11f, "Journey", "Micheal Jackson");
		
		store.addMedia(dvd);
		store.addMedia(book);
		store.addMedia(cd);
		store.addMedia(dvd);
		
		Media media = store.searchByTitle("Harry Potter");
		System.out.println(media.toString());
	}

}

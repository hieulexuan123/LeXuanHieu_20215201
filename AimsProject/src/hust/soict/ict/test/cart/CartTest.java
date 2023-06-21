package hust.soict.ict.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) throws Exception {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("Harry Potter", "Animation", "Roger Allers", 87, 19.95f);
	    Book book = new Book(0, "Harry Potter", "Science Fiction", 9.9f);
	    CompactDisc cd = new CompactDisc(10, "Greatest Hits", "Rock", 19f, "Journey", "Micheal Jackson");
		
		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(cd);
		cart.sortByCost();
		cart.print();
		
		cart.sortByTitle();
		cart.print();
		
	}

}

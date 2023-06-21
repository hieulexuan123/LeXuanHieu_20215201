package hust.soict.ict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;

public class MediaTest {

	public static void main(String[] args) throws NegativeException {
		List<Media> media = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Harry Potter", "Science Fiction", 9.9f);
        CompactDisc cd = new CompactDisc("Greatest Hits", "Rock", 11f, "Journey", "Micheal Jackson");

        media.add(cd);
        media.add(dvd);
        media.add(book);

        for (Media m : media) {
            System.out.println(m.toString());
        }

	}

}

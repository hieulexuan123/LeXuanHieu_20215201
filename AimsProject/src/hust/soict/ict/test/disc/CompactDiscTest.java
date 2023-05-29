package hust.soict.ict.test.disc;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.Track;

public class CompactDiscTest {

	public static void main(String[] args) {
		CompactDisc cd = new CompactDisc(1, "Greatest Hits", "Rock", 11f, "Journey", "Micheal Jackson");
		cd.addTrack(new Track("abc", 20));
		cd.addTrack(new Track("abc", 50));
		System.out.println(cd.toString());
	}

}

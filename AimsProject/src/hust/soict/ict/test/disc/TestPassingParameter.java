package hust.soict.ict.test.disc;
import hust.soict.ict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 =tmp;
	}
	
	public static void betterSwap(Object o1, Object o2) {
		if (o1 instanceof DigitalVideoDisc && o2 instanceof DigitalVideoDisc) {
	        DigitalVideoDisc dvd1 = (DigitalVideoDisc) o1;
	        DigitalVideoDisc dvd2 = (DigitalVideoDisc) o2;

	        String tempTitle = dvd1.getTitle();
//	        dvd1.setTitle(dvd2.getTitle());
//	        dvd2.setTitle(tempTitle);
	    }
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
//		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}

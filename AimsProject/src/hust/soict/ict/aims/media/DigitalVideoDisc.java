package hust.soict.ict.aims.media;

public class DigitalVideoDisc extends Disc{
	private static int nbDigitalVideoDiscs = 0;
	
//	public DigitalVideoDisc(String title) {
//		nbDigitalVideoDiscs++;
//		this.id = nbDigitalVideoDiscs;
//		this.title = title;
//	}
//	
//	public DigitalVideoDisc(String title, String category, float cost) {
//		nbDigitalVideoDiscs++;
//		this.id = nbDigitalVideoDiscs;
//		this.title = title;
//		this.category = category;
//		this.cost = cost;
//	}
//
//	public DigitalVideoDisc(String title, String category, String director, float cost) {
//		nbDigitalVideoDiscs++;
//		this.id = nbDigitalVideoDiscs;
//		this.title = title;
//		this.category = category;
//		this.director = director;
//		this.cost = cost;
//	}
//
//	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
//		nbDigitalVideoDiscs++;
//		this.id = nbDigitalVideoDiscs;
//		this.title = title;
//		this.category = category;
//		this.director = director;
//		this.length = length;
//		this.cost = cost;
//	}
//	
	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(nbDigitalVideoDiscs++, title, category, cost, length, director);
	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $";
	}
	

	public boolean isMatch(String title) {
		return title == this.getTitle();
	}
}

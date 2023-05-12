package hust.soict.ict.aims.disc;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	
	public DigitalVideoDisc(String title) {
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $";
	}
	
	public boolean isMatch(String title) {
		return title == this.getTitle();
	}
}
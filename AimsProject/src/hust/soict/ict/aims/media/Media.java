package hust.soict.ict.aims.media;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media() {
		
	}

	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
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

	public float getCost() {
		return cost;
	}
	
	
}

package hust.soict.ict.aims.store;
import java.util.ArrayList;

import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;

public class Store {
	private int capacity;
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public Store(int capacity) {
        this.capacity = capacity;
    }
    
    public void print() {
		System.out.println("\n***********************STORE***********************");
		System.out.println("Items available in store:");
		for (int i=1; i<=itemsInStore.size(); i++) {
			System.out.println(i + ". " + itemsInStore.get(i-1).toString());
		}
		System.out.println("***************************************************");
	}
    
    public void addMedia(Media media) {
		if (itemsInStore.size() < capacity) {
			itemsInStore.add(media);
			System.out.println("Successfully added");
		}
		else {
			System.out.println("Your store is full!");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.isEmpty()) {
			System.out.println("Your store is empty!");
		}
		else if (!itemsInStore.contains(media)) {
			System.out.println("Media is not found in your store");
		}
		else {
			itemsInStore.remove(media);
			System.out.println("Successfully removed");
		}
	}
	
	public Media searchByTitle(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title))
				return media;
		}
		return null;
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
}

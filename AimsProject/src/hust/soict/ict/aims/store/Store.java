package hust.soict.ict.aims.store;
import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.ict.aims.exception.EmptyException;
import hust.soict.ict.aims.exception.NotExistedException;
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
    
    public void addMedia(Media media) throws LimitExceededException {
		if (itemsInStore.size() < capacity) {
			itemsInStore.add(media);
			System.out.println("Successfully added");
		}
		else {
			throw new LimitExceededException("Error: The number of media has reached its limit");
		}
	}
	
	public void removeMedia(Media media) throws EmptyException, NotExistedException {
		if (itemsInStore.isEmpty()) {
			throw new EmptyException("Your cart is empty!");
		}
		else if (!itemsInStore.contains(media)) {
			throw new NotExistedException("Media is not found in your cart");
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

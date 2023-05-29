package hust.soict.ict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Successfully added");
		}
		else {
			System.out.println("Your cart is full!");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.isEmpty()) {
			System.out.println("Your cart is empty!");
		}
		else if (!itemsOrdered.contains(media)) {
			System.out.println("Media is not found in your cart");
		}
		else {
			itemsOrdered.remove(media);
			System.out.println("Successfully removed");
		}
	}
	
	
	public float totalCost() {
		float cost = .0f;
		for (Media media : itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered items:");
		for (int i=1; i<=itemsOrdered.size(); i++) {
			System.out.println(i + ". " + itemsOrdered.get(i-1).toString());
		}
		System.out.println("Total cost: " + this.totalCost() + "$");
		System.out.println("***************************************************");
	}
	
	public void searchById(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println(media.toString());
				found = true;
			}
		}
		if (!found){
			System.out.println("Item not found");
		}
	}
	
	
	public void searchByTitle(String title) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				System.out.println(media.toString());
				found = true;
			}
		}
		if (!found){
			System.out.println("Item not found");
		}
	}
	
	public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public void makeEmpty() {
    	itemsOrdered.clear();
    }
    
    public Media findByTitle(String title) {
    	for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title))
				return media;
		}
		return null;
    }
}

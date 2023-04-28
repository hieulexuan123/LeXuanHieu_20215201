
public class Cart {
	private int qtyOrdered = 0;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("Your cart is full!");
		}
	}
	
	void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered==0) {
			System.out.println("Your cart is empty!");
			return;
		}
		else {
			for (int i=0; i<qtyOrdered; i++) {      
				if (itemsOrdered[i] == disc) {       //if disc is found
					for (int j=i; j<qtyOrdered-1; j++) {
						itemsOrdered[j] = itemsOrdered[j+1];
					}
					itemsOrdered[qtyOrdered-1] = null;
					qtyOrdered--;
					System.out.println("The disc has been removed");
					return;
				}
			}
			System.out.println("The disc is not found in your cart!");
		}
	}
	
	float totalCost() {
		float cost = .0f;
		for (int i=0; i<qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
}

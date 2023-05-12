
public class Cart {
	private int qtyOrdered = 0;
	public static final int MAX_NUMBERS_ORDERED = 5;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("Your cart is full!");
		}
	}
	
	
	//add an array
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {   
		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i=0; i<dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered ++;
			}
			System.out.println("All discs have been added");
		}
		else {
			System.out.println("Your cart is full!");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc1;
			itemsOrdered[qtyOrdered++] = disc2;
			System.out.println("2 discs have been added");
		}
		else {
			System.out.println("Your cart is full!");
		}
	}
	
	//add arbitrary number of discs
//	public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
//		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
//			for (int i=0; i<dvdList.length; i++) {
//				itemsOrdered[qtyOrdered] = dvdList[i];
//				qtyOrdered ++;
//			}
//			System.out.println("All discs have been added");
//		}
//		else {
//			System.out.println("Your cart is full!");
//		}
//	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
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
	
	public float totalCost() {
		float cost = .0f;
		for (int i=0; i<qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered items:");
		for (int i=1; i<=qtyOrdered; i++) {
			System.out.println(i + ". " + itemsOrdered[i-1].toString());
		}
		System.out.println("Total cost: " + this.totalCost() + "$");
		System.out.println("***************************************************");
	}
	
	public void searchById(int id) {
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i].toString());
				return;
			}
		}
		System.out.println("Item not found");
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println(itemsOrdered[i].toString());
				found = true;
			}
		}
		if (!found){
			System.out.println("Item not found");
		}
	}
}

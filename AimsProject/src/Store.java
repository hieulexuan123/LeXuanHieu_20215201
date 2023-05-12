
public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int numItems;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        numItems = 0;
    }

    public void addDVD(DigitalVideoDisc disc) {
    	if (numItems < itemsInStore.length) {
			itemsInStore[numItems] = disc;
			numItems ++;
			System.out.println("The disc has been added to store");
		}
		else {
			System.out.println("Your store is full!");
		}
    }

    public void removeDVD(DigitalVideoDisc disc) {
    	if (numItems==0) {
			System.out.println("Your store is empty!");
			return;
		}
		else {
			for (int i=0; i<numItems; i++) {      
				if (itemsInStore[i] == disc) {       //if disc is found
					for (int j=i; j<numItems-1; j++) {
						itemsInStore[j] = itemsInStore[j+1];
					}
					itemsInStore[numItems-1] = null;
					numItems--;
					System.out.println("The disc has been removed from your store");
					return;
				}
			}
			System.out.println("The disc is not found in your store!");
		}
    }
}

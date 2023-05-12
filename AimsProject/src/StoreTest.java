
public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store(3);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Spider man");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Spider man");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Spider man");
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spider man");
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		store.addDVD(dvd4);
		store.removeDVD(dvd4);
		store.removeDVD(dvd1);
		store.removeDVD(dvd2);
		store.removeDVD(dvd3);
	}

}

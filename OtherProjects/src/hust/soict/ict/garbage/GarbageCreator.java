package hust.soict.ict.garbage;

public class GarbageCreator {
	public static void createGarbage() {
        try {
            while (true) {
                String str = new String("abc");  // Creates a garbage object
                str = null;
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory! Garbage creation stopped.");
        }
    }
	
	public static void main(String[] args) {
		createGarbage();
	}

}

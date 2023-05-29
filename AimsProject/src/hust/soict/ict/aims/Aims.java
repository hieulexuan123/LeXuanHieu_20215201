package hust.soict.ict.aims;
import java.util.Scanner;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Track;
import hust.soict.ict.aims.store.Store;

public class Aims {

	public static void main(String[] args) {
		Store store = new Store(20);
//		DigitalVideoDisc dvd = new DigitalVideoDisc("Harry Potterr", "Animation", "Roger Allers", 87, 19.95f);
//	    Book book = new Book(5, "Harry Potter", "Science Fiction", 9.9f);
//	    CompactDisc cd = new CompactDisc(10, "Greatest Hits", "Rock", 11f, "Journey", "Micheal Jackson");	
//		store.addMedia(dvd);
//		store.addMedia(book);
//		store.addMedia(cd);
		
		Cart cart = new Cart();
		
		String choice;
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;

		
		while (isContinue) {
			showMenu();
			choice = scanner.next();
			
			switch (choice) {
				//View store
				case "1": {
					boolean viewStoreContinue = true;
					while (viewStoreContinue) {
						store.print();
						storeMenu();
						choice = scanner.next();
						switch(choice) {
							//See a media's detail
							case "1": {
								System.out.println("Enter the title of the media: ");
								scanner.nextLine();
								String title = scanner.nextLine();
								Media media = store.searchByTitle(title);
								if (media == null) {
									System.out.println("Media does not exist.");
								}
								else {
									System.out.println("Media information: ");
									System.out.println(media.toString());
									boolean viewMediaDetailContinue = true;
									while (viewMediaDetailContinue) {
										mediaDetailsMenu();
										choice = scanner.next();
										switch(choice) {
											case "1":{
												cart.addMedia(media);
												break;
											}
											case "2":{
												if (media instanceof Book) {
													System.out.println("Book cannot be played.");
												}
												else if (media instanceof CompactDisc){
													((CompactDisc)media).play();
												}
												else {
													((DigitalVideoDisc)media).play();
												}
												break;
											}
											case "0": {
												viewMediaDetailContinue = false;
												break;
											}
											default: {
												System.out.println("Choice is not valid. Enter again.");
											}					
										}
									}			
								}
								break;
							}
								
							//Add a media to cart
							case "2": {
								System.out.println("Enter the title of the media: ");
								scanner.nextLine();
								String title = scanner.nextLine();
								Media media = store.searchByTitle(title);
								if (media == null) {
									System.out.println("Media does not exist.");
								}
								else {
									cart.addMedia(media);
								}
								break;
							}
							
							//Play a media
							case "3": {
								System.out.println("Enter the title of the media: ");
								scanner.nextLine();
								String title = scanner.nextLine();
								Media media = store.searchByTitle(title);
								if (media == null) {
									System.out.println("Media does not exist.");
								}
								else {
									if (media instanceof Book) {
										System.out.println("Book cannot be played.");
									}
									else if (media instanceof CompactDisc){
										((CompactDisc)media).play();
									}
									else {
										((DigitalVideoDisc)media).play();
									}
								}
								break;
							}
								
							//See current cart
							case "4": {
								cart.print();
								break;
							}
								
							//Back
							case "0": {
								viewStoreContinue = false;
								break;
							}
							
							default: System.out.println("Choice is not valid. Enter agian");
						}
					}
					
					
					break;
				}
				
				
				//Update Store
				case "2": {
					boolean isValid = false;
					while (!isValid) {
						System.out.println("Enter the type of media (book/cd/dvd): ");
						String type;
						type = scanner.next();
						
						if (!(type.equals("book") || type.equals("dvd") || type.equals("cd"))) {
							System.out.println("Type does not exist. Enter again.");
						}
						else {
							int id; 
							String title;
							String category;
							float cost; 
							
							System.out.println("Enter id: ");
							id = scanner.nextInt();
							scanner.nextLine();
							System.out.println("Enter title: ");
							title = scanner.nextLine();
							System.out.println("Enter category: ");
							category = scanner.nextLine();
							System.out.println("Enter cost: ");
							cost = scanner.nextFloat();
							scanner.nextLine();
							
							if (type.equals("book")) {
								System.out.println("Enter the number of authors: ");
								int num = scanner.nextInt();
								scanner.nextLine();
								Book book = new Book(id, title, category, cost);							
								while (num>0) {
									System.out.println("Enter author: ");
									String author = scanner.nextLine();
									book.addAuthor(author);
									num--;
								}
								store.addMedia(book);
							}
							else if (type.equals("dvd")) {
								System.out.println("Enter the director: ");
								String director = scanner.nextLine();
								System.out.println("Enter length: ");
								int length = scanner.nextInt();
								scanner.nextLine();
								DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
								store.addMedia(dvd);
							}
							else {
								System.out.println("Enter the director: ");
								String director = scanner.nextLine();
								System.out.println("Enter the artist: ");
								String artist = scanner.nextLine();
								System.out.println("Enter the number of tracks: ");
								int num = scanner.nextInt();
								scanner.nextLine();
								CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);
								while (num>0) {
									System.out.println("Enter track title: ");
									String trackTitle = scanner.nextLine();
									System.out.println("Enter track length: ");
									int trackLength = scanner.nextInt();
									scanner.nextLine();
									cd.addTrack(new Track(trackTitle, trackLength));
									num--;
								}
								store.addMedia(cd);
								
							}

							isValid = true;
						}
					}
					store.print();
					break;
				}
				
				//See current cart
				case "3": {
					boolean viewCartContinue = true;
					while (viewCartContinue) {
						cartMenu();
						choice = scanner.next();
						switch (choice) {
							//Filter media in cart
							case "1": {
								boolean isValid = false;
								while (!isValid) {
									System.out.println("1 - By id. 2 - By title");
									choice = scanner.next();
									switch(choice) {
										case "1": {
											System.out.println("Enter the id: ");
											int id = scanner.nextInt();
											scanner.nextLine();
											cart.searchById(id);
											isValid = true;
											break;
										}
										case "2": {
											System.out.println("Enter the title: ");
											scanner.nextLine();
											String title = scanner.nextLine();
											cart.searchByTitle(title);
											isValid = true;
											break;
										}
										default: {
											System.out.println("Choice is not valid. Enter again");
										}
									}
								}
								break;
							}
								
							//Sort media in cart
							case "2": {
								boolean isValid = false;
								while (!isValid) {
									System.out.println("1 - By title. 2 - By cost");
									choice = scanner.next();
									switch(choice) {
										case "1": {
											cart.sortByTitle();
											cart.print();
											isValid = true;
											break;
										}
										case "2": {
											cart.sortByCost();
											isValid = true;
											cart.print();
											break;
										}
										default: {
											System.out.println("Choice is not valid. Enter again");
										}
									}
								}
								break;
							}
								
							//Remove media from cart
							case "3": {
								System.out.println("Enter the title of the media: ");
								scanner.nextLine();
								String title = scanner.nextLine();
								Media media = cart.findByTitle(title);
								if (media == null) {
									System.out.println("Media does not exist.");
								}
								else {
									cart.removeMedia(media);
								}
								break;
							}
								
							//Play a media
							case "4": {
								System.out.println("Enter the title of the media: ");
								scanner.nextLine();
								String title = scanner.nextLine();
								Media media = cart.findByTitle(title);
								if (media == null) {
									System.out.println("Media does not exist.");
								}
								else {
									if (media instanceof Book) {
										System.out.println("Book cannot be played.");
									}
									else if (media instanceof CompactDisc){
										((CompactDisc)media).play();
									}
									else {
										((DigitalVideoDisc)media).play();
									}
								}
								break;
							}
								
							//Place order
							case "5": {
								System.out.println("Your order is placed");
								cart.makeEmpty();
								break;
							}
								
							//Back
							case "0": {
								viewCartContinue = false;
								break;
							}
							
							default: System.out.println("Choice is not valid. Enter again.");								
						}
					}
					break;
				}
				
				//Exit
				case "0": {
					System.out.println("Exit...");
					isContinue = false;
					break;
				}
				
				default:
					System.out.println("Choice is not valid. Enter again");
			}
		}
		
	}
	
	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("----------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options:");
		System.out.println("----------------------");
		System.out.println("1. See a media's detail");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void cartMenu() {
		System.out.println("Options:");
		System.out.println("----------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("----------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
}

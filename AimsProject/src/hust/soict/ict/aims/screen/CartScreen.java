package hust.soict.ict.aims.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public CartScreen (Cart cart) {
		super();
		
		this.cart = cart;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);

					loader.setController(controller);
					
					Parent root = loader.load();	
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd;
		try {
			dvd = new DigitalVideoDisc("Harry Potterr", "Animation", "Roger Allers", 87, 19.95f);
			cart.addMedia(dvd);
		} catch (NegativeException e) {
			e.printStackTrace();
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
	    Book book;
		try {
			book = new Book("Harry Potter", "Science Fiction", 9.9f);
			cart.addMedia(book);
		} catch (NegativeException e) {
			e.printStackTrace();
		} catch (LimitExceededException e) {			
			e.printStackTrace();
		}
	    CompactDisc cd;
		try {
			cd = new CompactDisc("Greatest Hits", "Rock", 11f, "Journey", "Micheal Jackson");
			cart.addMedia(cd);
		} catch (NegativeException e) {
			e.printStackTrace();
		} catch (LimitExceededException e) {			
			e.printStackTrace();
		}	    
	    new CartScreen(cart);
	}
}

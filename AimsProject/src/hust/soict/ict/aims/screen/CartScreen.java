package hust.soict.ict.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
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
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("Harry Potterr", "Animation", "Roger Allers", 87, 19.95f);
	    Book book = new Book(5, "Harry Potter", "Science Fiction", 9.9f);
	    CompactDisc cd = new CompactDisc(10, "Greatest Hits", "Rock", 11f, "Journey", "Micheal Jackson");
	    
	    cart.addMedia(dvd);
	    cart.addMedia(book);
	    cart.addMedia(cd);
	    
	    new CartScreen(cart);
	}
}

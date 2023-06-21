package hust.soict.ict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.screen.add.AddBookToStoreScreen;
import hust.soict.ict.aims.screen.add.AddCompactDiscToStoreScreen;
import hust.soict.ict.aims.screen.add.AddDigitalVideoDiscToStoreScreen;
import hust.soict.ict.aims.store.Store;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	public StoreScreen(Store store) {
		this.cart = new Cart();
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update store");
		JMenuItem addBookMenuItem = new JMenuItem("Add book");
		addBookMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AddBookToStoreScreen(store);
		    }
		});
		smUpdateStore.add(addBookMenuItem);

		JMenuItem addCDMenuItem = new JMenuItem("Add CD");
		addCDMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AddCompactDiscToStoreScreen(store);
		    }
		});
		smUpdateStore.add(addCDMenuItem);

		JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
		addDVDMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AddDigitalVideoDiscToStoreScreen(store);
		    }
		});
		smUpdateStore.add(addDVDMenuItem);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		JMenuItem viewCart = new JMenuItem("View cart");
	    viewCart.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            new CartScreen(cart);
	        }
	    });
		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i<mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
	}
	
	public static void main(String[] args) {
		Store store = new Store(10);
		DigitalVideoDisc dvd;
		try {
			dvd = new DigitalVideoDisc("Harry Potterr", "Animation", "Roger Allers", 87, 19.95f);
			store.addMedia(dvd);
		} catch (NegativeException e) {
			e.printStackTrace();
		} catch (LimitExceededException e) {
			e.printStackTrace();
		}
	    Book book;
		try {
			book = new Book("Harry Potter", "Science Fiction", 9.9f);
			store.addMedia(book);
		} catch (NegativeException e) {
			e.printStackTrace();
		} catch (LimitExceededException e) {			
			e.printStackTrace();
		}
	    CompactDisc cd;
		try {
			cd = new CompactDisc("Greatest Hits", "Rock", 11f, "Journey", "Micheal Jackson");
			store.addMedia(cd);
		} catch (NegativeException e) {
			e.printStackTrace();
		} catch (LimitExceededException e) {			
			e.printStackTrace();
		}
	    new StoreScreen(store);
	}
}

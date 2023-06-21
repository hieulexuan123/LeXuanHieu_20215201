package hust.soict.ict.aims.screen.add;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.ict.aims.screen.StoreScreen;
import hust.soict.ict.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createMenuBar(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Add Item");
        setSize(1024, 768);
    }

    protected JMenuBar createMenuBar() {
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
		JMenuItem viewStoreMenuItem = new JMenuItem("View store");
	    viewStoreMenuItem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            new StoreScreen(store);
	            dispose(); // to close the current frame
	        }
	    });
	    menu.add(viewStoreMenuItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
    }

    protected abstract JPanel createCenter();
}

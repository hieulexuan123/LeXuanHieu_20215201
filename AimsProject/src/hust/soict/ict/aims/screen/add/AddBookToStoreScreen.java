package hust.soict.ict.aims.screen.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.screen.StoreScreen;
import hust.soict.ict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    protected JPanel createCenter() {
    	JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();
        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();
        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();
        JLabel authorsLabel = new JLabel("Authors (comma-separated):");
        JTextField authorsField = new JTextField();

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorsField.getText().split(",")));

                Book newBook;
				try {
					newBook = new Book(title, category, cost, authors);
					store.addMedia(newBook);
					JOptionPane.showMessageDialog(null, "Book added successfully!");
				} catch (NegativeException e1) {
					e1.printStackTrace();
				} catch (LimitExceededException e1) {
					e1.printStackTrace();
				}
               
            }
        });

        center.add(titleLabel);
        center.add(titleField);
        center.add(categoryLabel);
        center.add(categoryField);
        center.add(costLabel);
        center.add(costField);
        center.add(authorsLabel);
        center.add(authorsField);
        center.add(new JLabel()); // Empty label to align the button to the right
        center.add(addButton);

        return center;

    }
}

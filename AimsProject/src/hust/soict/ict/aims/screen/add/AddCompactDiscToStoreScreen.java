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
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.screen.StoreScreen;
import hust.soict.ict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	public AddCompactDiscToStoreScreen(Store store) {
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
        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();
        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField();

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String director = directorField.getText();
                String artist = artistField.getText();  

                CompactDisc newCd;
				try {
					newCd = new CompactDisc(title, category, cost, director, artist);
					store.addMedia(newCd);
					JOptionPane.showMessageDialog(null, "CD added successfully!");
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
        center.add(directorLabel);
        center.add(directorField);
        center.add(artistLabel);
        center.add(artistField);
        center.add(new JLabel()); // Empty label to align the button to the right
        center.add(addButton);

        return center;

    }
}

package hust.soict.ict.aims.screen.add;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.screen.StoreScreen;
import hust.soict.ict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
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
        JLabel lengthLabel = new JLabel("Length:");
        JTextField lengthField = new JTextField();

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String director = directorField.getText();
                int length = Integer.parseInt(lengthField.getText().trim());

                DigitalVideoDisc newDvd;
				try {
					newDvd = new DigitalVideoDisc(title, category, director, length, cost);
					store.addMedia(newDvd);
					JOptionPane.showMessageDialog(null, "DVD added successfully!");
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
        center.add(lengthLabel);
        center.add(lengthField);
        center.add(new JLabel()); // Empty label to align the button to the right
        center.add(addButton);

        return center;
    }
}

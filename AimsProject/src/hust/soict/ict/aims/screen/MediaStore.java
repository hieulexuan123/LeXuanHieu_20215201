package hust.soict.ict.aims.screen;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addBtn = new JButton("Add to cart");
		container.add(addBtn);
		
		if (media instanceof Playable) {
			JButton playBtn = new JButton("Play");
			playBtn.addActionListener(new btnListener());
			container.add(playBtn);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
	}
	
	private class btnListener implements ActionListener {

		@Override
		 public void actionPerformed(ActionEvent e) {
	        JDialog dialog = new JDialog();
	        dialog.setTitle("Playable Media");

	        JPanel panel = new JPanel();
	        panel.add(new JLabel("Playing " + media.getTitle()));
	        dialog.add(panel);

	        dialog.setSize(300, 200); 
	        dialog.setLocationRelativeTo(null); 
	        dialog.setModal(true); 
	        dialog.setVisible(true); 
	    } 
		
	}
	
}

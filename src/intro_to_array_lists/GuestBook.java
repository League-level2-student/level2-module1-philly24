package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
JButton button1;
JButton button2;
JFrame frame;
JPanel panel;

	public void gui() {
	frame = new JFrame();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	button1 = new JButton();
	button1.setText("Add Name");
	button1.addActionListener(this);
	button2 = new JButton();
	button2.setText("View Names");
	button2.addActionListener(this);
	panel = new JPanel();
	panel.add(button1);
	panel.add(button2);
	frame.add(panel);
	frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> name = new ArrayList<String>();
		JButton buttonPressed = (JButton) e.getSource();
		String names;
		String message;
		if (buttonPressed==button1) {
			 names = JOptionPane.showInputDialog("add name");
		name.add(names);
		}
		else {
			for (int i = 0; i < name.size(); i++) {
				message = "Guest #"+i+": "; 
				JOptionPane.showMessageDialog(null,message);
			}
		
		}
	}
public static void main(String[] args) {
	GuestBook guest = new GuestBook();
	guest.gui();
	
}
}

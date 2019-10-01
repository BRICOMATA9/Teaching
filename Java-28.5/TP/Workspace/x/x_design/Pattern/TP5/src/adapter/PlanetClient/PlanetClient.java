package adapter.PlanetClient;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class PlanetClient {
	public static void main(String[] args) {
		// our new icon
		Icon icon = new PlanetIcon(100);

		// we adapt the PlanetIcon so it is now a JComponent
		JComponent component = new IconAdapter(icon);
        
        // JFrame expects JComponent objects
		JFrame frame = new JFrame();
		
		// the add() method of the frame is expecting a JComponent
		frame.add(component,BorderLayout.CENTER);

		// set up the rest of the UI
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

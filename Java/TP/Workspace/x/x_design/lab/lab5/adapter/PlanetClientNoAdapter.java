import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class PlanetClientNoAdapter
{
	public static void main(String[] args) {
		JComponent component = new JButton("Click Me!");
        
        // we are using a JFrame (which expects JCompnents)
		JFrame frame = new JFrame();
		
		// the add() method of the frame is expecting a JComponent
		frame.add(component,BorderLayout.CENTER);

		// set up the rest of the UI
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

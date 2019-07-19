package adapter.PlanetClient;

import javax.swing.*;
import java.awt.*;

public class IconAdapter extends JComponent {
	private Icon icon;
	
	public IconAdapter(Icon icon) {
		this.icon = icon;
	}
	
	public void paintComponent(Graphics g) {
		icon.paintIcon(this,g,0,0);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(icon.getIconWidth(),icon.getIconHeight());
	}

}

package vue;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import modele.Gestion_Entreprises_Interdites_achat;

@SuppressWarnings("rawtypes")
public class Renderer_combobox_ajout  implements ListCellRenderer{
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	ImageIcon icone = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone_interdit.png")));

	public Component getListCellRendererComponent(JList list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {


		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
				isSelected, cellHasFocus);

		if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(value.toString())==true){
			renderer.setEnabled(false);

			renderer.setToolTipText("Achat Interdit !!");
			renderer.setForeground(Color.GRAY);
			renderer.setIcon(icone);
			renderer.setFocusable(false);	    	
		}

		return renderer;
	}
}
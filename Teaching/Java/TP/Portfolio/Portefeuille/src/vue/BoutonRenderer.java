package vue;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import vue.ButtonEditor.ButtonListener;

public class BoutonRenderer extends JButton implements TableCellRenderer{
	static ArrayList<Integer> lignes_boutons_alerte = new ArrayList<Integer>();
	ButtonListener listener ;
	static String text="Pousser l'alerte";
	public BoutonRenderer(){
		//this.setText("Pousser l'alerte");
	}	
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		//Si la valeur de la cellule est un JButton, on transtype cette valeur
		String ligne_alerte =") a mis une <strong>alerte</strong> pour <strong>";


		if(Panel_interface_bob.Tableau_Activite_Entreprises.getValueAt(row,0).toString().contains(ligne_alerte)){
			this.setText(text);
			this.setEnabled(true);
		//System.out.print("dans le if");

		}else{			
				this.setText(null);
				this.setEnabled(false);

		}
		return this; 
	}
}
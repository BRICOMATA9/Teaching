package vue;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import modele.Gestion_Tableau_Activite_Entreprises;


public class TableRenderer_activiteentreprises_bob extends DefaultTableCellRenderer
{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);

		if(row==0){
			this.setHorizontalAlignment(CENTER);
		}
		else{
			if(Gestion_Tableau_Activite_Entreprises.liste_users.contains(Panel_interface_bob.Tableau_Activite_Entreprises.getValueAt(row, 0))){
			
				this.setForeground(new Color(225,69,0));
				this.setHorizontalAlignment(LEFT);
			}
			else{
				this.setForeground(Color.BLACK);
				this.setHorizontalAlignment(LEFT);
			}
		}

		return this;
	}
}
package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import modele.Gestion_entreprises_a_risque;
import modele.ModeleDynamiqueObjet;
import vue.Panel_interface;


public class TableRenderer extends DefaultTableCellRenderer
{
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);

		if((ModeleDynamiqueObjet.row_a_colorier.contains(row))&&(column!=5)){
			this.setBackground(Color.orange);
			this.setToolTipText("Alerte sur cette entreprise");
			if(row==Panel_interface.tableau.getSelectedRow()){
				this.setBackground(Color.getColor("ss", 57));
			}
		} 
		else{
			if(Gestion_entreprises_a_risque.verifier_si_alerte_sur_entreprise(Panel_interface.tableau.getValueAt(row,0).toString())==true){
				//this.setBackground(Color.red);
				this.setToolTipText("Entreprise a risque");
			}
			else{
			if(row !=Panel_interface.tableau.getSelectedRow()){
				this.setBackground(Color.white);  
			}
			}
		}
		return this;
	}
}
package vue;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import modele.Gestion_Entreprises_Interdites_achat;
import modele.Gestion_entreprises_a_risque;
import vue.Panel_interface;


public class IconRenderer extends DefaultTableCellRenderer
{
	
	private ImageIcon icone = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/warning_icone1.png")));
	private ImageIcon iconeinterdit = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone_interdit.png")));
	private static final long serialVersionUID = 1L;
	
	@Override
	// Cette m�thode permet de ' dessiner ' une cellule
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);

		if((Gestion_Entreprises_Interdites_achat.verifier_entreprise(Panel_interface.tableau.getValueAt(row,0).toString())==true)&&(column==6)){
			this.setIcon(iconeinterdit);
			this.setToolTipText("Achat Interdit sur cette entreprise");
			if((Gestion_entreprises_a_risque.verifier_si_alerte_sur_entreprise(Panel_interface.tableau.getValueAt(row, 0).toString())==true)&&(column==5)){

				this.setIcon(icone);
				this.setToolTipText("Entreprise a risque");
			} 
		}else{
			if((Gestion_entreprises_a_risque.verifier_si_alerte_sur_entreprise(Panel_interface.tableau.getValueAt(row, 0).toString())==true)&&(column==5)){
				this.setIcon(icone);
				this.setToolTipText("Entreprise a risque");
			} 
			else{				
			this.setIcon(null);
			}
		}
		return this;
	}
}
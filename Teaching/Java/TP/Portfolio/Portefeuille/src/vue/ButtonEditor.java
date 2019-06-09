package vue;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;
	protected static  JButton button;
	private ButtonListener bListener = new ButtonListener();
	public static String texte_bouton;

	//Constructeur avec une CheckBox
	public ButtonEditor(JCheckBox checkBox) {
		//Par défaut, ce type d'objet travaille avec un JCheckBox
		super(checkBox);
		//On crée à nouveau un bouton

		button = new BoutonRenderer();
		button.addActionListener(bListener);


	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) { 
		//On précise le numéro de ligne à notre listener
		bListener.setRow(row);
		//Idem pour le numéro de colonne
		bListener.setColumn(column);
		//On passe aussi le tableau en paramètre pour des actions potentielles
		bListener.setTable(table); 

		return button;
	}

	//Notre listener pour le bouton
	class ButtonListener implements ActionListener{        
		public void setColumn(int col){}
		public void setRow(int row){}
		public void setTable(JTable table){}

		public void actionPerformed(ActionEvent event) {
			String ligne_alerte ="alerte";
			button.setText(BoutonRenderer.text);

			//On affiche un message, mais vous pourriez effectuer les traitements que vous voulez

			int ligne =Panel_interface_bob.Tableau_Activite_Entreprises.getSelectedRow();
			texte_bouton=Panel_interface_bob.modele_tableau_activite_entreprise.getValueAt(ligne, 0).toString();

			//System.out.println("texte bouton"+texte_bouton);
			//System.out.println(BoutonRenderer.lignes_boutons_alerte);
			if(texte_bouton.contains(ligne_alerte)==true){
				@SuppressWarnings("unused")

				Popup_Pousser_Alerte pop = new Popup_Pousser_Alerte(new JFrame(),"Pousser Alerte",true);
			}

		}
	}     
}
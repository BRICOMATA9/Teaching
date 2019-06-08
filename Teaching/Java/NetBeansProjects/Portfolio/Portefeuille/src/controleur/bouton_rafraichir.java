package controleur;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;

import modele.API_YahooFinance;
import modele.ModeleDynamiqueObjet;
import vue.Panel_interface;

public class bouton_rafraichir extends AbstractAction {
	private static final long serialVersionUID = 1L;
	@Override
	public void actionPerformed(ActionEvent e) {
	rafraichirtableau();
		ModeleDynamiqueObjet.rafraichirtotalportefeuille();
	}
	
	
	public static void rafraichirtableau(){
		double valeurupdate = 0;

		for (int i=0;i<Panel_interface.tableau.getRowCount();i++){
			String ID =Panel_interface.tableau.getValueAt(i, 1).toString();

			try {
				valeurupdate = API_YahooFinance.valeuraction(ID);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Panel_interface.tableau.setValueAt(valeurupdate+"euros", i, 3);
		}
	}
}

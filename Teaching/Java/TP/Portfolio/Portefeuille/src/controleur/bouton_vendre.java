package controleur;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import modele.Gestion_base_de_donnee;
import modele.ModeleDynamiqueObjet;
import modele.jcomboboxachatvente;
import vue.Panel_interface;
import java.util.Date;


public class bouton_vendre extends AbstractAction {

	private static final long serialVersionUID = 1L;
	String nombre_actions_a_vendre;
	int nombre_actions_a_vendre_int;
	int nombre_action_a_verif;
	@Override
	public void actionPerformed(ActionEvent e) {
		String ID_entreprise_a_vendre = null;
		nombre_actions_a_vendre= Panel_interface.Champ_achat_vente.getText();
		nombre_actions_a_vendre_int=Integer.parseInt(nombre_actions_a_vendre) ;
		int position_liste_entreprise = Panel_interface.combo_box_achat_vente.getSelectedIndex();
		String entreprise_selectionnee=Panel_interface.combo_box_achat_vente.getSelectedItem().toString();
		ID_entreprise_a_vendre= Panel_interface.Liste_choix_ID_achat_vente.get(position_liste_entreprise);
		for (int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i,0)== entreprise_selectionnee){
				nombre_action_a_verif = Integer.parseInt(Panel_interface.tableau.getValueAt(i, 2).toString());
			}
		}

		if(nombre_actions_a_vendre_int > nombre_action_a_verif){
			JOptionPane.showMessageDialog(null, "Vous ne pouvez pas vendre plus d'actions que vous n'en possedez");
			Panel_interface.Champ_achat_vente.setText("");
		}
		else{
			Gestion_base_de_donnee.Vente(ID_entreprise_a_vendre, nombre_actions_a_vendre_int);
			Date date = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
					DateFormat.SHORT,
					DateFormat.MEDIUM);
			jcomboboxachatvente.remplirtableauachatvente("Vente", entreprise_selectionnee, ID_entreprise_a_vendre,nombre_actions_a_vendre_int,bouton_connexion.utilisateurconnecte,shortDateFormat.format(date));

			Date date1 = new Date();
			SimpleDateFormat formater = new SimpleDateFormat("'le' dd/MM/yyyy 'a' hh:mm:ss");
			String resume = "<html><body><b>"+formater.format(date1)+"</b> <br> Vente  de "+nombre_actions_a_vendre_int+ " actions de "+entreprise_selectionnee+" </body></html>";
			ModeleDynamiqueObjet.updatehistoriqueachatvente(resume);

		}
	}
}
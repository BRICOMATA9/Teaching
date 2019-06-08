package controleur;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import modele.Gestion_base_de_donnee;
import modele.ModeleDynamiqueObjet;
import modele.jcomboboxachatvente;
import vue.Panel_interface;

public class bouton_acheter extends AbstractAction  {

	private static final long serialVersionUID = 1L;
	private static  String nombre_actions_a_acheter;
	private static  int nombre_actions_a_acheter_int;

	@Override
	public void actionPerformed(ActionEvent e) {
		nombre_actions_a_acheter = Panel_interface.Champ_achat_vente.getText();
		nombre_actions_a_acheter_int=Integer.parseInt(nombre_actions_a_acheter) ;
		double valeur_unitaire = 0;
		String ID_entreprise_a_acheter = null;
		String entreprise_selectionnee=Panel_interface.combo_box_achat_vente.getSelectedItem().toString();
		int position_liste_entreprise = Panel_interface.combo_box_achat_vente.getSelectedIndex();	
		ID_entreprise_a_acheter = Panel_interface.Liste_choix_ID_achat_vente.get(position_liste_entreprise);

		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise_selectionnee)){
				valeur_unitaire=Double.parseDouble(Panel_interface.tableau.getValueAt(i, 3).toString().replace("euros", ""));
			}
		}
		
		double Montantachat =nombre_actions_a_acheter_int*valeur_unitaire;

		if(Montantachat < bouton_limite_investissement.chiffre_limite_investissement){
			
			//System.out.println("Dans le if du bouton achat limite investissement");
			Gestion_base_de_donnee.Achat(ID_entreprise_a_acheter, nombre_actions_a_acheter_int);
			Date date = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
					DateFormat.SHORT,
					DateFormat.MEDIUM);
			jcomboboxachatvente.remplirtableauachatvente("Achat", entreprise_selectionnee, ID_entreprise_a_acheter,nombre_actions_a_acheter_int,bouton_connexion.utilisateurconnecte,shortDateFormat.format(date));

			Date date1 = new Date();
			SimpleDateFormat formater = new SimpleDateFormat("'le' dd/MM/yyyy 'a' hh:mm:ss");
			String resume ="<html><body>"+formater.format(date1)+"<br>  Achat de "+nombre_actions_a_acheter_int+ " actions de "+entreprise_selectionnee+" </body></html>";
			ModeleDynamiqueObjet.updatehistoriqueachatvente(resume);
		}else{
			JOptionPane.showMessageDialog(null, "La limite d'investissement est de "+bouton_limite_investissement.chiffre_limite_investissement+". Vous ne pouvez pas acheter autant d'actions");
		}


	}
}

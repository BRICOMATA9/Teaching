package controleur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import modele.Gestion_Entreprises_Interdites_achat;
import vue.Panel_interface_bob;

public class bouton_interdire_achat extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		String entreprise;
		entreprise= Panel_interface_bob.combobox_entreprises.getSelectedItem().toString();
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment interdire les achats sur l'entreprise "+entreprise+" ? ", "Interdiction d'achat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(Panel_interface_bob.combobox_entreprises.getSelectedItem().toString())==true){
				
				if(option==JOptionPane.OK_OPTION){
					
					Gestion_Entreprises_Interdites_achat.supprimerentreprise(entreprise);
					Panel_interface_bob.bouton_interdire_achat.setText("Interdire d'achat");
					
				}
				if(option==JOptionPane.NO_OPTION){
					
				}
		}else{
		
		if(option==JOptionPane.OK_OPTION){
			//System.out.println(" dans le ok");
			Gestion_Entreprises_Interdites_achat.stockerentreprise(entreprise);
			Panel_interface_bob.bouton_interdire_achat.setText("Enlever interdiction d'achat");
			
		}
		if(option == JOptionPane.NO_OPTION){
			
		}
		}

	}
}

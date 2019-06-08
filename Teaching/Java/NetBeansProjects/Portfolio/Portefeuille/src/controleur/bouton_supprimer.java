package controleur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import modele.Gestion_alertes;
import modele.Gestion_base_de_donnee;
import modele.ModeleDynamiqueObjet;
import modele.jcomboboxachatvente;
import vue.Panel_interface;

public class bouton_supprimer extends AbstractAction {


	private static final long serialVersionUID = 1L;
	String IDselection;
	String NomSelection;
	int nombre_actions;
	@Override
	public void actionPerformed(ActionEvent e) {
		new JOptionPane(); 
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous revendre les actions de l'entreprise selectionnee?", "Suppression de l'entreprise", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		int[] selection = Panel_interface.tableau.getSelectedRows();	
		for(int i = selection.length - 1; i >= 0; i--){
			IDselection = Panel_interface.tableau.getValueAt(selection[i],1).toString();
			NomSelection= Panel_interface.tableau.getValueAt(selection[i], 0).toString();
			nombre_actions =Integer.parseInt(Panel_interface.tableau.getValueAt(selection[i],2).toString());
			Panel_interface.modele.removePortefeuille(selection[i]);



			if(option == JOptionPane.NO_OPTION){
				Gestion_base_de_donnee.supprimerlignedelabase(IDselection);
				jcomboboxachatvente.supprimerentreprise(IDselection);
				jcomboboxachatvente.supprimerentreprisedetabeaucomboboxachatvente(IDselection);
				ModeleDynamiqueObjet.rafraichirtotalportefeuille();
				Gestion_alertes.supprimeralerte(NomSelection);
			}
			if(option==JOptionPane.OK_OPTION){				
				Gestion_base_de_donnee.supprimerlignedelabase(IDselection);
				jcomboboxachatvente.supprimerentreprise(IDselection);
				jcomboboxachatvente.supprimerentreprisedetabeaucomboboxachatvente(IDselection);
				Gestion_alertes.supprimeralerte(NomSelection);
				Gestion_base_de_donnee.Vente(IDselection, nombre_actions);

			}
		}
	}
}
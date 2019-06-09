package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modele.Gestion_achatvente_automatique;
import modele.Gestion_base_de_donnee;
import modele.ModeleDynamiqueObjet;
import vue.Panel_interface;
import vue.Popup_achatventeautomatique;

public class bouton_achatvente_automatique extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String entreprise;
	private static int nombre_action;
	private static int valeur_limite;

	public bouton_achatvente_automatique(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(new Dimension(800,200));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();

	}



	private void initComponent(){
		Popup_achatventeautomatique panelcombobox =new Popup_achatventeautomatique();
		panelcombobox.setBackground(Color.white);
		panelcombobox.setPreferredSize(new Dimension(800, 150));

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panelcombobox);
		JPanel control = new JPanel();

		JButton okBouton = new JButton("OK");
		JButton cancelBouton = new JButton("Annuler");
		control.add(okBouton);
		control.add(cancelBouton);

		// Initialiser les composants 
		Popup_achatventeautomatique.combobox_achatvente_automatique.setSelectedItem(Panel_interface.combo_box_achat_vente.getSelectedItem());
		Popup_achatventeautomatique.spinner_valeur_achatvente_auto.setValue(50);	


		Popup_achatventeautomatique.spinner_nombreaction.addKeyListener(new KeyListener() { 

			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER) {

					okBouton.doClick();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER) {

					okBouton.doClick();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER) {

					okBouton.doClick();
				}

			}
		});


		okBouton.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {

				entreprise =Popup_achatventeautomatique.combobox_achatvente_automatique.getSelectedItem().toString();
				valeur_limite = Integer.parseInt(Popup_achatventeautomatique.spinner_valeur_achatvente_auto.getValue().toString());
				nombre_action = Integer.parseInt(Popup_achatventeautomatique.spinner_nombreaction.getValue().toString());

				if((Popup_achatventeautomatique.radiobouton_achat.isSelected()==true)&&(Popup_achatventeautomatique.radiobouton_endessous.isSelected()==true)){
					achatautomatique_endessous(entreprise,valeur_limite,nombre_action);
					Gestion_achatvente_automatique.stockerachatventeautomatique(entreprise, "Achat", "en_dessous", valeur_limite, nombre_action);
					setVisible(false);

				}


				if((Popup_achatventeautomatique.radiobouton_achat.isSelected()==true)&&(Popup_achatventeautomatique.radiobouton_audessus.isSelected()==true)){
					achatautomatique_audessus(entreprise,valeur_limite,nombre_action);				
					Gestion_achatvente_automatique.stockerachatventeautomatique(entreprise, "Achat", "au_dessus", valeur_limite, nombre_action);
					setVisible(false);

				}


				if((Popup_achatventeautomatique.radiobouton_vente.isSelected()==true)&&(Popup_achatventeautomatique.radiobouton_endessous.isSelected()==true)){
					venteautomatique_endessous(entreprise,valeur_limite,nombre_action);
					Gestion_achatvente_automatique.stockerachatventeautomatique(entreprise, "Vente", "en_dessous", valeur_limite, nombre_action);
					setVisible(false);


				}		

				//Si vente quand au dessus d'une certaine valeur
				if((Popup_achatventeautomatique.radiobouton_vente.isSelected()==true)&&(Popup_achatventeautomatique.radiobouton_audessus.isSelected()==true)){
					venteautomatique_audessus(entreprise,valeur_limite,nombre_action);
					Gestion_achatvente_automatique.stockerachatventeautomatique(entreprise, "Vente", "au_dessus", valeur_limite, nombre_action);
					setVisible(false);

				}			

				else{
					if((Popup_achatventeautomatique.radiobouton_audessus.isSelected()==false)&&(Popup_achatventeautomatique.radiobouton_endessous.isSelected()==false)){
						JOptionPane.showMessageDialog(null, "Vous n'avez pas selectionne l'option au_dessus ou en_dessous ");
					}
					if(((Popup_achatventeautomatique.radiobouton_audessus.isSelected()==true)||(Popup_achatventeautomatique.radiobouton_endessous.isSelected()==true))&&(Popup_achatventeautomatique.radiobouton_achat.isSelected()==false)&&(Popup_achatventeautomatique.radiobouton_vente.isSelected()==false)){
						JOptionPane.showMessageDialog(null, "Vous n'avez pas selectionne l'option Achat ou Vente ");
					}
				}


			}

		});




		this.getContentPane().add(content, BorderLayout.NORTH);
		this.getContentPane().add(control, BorderLayout.SOUTH);
		this.setVisible(true);


	} 

	public static void choixtypetransactionautomatique(String entreprise,String type_transaction,String type_condition,int valeur_limite,int nombreactions){
		if(type_transaction.equals("Achat")&&(type_condition.equals("au_dessus"))){
			achatautomatique_audessus(entreprise,valeur_limite,nombreactions);
			Gestion_achatvente_automatique.stopper_achatvente_automatique(entreprise);
		}
		if(type_transaction.equals("Achat")&&(type_condition.equals("en_dessous"))){
			achatautomatique_endessous(entreprise,valeur_limite, nombreactions);
			Gestion_achatvente_automatique.stopper_achatvente_automatique(entreprise);
		}
		if(type_transaction.equals("Vente")&&(type_condition.equals("au_dessus"))){

			venteautomatique_audessus(entreprise,valeur_limite,nombreactions);
			Gestion_achatvente_automatique.stopper_achatvente_automatique(entreprise);
		}
		if(type_transaction.equals("Vente")&&(type_condition.equals("en_dessous"))){

			venteautomatique_endessous(entreprise,valeur_limite,nombreactions);
			Gestion_achatvente_automatique.stopper_achatvente_automatique(entreprise);
		}
	}

	public static void achatautomatique_audessus(String entreprise,int valeur_limite,int nombreactions){
		//Si la valeur est au dessus, on achete les actions.
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
				if(Double.parseDouble(Panel_interface.tableau.getValueAt(i, 3).toString().replace("euros", "")) > valeur_limite){
					Gestion_base_de_donnee.Achat(ModeleDynamiqueObjet.recupererIDavecnomentreprise(entreprise), nombre_action);
					JOptionPane.showMessageDialog(null, "Achat automatique sur "+entreprise+"effectue ("+nombreactions+" vendues)");
				}
			}
		}
			
	}
	public static void achatautomatique_endessous(String entreprise,int valeur_limite,int nombreactions){
		//Si la valeur est au dessus, on achete les actions.
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
				if(Double.parseDouble(Panel_interface.tableau.getValueAt(i, 3).toString().replace("euros", "")) < valeur_limite){
					
					Gestion_base_de_donnee.Achat(ModeleDynamiqueObjet.recupererIDavecnomentreprise(entreprise), nombre_action);
					JOptionPane.showMessageDialog(null, "Achat automatique sur "+entreprise+"effectue ("+nombreactions+" vendues)");
					
				}

			}

		}
	}

	public static void venteautomatique_audessus(String entreprise,int valeur_limite,int nombreactions){
		
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
				if(Double.parseDouble(Panel_interface.tableau.getValueAt(i, 3).toString().replace("euros", "")) > valeur_limite){
					Gestion_base_de_donnee.Vente(ModeleDynamiqueObjet.recupererIDavecnomentreprise(entreprise), nombre_action);
					JOptionPane.showMessageDialog(null, "Achat automatique sur "+entreprise+"effectue ("+nombreactions+" vendues)");
					
				}
			}
		}
		
	}

	public static void venteautomatique_endessous(String entreprise,int valeur_limite,int nombreactions){
		
		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
				if(Double.parseDouble(Panel_interface.tableau.getValueAt(i, 3).toString().replace("euros", "")) < valeur_limite){
					Gestion_base_de_donnee.Vente(ModeleDynamiqueObjet.recupererIDavecnomentreprise(entreprise), nombre_action);
					JOptionPane.showMessageDialog(null, "Achat automatique sur "+entreprise+"effectue ("+nombreactions+" vendues)");
					
					}
			}
		}
	}
}



package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.Timer;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import modele.Gestion_Entreprises_Interdites_achat;
import modele.Gestion_alertes;
import modele.Gestion_entreprises_a_risque;

public class Jpopupmenu extends JPopupMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JMenuItem item_entreprise_a_risque = new JMenuItem("Signaler comme entreprise à risque");
	private static JMenuItem item_poser_alerte = new JMenuItem("Poser une alerte");
	private static JMenuItem item_enlever_alerte = new JMenuItem("Enlever l'alerte");
	private static JMenuItem item_enlever_signalement_risque = new JMenuItem("Enlever le signalement à risque");
	private static String entreprise_selectionnee;
	public Jpopupmenu(){

		
		item_entreprise_a_risque.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Panel_interface.tableau.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Vous devez sélectionner une entreprise dans le tableau","Erreur de selection",JOptionPane.WARNING_MESSAGE);
				}
				else{
							
					int row =Panel_interface.tableau.getSelectedRow();
					String entreprise = Panel_interface.tableau.getValueAt(row, 0).toString();
					Gestion_entreprises_a_risque.enregistrer_entreprise_a_risque(entreprise);
					Gestion_entreprises_a_risque.recuperer_entreprise_a_risque();
					JOptionPane.showMessageDialog(null, "Entreprise enregistree comme a risque");
				
				}
				
			}
			
		});
		
		item_poser_alerte.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Panel_interface.tableau.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Vous devez sélectionner une entreprise dans le tableau","Erreur de selection",JOptionPane.WARNING_MESSAGE);
				}
				else{
					@SuppressWarnings("unused")
					Popup_alertes pop = new Popup_alertes(null, "test", true);	
				}
			}
			
		});
		item_enlever_alerte.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Panel_interface.tableau.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Vous devez sélectionner une entreprise dans le tableau","Erreur de selection",JOptionPane.WARNING_MESSAGE);
				}
				else{
					
					Gestion_alertes.supprimeralerte(entreprise_selectionnee);
					JOptionPane.showMessageDialog(null, "Alerte supprimee");
				
				}
			}
			
		});
		item_enlever_signalement_risque.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Panel_interface.tableau.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Vous devez sélectionner une entreprise dans le tableau","Erreur de selection",JOptionPane.WARNING_MESSAGE);
				}
				else{
					Gestion_entreprises_a_risque.supprimer_entreprise_a_risque(entreprise_selectionnee);
					JOptionPane.showMessageDialog(null, "Signalement enleve");
				}
			}
			
		});
	
		
		this.addPopupMenuListener(new PopupMenuListener(){
				
			
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e){
				
			
				entreprise_selectionnee =Panel_interface.tableau.getValueAt(Panel_interface.tableau.getSelectedRow(),0 ).toString();
					System.out.println("SOURCE     "+e.getSource().toString());
				if((Gestion_alertes.verifier_si_alerte_sur_entreprise(entreprise_selectionnee)==true)&&(Gestion_entreprises_a_risque.verifier_alerte_sur_ligne(entreprise_selectionnee)==false)){
					//System.out.println("Alerte sur entreprise, on donne la possiblilité de l'enlever");
					add(item_enlever_alerte);
					add(item_entreprise_a_risque);
					removecomp(item_poser_alerte);
					removecomp(item_enlever_signalement_risque);
					repaint();
					revalidate();
					//System.out.println("Entreprise avec alerte mais pas signalé à risque");
				}else{
				if((Gestion_entreprises_a_risque.verifier_alerte_sur_ligne(entreprise_selectionnee)==true)&&(Gestion_alertes.verifier_si_alerte_sur_entreprise(entreprise_selectionnee)==false)){
					removecomp(item_entreprise_a_risque);
					removecomp(item_enlever_alerte);
					add(item_enlever_signalement_risque);
					add(item_poser_alerte);
					
					repaint();
					revalidate();
					//System.out.println("Entreprise à risque mais sans alerte");
				}else{
					if((Gestion_alertes.verifier_si_alerte_sur_entreprise(entreprise_selectionnee)==true)&&(Gestion_entreprises_a_risque.verifier_alerte_sur_ligne(entreprise_selectionnee)==true)){
						add(item_enlever_signalement_risque);
						add(item_enlever_alerte);
						removecomp(item_poser_alerte);
						removecomp(item_entreprise_a_risque);
						repaint();
						revalidate();
						//System.out.println("A risque et avec Alerte");
					}else{
						
						removecomp(item_enlever_alerte);
						removecomp(item_enlever_signalement_risque);
						add(item_entreprise_a_risque);
						add(item_poser_alerte);
						repaint();
						revalidate();
						//System.out.println("Sans risque et sans alerte");
				}
				
				}
				
				
				
				
				}
	
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				
			}
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				
			}
			
		});
			
	}
	public void removecomp(JMenuItem item){
		this.remove(item);
		
	
	}
}
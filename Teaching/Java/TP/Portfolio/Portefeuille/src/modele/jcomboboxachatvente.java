package modele;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import vue.Panel_interface;
import vue.Renderer_combobox_ajout;

public class jcomboboxachatvente {


	private static Statement st=SQLiteJDBC.connexionbddSQLITE();

	static String IDcorrespondantcomboboxachatvente;
	
	
	
	@SuppressWarnings("unchecked")
	public static void remplir(){

		Panel_interface.combo_box_achat_vente.removeAllItems();

		for (int i=0;i<Panel_interface.tableau.getRowCount();i++){
			Object nom =Panel_interface.tableau.getValueAt(i,0);
			String nom1 = nom.toString();
			Panel_interface.combo_box_achat_vente.addItem(nom1);
			Object ID = Panel_interface.tableau.getValueAt(i, 1);
			String ID1=ID.toString();
			Panel_interface.Liste_choix_ID_achat_vente.add(ID1);
		}
		Renderer_combobox_ajout renderer = new Renderer_combobox_ajout();
		Panel_interface.combo_box_achat_vente.setRenderer(renderer);
		Panel_interface.combo_box_achat_vente.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				String entreprise = Panel_interface.combo_box_achat_vente.getSelectedItem().toString();
				if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(entreprise)==true){
					Panel_interface.bouton_acheter.setEnabled(false);
				
					Panel_interface.bouton_achat_automatique.setEnabled(false);
				}else{
					Panel_interface.bouton_acheter.setEnabled(true);
					Panel_interface.bouton_achat_automatique.setEnabled(true);
				}
			}
			
		});
		if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(Panel_interface.combo_box_achat_vente.getSelectedItem().toString())==true){
			Panel_interface.bouton_acheter.setEnabled(false);
			
			Panel_interface.bouton_achat_automatique.setEnabled(false);
		}
		
	}

	@SuppressWarnings("unchecked")
	public static void supprimerentreprise(String ID){

		int s = Panel_interface.combo_box_achat_vente.getSelectedIndex();
		String entreprise = null;
		try {
			entreprise = API_YahooFinance.recuperernom(ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Panel_interface.Liste_entreprise_combo_box_achat_vente.remove(entreprise);
		Panel_interface.combo_box_achat_vente.removeItemAt(s);
		Panel_interface.Liste_choix_ID_achat_vente.remove(ID);
		/*for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			Panel_interface.combo_box_achat_vente.addItem(Panel_interface.tableau.getValueAt(i, 0));
		}*/
		//Panel_interface.combo_box_achat_vente.setSelectedIndex(0);
	}



	public static void supprimerentreprisedetabeaucomboboxachatvente(String ID){
		try{
			String sql ="DELETE FROM `tableau_combobox_achat_vente` WHERE `tableau_combobox_achat_vente`.`ID` = '"+ ID +"' ";
			st.executeUpdate(sql);

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void remplirtableauachatvente(String type_transaction,String nom, String ID,int nombre_actions,String user,String Date){

		try{
			String sql ="INSERT INTO `Tableau_achat_vente` (`Type_Transaction`,`Entreprises`,`ID`,`nombre_actions`,`Utilisateur`,`Date`) VALUES ('"+type_transaction+"','"+nom +"','"+ID +"','"+nombre_actions+"','"+user+"','"+Date+"')";
			st.executeUpdate(sql);

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

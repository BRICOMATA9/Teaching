package modele;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.data.time.Day;
import org.jfree.data.time.Second;

import controleur.Graphique_journalier_totalportefeuille;
import controleur.Graphique_mensuel_totalportefeuille;
import controleur.bouton_connexion;
import controleur.bouton_rafraichir;
import vue.Panel_interface;

public class Gestion_base_de_donnee {

	static double achat;
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;


	


	public static void sauverlignedansBase(String Entreprise, String ID, int nb_actions, Double valeur_action,Double total,String username){

		try{
			String sql = "INSERT INTO `Tableau_Alice`(`Entreprises`,`ID`,`nombre_actions`,`valeur_action`,`total`,`Utilisateur`) VALUES ('"+ Entreprise +"','" + ID +"','" + nb_actions + "','"+ valeur_action + "','"+total+"','"+username+"')";
			st.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void supprimerlignedelabase(String ID){

		try{
			String sql = "DELETE FROM `Tableau_Alice` WHERE `Tableau_Alice`.`ID` = '"+ ID +"' ";
			st.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void recupererBase(String username){

		try{
			String sql ="SELECT * from `Tableau_Alice` WHERE (`Utilisateur`= '"+username+"')";
			rs=st.executeQuery(sql);

			ModeleDynamiqueObjet.Portefeuille.clear();
			while(rs.next()){
				int nb_actions =rs.getInt("nombre_actions");
				Double val_actions = ModeleDynamiqueObjet.floor(API_YahooFinance.valeuraction(rs.getString("ID")),2);
				Double total = ModeleDynamiqueObjet.floor((nb_actions*val_actions),2)- achat;
				String Total1= total.toString();
				ModeleDynamiqueObjet.Portefeuille.add(new  Portefeuille(rs.getString("Entreprises"),rs.getString("ID"),nb_actions,val_actions.toString()+"euros",Total1+"euros","","")); 
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	


	public static void Achat(String ID_achat, int nombre_action){

		int ancien_nombre_action= 0;
		int nouveau_nombre_action=0;
		double valeur = 0;
		double nouveau_total_ligne = 0;
		try{
			String sql ="SELECT * from `Tableau_Alice` WHERE `ID`='"+ID_achat+"'";
			rs=st.executeQuery(sql);
			while(rs.next()){
				ancien_nombre_action=rs.getInt("nombre_actions");
				valeur=rs.getDouble("valeur_action");
			}
			nouveau_nombre_action= ancien_nombre_action + nombre_action;
			nouveau_total_ligne=nouveau_nombre_action*valeur;
			String changer_nombre_action ="UPDATE `Tableau_Alice` SET `nombre_actions`='"+nouveau_nombre_action+"' WHERE `ID`='"+ID_achat+"' ";
			String changer_total ="UPDATE `Tableau_Alice` SET `total`='"+nouveau_total_ligne+"' WHERE `ID`='"+ID_achat+"' ";
			st.executeUpdate(changer_nombre_action);
			st.executeUpdate(changer_total);

		}catch(SQLException e){
			e.printStackTrace();
		}
		for (int i=0;i<Panel_interface.tableau.getRowCount();i++){
			String entreprise =Panel_interface.tableau.getValueAt(i, 1).toString();

			if(entreprise.equals(ID_achat)){
				Panel_interface.tableau.setValueAt(nouveau_nombre_action, i, 2);
				Panel_interface.tableau.setValueAt(nouveau_total_ligne+"euros", i, 4);
				Panel_interface.modele.fireTableDataChanged();
			}
		}
		ModeleDynamiqueObjet.rafraichirtotalportefeuille();
	}


	public static void Vente(String ID_vente, int nombre_action){

		int ancien_nombre_action= 0;
		int nouveau_nombre_action=0;
		double valeur = 0;
		double nouveau_total_ligne = 0;
		String entreprises = null;
		try{
			String sql ="SELECT * from `Tableau_Alice` WHERE `ID`='"+ID_vente+"'";
			rs=st.executeQuery(sql);
			while(rs.next()){
				ancien_nombre_action=rs.getInt("nombre_actions");
				valeur=rs.getDouble("valeur_action");
				entreprises=rs.getString("Entreprises");
			}
			nouveau_nombre_action= ancien_nombre_action - nombre_action;

			if(nouveau_nombre_action==0){
				supprimerlignedelabase(ID_vente);
				for (int i=0;i<Panel_interface.tableau.getRowCount();i++){
					if(ID_vente.equals(Panel_interface.tableau.getValueAt(i, 1))){
						Gestion_alertes.supprimeralerte(entreprises);
						Panel_interface.modele.removePortefeuille(i);
						Panel_interface.modele.fireTableRowsDeleted(i, i);
						jcomboboxachatvente.supprimerentreprise(ID_vente);
					}
				}
				bouton_rafraichir.rafraichirtableau();
			}
			nouveau_total_ligne=nouveau_nombre_action*valeur;

			String changer_nombre_action ="UPDATE `Tableau_Alice` SET `nombre_actions`='"+nouveau_nombre_action+"' WHERE `ID`='"+ID_vente+"' ";
			String changer_total ="UPDATE `Tableau_Alice` SET `total`='"+nouveau_total_ligne+"' WHERE `ID`='"+ID_vente+"' ";
			st.executeUpdate(changer_nombre_action);
			st.executeUpdate(changer_total);

		}catch(SQLException e){
			e.printStackTrace();
		}
		for (int i=0;i<Panel_interface.tableau.getRowCount();i++){
			String entreprise =Panel_interface.tableau.getValueAt(i, 1).toString();
			if(entreprise.equals(ID_vente)){
				Panel_interface.tableau.setValueAt(nouveau_nombre_action, i, 2);
				Panel_interface.tableau.setValueAt(nouveau_total_ligne+"euros", i, 4);
				Panel_interface.modele.fireTableDataChanged();
			}
		}
		ModeleDynamiqueObjet.rafraichirtotalportefeuille();
	}

	
	
	public static void stockertotaldansbase(String date, double totalportefeuille) {

		String sql1 = "INSERT INTO `tableau_totalportefeuille`(`Date`,`Totalportefeuille`,`Utilisateur`) VALUES('"+date+"','"+totalportefeuille+"','"+bouton_connexion.utilisateurconnecte+"')";
		try {
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void recuperertotauxdujour() {
		try{
			String sql ="SELECT * from `tableau_totalportefeuille` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";

			rs=st.executeQuery(sql);
			while(rs.next()){
				String date = rs.getString("Date");	
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
				Date d = sdf.parse(date);
				
				double total = Double.parseDouble(rs.getString("Totalportefeuille"));
				//System.out.println("Total :"+total);
				
				if(Formatage_Date.recupererles30derniersjours(date)==true){
					int jour = Formatage_Date.recuperer_jour(date);
					int  mois = Formatage_Date.recuperer_mois(date)+1;
					int annee = Formatage_Date.recuperer_annee(date);
						
					if(Formatage_Date.recuperer24dernieresheures(date)==true){
						int heure = Formatage_Date.recuperer_heure(date);
						int minutes = Formatage_Date.recuperer_minutes(date);
						int secondes =Formatage_Date.recuperer_secondes(date);
						Second sec = new Second(d);
						System.out.print("SECOND : "+sec);
						Graphique_journalier_totalportefeuille.s1.addOrUpdate(sec, total);	
					}
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

	public static void recuperertotaux() {
		try{
			String sql ="SELECT * from `tableau_totalportefeuille` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";

			rs=st.executeQuery(sql);
			while(rs.next()){
				String date = rs.getString("Date");	
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
				Date d = sdf.parse(date);
				
				double total = Double.parseDouble(rs.getString("Totalportefeuille"));
				//System.out.println("Total :"+total);
				
				if(Formatage_Date.recupererles30derniersjours(date)==true){
					int jour = Formatage_Date.recuperer_jour(date);
					int  mois = Formatage_Date.recuperer_mois(date)+1;
					int annee = Formatage_Date.recuperer_annee(date);
					
					Graphique_mensuel_totalportefeuille.s1_mensuel.addOrUpdate(new Day(jour, mois,annee), total);	
					
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
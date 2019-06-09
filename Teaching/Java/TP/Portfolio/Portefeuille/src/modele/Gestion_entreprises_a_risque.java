package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import controleur.bouton_connexion;
import vue.Panel_interface;

public class Gestion_entreprises_a_risque {
	
	
	
	static Connection cn=null;
	static Statement st=SQLiteJDBC.connexionbddSQLITE();
	static ResultSet rs=null;
	
	

	public static void enregistrer_entreprise_a_risque(String entreprise){
		if(ModeleDynamiqueObjet.ligne_a_risque.contains(Panel_interface.tableau.getSelectedRow())==false){
			Date date= new Date();
			String date1 =Formatage_Date.mettredateenformepourstockage(date);
			String sql1= "INSERT INTO `Tableau_entreprises_a_risque`(`Entreprise`,`Utilisateur`,`Date`) VALUES('"+entreprise+"','"+bouton_connexion.utilisateurconnecte+"','"+date1+"')";
			try {
				st.executeUpdate(sql1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public static Boolean verifier_si_alerte_sur_entreprise(String entreprise){
		Boolean entreprise_avec_alerte=false;
		String entreprisebdd;
		
		String sql ="SELECT * from `Tableau_entreprises_a_risque` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				 entreprisebdd =rs.getString("Entreprise");
				//if((entreprisebdd != null)){
				if(entreprisebdd.equals(entreprise)){
					entreprise_avec_alerte=true;
				}
			}
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entreprise_avec_alerte;
	}
	
	
	
	public static Boolean verifier_alerte_sur_ligne(String entreprises){
		String entreprise;
		Boolean verif =false;

		String sql ="SELECT * from `Tableau_entreprises_a_risque` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				entreprise =rs.getString("Entreprise");
				
					if(entreprises.equals(entreprise)){	
					
						verif=true;
					}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return verif;
	}
	
	
	public static void supprimer_entreprise_a_risque(String entreprise){
		String sql1= "DELETE  FROM `Tableau_entreprises_a_risque` WHERE `Tableau_entreprises_a_risque`.`Entreprise`='"+entreprise+"'";
		try {
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void recuperer_entreprise_a_risque(){
		String entreprise;
		
		String sql1="SELECT * FROM `Tableau_entreprises_a_risque` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";
		try {
			ModeleDynamiqueObjet.ligne_a_risque.clear();
			rs=st.executeQuery(sql1);
			while(rs.next()){
				entreprise=rs.getString("Entreprise");
				for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
					if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
						ModeleDynamiqueObjet.ligne_a_risque.add(i);		
					}
				}			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Panel_interface.modele.fireTableDataChanged();
		
	}
}
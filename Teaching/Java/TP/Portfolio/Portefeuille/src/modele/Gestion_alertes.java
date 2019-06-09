package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controleur.bouton_connexion;
import vue.Panel_interface;

public class Gestion_alertes {
	static double achat;
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;

	public static void enregistreralerte(String entreprise, int valeur_alerte, String Date) {
		String sql1 = "INSERT INTO `tableau_alertes`(`Entreprise`,`valeur_alerte`,`Utilisateur`,`Date`) VALUES('"+entreprise+"','"+valeur_alerte+"','"+bouton_connexion.utilisateurconnecte+"','"+Date+"')";
		try {
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static void supprimeralerte(String entreprise){
		if(verifier_si_alerte_sur_entreprise(entreprise)==true){
		String sql ="DELETE  from `tableau_alertes` WHERE `tableau_alertes`.`Entreprise`='"+entreprise+"' ";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
			if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
				System.out.println(ModeleDynamiqueObjet.row_a_colorier);
				System.out.println(ModeleDynamiqueObjet.entreprise_color);
				ModeleDynamiqueObjet.row_a_colorier.remove(ModeleDynamiqueObjet.entreprise_color.indexOf(entreprise));
			}
		}
		Panel_interface.modele.fireTableDataChanged();
		}
	}
	

	public static Boolean verifier_si_alerte_sur_entreprise(String entreprise){
		Boolean verif=false;
		String entreprises;
			String sql="SELECT * FROM `tableau_alertes` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";
			try {
				rs=st.executeQuery(sql);
				while(rs.next()){
					entreprises=rs.getString("Entreprise");
					if(entreprises.equals(entreprise)){
						verif=true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return verif;
	}


	public static void colorierlignesalerte() {
		String entreprise;
		int valeur;
		String sql ="SELECT * from `tableau_alertes` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				entreprise =rs.getString("Entreprise");
				valeur = rs.getInt("valeur_alerte");
		
			
				//On ajoute la ligne à row_a_colorier si la valeur d'actions est supérieur à a valeur d'alerte.
				for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
					if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
						
						if(Double.parseDouble(Panel_interface.tableau.getValueAt(i, 3).toString().replace("euros", ""))>valeur){
							ModeleDynamiqueObjet.row_a_colorier.add(i);
							ModeleDynamiqueObjet.entreprise_color.add(entreprise);
							Panel_interface.modele.fireTableDataChanged();
						}		
					}
				}
				
		
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}	
}
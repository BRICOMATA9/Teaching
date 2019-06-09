package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controleur.bouton_achatvente_automatique;
import controleur.bouton_connexion;

public class Gestion_achatvente_automatique {


	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;


	public static void stockerachatventeautomatique(String entreprise,String type,String type2,int valeur_limite,int nombreactions){
		String sql="INSERT INTO `Tableau_achatventeautomatique`(`Entreprises`,`Achat-Vente`,`condition`,`valeur_limite`,`nombreactions`,`Utilisateur`) VALUES('"+entreprise+"','"+type+"','"+type2+"','"+valeur_limite+"','"+nombreactions+"','"+bouton_connexion.utilisateurconnecte+"')";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}


	public static void recupererachatventeautomatique(){
		String entreprise;
		String type_transaction;
		String type_condition;
		int valeur_limite;
		int nombreactions;

		String sql ="SELECT * from `Tableau_achatventeautomatique` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"'";

		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				entreprise=rs.getString("Entreprises");
				type_transaction=rs.getString("Achat-Vente");
				type_condition=rs.getString("condition");
				valeur_limite=rs.getInt("valeur_limite");
				nombreactions=rs.getInt("nombreactions");
				bouton_achatvente_automatique.choixtypetransactionautomatique(entreprise, type_transaction, type_condition,valeur_limite,nombreactions);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Apres avoir acheté automatiquement une fois, on le refait pas donc on élimine l'achat de la bdd.
	public static void stopper_achatvente_automatique(String entreprise){

		String sql ="DELETE  from `Tableau_achatventeautomatique` WHERE `Utilisateur`='"+bouton_connexion.utilisateurconnecte+"' AND `Entreprises`='"+entreprise+"'";

		try {
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Gestion_Entreprises_Interdites_achat{




	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;

	public static void stockerentreprise(String entreprise){
		
		if(verifier_entreprise(entreprise)==false){
		Date Date= new Date();
		String date=Formatage_Date.mettredateenformepourstockage(Date);
		String sql="INSERT INTO `tableau_entreprises_interdites_achat`(`Date`,`Entreprises`) VALUES('"+date+"','"+entreprise+"')";

		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}

	public static void supprimerentreprise(String entreprise){
		String sql ="DELETE FROM `tableau_entreprises_interdites_achat` WHERE `Entreprises`='"+entreprise+"'";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}





	public static Boolean verifier_entreprise(String entreprise){
		Boolean entreprise_interdite=false;
		String entrepriseinterdite;
		String sql="SELECT * FROM `tableau_entreprises_interdites_achat`";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				entrepriseinterdite=rs.getString("Entreprises");	
				if(entrepriseinterdite.equals(entreprise)){
					//System.out.println(entreprise+ " est interdite d'achat");
					entreprise_interdite=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entreprise_interdite;
	}
	public static ArrayList<String> prevenir_bob_des_entreprises_a_risque(){
		ResultSet rs1;
		String es;
		Statement st1=SQLiteJDBC.connexionbddSQLITE();
		//On récupere toutes les entreprises qui ont été signalées comme à risque
		ArrayList<String> liste_entreprises_a_risque = new ArrayList<String>();
		String sql="SELECT * FROM `Tableau_entreprises_a_risque`";
		try {
			rs1=st1.executeQuery(sql);
			while(rs1.next()){
				es=rs1.getString("Entreprise");
				liste_entreprises_a_risque.add(es);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Si elles sont déjà enregistrées comme interdites d'achat, on les vire
		//System.out.println("Entreprises à risque :"+liste_entreprises_a_risque);
		String entreprise_interdite;
		String sql1="SELECT * FROM `tableau_entreprises_interdites_achat`";
		try {
			rs=st.executeQuery(sql1);
			while(rs.next()){
				entreprise_interdite=rs.getString("Entreprises");
				if(liste_entreprises_a_risque.contains(entreprise_interdite)){
					liste_entreprises_a_risque.remove(entreprise_interdite);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("Entreprises à risque - entreprises interdites :"+liste_entreprises_a_risque);

		return liste_entreprises_a_risque;	
	}
}

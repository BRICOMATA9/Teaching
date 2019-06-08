package modele;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;

import vue.Panel_interface_bob;

public class Gestion_Tableau_Activite_Entreprises {

	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;
	static double valeur_action;
	public static ArrayList<String> liste_users = new ArrayList<String>();
	private static ArrayList<String> liste_users_avec_alerte = new ArrayList<String>();
	
	
	public static void rafraichir_tableau(){
		String entreprise_selectionnee;
		//Prendre l'entreprise sélectionnée dans la combobox
		entreprise_selectionnee=Panel_interface_bob.combobox_entreprises.getSelectedItem().toString();
		//On clean le tableau
		
		Modele_Tableau_Activite_Entreprises.Activite_Entreprise.clear();
		Panel_interface_bob.Tableau_Activite_Entreprises.removeAll();
		//Récupérer et afficher les achats/ventes sur cette entreprise.
		afficher_pour_utilisateurs(entreprise_selectionnee);
		if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(entreprise_selectionnee)==true){
			//System.out.println("Deja interdite d'achat");
				Panel_interface_bob.bouton_interdire_achat.setText("Enlever interdiction achat");
		}
		else{
			Panel_interface_bob.bouton_interdire_achat.setText("Interdire d'achat");
		}
	}

	public static void afficher_pour_utilisateurs(String entreprise){

		String titre="<html><body><strong><center>Activité pour l'entreprise  "+entreprise+"</center></strong></body></html>";
		Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise(titre,new JButton()));

		liste_users.clear();
		String ID = null;
		String sql1= "SELECT * FROM `Liste_Entreprises_Yahoo_CAC40` WHERE `Entreprises`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql1);
			while(rs.next()){
				ID=rs.getString("ID");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//On recupere la valeur unitaire de l'action de l'entreprise sur YahooFInance
		//System.out.println("ID "+ ID);
		try {
			valeur_action=API_YahooFinance.valeuraction(ID);
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		ResultSet rs1;
		String user;
		Statement st1=SQLiteJDBC.connexionbddSQLITE();
		String sql="SELECT * FROM `Tableau_Utilisateurs` ";
		try {
			rs1=st1.executeQuery(sql);
			while(rs1.next()){
				user=rs1.getString("Utilisateurs");
				//on affiche l'utilisateur
				String s ="<html><body><strong>"+user+ " : </strong></body></html>";
				Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise(s,new JButton()));
				liste_users.add(s);
				//on affiche toutes les activités qu'a fait cet employé sur l'entreprise
				afficher_achat_entreprise(entreprise,user);
				afficher_vente_entreprise(entreprise,rs1.getString("Utilisateurs"));
				afficher_alertes(entreprise,rs1.getString("Utilisateurs"));
				afficher_entreprise_a_risque(entreprise,rs1.getString("Utilisateurs"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void afficher_entreprise_a_risque(String entreprise,String utilisateur){
		String sql="SELECT * FROM `Tableau_entreprises_a_risque` WHERE `Entreprise`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("Utilisateur").equals(utilisateur)){
				String phrase ="<html><body><strong>Signalement de l'entreprise comme etant a risque</strong></body></html>";
				Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise(phrase,new JButton()));
				}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void afficher_alertes(String entreprise,String utilisateur){
		int valeur_alerte;
		String Date;
		ArrayList<String> liste_alertes= new ArrayList<String>();
		String sql="SELECT * FROM `tableau_alertes` WHERE `Entreprise`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("Utilisateur").equals(utilisateur)){
				valeur_alerte=rs.getInt("valeur_alerte");
				Date=rs.getString("Date");
				String phrase ="<html><body>("+utilisateur+") a mis une <strong>alerte</strong> pour <strong>"+Modele_Tableau_Activite_Entreprises.floor(valeur_alerte,2) +"</strong> euros</body></html>";
				Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise("<html><body><strong>"+Formatage_Date.mettre_en_forme_date(Date)+"</strong></body></html> ",new JButton()));

				Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise(phrase,new JButton()));
				String user = utilisateur;
				
				liste_users_avec_alerte.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public static void   afficher_vente_entreprise(String entreprise,String utilisateur){
		String vente="Vente";
		String nombre_actions;
		String Date;
		
		//On recupere la valeur unitaire de l'action de l'entreprise sur YahooFInance

		String sql= "SELECT * FROM `Tableau_achat_vente` WHERE `Entreprises`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("Type_transaction").equals(vente)&&(rs.getString("Utilisateur").equals(utilisateur))){
					nombre_actions=rs.getString("nombre_actions");
					Date=rs.getString("Date");
					String phrase="<html><body> Vente de "+nombre_actions+" actions pour "+Modele_Tableau_Activite_Entreprises.floor(valeur_action*(Integer.parseInt(nombre_actions)),2)+" euros</body></html> ";
					Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise("<html><body><strong>"+Formatage_Date.mettre_en_forme_date(Date)+"</strong></body></html> ",new JButton()));
					Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise(phrase,new JButton()));

					//liste_ventes.add(phrase);
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	public static void afficher_achat_entreprise(String entreprise,String utilisateur){
		String achat="Achat";
		String nombre_actions;
		String Date;
		String sql= "SELECT * FROM `Tableau_achat_vente` WHERE `Entreprises`='"+entreprise+"'";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("Type_transaction").equals(achat)&&(rs.getString("Utilisateur").equals(utilisateur))){			
					nombre_actions=rs.getString("nombre_actions");
					Date=rs.getString("Date");
					String phrase="Achat de "+nombre_actions+" actions pour "+Modele_Tableau_Activite_Entreprises.floor(valeur_action*(Integer.parseInt(nombre_actions)),2)+" euros";
					Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise("<html><body><strong>"+Formatage_Date.mettre_en_forme_date(Date)+"</strong></body></html>",new JButton()));
					Panel_interface_bob.modele_tableau_activite_entreprise.addLigne(new Tableau_Activite_Entreprise(phrase,new JButton()));
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
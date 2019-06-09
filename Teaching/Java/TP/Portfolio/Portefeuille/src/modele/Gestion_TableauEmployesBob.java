package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



public class Gestion_TableauEmployesBob {
	
	
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;
	static ArrayList<String> liste_employes =recuperer_employes();


	public static List<TableauEmployesBob> remplir_JTable_Bob(){

		remplirbdd();
		String employe;
		double gain;
		String valeur_portefeuille;
		List<TableauEmployesBob> listEmployes = new ArrayList<>();

		String sql="SELECT * FROM `Tableau_Employes_Bob`";
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				employe=rs.getString("Employes");
				gain=Double.parseDouble(rs.getString("Gains").replace("euros", ""));
				valeur_portefeuille=rs.getString("Valeur_Portefeuille")+" euros";

				listEmployes.add(new TableauEmployesBob(employe,gain,valeur_portefeuille));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmployes;
	}



	public static void remplirbdd(){
		String employes;
		Boolean deja_dans_la_bdd=false;
		//On verifie si c'est pas déjà dans la bdd
		String sql1="SELECT * FROM `Tableau_Employes_Bob`";
		try {
			rs=st.executeQuery(sql1);
			while(rs.next()){
				employes=rs.getString("Employes");
				if(liste_employes.contains(employes)){
					//System.out.println(employes+ " deja dans la bdd");
					deja_dans_la_bdd=true;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//Si c'est pas déjà dans la bdd, on insert
		if(deja_dans_la_bdd==false){
			for(int i=0;i<liste_employes.size();i++){

				String employe=liste_employes.get(i);
				String remplirbdd="INSERT INTO `Tableau_Employes_Bob`(`Employes`,`Gains`,`Valeur_Portefeuille`)VALUES('"+employe+"','"+recuperer_gain_hebdomadaire(employe)+"','"+recuperer_valeurportefeuille(employe)+"')";
				try {
					st.executeUpdate(remplirbdd);
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
		}	
	}


	public static ArrayList<String> recuperer_employes(){
		ArrayList<String> liste_employes= new ArrayList<String>();
		String sql ="SELECT * FROM `Tableau_Utilisateurs`";

		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				liste_employes.add(rs.getString("Utilisateurs"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste_employes;
	}


	@SuppressWarnings("unchecked")
	public static double recuperer_valeurportefeuille(String employe){
		@SuppressWarnings("unused")
		String date;
		double total;
		double derniertotal = 0;
		@SuppressWarnings("rawtypes")
		ArrayList totaux = new ArrayList();
		@SuppressWarnings("unused")
		String Gain_Hebdomadaire = null;

		String sql1="SELECT * FROM `tableau_totalportefeuille` WHERE `Utilisateur`='"+employe+"'";
		try {
			rs=st.executeQuery(sql1);
			while(rs.next()){
				date = rs.getString("Date");

				total=rs.getDouble("Totalportefeuille");
				totaux.add(total);
			}
			if(totaux.size()!=0){
				derniertotal =floor(Double.parseDouble(totaux.get(totaux.size()-1).toString()),2);
			}
			else{
				derniertotal=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return derniertotal;
	}

	public static double recuperer_gain_hebdomadaire(String employe){
		String date;
		double total;
		ArrayList<Double> totaux = new ArrayList<Double>();
		double Gain_Hebdomadaire = 0;

		String sql1="SELECT * FROM `tableau_totalportefeuille` WHERE `Utilisateur`='"+employe+"'";
		try {
			rs=st.executeQuery(sql1);
			while(rs.next()){
				date = rs.getString("Date");
				if(Formatage_Date.recuperer7derniersjours(date)==true){
					total=rs.getDouble("Totalportefeuille");
					totaux.add(total);
				}
			}
			if(totaux.size()!=0){
				String premierelement;
				String dernierelement;
				premierelement=totaux.get(0).toString();
				dernierelement=totaux.get(totaux.size()-1).toString();
				Gain_Hebdomadaire=floor(Double.parseDouble(dernierelement)-Double.parseDouble(premierelement),2);
				//System.out.println("Gain hebdomadaire" + Gain_Hebdomadaire);
			}
			else{
				Gain_Hebdomadaire=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Gain_Hebdomadaire;
	}


	public static double floor(double a, int n) {
		double p = Math.pow(10.0, n);
		return Math.floor((a*p)+0.5) / p;
	}

}

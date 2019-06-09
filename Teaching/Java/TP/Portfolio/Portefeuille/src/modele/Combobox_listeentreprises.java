package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Combobox_listeentreprises {
	static Connection cn=null;
	static Statement st=SQLiteJDBC.connexionbddSQLITE();
	static ResultSet rs=null;


	public static ArrayList<String> remplir_combobox(){
		ArrayList<String> liste_nom_entreprises = new ArrayList<String>();
		String sql ="SELECT * FROM `Liste_Entreprises_Yahoo_CAC40`";		
		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				String entreprise=rs.getString("Entreprises");
				if(liste_nom_entreprises.contains(entreprise)==false){
					liste_nom_entreprises.add(entreprise);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste_nom_entreprises;
	}
}
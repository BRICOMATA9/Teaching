package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vue.Panel_interface;

public class jcomboboxajout {
	static Connection cn=null;
	static Statement st=SQLiteJDBC.connexionbddSQLITE();
	static ResultSet rs=null;
	
	public static ArrayList<String> recupererlisteIDajout(){
		ArrayList<String> listefinale = null;
		int i=1;
		ArrayList<String> liste = new ArrayList<String>();
		try{
			String sql ="SELECT * from `Liste_Entreprises_Yahoo_CAC40`";
			rs=st.executeQuery(sql);
			while(rs.next()){
				String ligne = rs.getString("ID");
				liste.add(ligne);
				i=i+1;	
			}

			for(int k=0;k<Panel_interface.tableau.getRowCount();k++){
				for (int m=0;m<liste.size();m++){
					if(Panel_interface.tableau.getValueAt(k,1).equals(liste.get(m))){
						liste.remove(m);
					}		
				}
			}
	
			listefinale = liste;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listefinale;
	}

	
	public static ArrayList<String> recupererlisteentrepriseajouter(){
		ArrayList<String> listefinale = null;
		int i=1;
		ArrayList<String> liste = new ArrayList<String>();
		try{
			String sql ="SELECT * from `Liste_Entreprises_Yahoo_CAC40`";
			rs=st.executeQuery(sql);	
			while(rs.next()){
				String ligne = rs.getString("Entreprises");
				liste.add(ligne);
				i=i+1;
			}
		
			for(int k=0;k<Panel_interface.tableau.getRowCount();k++){
				for (int m=0;m<liste.size();m++){
					if(Panel_interface.tableau.getValueAt(k,0).equals(liste.get(m))){
						liste.remove(m);
					}
					
						
				}
			}
			for (int m=0;m<liste.size();m++){
			if(Gestion_Entreprises_Interdites_achat.verifier_entreprise(liste.get(m))){
				
			}
			}
			
			
			listefinale = liste;
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listefinale;
	}

}

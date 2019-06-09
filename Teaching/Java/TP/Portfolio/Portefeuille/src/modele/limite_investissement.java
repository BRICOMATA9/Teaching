package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controleur.bouton_connexion;
import controleur.bouton_limite_investissement;
import vue.Panel_interface;

public class limite_investissement {

	
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;

	private static double limite_investissement_bdd;
	public static void recupererlimiteinvestissement(){


		try {
			String sql = "SELECT * FROM `Tableau_Utilisateurs` WHERE `Utilisateurs`='"+bouton_connexion.utilisateurconnecte+"' ";
			rs=st.executeQuery(sql);

			while(rs.next()){
				String limite = rs.getString("Limite_Investissement");
				limite_investissement_bdd=Double.parseDouble(limite);

			}
			if(limite_investissement_bdd !=0){
				controleur.bouton_limite_investissement.chiffre_limite_investissement=limite_investissement_bdd;
				Panel_interface.textfield_limite_investissement.setText((""+bouton_limite_investissement.chiffre_limite_investissement+""));
			}
			else{
				Panel_interface.textfield_limite_investissement.setText("0");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

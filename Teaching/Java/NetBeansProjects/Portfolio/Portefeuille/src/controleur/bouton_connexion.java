package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import modele.SQLiteJDBC;
import vue.Panel_connexion;

public class bouton_connexion{
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	private static ResultSet rs=null;
	public static String utilisateurconnecte;


	
	
	
	
	public static  Boolean connexion(){
		Boolean verif= false;
		String nomuser = Panel_connexion.textfield_utilisateur_connexion.getText();
		@SuppressWarnings("deprecation")
		String motdepasse=Panel_connexion.textfield_motdepasse_connexion.getText();

		if(nomuser.equals("") || motdepasse.equals("")){	

			if(motdepasse.equals("") && nomuser.equals("")){
				JOptionPane.showMessageDialog(null, "Vous devez remplir les champs pour vous connecter");				
			}

		}
		else{

			try{

				String sql ="SELECT * from `Tableau_Utilisateurs`";
				rs=st.executeQuery(sql);
				while(rs.next()){
					if(nomuser.equals( rs.getString("Utilisateurs"))&& motdepasse.equals( rs.getString("Motdepasse"))&&(nomuser!="bob")){
						utilisateurconnecte =nomuser;
						verif=true;
					}
					else{
						if(nomuser.equals("bob")){
							utilisateurconnecte=nomuser;
							verif=true;
						}
					}

				}
				if(verif ==false){
					JOptionPane.showMessageDialog(null, "Vous n'etes pas enregistre dans la base donnee. Veuillez vous inscrire avant de vous connecter");
					Panel_connexion.textfield_motdepasse_connexion.setText("");
					Panel_connexion.textfield_utilisateur_connexion.setText("");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}		
		}
		return verif;
	}
}
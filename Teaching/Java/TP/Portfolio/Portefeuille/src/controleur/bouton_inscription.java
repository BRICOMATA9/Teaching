package controleur;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.SQLiteJDBC;
import vue.Panel_connexion;

public class bouton_inscription extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {

		Boolean verif = false;
		String nominscription = Panel_connexion.textfield_username_inscription.getText();
		char[] motdepasseinscription = Panel_connexion.textfield_motdepasse_inscription.getPassword();
		String motdepasse = new String(motdepasseinscription);
		JFrame frame=new JFrame();

		if(motdepasse.equals("") && (nominscription.equals(""))){
			
			verif=true;

		}
		if( motdepasse.equals("") && (!nominscription.equals(""))){
			JOptionPane.showMessageDialog(frame, "Veuillez entrer un mot de passe");
			verif=true;

		}
		if( motdepasse.equals("") && (!nominscription.equals(""))){
			verif=true;

		}
		Statement st = SQLiteJDBC.connexionbddSQLITE();
		ResultSet rs;
		String sql="SELECT * FROM `Tableau_Utilisateurs`";
		ArrayList<String> usersenregistres = new ArrayList<String>();
		ArrayList<String> motdepasseenregistrer = new ArrayList<String>();

		try {
			rs=st.executeQuery(sql);
			while(rs.next()){
				usersenregistres .add(rs.getString("Utilisateurs"));
				motdepasseenregistrer.add(rs.getString("Motdepasse"));		
			}
			//Gerer si l'utilisateur est deja enregistr� ou si le mot de passe exite deja

			for(int i=0;i<usersenregistres.size();i++){
				if(( usersenregistres.get(i)).equals(nominscription)){
					verif=true;
					JOptionPane.showMessageDialog(null, "L'utilisateur "+nominscription+" est deja enregistre");
					Panel_connexion.textfield_username_inscription.setText("");
					usersenregistres.clear();
				}

			}				
			for(int k=0;k<motdepasseenregistrer.size();k++){	
				if((motdepasseenregistrer.get(k)).equals(motdepasse)){
					JOptionPane.showMessageDialog(null, "Mot de passe deja� utilise. Veuillez en essayer un nouveau");
					Panel_connexion.textfield_motdepasse_inscription.setText("");
					motdepasseenregistrer.clear();
				}
			}
		}catch(SQLException e2){
			e2.printStackTrace();
		}

		if(verif==false){
			try{
				String sql1="INSERT INTO `Tableau_Utilisateurs`(`Utilisateurs`,`Motdepasse`)VALUES('"+nominscription+"','"+motdepasse+"')";
				JOptionPane.showMessageDialog(null, "Inscription Reussie");
				st.executeUpdate(sql1);
				Panel_connexion.textfield_motdepasse_inscription.setText("");
				Panel_connexion.textfield_username_inscription.setText("");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
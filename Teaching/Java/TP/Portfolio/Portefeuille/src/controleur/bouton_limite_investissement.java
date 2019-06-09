package controleur;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import modele.SQLiteJDBC;
import modele.limite_investissement;
import vue.Panel_interface;

public class bouton_limite_investissement extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static double chiffre_limite_investissement;
	private static Statement st=SQLiteJDBC.connexionbddSQLITE();
	@Override
	public void actionPerformed(ActionEvent arg0) {

		chiffre_limite_investissement =Double.parseDouble(Panel_interface.textfield_limite_investissement.getText());
		String sql1 ="UPDATE `Tableau_Utilisateurs` SET `Limite_Investissement`='"+chiffre_limite_investissement+"' WHERE `Utilisateurs`='"+bouton_connexion.utilisateurconnecte+"' ";
		if(chiffre_limite_investissement > 0){
			try {
				st.executeUpdate(sql1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			limite_investissement.recupererlimiteinvestissement();
			if(chiffre_limite_investissement!=0){
				Panel_interface.label_limite_investissement.setText("<html><body><strong> Limite d'investissement :</strong>  </body></html>");	
			
				Panel_interface.textfield_limite_investissement.setText(""+bouton_limite_investissement.chiffre_limite_investissement+"");	
				
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Veuillez entrer une limite positive");
		}
	}
}
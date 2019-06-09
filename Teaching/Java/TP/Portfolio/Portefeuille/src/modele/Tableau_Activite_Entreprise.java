package modele;

import javax.swing.JButton;

public class Tableau_Activite_Entreprise{

	private String activite;   

	public Tableau_Activite_Entreprise(String activite,JButton bouton) {

		this.setActivite(activite);

	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

}

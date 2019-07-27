package bdd;

import java.util.Vector;

/**
 * Classe enseignant qui represente un enseignant
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class Enseignant extends Personne {

	private static int nbPers =0;
	private Vector<Cours> liste_cours;
	
	/**
	 * Constructeur d'un enseignant
	 * @param num_personne
	 * @param username
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param email
	 * @param tel
	 */
	public Enseignant(String num_personne, String username, String password, String nom, String prenom, String adresse, String email, int tel) {
		super(num_personne, username, password, nom, prenom, adresse, email, tel);
		
		liste_cours = new Vector<Cours>();
	}

	/**
	 * Méthode pour ajouter un cours dans la liste
	 * @param c le cours à ajouter dans la liste des cours de l'enseignant
	 */
	public void ajoutCours(Cours c)
	{
		liste_cours.add(c);
	}
	
	/**
	 * Méthode qui compare l'enseignant au paramètre et retourne un boolean
	 * @param ens
	 * @return true si ce sont les mêmes, false sinon
	 */
	public boolean egal(Enseignant ens)
	{
		return ((num_personne.compareTo(ens.getNum_personne()))==0);
	}

	/**
	 * Méthode qui retourne la liste des cours de l'enseignant
	 * @return the liste_cours
	 */
	public Vector<Cours> getListe_cours() {
		return liste_cours;
	}

	/**
	 * Méthode qui configure la liste des cours d'un enseignant
	 * @param liste_cours la liste_cours à configurer
	 */
	public void setListe_cours(Vector<Cours> liste_cours) {
		this.liste_cours = liste_cours;
	}

}

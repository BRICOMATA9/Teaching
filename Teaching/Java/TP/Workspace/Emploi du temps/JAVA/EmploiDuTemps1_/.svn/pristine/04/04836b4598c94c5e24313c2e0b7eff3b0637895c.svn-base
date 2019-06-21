package bdd;

import java.io.Serializable;
/**
 * Classe qui représente une salle
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class Salle implements Serializable{

	private static int nbSalle =0;
	
	/*Déclaration des constantes*/
	public static final int TP = 1;
	public static final int AMPHI =2;
	public static final int COURS = 3;
	
	/*Déclaration des attributs*/
	private String nom_salle;
	private int type_Salle;
	private int taille;
	
	/**
	 * Méthode qui prend en parametre le nom d'une salle et retourne le type
	 * @param nom
	 * @return le type de la salle
	 */
	public static int getTypeSalle(String nom)
	{
		int type_enseignement = -1;
		
		if(nom.compareToIgnoreCase("TP")==0){type_enseignement = Salle.TP;}
		else if(nom.compareToIgnoreCase("AMPHI")==0){type_enseignement = Salle.AMPHI;}
		else if(nom.compareToIgnoreCase("COURS")==0){type_enseignement = Salle.COURS;}
				
		return type_enseignement;
	}

	/**
	 * Constructeur d'une salle
	 * @param nom_salle
	 * @param salle
	 * @param taille
	 */
	public Salle(String nom_salle, int salle, int taille) {
		super();
		// TODO Auto-generated constructor stub
		this.nom_salle = nom_salle;
		type_Salle = salle;
		this.taille = taille;
	}

	/**
	 * @return Returns le nom_salle.
	 */
	public String getNom_salle() {
		return nom_salle;
	}

	/**
	 * @param nom_salle Le nom de la salle to set.
	 */
	public void setNom_salle(String nom_salle) {
		this.nom_salle = nom_salle;
	}

	/**
	 * @return la taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * @return le type_Salle
	 */
	public int getType_Salle() {
		return type_Salle;
	}

	/**
	 * @param type_Salle le type_Salle to set
	 */
	public void setType_Salle(int type_Salle) {
		this.type_Salle = type_Salle;
	}
	
	/**
	 *  Retourne le nom de la salle en String
	 */
	public String toString(){
		return (nom_salle);
	}
	
	/**
	 * Retourne true si la salle est la même que la salle en paramètre
	 * @param salle
	 * @return true si oui, false sinon
	 */
	public boolean egal(Salle salle) {
		return (this.nom_salle.compareTo(salle.getNom_salle())==0);
	}
	
	
}

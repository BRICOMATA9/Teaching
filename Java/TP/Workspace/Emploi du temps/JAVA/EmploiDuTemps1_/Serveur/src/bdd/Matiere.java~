/**
 * 
 */
package bdd;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

/**
 * Classe qui représente une matière
 * @author Tonya Vo Thanh & Alexander Remen
 *
 */
public class Matiere implements Serializable{

	private static int nbMat =0;
	
	/*Declaration des constantes*/
	public static final int obligatoire =1;
	public static final int optionnelle =2;
	
	/*Declaration des attributs*/
	private String num_matiere;
	private String intitule;
	private int type;
	private Vector<Enseignement> liste_enseignement;
	
	/**
	 * Constructeur d'une matière
	 * @param num_matiere le numéro de la matière
	 * @param intitule l'intitulé de la matière
	 * @param type le type de la matière
	 */
	public Matiere(String num_matiere, String intitule, int type) {
		super();
		this.num_matiere = num_matiere;
		this.intitule = intitule;
		this.type = type;
		liste_enseignement = new Vector<Enseignement>();
	}


	/**
	 * Ajoute l'enseignement dans la matière
	 * @param e l'enseignement à ajouter
	 */
	public void ajoutEnseignement(Enseignement e)
	{
		liste_enseignement.add(e);
	}

	/**
	 * @return num_matière le numero de la matière
	 */
	public String getNum_matiere() {
		return num_matiere;
	}

	/**
	 * @param num_matiere The num_matiere to set.
	 */
	public void setNum_matiere(String num_matiere) {
		this.num_matiere = num_matiere;
	}

	/**
	 * @return Returns the liste_enseignement.
	 */
	public Vector<Enseignement> getListe_enseignement() {
		return liste_enseignement;
	}

	/**
	 * @param liste_enseignement The liste_enseignement to set.
	 */
	public void setListe_enseignement(Vector<Enseignement> liste_enseignement) {
		this.liste_enseignement = liste_enseignement;
	}

	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * @return le String intitulé de la matière
	 */
	public String toString(){
		if(this!=null)
		return intitule;
		else return "";
		
	}
	/**
	 * Compare une matière à la matière donnée en paramètre
	 * @param mat
	 * @return true si oui, false sinon
	 */
	public boolean egal(Matiere mat)
	{
		return (num_matiere.compareTo(mat.getNum_matiere())==0);
	}
	
	/**
	 * Méthode qui retourne l'enseignant qui correspond au groupe donnée en paramètre
	 * @param gp groupe
	 * @return l'enseignant
	 * @throws Exception
	 */
	public Enseignant getEnseignant(Groupe gp) throws Exception
	{
		Enseignant enseignant= null;
		Iterator i = this.liste_enseignement.iterator();
		
		while(i.hasNext() && (enseignant == null))
		{
			enseignant=((Enseignement)i.next()).getEnseignant(gp);
		}
		return enseignant;
	}
}

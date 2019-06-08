package bdd;

import java.io.Serializable;
import java.util.Vector;

/**
 * Classe qui représente un groupe
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class Groupe implements Serializable {

	/*Declaration des attributs static*/
	private static int nbSpec =0; 
	
	/*D�claration des attributs*/
	private String num_groupe;
	private Responsable responsable;

	/**
	 * Constructeur qui crée un groupe
	 * @param num_groupe
	 */
	public Groupe(String num_groupe) {
		super();
		this.num_groupe = num_groupe;
	}

	/**
	 * @return the num_groupe
	 */
	public String getnum_groupe() {
		return num_groupe;
	}

	/**
	 * @param num_groupe le numero du groupe
	 */
	public void setnum_groupe(String num_groupe) {
		this.num_groupe = num_groupe;
	}

	/**
	 * @return Returns le responsable
	 */
	public Responsable getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable le responsable
	 */
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	
	/**
	 * Méthode qui retourne si le groupe est égal au groupe donné en paramètre
	 * @param g le groupe à comparer
	 * @return true si oui, false sinon
	 */
	public boolean egal(Groupe g)
	{
		return ((this.num_groupe.compareTo(g.getnum_groupe()))==0);
	}
	/**
	 * retourne le numero du groupe en String
	 */
	public String toString(){
		if (this != null) 
			return num_groupe;
		else return "";
		
	}
	
	
}

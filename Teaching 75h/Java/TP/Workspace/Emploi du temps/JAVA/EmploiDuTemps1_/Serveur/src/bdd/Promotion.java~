package bdd;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

/**
 * Classe qui représente une promotion
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class Promotion implements Serializable{
	
	/*Declaration des attributs*/
	private String nom_promotion;
	private Responsable resp;
	private Vector<Etudiant> liste_etudiant;

	/**
	 * Constructeur d'une promotion
	 * @param nom_promotion
	 * @param liste_etudiant
	 */
	public Promotion(String nom_promotion, Vector<Etudiant> liste_etudiant) {
		super();
		this.nom_promotion = nom_promotion;
		this.liste_etudiant = liste_etudiant;
		
		Iterator i = this.liste_etudiant.iterator();
		while(i.hasNext())
		{
			((Etudiant) i.next()).setPromo(this);
		}
			
	}

	/**
	 * @return le responsable
	 */
	public Responsable getResp() {
		return resp;
	}

	/**
	 * set responsable
	 * @param resp the resp to set
	 */
	public void setResp(Responsable resp) {
		this.resp = resp;
	}

	/**
	 * @return le numero promotion
	 */
	public String getNom_promotion() {
		return nom_promotion;
	}

	/**
	 * @return la liste d'etudiants
	 */
	public Vector<Etudiant> getListe_etudiant() {
		return liste_etudiant;
	}
	
	public void ajoutEtudiant(Etudiant et)
	{
		liste_etudiant.add(et);
	}

	/**
	 * set liste d'etudiants
	 * @param liste_etudiant liste d'etudiant
	 */
	public void setListe_etudiant(Vector<Etudiant> liste_etudiant) {
		this.liste_etudiant = liste_etudiant;
	}
	
	
	
	
}

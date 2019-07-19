package Systeme;

import java.io.Serializable;
import java.util.Vector;

/**
 * Classe Signal utilisé pour l'envoi de signaux entre le client et le serveur 
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class Signal implements Serializable{
	
	private String nom;
	private Vector parametres;
	
	/**
	 * Constructeur d'un signal
	 * @param nom
	 */
	public Signal(String nom) {
		super();
		this.nom = nom;
		this.parametres= new Vector();
	}
	/**
	 * Constructeur d'un signal
	 * @param nom
	 * @param parametres
	 */
	public Signal(String nom, Vector parametres) {
		super();
		this.nom = nom;
		this.parametres = parametres;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the parametres
	 */
	public Vector getParametres() {
		return parametres;
	}
	/**
	 * @param parametres the parametres to set
	 */
	public void setParametres(Vector parametres) {
		this.parametres = parametres;
	}
	
	/**
	 * Ajouter un paramètre
	 * @param o
	 */
	public void addParametre(Object o)
	{
		parametres.add(o);
	}
}

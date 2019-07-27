package bdd;

import java.io.Serializable;

/**
 * Classe qui représente la classe personne utilisée pour les enseignants et les étudiants
 * @author Alexander Remen et Tonya Vo Thanh
 * 
 */
public abstract class Personne implements Serializable{

	public static final int ETUDIANT = 0;
	public static final int ENSEIGNANT = 1;
	public static final int RESPONSABLE = 2;
	
	/*Declaration des Attributs*/
	protected String num_personne;
	protected String username;
	protected String password;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String email;
	protected int tel;
	
	
	/**
	 * Constructeur d'une personne
	 * @param username
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param email
	 * @param tel
	 */
	public Personne(String num_personne,String username, String password, String nom, String prenom, String adresse, String email, int tel) {
		this.num_personne=num_personne;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	/**
	 * 
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * set adresse
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return nom en String
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * set nom 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * set prenom
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * 
	 * @return tel
	 */
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the num_personne
	 */
	public String getNum_personne() {
		return num_personne;
	}
	
	/*public String toString() {
		String text = "Personne "+num_personne+" : "+this.nom+" , "+this.prenom+"\nLogin : "+this.username+" mdp : "+this.password;
		return text;
	}*/
	/**
	 * @return une personne en String
	 */
	public String toString() {
		String text = "";
		if(this!=null)
		text = this.nom+", "+this.prenom+" : " +this.email;
		return text;
	}
}

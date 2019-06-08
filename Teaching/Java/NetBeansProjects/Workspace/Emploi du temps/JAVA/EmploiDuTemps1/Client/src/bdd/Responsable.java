package bdd;

/**
 * Classe qui représente un responsable
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class Responsable extends Enseignant {

	private static int nbPers =0;
	private Promotion promo;
	
	/**
	 * Constructeur d'un responsable
	 * @param num_personne
	 * @param username
	 * @param password
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param email
	 * @param tel
	 * @param promo
	 */
	public Responsable(String num_personne, String username, String password, String nom, String prenom, String adresse, String email, int tel, Promotion promo) {
		super(num_personne, username, password, nom, prenom, adresse, email, tel);
		this.promo = promo;
		this.promo.setResp(this);
	}

	/**
	 * @return the promo
	 */
	public Promotion getPromo() {
		return promo;
	}

	/**
	 * Set Promo
	 * @param promo the promo to set
	 */
	public void setPromo(Promotion promo) {
		this.promo = promo;
	}

}

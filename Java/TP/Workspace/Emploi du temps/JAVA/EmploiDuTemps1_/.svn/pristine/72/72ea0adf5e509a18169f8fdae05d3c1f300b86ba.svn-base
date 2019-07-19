package bdd;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Classe cours qui peut regrouper une matière, un groupe, un enseignant, une salle et un creneau.
 * @author Tonya Vo Thanh & Alexander Remen
 *
 */
public class Cours implements Serializable{

	private Matiere matiere;
	private Groupe groupe;
	private Enseignant enseignant;
	private Salle salle;
	private Creneau creneau;
	
	/**
	 * Constructeur d'un cours ou l'enseignant est trouvé lui même si le groupe n'est pas égal à {@code null} sinon l'enseignant est {@code null}.
	 * @param creneau
	 * @param salle
	 * @param groupe
	 * @param matiere
	 * @throws Exception 
	 */
	public Cours(Creneau creneau, Salle salle, Groupe groupe, Matiere matiere) throws Exception {
		super();
		this.creneau = creneau;
		this.salle = salle;
		this.groupe = groupe;
		this.matiere = matiere;
		this.enseignant = null;
		if(groupe!=null)configureEnseignant();
	}
	
	/**
	 * Constructeur d'un cours
	 * @param matiere
	 * @param salle
	 * @param groupe
	 * @param creneau
	 * @param enseignant
	 */
	public Cours(Matiere matiere, Salle salle, Groupe groupe, Creneau creneau, Enseignant enseignant) {
		super();
		this.matiere = matiere;
		this.salle = salle;
		this.groupe = groupe;
		this.creneau = creneau;
		this.enseignant = enseignant;
	}



	private void configureEnseignant() throws Exception
	{
		enseignant=matiere.getEnseignant(this.groupe);
		if (enseignant == null) throw new Exception("Erreur cours : enseignant ou groupe inexistant"+enseignant+"  "+matiere);
		enseignant.ajoutCours(this);
	}

	/**
	 * @return l'enseignant
	 */
	public Enseignant getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant l'enseignant à configurer
	 */
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	/**
	 * @return le groupe
	 */
	public Groupe getGroupe() {
		return groupe;
	}

	/**
	 * @param groupe le groupe à configurer
	 */
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	/**
	 * @return la matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * @param matiere la matière à configurer
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/**
	 * @return la salle
	 */
	public Salle getSalle() {
		return salle;
	}

	/**
	 * @param salle la salle à configurer
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/**
	 * @return le creneau
	 */
	public Creneau getCreneau() {
		return creneau;
	}

	/**
	 * @param creneau le creneau à configurer
	 */
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	/**
	 * @return le cours en String
	 */
	public String toString() {
		
		return this.creneau.date()+" ("+this.creneau.heure()+"-"+this.creneau.heureFin()+") "+this.matiere+" , gr. "+this.groupe;
	}
	/**
	 * Méthode qui compare le jour du cours à la Date donnée en paramètre
	 * @param jour1 la Date à comparer
	 * @return integer
	 */
	public int compareJour(Date jour1) {
		GregorianCalendar d1 = this.creneau.getDate();
		GregorianCalendar d2 = new GregorianCalendar();
		
		d2.setTime(jour1);
		d2.set(GregorianCalendar.HOUR_OF_DAY, 0);
		d2.set(GregorianCalendar.MINUTE, 0);
		d2.set(GregorianCalendar.SECOND, 0);
		d2.set(GregorianCalendar.MILLISECOND, 0);
				
		return d1.compareTo(d2);
	}
	/**
	 * Compare le cours à un autre et retourne un boolean.
	 * @param lecours à comparer
	 * @return true si c'est le même cours, false sinon
	 */
	public boolean egal (Cours lecours){
		boolean retour = false;
		
		if (lecours.getCreneau().egal(this.getCreneau()))
		{
			if(lecours.getSalle().egal(this.getSalle()))
				retour=true;
		}
		return retour;
		
	}
		
	
}

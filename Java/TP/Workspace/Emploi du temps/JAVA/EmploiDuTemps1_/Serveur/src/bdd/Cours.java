package bdd;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cours implements Serializable{

	private Matiere matiere;
	private Groupe groupe;
	private Enseignant enseignant;
	private Salle salle;
	private Creneau creneau;

	public Cours(Creneau creneau, Salle salle, Groupe groupe, Matiere matiere) throws Exception {
		super();
		this.creneau = creneau;
		this.salle = salle;
		this.groupe = groupe;
		this.matiere = matiere;
		this.enseignant = null;
		if(groupe!=null)configureEnseignant();
	}

	public Cours(Matiere matiere, Salle salle, Groupe groupe, Creneau creneau, Enseignant enseignant) {
		super();
		this.matiere = matiere;
		this.salle = salle;
		this.groupe = groupe;
		this.creneau = creneau;
		this.enseignant = enseignant;
	}

	private void configureEnseignant() throws Exception {
		enseignant=matiere.getEnseignant(this.groupe);
		if (enseignant == null) throw new Exception("Erreur cours : enseignant ou groupe inexistant"+enseignant+"  "+matiere);
		enseignant.ajoutCours(this);
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public String toString() {
		return this.creneau.date()+" ("+this.creneau.heure()+"-"+this.creneau.heureFin()+") "+this.matiere+" , gr. "+this.groupe;
	}

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

	public boolean egal (Cours lecours){
		boolean retour = false;
		if (lecours.getCreneau().egal(this.getCreneau())) {
			if(lecours.getSalle().egal(this.getSalle()))
				retour=true;
		}
		return retour;
	}
}

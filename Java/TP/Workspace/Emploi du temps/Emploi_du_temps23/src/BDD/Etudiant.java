package BDD;

public class Etudiant extends Personne{

	private Groupe idGroupe;

	public Groupe getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Groupe idGroupe) {
		this.idGroupe = idGroupe;
	}

	@Override
	public String toString() {
		return "Personne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + "Groupe=" + idGroupe.getIdGroupe();
	}

}

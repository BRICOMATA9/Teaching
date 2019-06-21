package bdd;

public class Etudiant extends Personne{

	private Integer idGroupe;

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	@Override
	public String toString() {
		return idPersonne.toString();
	}

}

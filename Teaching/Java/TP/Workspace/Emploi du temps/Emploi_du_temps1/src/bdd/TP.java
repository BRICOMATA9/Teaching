package bdd;

public class TP extends Sceance {

	private Integer idGroupe;

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	@Override
	public String toString() {
		return idSceance.toString();
	}
}

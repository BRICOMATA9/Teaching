package bdd;

public class Groupe {

	private Integer idGroupe;
	private Integer idSection;

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	public Integer getIdSection() {
		return idSection;
	}

	public void setIdSection(Integer idSection) {
		this.idSection = idSection;
	}

	@Override
	public String toString() {
		return "Groupe=" + idGroupe + ", Section=" + idSection;
	}
}

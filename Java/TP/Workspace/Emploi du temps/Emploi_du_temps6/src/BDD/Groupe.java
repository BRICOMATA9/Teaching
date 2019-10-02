package BDD;

public class Groupe {

	private Integer idGroupe;
	private Section idSection;

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	public Section getIdSection() {
		return idSection;
	}

	public void setIdSection(Section idSection) {
		this.idSection = idSection;
	}

	@Override
	public String toString() {
		return "Groupe=" + idGroupe + ", Section=" + idSection;
	}
}

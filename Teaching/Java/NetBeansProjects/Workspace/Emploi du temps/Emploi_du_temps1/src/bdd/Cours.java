package bdd;

public class Cours extends Sceance {

	private Integer idSection;

	public Integer getIdSection() {
		return idSection;
	}

	public void setIdSection(Integer idSection) {
		this.idSection = idSection;
	}

	@Override
	public String toString() {
		return idSceance.toString();
	}
	
}

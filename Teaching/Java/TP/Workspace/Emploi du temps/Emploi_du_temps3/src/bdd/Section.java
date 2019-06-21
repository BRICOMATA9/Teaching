package bdd;

import java.util.Date;

public class Section {

	private Integer idSection;
	private Date annee;
	
	public Date getAnnee() {
		return annee;
	}
	public void setAnnee(Date année) {
		this.annee = année;
	}
	public Integer getIdSection() {
		return idSection;
	}
	public void setIdSection(Integer idSection) {
		this.idSection = idSection;
	}
	@Override
	public String toString() {
		return "Section=" + idSection + ", annee=" + annee;
	}
	
}

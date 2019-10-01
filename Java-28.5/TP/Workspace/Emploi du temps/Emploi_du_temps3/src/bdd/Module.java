package bdd;

public class Module {

	private String idModule;
	private String nom;
	private Integer coefficient;
	
	public String getIdModule() {
		return idModule;
	}
	public void setIdModule(String idModule) {
		this.idModule = idModule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String libellé) {
		this.nom = libellé;
	}
	public Integer getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(Integer coefficient) {
		this.coefficient = coefficient;
	}
	@Override
	public String toString() {
		return "Module=" + idModule + ", nom=" + nom + ", coefficient=" + coefficient;
	}
}

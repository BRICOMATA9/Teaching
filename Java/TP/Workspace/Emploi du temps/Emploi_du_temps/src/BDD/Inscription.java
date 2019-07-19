package BDD;

public class Inscription {

	private Integer idEtudiant;
	private String idModule;
	private Double moyenne;
	
	public Integer getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Integer idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getIdModule() {
		return idModule;
	}
	public void setIdModule(String module) {
		idModule = module;
	}
	public Double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}  
}

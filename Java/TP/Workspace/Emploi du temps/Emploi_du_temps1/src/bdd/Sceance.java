package bdd;

import java.util.Date;

public abstract class Sceance {

	protected Integer idSceance;
	private String idModule;
	private Integer idSalle;
	private Integer idEnseignant;
	private Date dateDebut;
	private Integer duree;
	
	public String getIdModule() {
		return idModule;
	}
	public void setIdModule(String idModule) {
		this.idModule = idModule;
	}
	public Integer getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Integer getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Integer idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public Integer getIdSceance() {
		return idSceance;
	}
	public void setIdSceance(Integer idSceance) {
		this.idSceance = idSceance;
	}
	@Override
	public String toString() {
		return idSceance.toString();
	}
}

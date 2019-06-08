package BDD;

public class Salle {

	private Integer idSalle;
	private String type;
	private Batiment idBatiment;
	private Integer capacite;
	private Salle successeur;
	private Salle predecesseur;
	
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	public Batiment getIdBatiment() {
		return idBatiment;
	}
	public void setIdBatiment(Batiment idBatiment) {
		this.idBatiment = idBatiment;
	}
	public Integer getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}
	@Override
	public String toString() {
		return "Salle=" + idSalle + ", Batiment=" + idBatiment + ", capacite=" + capacite;
	}
	public Salle getSuccesseur() {
		return successeur;
	}
	public void setSuccesseur(Salle successeur) {
		this.successeur = successeur;
	}
	public Salle getPredecesseur() {
		return predecesseur;
	}
	public void setPredecesseur(Salle predecesseur) {
		this.predecesseur = predecesseur;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

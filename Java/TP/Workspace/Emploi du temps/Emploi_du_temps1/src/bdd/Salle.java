package bdd;

public class Salle {

	private Integer idSalle;
	private Integer idBatiment;
	private Integer capacite;
	
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	public Integer getIdBatiment() {
		return idBatiment;
	}
	public void setIdBatiment(Integer idBatiment) {
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
		return idSalle.toString();
	}
}

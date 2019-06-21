package BDD;

public class Salle {

	private Integer idSalle;
	private Batiment idBatiment;
	private Integer capacite;
	
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
}

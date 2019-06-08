package BDD;

public class Batiment {

	private Integer idBatiment;

	public Integer getIdBatiment() {
		return idBatiment;
	}

	public void setIdBatiment(Integer idBatiment) {
		this.idBatiment = idBatiment;
	}

	@Override
	public String toString() {
		return "Batiment = " + idBatiment;
	}
}

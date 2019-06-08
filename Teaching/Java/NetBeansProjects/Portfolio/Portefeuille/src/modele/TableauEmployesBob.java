package modele;

public class TableauEmployesBob {
	private int index;
	private String employes;
	private double gain;
	private String valeur_portefeuille;

	public TableauEmployesBob(String employes, double gain, String valeur_portefeuille) {
		this.setEmployes(employes);
		this.setGain(gain);
		this.setValeur_portefeuille(valeur_portefeuille);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getEmployes() {
		return employes;
	}

	public void setEmployes(String employes) {
		this.employes = employes;
	}

	public double getGain() {
		return gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}

	public String getValeur_portefeuille() {
		return valeur_portefeuille;
	}

	public void setValeur_portefeuille(String valeur_portefeuille) {
		this.valeur_portefeuille = valeur_portefeuille;
	}
}
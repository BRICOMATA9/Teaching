import java.util.Scanner;
public class ComposantMateriel {
//attribut
	private double frequence;
	private int memoire;
	private int disqueDur;
	private double prix;
	public static Scanner sc=new Scanner(System.in);
	
	//constructeur
	public ComposantMateriel(double frequence, int memoire, int disqueDur){
		this.setFrequence(frequence);
		this.setMemoire(memoire);
		this.setDisqueDur(disqueDur);
	}

	public void lirePrix(){
		System.out.println("Donnez le prix du materiel:");
		prix=sc.nextDouble();
	}
	public double getFrequence() {
		return frequence;
	}

	public void setFrequence(double frequence) {
		this.frequence = frequence;
	}

	public int getMemoire() {
		return memoire;
	}

	public void setMemoire(int memoire) {
		this.memoire = memoire;
	}

	public int getDisqueDur() {
		return disqueDur;
	}

	public void setDisqueDur(int disqueDur) {
		this.disqueDur = disqueDur;
	}

	public double getPrix() {
		return prix;
	}

	public String toString(){
		return "frequence: "+frequence+" memoire: "+memoire+" disque dur: "+disqueDur;
	}
}

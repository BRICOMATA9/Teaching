import java.util.Scanner;


public class ComposantLogiciel {
	private String OS;
	private boolean packOffice, packAdditionnel;
	private double prix;
	public static Scanner sc=new Scanner(System.in);
	
	// constructeur
	public ComposantLogiciel(String OS, boolean packOffice, boolean packAdditionnel){
		this.OS=OS;
		this.setPackOffice(packOffice);
		this.setPackAdditionnel(packAdditionnel);
		
	}
	public ComposantLogiciel(ComposantLogiciel logiciel) {
		OS=logiciel.OS;
		packOffice=logiciel.packOffice;
		packAdditionnel=logiciel.packAdditionnel;
	}
	
	public void lirePrix(){
		System.out.println("Donnez le prix des logiciels");
		prix=sc.nextDouble();
	}
	//accesseurs
	public double getPrix(){
		 return prix;
	}
	public void setPrix(double prix){
		this.prix=prix;
	}

	public boolean getPackOffice() {
		return packOffice;
	}

	public void setPackOffice(boolean packOffice) {
		this.packOffice = packOffice;
	}

	public boolean getPackAdditionnel() {
		return packAdditionnel;
	}

	public void setPackAdditionnel(boolean packAdditionnel) {
		this.packAdditionnel = packAdditionnel;
	}
	public String toString(){
		return "Systeme d'exploitaion: "+OS+"\n"+(packOffice?"avec":"sans")+" pack office"+"\n"+(packAdditionnel?"avec":"sans")+" pack additionnel"; 
	}
}

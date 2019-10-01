package Modele;

public class Fonds {
	
	public double montant;
	public String cleF;
	
	public Fonds()
	{
		
	}
	
	public Fonds(double montant)
	{
		this.montant=montant;
	}
	
	public Fonds(double montant, String cleF)
	{
		this.montant=montant;
		this.cleF=cleF;
	}
	
	//Accesseurs
	
	public double getMontant() {
		return montant;
	}
	
	

}

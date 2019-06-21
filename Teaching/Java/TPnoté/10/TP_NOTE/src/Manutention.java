public class Manutention extends Employe
{
	
	//Getters & Setters
	
	public String Set_statut()
	{
		this.statut = "Manutention";
		return this.statut;
	}
	
	
	
	//Methods
	Manutention(String nom, String prenom, int age, int date_recru)
	{
		super(nom, prenom, age, date_recru);
		Set_statut();
		
	}
}
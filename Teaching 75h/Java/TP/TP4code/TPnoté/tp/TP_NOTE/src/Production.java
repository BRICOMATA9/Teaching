public class Production extends Employe
{
	
	//Getters & Setters
	
	public String Set_statut()
	{
		this.statut = "Production";
		return this.statut;
	}
	
	
	
	//Methods
	Production(String nom, String prenom, int age, int date_recru)
	{
		super(nom, prenom, age, date_recru);
		Set_statut();
		
	}
}

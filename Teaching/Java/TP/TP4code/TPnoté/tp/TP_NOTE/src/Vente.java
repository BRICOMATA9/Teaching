public class Vente extends Employe
{
	
	//Getters & Setters
	
	public String Set_statut()
	{
		this.statut = "Vente";
		return this.statut;
	}
	
	//Methods
	Vente(String nom, String prenom, int age, int date_recru)
	{
		super(nom, prenom, age, date_recru);
		Set_statut();
		
	}
}

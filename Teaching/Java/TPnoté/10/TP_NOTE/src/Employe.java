public abstract class Employe {
	
	protected String nom;
	protected String prenom;
	protected int age;
	protected int date_recru;
	protected int horaire;
	protected String statut;
		
	//Getters & Setters
	public int Set_horaire(int horaire)
	{
		this.horaire = horaire;
		return this.horaire;
	}
	
	public int Get_horaire()
	{
		return this.horaire;
	}
	public String Get_Statut()
	{
		return this.statut;
	}
	
	public String getNom()
	{
		String chaine_nom = "Employe : " + " " + this.prenom + " " + this.nom;
		
		return(chaine_nom);
		
	}
	
	//Methods
	public void calculerHoraire(int semaine) 
	{
		int horaire = 0;

		if (this.statut.equals("Vente"))
		{
			if (semaine<=3)
			{
				horaire = 32;
			}
			if (semaine>=3)
			{
				horaire = 48;
			}
		}
		if (this.statut.equals("Production"))
		{
			if ((semaine == 2) || (semaine == 4))
			{
				horaire = 30;
			}else
			{
				horaire = 42;
			}
		}
		if (this.statut.equals("Manutention"))
		{
			horaire = 35;
		}
		Set_horaire(horaire);
	}	
	
	//Basic Constructor
	Employe() {}
	
	//Constructeur surcharge
	Employe(String nom, String prenom, int age, int date_recru)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.date_recru=date_recru;
	
	}
}

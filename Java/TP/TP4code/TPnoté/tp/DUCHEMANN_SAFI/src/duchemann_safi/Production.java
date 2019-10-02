package duchemann_safi;

public class Production extends Employé {
	
 
    
	//Constructeur
  public Production(String nom, String prenom, int age,int date_recrutement,int horaire){
        //importer le constructeur d'employé
  	super(nom, prenom, age, date_recrutement,horaire);	
  }
	
	public String getNom(){
        return "Technicien : " + this.nom+this.prenom;
    }

	public int calculerHoraire(int semaine) {
		if (semaine==2 || semaine==4) {
			return 30;
		}
		else
		{
			return 42;
		}
		
}
}

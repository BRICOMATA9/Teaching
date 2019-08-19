package duchemann_safi;
/**
 *
 * @author hugod
 */
public abstract class Vente extends Employé {
	
 
    
	//Constructeur
    public Vente(String nom, String prenom, int age,int date_recrutement,int horaire){
	//importer le constructeur d'employé
	super(nom, prenom, age, date_recrutement,horaire);
    }
	
    public String getNom(){
        return "Vendeur : " + this.nom+this.prenom;
    }
	
	public int calculerHoraire(int semaine) {
		if (semaine<4) {
			return 32;
		}
		else 
		{
			return 48;
		}
		
		
	}

}

package duchemann_safi;
//Import d'arrayList
import java.util.ArrayList;

public class Personnel extends Employé{
	
	//ArrayList d'employé
	ArrayList <Employé> listeEmploye;

    public Personnel(String nom, String prenom, int age, int date_recrutement,int horaire) {
        super(nom, prenom, age, date_recrutement,horaire);
    }
	//ajout d'employés
    void ajouterEmploye(Employé emp) {
	listeEmploye.add(emp);
	System.out.println(listeEmploye);
    }
	
    void calculerHoraires(int i) {
	
    }
    public int HoraireMensuel(){
        int semaine;
        for (semaine=1;semaine<5;semaine++){
            
        }
    }
}

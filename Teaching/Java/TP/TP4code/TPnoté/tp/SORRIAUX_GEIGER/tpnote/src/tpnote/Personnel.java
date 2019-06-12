/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

/**
 *
 * @author geige
 */
import java.util.ArrayList;


public class Personnel {

	
	ArrayList<Employe> listepersonnel = new ArrayList<Employe>(); 
	
	public Personnel(){	
	}
	
	// Methodes 
	
	public void ajouteEmploye(Employe E1){
		
		listepersonnel.add(E1); //Pour ajouter un élément
                verifierPrimes(E1);
		
	}
	
public void calculerHoraires(int i){
	
	for (Employe E1 : listepersonnel){ //Pour afficher toute ta liste
		
		System.out.println(E1.getNom() + " " + E1.calculerHoraire(i) + " heures");

	}

	
}

public int HoraireMensuel(){
    
    int horaire=0;
    int horairetotal=0;
    for (Employe E1 : listepersonnel){ 
        horaire = (E1.calculerHoraire(1) + E1.calculerHoraire(2) + E1.calculerHoraire(3) + E1.calculerHoraire(4)); // on somme les horaires semaine par semaine pendant 1 mois
        horairetotal = horairetotal + horaire; // on ajoute a l'horaire totale
        }
    horairetotal = horairetotal/listepersonnel.size(); // on divise l'horaire totale par le nombre d'employés
    return horairetotal;
}

public void verifierPrime(Employe E1) throws ExceptionEmploye {
        // ...
		if(E1.date < 2007 && E1.age > 40)
		{
        throw new ExceptionEmploye("vous avez une prime " + E1.getNom());
		}
    }
	
	public void verifierPrimes(Employe E1){
		Personnel app = new Personnel();
        try {
            app.verifierPrime(E1);
        } catch (ExceptionEmploye me) {
            System.err.println("Prime: " + me.getMessage());
        }
	}


}


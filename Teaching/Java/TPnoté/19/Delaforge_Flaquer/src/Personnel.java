
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laura
 */
public class Personnel {
    //déclaration attributs tableau d'employés 
    private ArrayList<Employe> listePers=new ArrayList<Employe>();
    
    //constructeur par défaut
    public Personnel() {}
    
    //ajoute un employé a la fin du tableau d'employés
    public void ajouterEmploye(Employe e)
    {
        listePers.add(e);
    }
    
    //méthode affichage horaires de chaque employé
    public void calculerHoraires(int i)
    {
        for(int j=0; j<listePers.size(); j++)
        {
            listePers.get(j).calculerHoraire(i); //appel méthode calculerHoraire
            System.out.println(listePers.get(j).getNom()+" "+listePers.get(j).getHoraire()+" heures"); //affichage nom et horaire
        }
    }
    
    //méthode calcul moyenne d'heures dans l'entreprise
    public int HoraireMensuel()
    {
        int moyenne=0;
        for(int j=0; j<listePers.size(); j++) //boucle de parcours du tableau d'employés
        {
            for(int i=1; i<5; i++) //boucle de parcours des semaines
            {
                listePers.get(j).calculerHoraire(i); //récupération horaire de la semaine
                moyenne+=(listePers.get(j).getHoraire()); //incrémentation de la moyenne
            }
        }
        moyenne=moyenne/listePers.size(); //calcul de la moyenne
        
        return moyenne;
    }
    
    public void verifierPrimes()
    {
        System.out.println("\nEmployés concernés par la prime :");
        for(int i=0; i<listePers.size(); i++) //boucle de parcours des employés
        {
            try //test si prime
            {
                listePers.get(i).verifierPrime();   
            }
            catch(ExceptionEmploye e) 
            {

            }
        }
    }
    
    public static void main(String[] args) {
        Personnel p = new Personnel();
        p.ajouterEmploye(new Vente("Pierre", "Business", 45, 2005));
        p.ajouterEmploye(new Vente("Léon", "Vendtout", 25, 2011));
        p.ajouterEmploye(new Production("Yves", "Bosseur", 28, 2000));
        p.ajouterEmploye(new Manutention("Jeanne", "Stocketout", 32, 2008));
        p.calculerHoraires(2);
        System.out.println("Horaire moyen dans cette entreprise est de " +p.HoraireMensuel() + " heures.");
        p.verifierPrimes();
}
}

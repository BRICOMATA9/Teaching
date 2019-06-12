/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

import java.util.ArrayList;

/**
 * Classe Personnel qui comporte un arrayList d'employes
 * avec des methodes pour manipuler l'arraylist
 * et calculer les horaires
 * @author Emma
 */
public class Personnel
{
    private ArrayList<Employe> liste_employe;
    
    /**Constructeur */
    public Personnel()
    {
        liste_employe = new ArrayList<Employe>();
    }
    
    /**Methode qui ajoute un employe passé en parametre à la liste */ 
    public void ajouterEmploye(Employe new_employe)
    {
        // On ajoute à la liste un nouvel employé pasé en paramètre
        liste_employe.add(new_employe);
    }
    
    /**Methode qui calcule l'horaire en fonction de la semaine pour chaque employe de la liste */
    public void calculerHoraires(int i)
    {
        // On parcours la liste d'employé pour affihcer tous les employés
        for(int j=0; j<liste_employe.size(); j++)
        {
            // Afficher pour chaque employé son horaire en fonction de la semaine
            System.out.print(liste_employe.get(j).getNom()+" ");
            System.out.println(liste_employe.get(j).calculerHoraire(i)+" heures.");
        }    
    }
    
    /** Methode qui calcule l'horaire mensuel moyen de la liste */
    public int HoraireMensuel()
    {
        int horaire_moy=0;
        
        // On parcours la liste d'employé pour affihcer tous les employés
        for(int j=0; j<liste_employe.size(); j++)
        {
            for(int k=1; k<=4; k++)
            {
                // Afficher pour chaque employé son horaire en fonction de la semaine
                horaire_moy = horaire_moy + liste_employe.get(j).calculerHoraire(k);
            }  
        } 
        
        return horaire_moy/liste_employe.size();
    }
    
    /** VerifierPrimes de tous les employes en essayant de catch une exception*/
    public void verifierPrimes(){
        //Pour tous les employes
        for(int i=0; i<liste_employe.size(); i++)
            {
            //On try avec la fonction verifierPrime() d'un employé
            try{    
                    liste_employe.get(i).verifierPrime();
            
            }catch(ExceptionEmploye EE){
                //Si on a catch c'est que l'employe vérifie les conditions
                System.out.println(liste_employe.get(i).getNom()+ " doit avoir une prime.");
            }
        }
    }
}
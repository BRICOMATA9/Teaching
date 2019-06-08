/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employe;

import java.util.*;
import java.io.*;
/**
 *
 * @author Daniel Marin
 */
public class Personnel {
    
    private ArrayList<Employe> salaries;

    public Personnel() {
       salaries = new ArrayList<Employe>();
    }
    
    public void ajouterEmploye(Employe empl){
        salaries.add(empl);        
    }
    
    public void calculerHoraires(int i){
        System.out.println("Pour la semaine "+ i+ " : ");
        for(int j=0 ; j< salaries.size() ; j++)
        {
            int horaire = salaries.get(j).calculerHoraire(i);
            
            System.out.println( salaries.get(j).getNom() + " "+ horaire +" heures." );
        }
    }
    
    
    public int HoraireMensuel(){
        // doit Afficher la somme des horaires
        
        int somme = 0; // on initialise
        
        for(int i=0 ; i< salaries.size() ; i++)
        {
            //4 semaines dans un mois
            for(int j=1; j<5; j++){
                // une charge horaire par semaine
                somme  += salaries.get(i).calculerHoraire(j);
            }
        }
         // on a la somme totale des heures sur un mois
         // on divise par le nombre d'employés
         
         return (somme / salaries.size() ) ;
        
    }
    
    // pour l'instant, tout renvoit false
    public void verifierPrimes() throws ExceptionEmploye{
        
        System.out.println( "Les salariés éligibles à la prime sont : ");
        boolean min = false;
        //on checke que chaque employé est dispo
        for(int i=0 ; i< salaries.size() ; i++){
            //si éligible
            if( salaries.get(i).verifierPrime() )
            {
                min = true;
                salaries.get(i).getNom();
            }
            
        }
        if(!min ) System.out.println(" Il semblerait qu'aucun employé n'est éligible");
        
    }
    
    
    
}

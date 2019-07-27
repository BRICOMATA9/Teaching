/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employe;
/**
 *
 * @author Daniel Marin
 */
public abstract class Employe {
    
    protected String nom, prenom;
    protected int age;
    protected int date_embauche;

    public Employe(String nom, String prenom, int age, int date_embauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date_embauche = date_embauche;
    }
    
    public abstract int calculerHoraire( int semaine);
    
    public String getNom(){ 
        
        return "Employé: "+ this.prenom +" "+  this.nom ; 
    }
    
    
    //pas une réussite
    public boolean verifierPrime() throws ExceptionEmploye
   {
       try{       
           if( age > 40 && date_embauche < 2007){
               return true;
            }
           else throw new ExceptionEmploye();
       }
       catch(ExceptionEmploye e){       
           return false;
       }
   }
        
}

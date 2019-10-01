/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;
/**
 *
 * @author alexa
 */
public abstract class Employe {
    
    protected String nom; 
    protected String prenom; 
    protected int horaireT; 
    protected int dateRecrutement; 
    
    Employe (String nom,String prenom,int horaireT,int dateRecrutement)
    {
        this.nom = nom; 
        this.prenom = prenom;
        this.horaireT = horaireT;
        this.dateRecrutement = dateRecrutement;
    }
    
    public String getNom() //Retourne une concaténation de Employé: prénom + nom;   
    {
        String buffer = "Employé(e):" + this.nom + " " + this.prenom; 
        return buffer; 
    }
    
    public int getH()
     {
         return this.horaireT;
     }
    
    abstract void calculerHoraire(int semaine); //Pour calculer les horaire de l'employé
}

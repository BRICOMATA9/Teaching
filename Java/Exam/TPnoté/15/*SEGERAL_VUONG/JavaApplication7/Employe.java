/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

/**
 *
 * @author vuong
 */
public abstract class Employe  {
    
    private String nom; 
    private String prenom; 
    private String horaireT; 
    private String dateRecrutement; 
    
    Employe (String nom,String prenom,String horaireT,String dateRecrutement)
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
    abstract void calculerHoraire(int semaine); //Pour calculer les horaire de l'employé
}

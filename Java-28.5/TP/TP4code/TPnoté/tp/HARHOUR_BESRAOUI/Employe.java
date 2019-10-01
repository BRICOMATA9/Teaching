import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employe;

/**
 *
 * @author Amine
 */
public class Employe {
    
    protected String nom;
    protected String prenom;
    protected int age;
    protected Date DateRecrutement;
    
 /**
     * Constructeur surchargé, initialise les attributs avec les paramètres nécessaires
     *
     * @param nom nomde l'employe
     * @param prenom prenom de l'employe
     * @param age age
     * @param DateRecrutement date d'entree de l'employe
     */
    public Employe(String nom, String prenom, Date DateRecrutement, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.DateRecrutement = DateRecrutement;}
    
    

    /**
     * @param args the command line arguments
     */
    abstract class calculerHoraire (int semaine) {
    
    
    
            }
}
   
    public String getNom() { 
        return "Employe{" + "nom=" + nom + ", prenom=" + prenom + '}';
    }
    
}

import java.util.Date;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

/**
 *
 * @author Amine
 */
public class Vente extends Employe {
    
    private static const int HORAIRE_3_PREM_SEM = 32;
    private static const int HORAIRE_DERN_SEM = 48;
    
    /**
     * Constructeur surchargé, initialise les attributs avec les paramètres nécessaires
     *
     * @param nom nomde l'employe
     * @param prenom prenom de l'employe
     * @param age age
     * @param DateRecrutement date d'entree de l'employe
     */
    public Vente(String nom, String prenom, Date DateRecrutement, Int age) {
        super (nom, prenom, DateRecrutement, age);
        this.nom = nom;
        this.super_prenom = prenom;
        this.super_DateRecrutement = DateRecrutement;}
    
    public String getNom() { 
        return "Vendeur{" + "super.nom=" + nom + ", super.prenom=" + prenom + '}';}
   
    
}

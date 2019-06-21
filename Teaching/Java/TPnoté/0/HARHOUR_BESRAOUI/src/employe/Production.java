import java.util.Date;/** * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

/**
 *
 * @author Amine
 */
public class Production extends Employe {
    private static const int HORAIRE_SEM_PAIRES = 30;
    private static const int HORAIRE_SEM_IMPAIRES = 42;
    
    /**
     * Constructeur surchargé, initialise les attributs avec les paramètres nécessaires
     *
     * @param nom nomde l'employe
     * @param prenom prenom de l'employe
     * @param age age
     * @param DateRecrutement date d'entree de l'employe
     */
    public Production(String nom, String prenom, Date DateRecrutement, Int age) {
        super (nom, prenom, DateRecrutement, age);
        this.nom = nom;
        this.prenom = prenom;
        this.DateRecrutement = DateRecrutement;}
    
    public String getNom() { 
        return "Technicien{" + "super.nom=" + nom + ", super.prenom=" + prenom + '}';}
    
}

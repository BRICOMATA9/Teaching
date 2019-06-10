/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;


/**
 * Classe abstraite Employe
 * avec ses attributs nom, prenom, age, dateRecrutement
 * un constructeur surchargé
 * une méthode abstraite calculerHoraire
 * un getter getNom
 * @author margo
 */
public abstract class Employe {
    private String nom;
    private String prenom;
    private int age;
    private int dateRecrutement;
    
    public Employe(String nom, String prenom, int age, int dateRecrutement){
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.dateRecrutement=dateRecrutement;
    }
    
    /** Méthode abstraite qui permettra de retourner le nombre d'heures hebdomadaires*/
    public abstract int calculerHoraire(int semaine);
    
    /**On retourne le nom de la personne */
    public String getNom(){
        return nom+" "+prenom;
    }
    
    /**Methode qui utilise une exception pour vérifier les conditions de l'employe */
    public void verifierPrime() throws ExceptionEmploye{
        //Si il a été embauche avant 2007 et a plus de 40 ans
        if(dateRecrutement<2007 && age>40){
            //On jette l'exception
            throw new ExceptionEmploye();
        }
    }
}

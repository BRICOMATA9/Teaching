/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kiary
 */
public abstract class Employe {
    protected String nom;
    protected String prenom;
    protected int age;
    protected int dateRecrutement;
    
    public Employe(String newNom, String newPrenom, int newAge, int newDateRecrutement){
    nom=newNom;
    prenom=newPrenom;
    age=newAge;
    dateRecrutement=newDateRecrutement;
    }
    
    abstract int calculerHoraire(int semaine);
    public String getNom(){
        return ("Employé: "+prenom+" "+nom);
    }
    
    public void verifierPrime() throws ExceptionEmploye{
        if(age>40 && dateRecrutement<2007){
            throw new ExceptionEmploye("Erreur exception employé");
        }
    }
    
    public String getPrenom(){
        return prenom;
    }
    public String getNomnom(){
        return nom;
    }
    public int getDateRecrutement(){
        return dateRecrutement;
    }
    public int getAge(){
        return age;
    }
    
}

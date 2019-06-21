/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author utilisateur
 */
public abstract class Employe {
    //déclaration des attributs
    protected String nom;
    protected String prenom;
    protected int age;
    protected int dateRecrutement;
    
    //constructeur surchargé
    public Employe(String prenom, String nom, int age, int dateRecrutement) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateRecrutement = dateRecrutement;
    }
    
    //appelle la méthode calculer horaire de la classe fille qui calcule l'horaire d'un employé
    //en fonction de sa mission et de la semaine
    public void calculerHoraire(int semaine) {
        
    }
    
    //renvoie une chaine de caractères contenant le nom et prénom de l'employé ainsi qu'un préfixe "Employé :"
    public String getNom()
    {
        String s= "Employe "+prenom+ " "+nom;
        return s;
    }
    
    public int getHoraire()
    {
        return getHoraire();
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getDate()
    {
        return dateRecrutement;
    }
    
    public void verifierPrime() throws ExceptionEmploye
    {
        if(dateRecrutement<2007 && age>40)
        {
            throw new ExceptionEmploye(this);
        }
    }
    
}
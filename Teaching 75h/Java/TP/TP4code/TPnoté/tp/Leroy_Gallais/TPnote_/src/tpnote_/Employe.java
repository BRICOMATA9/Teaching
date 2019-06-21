/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote_;

/**
 *
 * @author Jean Leroy
 */
public abstract class Employe  {
    
    protected String nom;
    protected String prenom;
     protected int age;
     protected int date;
     protected char type;

    public Employe(String nom, String prenom, int age, int date) 
   // throws ExceptionEmploye
    {

        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public int getDate() {
        return date;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(int date) {
        this.date = date;
    }
     
    
    public String getFullNom()
    {
        String chaine = "Employe : ";
        chaine =chaine + nom;
        chaine = chaine + " ";
        chaine = chaine + prenom;
        return chaine;
    }

    public char getType() {
        return type;
    }
    
    abstract int calculerHoraire(int semaine);

    
    
}

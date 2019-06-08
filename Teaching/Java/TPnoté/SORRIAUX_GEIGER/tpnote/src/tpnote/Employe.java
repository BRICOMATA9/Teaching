/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

/**
 *
 * @author geige
 */
abstract class Employe {
    protected int age,date;
    protected String nom,prenom;
    
    public Employe (String prenom, String nom, int age, int date){
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
    }
    
    abstract int calculerHoraire(int semaine);
    
    public String getNom(){
        String newChaine;
        newChaine = "Employé : " + prenom + " " + nom;
        return newChaine;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duchemann_safi;

/**
 *
 * @author hugod
 */
public abstract class Employé {
    protected String nom;
    protected String prenom;
    protected int age;
    protected int date_recrutement;
    protected int semaine;
    protected int horaire;
    
    public Employé(String nom, String prenom, int age, int date_recrutement,int horaire){
        nom=this.nom;
        prenom=this.prenom;
        age=this.age;
        date_recrutement=this.date_recrutement;
        horaire=this.horaire;
    }
    public abstract int calculerHoraire(int semaine);
    
    public String getNom(){
        return "Employe : " + this.nom+this.prenom;
    }
    
}
    

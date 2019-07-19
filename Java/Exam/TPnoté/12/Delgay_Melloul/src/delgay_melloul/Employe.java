/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package delgay_melloul;

/**
 *
 * @author julien
 */
public abstract class Employe {
    
    //attributs
    protected String nom;
    protected String prenom;
    protected int age;
    protected int dateRecrutement;
    
    //ctor
    public Employe(String nom, String prenom, int age, int dateRecrutement) {
        this.nom  = nom;
        this.prenom  = prenom;
        this.age  = age;
        this.dateRecrutement  = dateRecrutement;
    }
    
    //methodes
    abstract void calculerHoraire(int semaine);
    
    public String getNom() {
        String str = "Employé: " + this.prenom + this.nom;
        return str;
    }
}

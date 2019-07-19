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
public class Vente extends Employe {
    
    //ctor
    public Vente(String nom, String prenom, int age, int dateRecrutement){
        super(nom,prenom,age,dateRecrutement);
    }
    
    //methodes
    public void calculerHoraire(int semaine){
        if(semaine%4 == 0)
            System.out.println(" 48h");
        else
            System.out.println(" 32h");
    }
    
    public String getNom() {
        String str = "Vendeur: " + this.prenom + this.nom;
        return str;
    }
}

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
public class Manutention extends Employe{
    
    //ctor
    public Manutention(String nom, String prenom, int age, int dateRecrutement){
        super(nom,prenom,age,dateRecrutement);
    }
    
    //methodes
    public void calculerHoraire(int semaine){
        System.out.println(" 35h");
    }
    
    public String getNom() {
        String str = "Manutentionnaire: " + this.prenom + this.nom;
        return str;
    }
}

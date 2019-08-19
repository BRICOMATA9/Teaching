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
public class Production extends Employe{
    
    //ctor
    public Production(String nom, String prenom, int age, int dateRecrutement){
        super(nom,prenom,age,dateRecrutement);
    }
    
    //methodes
    public void calculerHoraire(int semaine){
        if(semaine%2 == 0)
            System.out.println(" 30h");
        else
            System.out.println(" 42h");
    }
    
    public String getNom() {
        String str = "Technicien: " + this.prenom + this.nom;
        return str;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employe;

/**
 *
 * @author Daniel Marin
 */
public class Manutention extends Employe {
    
    public Manutention(String nom, String prenom, int age, int date_embauche) {
        super(nom, prenom, age, date_embauche);
    }

    @Override
    public int calculerHoraire(int semaine) {
        return 35;
    }
    
    @Override
    public String getNom(){
        return "Manutentionaire: "+ this.prenom +" "+  this.nom ;         
    }
    
}

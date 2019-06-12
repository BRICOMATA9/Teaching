/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;


/**
 *Classe manutention qui hérite d'employe
 * et qui implémente les méthodes
 * @author margo
 */
public class Manutention extends Employe {
    
    //Attribut pour le nb d'heures
    private int nbHeures;
    
    public Manutention(String nom, String prenom, int age, int dateRecrutement){
        super(nom,prenom,age,dateRecrutement);
        nbHeures=35;
    }
    
    @Override 
    public int calculerHoraire(int semaine){
        return nbHeures;
    }
    
    @Override
    public String getNom(){
        return "Manutentionnaire : "+super.getNom();
    }
    
}

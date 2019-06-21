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
public class Vente extends Employe  {
	
public int horaire123 = 32;
public int horaire4 = 48;

    public Vente(String prenom, String nom, int age, int date) {
        super(prenom,nom,age,date);
    }

    public int calculerHoraire(int semaine){
        
        if(semaine == 1 || semaine ==2 || semaine ==3){
            return horaire123;
        }else{
            return horaire4;
        }
    }
    
    public String getNom(){
        String newChaine;
        newChaine = "Vendeur : " + prenom + " " + nom;
        return newChaine;
    }
	
}

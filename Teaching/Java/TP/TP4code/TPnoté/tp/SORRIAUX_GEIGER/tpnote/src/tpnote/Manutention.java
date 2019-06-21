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
public  class Manutention extends Employe {
	
	public int horaire = 35;

    public Manutention(String prenom, String nom, int age, int date) {
        super(prenom,nom,age,date);
    }
	
    public int calculerHoraire(int semaine){
        return horaire;
    }
    
    public String getNom(){
        String newChaine;
        newChaine = "Manutentionaire : " + prenom + " " + nom;
        return newChaine;
    }
	
	

}

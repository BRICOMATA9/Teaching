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
public  class Production extends Employe  {
	
	public int horaireP = 30;
	public int horaireI = 42;

    public Production(String prenom, String nom, int age, int date) {
        super(prenom,nom,age,date);
    }
	
    public int calculerHoraire(int semaine){
        
        if(semaine == 4 || semaine ==2 ){
            return horaireP;
        }else{
            return horaireI;
        }
    }
    
    public String getNom(){
        String newChaine;
        newChaine = "Technicien : " + prenom + " " + nom;
        return newChaine;
    }
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

/**
 * Classe production qui hérite d'employe
 * et qui implémente les méthodes
 * @author margo
 */
public class Production extends Employe {
    
    //Attributs pour le type d'horaire
    private int nbHpaire;
    private int nbHimp;
    
    public Production(String nom, String prenom, int age, int dateRecrutement){
        super(nom,prenom,age,dateRecrutement);
        nbHpaire=30;
        nbHimp=42;
    }
    
    @Override 
    public int calculerHoraire(int semaine){
        if(semaine%2==0){
            //Paire
            return nbHpaire;
        }else if(semaine%2!=0){
            //Impaire
            return nbHimp;
        }else return 0;
    }
    
    @Override
    public String getNom(){
        return "Technicien : "+super.getNom();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;


/**
 * Classe vente qui hérite d'employe
 * et qui implémente les méthodes
 * @author margo
 */
public class Vente extends Employe{

    //Attributs pour le type d'horaire
    private int troisSemH;
    private int uneSemH;
    
    /** Constructeur*/
    public Vente(String nom, String prenom, int age, int dateRecrutement){
        super(nom,prenom,age,dateRecrutement);
        troisSemH = 32;
        uneSemH = 48;
    }
    
    @Override 
    public int calculerHoraire(int semaine){
        //Si c'est dans les 3 premières semaines
        if(semaine<=3){
            return troisSemH;
        }else if(semaine==4){
            //Sinon si c'est dans la 4ème semaine
            return uneSemH;
        }return 0;
    }
    
    @Override
    public String getNom(){
        return "Vendeur : "+super.getNom();
    }
    
}

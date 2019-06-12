/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_4;


import modele.*;
import vue.Vue;

/**
 *
 * @author margo
 */
public class Test {
    public static void main(String[] args){
        try{
            Portefeuille pf = new Portefeuille();

            pf.ajouterFonds("margot", 45);
            pf.ajouterFonds("gomar", 12);
            Instrument instru = new Instrument();
            Fonds f1 = new Fonds(30);
            Fonds f2 = new Fonds(25);
            instru.ajouterFonds(f1);
            instru.ajouterFonds(f2);
            pf.ajouterInstru("ko", instru.getCollection().get(0));
            pf.ajouterInstru("ko", instru.getCollection().get(1));
            
            Vue v = new Vue(pf);
            
                   
            //1.5
            String cle1 = v.saisieCleFonds();
            double montant = v.saisieMontant();
            pf.ajouterFonds(cle1, montant);
            
            //1.6
            String cle2 = v.saisieCleInstru();
            pf.ajouterInstru(cle2, pf.getFonds(cle1));
            
            //1.7
            String cle3 = v.saisieCleFondsSupp();
            pf.supprimerFonds(cle3);
            String cle4 = v.saisieCleInstruSupp();
            pf.supprimerInstru(cle4);
            
            //1.9
            pf.getInstru("ko").triCollection();
            
            //1.10
            v.afficherInstruments();
            
            
            
        }catch(FondsExistant FE){
            
        }catch(InstruExistant IE){
            
        }
    }
}

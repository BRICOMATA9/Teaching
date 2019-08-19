/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 * Classe Main
 * @author Emma
 */
import Model.*;
import Vue.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        /** Creation des hashmap */
        HashMap<String, Fonds> fonds = new HashMap();
        HashMap<String, Instrument> instruments = new HashMap();
        
        /** On instancie des objet de type Fonds */
        Fonds f1 = new Fonds(30);
        Fonds f2 = new Fonds(10);
        Fonds f3 = new Fonds(20);
        
        /** On créé une collection  laquelle on ajoute les fonds */
        ArrayList<Fonds> collection1 = new ArrayList();
        collection1.add(f3);
        collection1.add(f2);
        collection1.add(f1);
        
        /** On créé une autre collection  laquelle on ajoute les fonds */
        ArrayList<Fonds> collection2 = new ArrayList();
        collection2.add(f2);
        collection2.add(f3);
        
        /** On instancie des objets de type instrument */
        Instrument i1 = new Instrument(collection1);
        Instrument i2 = new Instrument(collection2);
        
        /** On remplie les HashMap */
        fonds.put("f1",f1);
        fonds.put("f2",f2);
        fonds.put("f3",f3);
        instruments.put("i1",i1);
        instruments.put("i2",i2);
        
        /** On créé et rempli le portefeuille */
        Portefeuille portefeuille = new Portefeuille(fonds, instruments);
          
        /** TEST Q1.5*/
        String clefFonds = Console.recupClefFonds();
        int amount = Console.recupAmount();
        
        try
        {
            // instancier et ajouter le fonds à la HashMap des fonds
            portefeuille.ajoutHashMap(clefFonds, amount);
        }
        catch(FondsExistant fe){}
        
        /** TEST Q1.6*/
        String clefInstru = Console.recupClefInstru();
        Fonds newFonds = new Fonds(amount);
        portefeuille.ajoutInstru(clefInstru, newFonds);
        
        /** TEST Q1.7*/
        String clefFondSupp = Console.supprimerFonds();
        portefeuille.supprimerFonds(clefFondSupp);
        
        String clefInstruSupp = Console.supprimerInstru();
        portefeuille.supprimerInstru(clefInstruSupp);
        
        /** TEST Q1.9*/
        Instrument instrumentTri = Console.choixTri(instruments);
        instrumentTri.tri();
        Console.affichageTri(instrumentTri);
        
        /** TEST Q1.10*/
        Console.affichageTout(instruments);
   } 
}

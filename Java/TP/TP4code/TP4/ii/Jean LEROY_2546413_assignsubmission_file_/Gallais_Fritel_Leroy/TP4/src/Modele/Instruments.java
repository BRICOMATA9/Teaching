/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *Classe instrument avec comme attribut une ArrayList de Fonds
 * @author Jean Leroy
 */
public class Instruments {

    public Instruments() {
        this.collection = new ArrayList<>();
    }
    /*
    *Getter pour la collection de fond
    */
    public ArrayList<Fonds> getCollection() {
        
        return collection;
    }
    
    private ArrayList<Fonds> collection;

    public Instruments(ArrayList<Fonds> collection) {
        this.collection = new ArrayList<>();
        this.collection = collection;
    }
    /*
    *Ajoute une fond a l'instrument
    */
    public void add_fund(Fonds f)
    {
      collection.add(f);
    }
/*
    *Affiche les informations d'un instrument
    */
    public void get_info() {
        double somme = 0.0;
        for (Fonds f : collection)
        {
            somme =somme + f.getMontant();
        }
        System.out.println("L'instrument contient " + collection.size() + "fonds pour une valeur totale de  : " + somme + "€.");

    }
    
    
}

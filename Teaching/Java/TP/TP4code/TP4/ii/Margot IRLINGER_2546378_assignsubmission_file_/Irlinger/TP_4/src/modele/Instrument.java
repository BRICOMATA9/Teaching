/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Instrument
 * possédant un atribut ArrayList
 * @author margo
 */
public class Instrument {
    
    /**attribut public ArrayList<Fonds>*/
    private ArrayList<Fonds> collection;
    
    /**Constructeur par défaut instanciant l'ArrayList*/
    public Instrument(){
        collection = new ArrayList<>();
    }
    
    /**Constructeur surchargé prenant en paramètre un ArrayList*/
    public Instrument(ArrayList<Fonds> collection){
        this.collection = collection;
    }
    
    /**Methode ajouterFonds prenant en parametre un fonds à ajouter dans l'arraylist*/
    public void ajouterFonds(Fonds f){
        collection.add(f);
    }
    
    /**Getter retournant l'arraylist de fonds*/
    public ArrayList<Fonds> getCollection(){
        return collection;
    }
    
    /**Setter prenant en parametre un arraylist de fonds*/
    public void setCollection(ArrayList<Fonds> collection){
        this.collection = collection;
    }
    
    /**Methode permettant de supprimer le contenu de l'arraylist*/
    public void supprimerCollection(){
        collection.clear();
    }
    
    /**Methode permettant de trier par ordre croissant de montant les fonds
     * de l'arraylist*/
    public void triCollection(){
        Collections.sort(collection);
    }
   
            
}

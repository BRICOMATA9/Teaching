/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author Nihal
 */
public class Instrument {
    private ArrayList<Fonds> valeursFonds;
    
    //constructeur par défaut
    public Instrument(){
        valeursFonds= new ArrayList<Fonds>();
    }
    
    public Instrument(ArrayList<Fonds> newFonds){
        valeursFonds= newFonds;
    }
    /// méthode d'ajout d'un objet de la classe Fonds en paramètres 
    public void ajouter(Fonds fd){
        valeursFonds.add(fd);
    }
    
    //setters
    public void setValeursFonds(ArrayList<Fonds> newArrayListFonds){
        valeursFonds=newArrayListFonds;
    }
    
    //getters
    public ArrayList<Fonds> getValeursFonds(){
        return valeursFonds;
    }
    
    
}

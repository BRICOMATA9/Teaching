/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author vuong
 */
public class Instrument {
    
    private ArrayList<Fonds> collectionFonds; 
    
    //constructeur par défaut instrument
    Instrument ()
    {
        this.collectionFonds = new ArrayList<Fonds>(); 
    }
    
    //Constructeur surchargé instrument
    Instrument (Fonds fonds)
    {
        this.collectionFonds = new ArrayList<Fonds>();
        this.collectionFonds.add(fonds); 
    }
    
    //Méthode d'ajout d'un fond dans un instrument
    public void addFonds( Fonds f)
    {
        this.collectionFonds.add(f); 
    }
    
    //Méthode de récupération de la collection de fonds
    public ArrayList<Fonds> getCollectionFonds() 
    {
        return collectionFonds;
    }
    
    public ArrayList getCollectionFdeI ()
    {
        return this.collectionFonds; 
    }
    
    //Méthode de tri
    public void tricollection()
    {
      Collections.sort(collectionFonds);
    }
    
}

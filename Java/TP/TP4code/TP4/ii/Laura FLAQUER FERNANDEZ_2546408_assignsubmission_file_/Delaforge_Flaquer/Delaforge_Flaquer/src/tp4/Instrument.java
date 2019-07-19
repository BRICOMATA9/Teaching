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
 * @author laura 
 * @author ludivine
 */
public class Instrument {
    //Attribut
    protected ArrayList<Fonds> collectInstru;
    
    /**
     * Constructeur par défaut
     */
    public Instrument()
    {
        collectInstru=new ArrayList<>();
    }
    
    /**
     * Constructeur avec paramètres
     * @param collectInstru 
     */
    public Instrument(ArrayList<Fonds> collectInstru)
    {
        this.collectInstru=collectInstru;
    }
    
    /**
     * Méthode get
     * @return collectInstru
     */
    public ArrayList<Fonds> getCollectInstru()
    {
        return collectInstru;
    }
    
    /**
     * Ajouter un objet de la classe Fonds
     * @param f 
     */
    public void ajoutCollection(Fonds f)
    {
        collectInstru.add(f);
    }
    
    /**
     * Trier la collection par instruments
     */
    public void triCollection()
    {
        Collections.sort(collectInstru);
    }
    
}

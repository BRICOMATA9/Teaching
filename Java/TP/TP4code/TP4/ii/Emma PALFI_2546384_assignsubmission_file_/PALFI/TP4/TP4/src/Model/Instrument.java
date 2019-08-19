/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Instrument 
 * @author Emma
 */
public class Instrument 
{
    /** Attributs */
    private ArrayList<Fonds> collection;
    
    /** Constructeur par défaut */
    public Instrument()
    {
        this.collection = new ArrayList();
    }
    
    /** Constructeur surchargé
    * @param collection */
    public Instrument(ArrayList<Fonds> collection)
    {
        this.collection = new ArrayList();
        this.collection = collection;
    }
    
    /** Getter qui permet de récupérer la collection de fons de l'instrument
     * @return  */
    public ArrayList<Fonds> getCollection()
    {
        return collection;
    }
    
    /** Méthode ajout qui permet d'ajouter un fonds passé en paramètre 
     à la collection de l'instrumen
     * @param fonds*/
    public void ajout(Fonds fonds)
    {
        this.collection.add(fonds);
    }
    
    /** Méthode tri qui utilise la fonction sort() de l'interface Comparable
     * et qui permet de trier la collection de fonds */
    public void tri()
    { 
        Collections.sort(collection);
    }
}

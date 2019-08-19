/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Collections;
import controleur.*;
import java.util.Arrays;


/**
 *
 * @author louis
 */
public class Instrument {
    ArrayList<Fonds> collection;
    
    /**
     * Constructeur par defaut
     */
    
    public Instrument(){
        collection = new ArrayList<Fonds>();
    }
    
    /**
     * Constructeur surcharge
     * @param m_collection 
     */
    
    public Instrument(ArrayList<Fonds> m_collection ){
        this.collection= m_collection;
    }
    
    /**
     * Ajouter un fond à l'ArrayList 
     * @param objet 
     */
    
    public void ajoutFond(Fonds objet){
        collection.add(objet);
    }
    
    /**
     * getter
     * @return 
     */
    
    public ArrayList<Fonds> getCollec()
    {
        return collection;
    }
    
    /**
     * Affichage des fonds qui composent l'instrument
     */
    
    public void afficher()
    {
        for (int i=0; i<collection.size(); i++)
        {
            Fonds f=collection.get(i);
            f.afficher();
        }  
    }
    
    /**
     * Fonctioon permettant le tri dans l'ordre croissant des fonds d'un instrument
     */

    
    public void tri()
    {
       Collections.sort(collection);
    }
    
    /**
     * Fonction de calcul de la somme des fonds (utile pour la question 1.10)
     * @return 
     */
    
    public double calcul_fond()
    {
        double total=0;
        for(int i=0; i<collection.size(); i++)
        {
            total=total+ collection.get(i).getAmount();
        } 
        return total;
            
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;

/**
 *
 * @author laura 
 * @author ludivine
 */

public class Fonds extends ComparableImplemente {
    //Attribut
    protected double montant;
    
    /**
     * Constructeur par défaut
     */
    public Fonds()
    {
        montant=0;
    }
    
    /**
     * Constructeur avec paramètres
     * @param montant 
     */
    public Fonds(double montant)
    {
        this.montant=montant;
    }
    
    
    /**
     * Méthode get
     * @return un montant
     */
    @Override
    public double getMontant()
    {
        return montant;
    }

    
}

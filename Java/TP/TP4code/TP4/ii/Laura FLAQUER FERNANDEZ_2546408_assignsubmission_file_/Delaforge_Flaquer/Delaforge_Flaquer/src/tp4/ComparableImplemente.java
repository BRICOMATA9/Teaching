/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp4;

/**
 *
 * @author laura 
 * @author ludivine
 */


public class ComparableImplemente extends Object implements Comparable<Fonds>  {
    
    /**
     * Méthode pour savoir si deux fonds sont égaux
     * @param f
     * @return une valeur de vérité
     */
    public boolean equals(Fonds f) 
    {
        return this.getMontant()==f.getMontant();  
    }
    
    /**
     * Méthode get
     * @return 
     */
    public double getMontant()
    {
        return 0;
    }
    
    @Override
    /**
     * Méthode pour comparer deux fonds entre eux
     * @param f
     * @return un entier (0, 1 ou -1)
     */
    public int compareTo(Fonds f) {
        if (this.getMontant() < f.getMontant()) 
        {
            return -1 ;        
        }
        else if (this.getMontant() > f.getMontant()) 
        {
            return 1 ;        
        }
        else return 0;
    }
}

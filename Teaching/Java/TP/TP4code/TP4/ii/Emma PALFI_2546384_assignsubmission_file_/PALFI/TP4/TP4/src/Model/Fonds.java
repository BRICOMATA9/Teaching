/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Une classe qui implémente l'interface Comparable
 * utile pour l'utilisation de la fonction sort()
 * @author Emma
 */
public class Fonds implements Comparable<Fonds>
{
    protected double amount;
    
    /** Constructeur par défaut */
    public Fonds()
    {
        
    }
    
    /** Constructeur surchargé
     * @param amount */
    public Fonds(double amount)
    {
        this.amount = amount;
    }  
    
    /** Getter pour récupérer l'attribut amount
     * @return  */
    public double getAmount()
    {
        return amount;
    }
    
    /** Méthode equals qui retourne true si le fonds passé en param et 
     * le fonds courant sont égaux, false sinon
     * @param fonds
     * @return 
     */
     public boolean equals(Fonds fonds)
    {
        if(this.amount == fonds.getAmount())
        {
            return true;
        }
        else {return false;}
    }
    
    /** Méthode qui permet de comparer deux fonds, celui passé en pramètre et 
     * le fonds courant en retournant un int 
     * Méthode override car elle existe déjà dans l'interface Comparable
     * @param fonds
     * @return 
     */
    @Override
    public int compareTo(Fonds fonds)
    {
        if(equals(fonds))
        {
           return 0; 
        }
        else if(this.amount > fonds.getAmount())
        {
            return 1;
        }
        else
        {
           return -1; 
        }
    }
}

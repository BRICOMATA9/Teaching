/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import controleur.*;

/**
 *
 * @author louis
 */

/**
 * Classe Fonds
 * Implemente la classe Comparable pour utiliser les elements de comparaison
 */

public class Fonds implements Comparable<Fonds>{ 
    private double amount;
    
    /**
     * Constructeur surcharge
     * @param m_amount 
     */
    
    public Fonds(double m_amount){
        this.amount = m_amount;
    }
    
    /**
     * getter
     * @return 
     */
    
    public double getAmount()
    {
        return amount;
    }
    
    /**
     * Fonction permettant l'affichage de la valeur de chaque fond
     */
    
    public void afficher()
    {
        System.out.println(amount);
    }
    
    /**
     * Verification de l'egalite entre 2 fonds
     * @param f
     * @return 
     */
    
    public boolean equals(Fonds f)
    {
        if(f.amount==this.amount)
            return true;
        else
            return false;
    }
    
    /**
     * Comparaison entre deux fonds
     * @param f
     * @return 
     */
    
    public int compareTo(Fonds f)
    {
        if(f.amount>amount)
            return -1;
        if(f.amount==amount)
            return 0;
        else
            return 1;
    }
}

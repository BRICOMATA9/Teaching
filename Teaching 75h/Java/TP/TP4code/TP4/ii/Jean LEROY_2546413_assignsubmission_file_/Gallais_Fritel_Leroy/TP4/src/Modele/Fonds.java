/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *Classe fonds avec l'attribut montant
 * @author Jean Leroy
 */
public class Fonds implements Comparable<Fonds> {
    private double montant;

    public Fonds(double montant) {
        this.montant = montant;
    }
    /*
    *Retourne le montant du fond
    */

    public double getMontant() {
        return montant;
    }
    /*
    *Implementaiton de la focntion compare to 
    */

    @Override
    public int compareTo(Fonds f) {
        if (this.equals(f))
                {
                   return 0;
                }
        else if (this.getMontant()>f.getMontant())
        {
            return 1;
        }
        else if (this.getMontant()<f.getMontant())
        {
            return -1;
        }
        else return 100;

    }
       
    /*
    *Comapre le montant de deux fonds
    */
    public boolean equals(Fonds f)
    {
        return this.getMontant() == f.getMontant();
    }
    
}

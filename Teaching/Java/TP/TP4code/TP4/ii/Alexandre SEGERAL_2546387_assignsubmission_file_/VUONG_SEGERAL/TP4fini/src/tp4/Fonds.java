/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

/**
 *
 * @author vuong
 */
public class Fonds implements Comparable<Fonds> {
    private double amount; 
    
    //Constructeur par défaut
    Fonds ()
    {
    }
    
    //Constructeur Surchargé
    Fonds( double fonds )
    {
        this.amount = fonds; 
    }
    
    // getter pour la valeur du fond
    public double getAmount ()
    {
        return this.amount; 
    }
    
    //setter valeur du fond
    public void setAmount(double amount) 
    {
        this.amount = amount;
    }
    
    //Renvoi true si référencé et paramètre equals
    public boolean equals ( Fonds o)
    {
        boolean a=false;
        if ( this.amount  == o.getAmount() )
        {
            a = true; 
        }
        return a; 
    }

    @Override
    public int compareTo(Fonds o) {
        int buffer= 2; 
        //Si la valeur entrée est supérieur à la valeur du Fonds qui l'appelle
        if ( this.amount > o.getAmount())
        {
            buffer = 1; 
        }
        if ( this.amount < o.getAmount())
        {
            buffer = -1; 
        }
        if ( this.amount == o.getAmount())
        {
            buffer = 0; 
        } 
        return buffer; 
    }
}

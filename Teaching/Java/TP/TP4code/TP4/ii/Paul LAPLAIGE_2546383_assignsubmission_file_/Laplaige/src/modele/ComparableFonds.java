/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe abstraite ComparableFonds
 * @author Paul
 */
public abstract class ComparableFonds implements Comparable<Fonds>, Amount
{
   //1.8
    public boolean equals (Fonds pFonds)
    {
       if(this.getAmount()==pFonds.getAmount())
       {
           return true;
       }
       else
       {
           return false;
       }
    }
   
    public int compareTo(Fonds pFonds)
    {
        if(this.getAmount()>pFonds.getAmount())
        {
            return 1;
        }
        else if(this.getAmount()<pFonds.getAmount())
        {
            return -1;
        }
        return 0;
    }
}

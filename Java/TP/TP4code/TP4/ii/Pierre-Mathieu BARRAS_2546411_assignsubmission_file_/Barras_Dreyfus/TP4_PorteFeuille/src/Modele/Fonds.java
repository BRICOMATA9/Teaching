/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Comparator;
import java.lang.Comparable;

/**
 *
 * @author evadr
 */
public class Fonds implements Comparable<Fonds> {
    
    private double amount;
    
    public Fonds(){
        super();
    }
    
    public Fonds(double amount)
    {
        super();
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public int compareTo(Fonds f){
        if(this.amount> f.getAmount()){
            return 1;
        }else if(this.amount==f.getAmount()){
            return 0;
        }else{
            return -1;
        }
        
        
    }
    
    public boolean equals(Fonds f){
        return(this.amount==f.getAmount());
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delgay_melloul;

/**
 *
 * @author julien
 */
public class Fonds implements Comparable<Fonds>{
    
    //attributs
    private double amount;
    
    
    //ctor
    public Fonds(){
        amount = 0;
    }
    
    public Fonds(double montant){
        amount = montant;
    }
    
    
    //Comparable<Fonds>
    public boolean equals(Fonds f){
        return this.GetMontant() == f.GetMontant();
    }
    
    @Override
    public int compareTo(Fonds f){
        if(this.GetMontant() < f.GetMontant())
            return -1;
        if(this.GetMontant() > f.GetMontant())
            return 1;
        return 0;
    }
    
    
    //accesseurs
    public double GetMontant(){return amount;}
    
}

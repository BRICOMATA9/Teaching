/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Nihal
 */
public class Fonds {
    
    double amount; // unique attribut de la classe fonds
    
    //constructeur par défaut
    public Fonds(){
        amount=0.0;
        
    }
    //constructeur avec paramètres
    public Fonds(double newAmount){
        amount=newAmount;
    }
    
    //getters
    public double getAmount(){
        return amount;
    }
    //setters
    public void setAmount(double newAmount){
        amount=newAmount;
    }
    
}

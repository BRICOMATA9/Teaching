/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe fonds qui implémente Comparable
 * @author margo
 */
public class Fonds implements Comparable<Fonds>{
    /**Attribut privé double correspondant au montant*/
    private double montant;
    
    /**Constructeur par défaut mettant le montant à 0*/
    public Fonds(){
        montant = 0;
    }
    
    /**Constructeur surchargé prenant en paramètre un double pour le montant*/
    public Fonds(double montant){
        this.montant = montant;
    }
    
    /**Getter retrournant le double du montant*/
    public double getMontant(){
        return montant;
    }
    
    /**Setter prenant en paramètre un double pour le montant*/
    public void setMontant(double montant){
        this.montant = montant;
    }
    
    /**Methode equals comparant le montant du fonds actuel avec celui du fonds 
    *passé en paramètre
    *Retourne true si les montants sont égaux et false sinon*/
    public boolean equals(Fonds f){
        return this.getMontant() == f.getMontant();
    }
    
    /**Methode compareTo comparant le montant du fond actuel avec celui du fonds
     *passé en paramètre
     * Retourne -1 si le montant est inférieur
     * Appel la fonction equals si le montant est égal
     * Retourne 1 si le montant est supérieur*/
    @Override
    public int compareTo(Fonds f){
        if(this.getMontant()<f.getMontant()){
            return -1;
        }else if(this.equals(f)){
            return 0;
        }else return 1;
        
    }
}

package Modèle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author valentin
 */
public class Comparable_fonds extends Fonds implements Comparable<Fonds> {
    
    public boolean equals(Fonds f){
        
       return f.getA() == this.getA(); 
    }
    
     @Override
    public int compareTo(Fonds fd) {
        if(this.getA() > fd.getA()){
            return 1;
        }else if(this.getA() == fd.getA()){
            return 0;
        }else{
            return -1;
        }
    }
}

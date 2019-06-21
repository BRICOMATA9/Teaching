/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnoté2;

/**
 *
 * @author michelclada
 */
public class Vente extends Employe {
    public Vente(String n,String s,int a,int d){
        super(n,s,a,d);
        
       
    
    }
    @Override
    public void getNom(){
        System.out.print("Vendeur "+surname+" "+name+" ");
    }
    @Override
    public int calculerHoraire(int i){
        if(i==1 || i==2 || i==3 ){
            return 32;
        }
        if(i==4){
            return 48;
        }
        else{
        return 0;
        }
    }
    
}

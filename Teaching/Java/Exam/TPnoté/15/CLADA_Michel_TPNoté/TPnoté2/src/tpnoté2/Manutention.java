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
public class Manutention extends Employe {
    public Manutention(String n,String s,int a,int d){
        super(n,s,a,d);
       
    
    }
    @Override
    public void getNom(){
        System.out.print("Manutentionnaire "+surname+" "+name+" ");
    }
    @Override
    public int calculerHoraire(int i){
        return 35;
    }
    
}

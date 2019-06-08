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
public class Production extends Employe {
    public Production(String n,String s,int a,int d){
        super(n,s,a,d);
       
    
    }
    @Override
    public void getNom(){
        System.out.print("Technicien "+surname+" "+name+" ");
    }
    @Override
    public int calculerHoraire(int i){
        int reste = i % 2;
            if (reste == 0) {
                return 30;
            } else {
                return 42;
            }
    }
    
}
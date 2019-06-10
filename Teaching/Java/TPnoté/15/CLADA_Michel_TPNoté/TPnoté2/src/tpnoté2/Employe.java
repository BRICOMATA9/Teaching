/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnoté2;
import java.util.ArrayList;

/**
 *
 * @author michelclada
 */
public abstract class Employe {
    public String name;
    public String surname;
    public int age;
    public int date;
    
    public Employe(String n,String s,int a,int d){
        this.name=n;
        this.surname=s;
        this.age=a;
        this.date=d;
       
    
    }
    
    public void getNom(){
    System.out.print("Employé: "+surname+" "+name+" ");
    }
    public abstract int calculerHoraire(int i);
}

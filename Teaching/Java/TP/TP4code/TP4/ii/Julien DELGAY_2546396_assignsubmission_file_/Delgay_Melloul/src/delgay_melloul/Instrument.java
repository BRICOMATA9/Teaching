/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package delgay_melloul;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author julien
 */
public class Instrument {
    
    //attributs
    private ArrayList<Fonds> amounts;
    
    
    //ctors
    public Instrument(){
        amounts = new ArrayList<Fonds>();
    }
    
    public Instrument(ArrayList<Fonds> montants){
        amounts = montants;
    }
    
    
    //methodes
    public void ajouterFond(Fonds f){
        amounts.add(f);
    }
    
    public void trierMontants(){
        Collections.sort(amounts);
        for(Fonds f : amounts){
            System.out.println(f.GetMontant());
        }
    }
    
    //accesseurs
    public ArrayList<Fonds> getMontants(){return amounts;}
    
}

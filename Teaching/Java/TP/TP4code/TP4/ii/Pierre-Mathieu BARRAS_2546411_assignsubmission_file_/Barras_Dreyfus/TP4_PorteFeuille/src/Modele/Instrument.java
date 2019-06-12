/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;




/**
 *
 * @author evadr
 */
public class Instrument {
    
    private ArrayList<Fonds> valeurFonds;
    
    public Instrument(){
        super();
    }
    
    public Instrument(ArrayList<Fonds>valeurFonds)
    {
        super();
        this.valeurFonds = valeurFonds;
    }
    
    public void addFonds (Fonds f)
    {
        this.valeurFonds.add(f);
    }

    public ArrayList<Fonds> getValeurFonds() {
        return valeurFonds;
    }

    public void setValeurFonds(ArrayList<Fonds> valeurFonds) {
        this.valeurFonds = valeurFonds;
    }
    
    
    //Source : https://www.javaworld.com/article/3323403/java-challengers-5-sorting-with-comparable-and-comparator-in-java.html?fbclid=IwAR1LexcQNeqZl1qlxoYb2VQI-tpN6vBn_rkraCe5yiFj8gMeGvbOJJRZp3w
    public void sortInstrument(){
        
        Collections.sort(this.valeurFonds,(m1,m2) -> m1.compareTo(m2));
    }
}

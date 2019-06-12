/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author valentin
 */
public class Instrument {
    
    private ArrayList<Fonds>fondinst;
//constructeur
    public Instrument(){
        fondinst = new ArrayList<>();
    }
    
    public ArrayList<Fonds> getfondinst() {
        return fondinst;
    }
    
     public Instrument(Instrument in){
        fondinst = in. getfondinst();
    }
     public Instrument(ArrayList<Fonds> fondinst) {
        this.fondinst = fondinst;
    }
    
      public boolean ajout_fds(Fonds f){
        
         fondinst.add(new Fonds(f.getA())); 
         if(fondinst.get(fondinst.size()-1).equals(f)){
            return true;
        }else return false;
          
          
    }
      
      public ArrayList<Fonds> getfi()
      {
      return fondinst;
      
      }
      //detruit un fond
      public void det_fd(){
        fondinst.removeAll(fondinst);
    }

    public void tri(){
       //Collections.sort(fondinst);
    }
    //prend le totaux des fonds
     public double gettotalfd(){
        double totalfd = 0;
        for(int i = 0; i < fondinst.size(); i++){
            totalfd += fondinst.get(i).getA();
        }
        return totalfd;
    }
    //affiche instruments
      public void affinst(){
        for(int i = 0; i < fondinst.size(); i++){
            System.out.println(fondinst.get(i).getA() );
        }
    }
     
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;
import java.util.HashMap;
import Controleur.FondsInexistant;
import Controleur.InstrumentInexistant;
import Controleur.FondsExistant;
import java.util.Iterator;
import java.util.Map;
import Modèle.Fonds;
import java.util.ArrayList;

/**
 *
 * @author valentin
 */

public class Porte_feuille {
    private HashMap<String,Fonds> fd ;
    private HashMap<String,Instrument> instru ;
    
    //constructeur
    public Porte_feuille(){
        fd = new HashMap<>();
        instru = new HashMap<>();
    }

    public HashMap<String, Fonds> getFd() {
        return fd;
    }

    public HashMap<String, Instrument> getInstru() {
        return instru;
    }
    
    
    public Instrument getInstru(String clef) {
        return instru.get(clef);
    }
    
    public Fonds getFd(String clef) {
        return fd.get(clef);
    }
public double recherche_fonds(String clef) throws FondsInexistant {
    try{
    if(fd.get(clef)==null){
        throw new FondsInexistant(); 
    }
    else {return fd.get(clef).getA();}
   
}
    catch (FondsInexistant e){
        return 0;
    }
}
 public ArrayList<Fonds> recherche_inst(String clefinst) throws InstrumentInexistant{
try{
    if(instru.get(clefinst)==null){
        throw new InstrumentInexistant(); 
    }
    else {return instru.get(clefinst).getfi();}
    }
catch (InstrumentInexistant e){
        return null;
        
}
}
 public void ajout_fond_hash(String clefh,double pa)throws FondsExistant{
 try{
     if(fd.containsKey(clefh)){
         
         throw new FondsExistant();
     }
     else {
         
         Fonds f = new Fonds(pa);
         fd.put(clefh,f);
     }
 }
 catch(FondsExistant e){}
 }
 
 public void ajouter_inst(String clefinstru, Instrument in) {
        
        if(instru.containsKey(clefinstru)){
            System.out.println("Clé existe déjà !");
            
        }
        else {
            instru.put(clefinstru, new Instrument(in));
            System.out.println("Instrument ajouté !");
           
        }
    }
 
 
 
 public void ajout_fond_instru(String clefinst,Fonds fds)throws FondsExistant{
     
     if(instru.containsKey(clefinst)){
        instru.get(clefinst).ajout_fds(fds);       
     }
     else {
          System.out.println("l'instrument n'existe pas ");
         
     }

 }
     
     
   public void suppr_fd(String cle) throws FondsInexistant{
        try{
            recherche_fonds(cle);
            fd.remove(cle);
        }catch(FondsInexistant e){
        
        }
    }
    public void suppr_inst(String clefit) throws InstrumentInexistant{
        try{
            recherche_inst(clefit);
            instru.get(clefit).det_fd();
            instru.remove(clefit);
        }catch(InstrumentInexistant e){
            
        }  
     
 }
 
 
}

         
        






import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * PORTEFEUILLE
 */

/**
 *
 * @author antoinesorriaux et thomasgeiger
 */
public class Portefeuille   {
    
    HashMap<String,fonds> searchfonds;
    HashMap<String,Instrument> searchinstru; 
    
    /**
    * Constructeur par défaut Portefeuille
    */
    
    Portefeuille(){
        
      
    }
    
     /**
    * Constructeur surchargé Portefeuille
    */
    
    Portefeuille(HashMap<String,fonds> sfonds, HashMap<String,Instrument> sInstru){
        
        this.searchfonds = sfonds; 
        this.searchinstru = sInstru;
        
       
      
    }
    
    // METHODES
    
    /**
    * methodes portefeuille
    */
    
    /**
    * recherche instrument
    */
    
    
      public ArrayList<fonds> rechercheInstrument(String ID) throws InstrumentInexistantException {
        
                   
                    if(!(searchinstru.containsKey(ID))){
                        
                        
                        throw new InstrumentInexistantException();
                        
                    }
                    else{
                        
                        return (ArrayList<fonds>) searchinstru.get(ID).collectionfonds ;
                        
                    }   
        
    }
      
      /**
    * ajout fonds
    */
      
     public void ajoutfonds(String ID, int montant) throws FondsExistantException {
         
         fonds F1 = new fonds();
         
         if(searchfonds.containsKey(ID))
         {
           throw new FondsExistantException();  
         }
         else{
             
             F1.amount = montant;
             searchfonds.put(ID, F1);   
         }         
         
     }
     
     /**
    * recherche fonds
    */

    public int rechercheFonds(String ID) throws FondsInexistantException{
         
                    if(!(searchfonds.containsKey(ID))){
                        
                        throw new FondsInexistantException();
                        
                    }
                    else{
                        
                        return searchfonds.get(ID).amount ;
                        
                    } 
    }
    
    /**
    * ajout Instrument
    */
    
    public void ajoutInstru(String nom, fonds F1){
        
        Instrument I1 = new Instrument();
        
        I1.AjoutFonds(F1);
        searchinstru.put(nom, I1);
        
    }
    
    /**
    * Suppression fond
    */
    
    public void supFonds(String ID){
        
        searchfonds.remove(ID);
        
    }
    
    /**
    * Suppression Instrument
    */
    
     public void supInstru(String ID){
         
        // VIDER LA LISTE DE FONDS
        searchinstru.get(ID).collectionfonds.clear();
        
        // SUPPRIMER LES INSTRUMENTS
        searchinstru.remove(ID);
        
    }
    
    
    
}

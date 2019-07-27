/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.HashMap;
import Controleur.*;
import java.util.ArrayList;

/**
 *
 * @author Nihal
 */
public class Portefeuille {
    private HashMap<String, Fonds> fondsMap;
    private HashMap<String, Instrument> instrumentMap;
        
    //constructeurs
    public Portefeuille(){
        fondsMap=new HashMap<String, Fonds>();
        instrumentMap=new HashMap<String, Instrument>();
    }
    
    public Portefeuille(HashMap<String, Fonds> newFondsMap, HashMap<String, Instrument> newInstrumentMap){
        fondsMap=new HashMap<>();
        fondsMap.putAll(newFondsMap);
        instrumentMap=new HashMap<>();
        instrumentMap.putAll(newInstrumentMap);
    }
    
    
    //getters & setters
    public HashMap<String, Fonds> getFondsMap(){
        return fondsMap;
    }
    
    public HashMap<String, Instrument> getInstrumentMap(){
        return instrumentMap;
    }
    
    public void setFondsMap(HashMap<String, Fonds> newFondsMap){
        fondsMap=new HashMap<>();
        fondsMap.putAll(newFondsMap);
    }
     public void setInstrumentMap(HashMap<String, Instrument> newInstrumentMap){
        instrumentMap=new HashMap<>();
        instrumentMap.putAll(newInstrumentMap);
    }
     
   /// méthode de recherche d’un fonds, avec en paramètre la clé du fonds recherché
     
     public double rechercherFonds(String key) throws FondsInexistantException{
         double montant=0.0;
         Fonds f;
         //recherche de l'existence du fonds
         f = fondsMap.get(key);
         if(f==null){
             throw new FondsInexistantException();
         }else{
             montant= f.getAmount();
             return montant; 
         }
     }
     public ArrayList<Fonds> rechercherInstrument(String key) throws InstrumentInexistantException{
         ArrayList<Fonds> rechFonds;
         rechFonds= new ArrayList<Fonds>();
         Instrument i= instrumentMap.get(key);
         if(i==null){
             throw new InstrumentInexistantException();
         }else{
             rechFonds= i.getValeursFonds();
             return rechFonds;
         }
     }
     
     
     


public void ajoutInstrument(String key, Fonds fond) throws InstrumentInexistantException 
{
    ///recherche du fonds
Instrument iM = new Instrument() ; 
//teste instrumentMap(hashmap) si ce fonds existe 
iM = instrumentMap.get(key);

 if(iM!= null)
         {
             throw new InstrumentInexistantException();   
         }
 else{
             //l'instrument n'existe pas, ajouter le fonds dans fondsMap 
        iM.ajouter(fond);
         }
}


public void deleteFonds (String key) throws FondsInexistantException
{
 double valeur = 0.0 ;
 valeur = rechercherFonds(key);
   if (valeur!=0.0)
    {
       fondsMap.remove(key);
       System.out.println("Le fonds est supprimé");

    } 
   else {
                throw new FondsInexistantException();            
        }
}

public void ajoutFonds(String key, double montant) throws FondsExistantException{
         Fonds fd= new Fonds();
         //recherche si le fond existe deja
         fd= fondsMap.get(key);
         if(fd!= null){
             throw new FondsExistantException();   
         }else{
             //le fonds n'existe pas, ajout du fonds 
             fd= new Fonds(montant);
             fondsMap.put(key, fd);
         }
     }

public void deleteInstrument (String key) throws InstrumentInexistantException, FondsInexistantException
{

 ArrayList<Fonds> fdtry = new ArrayList<>(); 
 fdtry = rechercherInstrument(key); 
 
   if (fdtry != null)
    {
     
       fdtry.clear();
       instrumentMap.remove(key); 
       
    } 
   else {
                throw new InstrumentInexistantException();            
        }
}
}

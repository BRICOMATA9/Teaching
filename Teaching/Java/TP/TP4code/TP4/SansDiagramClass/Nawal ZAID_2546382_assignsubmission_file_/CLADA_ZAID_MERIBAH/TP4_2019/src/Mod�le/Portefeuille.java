package Modèle;

import Contrôleur.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Idris MERIBAH ,Michel CLADA , Nawal ZAID
 */
public class Portefeuille 
{
    private HashMap<String, Fonds> fondsMap;
    private HashMap<String, Instrument> InstrumentMap;
//constructeur par defaut    
    public Portefeuille()
    {
        fondsMap = new HashMap<>();
        InstrumentMap = new HashMap<>();
    }
//constructeur surchargé
    public Portefeuille(HashMap<String, Fonds> fondsMap, HashMap<String, Instrument> InstrumentMap) 
    {
        this.fondsMap = fondsMap;
        this.InstrumentMap = InstrumentMap;
    }
//getters
    public HashMap<String, Fonds> getfondsMap() 
    {
        return fondsMap;
    }
//setters
    public void setfondsMap(HashMap<String, Fonds> fondsMap) 
    {
        this.fondsMap = fondsMap;
    }
//constructeur par defaut
    public HashMap<String, Instrument> InstrumentMap() 
    {
        return InstrumentMap;
    }
    //setters
    public void setInstrumentMap(HashMap<String, Instrument> InstrumentMap) 
    {
        this.InstrumentMap = InstrumentMap;
    }
    
    public double rechercherFonds(String key) throws FondsInexistant
    {
        double amount= 0.d;
        Fonds f;
        f= fondsMap.get(key);
        if(f==null){
            throw new FondsInexistant();
            
        }else{
            amount=f.getAmount();
            return amount;
        }
    }
    
    public ArrayList<Fonds> rechercherInstrument(String key) throws InstrumentInexistant
    {
        ArrayList<Fonds> unFonds;
        unFonds= new ArrayList<Fonds>();
        Instrument i = InstrumentMap.get(key);
        if (i==null) {
            throw new InstrumentInexistant();
           
        }else{
            unFonds = i.getValeursFonds();
            return unFonds;
            
        }
        
    }
    
    public void createFund(String key, double amount) throws FondsExistant
    {
        if (fondsMap.containsKey(key))
        {
            throw new FondsExistant();
        }
        
        else
        {
            fondsMap.put(key, new Fonds(amount));
        }
    }
    
    public void ajouterFonds(String key, Fonds f) throws InstrumentInexistant
    {
      Fonds fn = new Fonds();
      fn= fondsMap.get(key);
        
    }
    
    public void supprimerfonds(String key)
    {
        boolean exists = true;

        try 
        {
            double amount = rechercherFonds(key);
        } 
        
        catch (FondsInexistant fi) 
        {
            System.out.println("Erreur : Le fond que vous désirez supprimer n'existe pas.");
            exists = false;
        }

        if (exists) 
        {
            fondsMap.remove(key);
        }
    }
    
    public void deleteInstrument(String key)
    {
        boolean exists = true;
        
        try
        {
            ArrayList<Fonds> ValeursFonds = rechercherInstrument(key);
        }
        
        catch (InstrumentInexistant ii)
        {
            System.out.println("Erreur : L'instrument que vous souhaitez supprimer n'existe pas.");
            exists = false;
        }
        
        if (exists)
        {
            InstrumentMap.get(key).getValeursFonds().clear();
            InstrumentMap.remove(key);
        }
    }

   
}

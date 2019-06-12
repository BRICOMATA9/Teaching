/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.io.*;
import java.util.*;
import controleur.*;

/**
 * Classe Portefeuille
 * @author Paul
 */
public class Portefeuille 
{
    private HashMap<String,Fonds>hashFonds;
    private HashMap<String,Instrument>hashInstruments;
    
    public  Portefeuille()
    {
        hashFonds = new HashMap<>();
        hashInstruments = new HashMap<>();
    }
    
    /**
    * Constructeur
    * @author Paul
    */
    public  Portefeuille(HashMap<String, Fonds> pFonds, HashMap<String, Instrument> pInstruments)
    {
        hashFonds = new HashMap<>(pFonds);
        hashInstruments = new HashMap<>(pInstruments);
    }
    
    /**
    * Getter
    * @author Paul
    */
    public HashMap<String,Fonds> getFonds()
    {
        return hashFonds;
    }

    public HashMap<String,Instrument> getInstruments()
    {
        return hashInstruments;
    }
    
    //1.3
    public Fonds rechercherFonds(String pClef) throws FondsInexistant
    {
        if(hashFonds.get(pClef)== null)
        {
            throw new FondsInexistant();
        }
        else 
        {
            return hashFonds.get(pClef);
        }              
    }
    
    //1.4
    public ArrayList<Fonds> rechercherInstrument(String pClef) throws InstrumentInexistant
    {
        if(hashInstruments.get(pClef)== null)
        {
            throw new InstrumentInexistant();
        }
        else
        {
            return hashInstruments.get(pClef).getListeFonds();
        }            
    }
    
    //1.5
    public void ajouterHashFonds(String pClef, double pAmount) throws FondsExistant
    {
        if(hashFonds.containsKey(pClef))
        { 
            throw new FondsExistant();
        }
        else
        { 
            Fonds fond = new Fonds(pAmount);
            hashFonds.put(pClef,fond);            
        }             
    }
    
    //1.6
    public void ajouterFondsHashIntrument(String pClef, Fonds pFonds)
    {
        if(hashInstruments.containsKey(pClef))
        { 
            hashInstruments.get(pClef).ajouterFonds(pFonds);
        }
        else
        { 
            System.out.println("Instrument inconnu");
        }             
    }
    
    public void ajouterHashInstrument(String pClef, Instrument pInstrument) throws FondsExistant
    {
        hashInstruments.put(pClef,pInstrument);                 
    }
    
    //1.7
    public void supprimerHashFonds(String pClef) throws FondsInexistant
    {
        try
        {
            Fonds fond = rechercherFonds(pClef);
            hashFonds.remove(pClef);
        }
        catch(FondsInexistant e){}             
    }
    
    public void supprimerHashInstrument(String pClef) throws InstrumentInexistant
    {
        try
        {
            ArrayList<Fonds>instru = rechercherInstrument(pClef);
            hashInstruments.remove(pClef);
        }
        catch(InstrumentInexistant e){}                       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author louis
 */
public class Portefeuille {
    HashMap<String, Fonds> mapFond ;
    HashMap<String, Instrument> mapInstrument;
    
    /**
     * Constructeur par defaut
     */
    
    public Portefeuille(){
        mapFond = new HashMap <String, Fonds>();
        mapInstrument = new HashMap <String, Instrument>();
    }
    
    /**
     * Constructeur surcharge
     * @param mFond
     * @param mInstru 
     */
    
    public Portefeuille(HashMap<String, Fonds> mFond, HashMap<String, Instrument> mInstru)
    {
        mapFond=mFond;
        mapInstrument=mInstru;
    }
    
    /**
     * Methode de recherche d'un fond dans le portefeuille
     * @param cle
     * @return 
     */
    
    public double recherche_fond(String cle)
    {
       
        
             Fonds f=mapFond.get(cle);
             if(f==null)
             {
                 new FondsInexistant();
                 return -5;
             }
             else
                return f.getAmount();
        
        
    }
    
    /**
     * Methode de cherche d'un instrument dans le portefeuille
     * @param cle
     * @return 
     */
    
    public ArrayList<Fonds> recherche_instru(String cle) 
    {
             Instrument i=mapInstrument.get(cle);
             if(i==null)
             {
                 new InstrumentInexistant();
                 ArrayList<Fonds> nul=new ArrayList<Fonds>();
                 return nul;
             }
             else
                return i.getCollec();
        
        
    }
    
    /**
     * Methode d'ajout d'un fond dans le portefeuille
     * @param cle
     * @param montant
     * @throws FondsExistant 
     */
    
    public void ajouter_fond(String cle, double montant) throws FondsExistant
    {
        try{
            if(mapFond.containsKey(cle))
                throw new FondsExistant();
            else
                mapFond.put(cle, new Fonds(montant));
        }
        catch(FondsExistant e)
        {
            throw new FondsExistant();
        }
    }
    
    /**
     * Methode d'ajout de fond dans un instrument du portefeuille
     * @param cle
     * @param f
     * @throws FondsExistant 
     */
        
    public void ajouter_fond_instru(String cle, Fonds f) throws FondsExistant
    {
        if(recherche_instru(cle).size()==0)
        {
            ArrayList<Fonds> ajout=new ArrayList<Fonds>();
            ajout.add(f);
            mapInstrument.put(cle, new Instrument(ajout));
            
        }
        else
            mapInstrument.get(cle).ajoutFond(f);
    }
    
    /**
     * Methode d'affichage des fonds et instruments constituant le portefeuille
     */
    
    public void afficher()
    {
        for(Iterator i=mapFond.keySet().iterator(); i.hasNext();)
        {
            String cle =(String) i.next();
            System.out.print(cle+ ": ");
            mapFond.get(cle).afficher();
        }
        
        for(Iterator i=mapInstrument.keySet().iterator(); i.hasNext();)
        {
            String cle =(String) i.next();
            System.out.print(cle+ ": ");
            mapInstrument.get(cle).afficher();
        }
    }
    
    /**
     * Methode de suppression d'un fond du portefeuille
     * @param cle 
     */
    
    public void suppr_fond(String cle)
    {
        if(recherche_fond(cle)<0)
        {
            System.out.println("Erreur, ce fond est inexistant");
        }
        else
            mapFond.remove(cle);
    }
    
    /**
     * Methode de suppression d'un instrument du portefeuille
     * @param cle 
     */
    
    public void suppr_instru(String cle)
    {
        if(recherche_instru(cle).size()==0)
            System.out.println("Erreur, cet instrument est inexistant");
        else
        {
            mapInstrument.get(cle).collection.clear();
            mapInstrument.remove(cle);
        }
    }
    
    /**
     * getter (utile pour affichage)
     * @return 
     */
    public HashMap<String, Instrument> getMapInstru()
    {
        return mapInstrument;
    }
            
}

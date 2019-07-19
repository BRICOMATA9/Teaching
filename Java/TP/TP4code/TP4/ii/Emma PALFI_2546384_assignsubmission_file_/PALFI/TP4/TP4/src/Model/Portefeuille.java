/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe Portefeuille 
 * @author Emma
 */
public class Portefeuille {
    
    /** Attributs */
    private HashMap<String,Fonds> fonds;
    private HashMap<String,Instrument> instruments;
    
    /** Constructeur surchargé
     * @param fonds
     * @param instruments */
    public Portefeuille(HashMap<String,Fonds> fonds, HashMap<String,Instrument> instruments)
    {
        this.fonds = new HashMap();
        this.instruments = new HashMap();
        this.fonds = fonds;
        this.instruments = instruments;
    }
    
    /** Méthode rechercheFonds qui recherche un fonds dans la hashmap 
    * et throws l'exception FondsInexistant si le fonds n'existe pas dans la
    * HashMap
     * @param clef
     * @return 
     * @throws Model.FondsInexistant */
    public double rechercheFonds(String clef) throws FondsInexistant
    {
        if(fonds.containsKey(clef))
        {
            return fonds.get(clef).getAmount();
        }
        else { throw new FondsInexistant();}
    }
    
     /** Méthode rechercheInstrument qui recherche un instruments dans la hashmap 
    * et throws l'exception InstrumentInexistant si l'instrument n'existe pas dans la
    * HashMap
    * @param clef
    * @return 
    * @throws Model.InstrumentInexistant */
    public ArrayList<Fonds> rechercheInstrument(String clef) throws InstrumentInexistant
    {
        if(instruments.containsKey(clef))
        {
            return instruments.get(clef).getCollection();
        }
        else { throw new InstrumentInexistant();}
    }
    
    /** Méthode ajoutHashMap qui permet d'ajouter un fond à la HashMap de fonds, 
     * catch l'exception FondsInexistant si le fonds n'existe pas et envoie 
     * l'exception FondsExistant si le fond existe.
     * @param clef
     * @param amount
     * @throws FondsExistant 
     */
    public void ajoutHashMap(String clef, double amount) throws FondsExistant
    {
        try
        {
            rechercheFonds(clef);
            throw new FondsExistant();
        }
        catch(FondsInexistant fi)
        { 
            Fonds f = new Fonds(amount);
            fonds.put(clef,f); 
            System.out.println("Fonds créés et ajoutés");
        }
    }
    
     /** Méthode ajoutInstru qui permet d'ajouter un fond à la HashMap d'instruments, 
     * catch l'exception InstrumentInexistant si l'instrument n'existe pas.
     * @param clef
     * @param fonds */
    public void ajoutInstru(String clef, Fonds fonds)
    {
         try
        {
            rechercheInstrument(clef);
        }
        catch(InstrumentInexistant ii)
        { 
            // On instancie un nouvel instrument
            Instrument instrument = new Instrument();
            // On ajoute l'instrument vide à la HashMap
            instruments.put(clef, instrument); 
            // Ajoute le fond à la collection de l'instru direct dans la Hashmap
            instruments.get(clef).ajout(fonds); 
            System.out.println("Instrument ajouté"); 
        }
            
    }
    
    /** Méthode supprimer Fonds qui permet de supprimer un fonds de la HashMap 
     * de fonds, catch l'exception FondsInexistant si le fond n'existe pas.
     * @param clef */
    public void supprimerFonds(String clef)
    {
        try
        {
            rechercheFonds(clef);
            fonds.remove(clef);
        }   
        catch(FondsInexistant fi)
        {
            System.out.println("erreur, fonds inexistant");
        }  
    }
    
     /** Méthode supprimerInstru qui permet de supprimer un instrument de la HashMap 
     * d'instruments, catch l'exception InstrumentInexistant si l'instrument 
     * n'existe pas.
     * @param clef */
    public void supprimerInstru(String clef)
    {
        try
        {
            rechercheInstrument(clef);
            instruments.get(clef).getCollection().clear();
            instruments.remove(clef);
        }   
        catch(InstrumentInexistant ii)
        {
            System.out.println("erreur, fonds inexistant");
        } 
    }
}

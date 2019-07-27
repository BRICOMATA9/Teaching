/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jean Leroy
 */
public class Portefeuille {

    public Portefeuille(HashMap<String, Fonds> hash_fonds, HashMap<String, Instruments> hash_intr) {
        this.hash_fonds = new HashMap();
        this.hash_instr = new HashMap();
        this.hash_fonds = hash_fonds;
        this.hash_instr = hash_intr;
    }
    public Portefeuille()
    {
        hash_fonds = new HashMap();
        hash_instr = new HashMap();
    }
    
    public HashMap<String, Fonds> hash_fonds;
    public HashMap<String, Instruments> hash_instr;
    
    /*
    *Recherche un fond dans le portefeuille, si non existan propage l'exception fond iNexisatnt
    */
    public double search_fond(String cle) throws ExceptionFondInexistant
    {
        {
        if (hash_fonds.containsKey(cle))
        {
            System.out.println("Fund found");
            return hash_fonds.get(cle).getMontant();
        }
        else 
        {
            throw new ExceptionFondInexistant();    
        }
     }
 }
        /*
    *Recherche un instrument dans le portefeuille, si non existan propage l'exception isntrument inexisatnt
    */
    public ArrayList<Fonds> search_instr(String cle) throws ExceptionInstrumentInexistant
    {
           if (hash_instr.containsKey(cle))
           {
               return hash_instr.get(cle).getCollection();
           }
           else
           {
               throw new ExceptionInstrumentInexistant();
           }
    }
    /*
    *Ajoute un fond a un instrument du portefeuille
    */
    public void add_fond(String cle, double mont) throws ExceptionFondExistant
    {
        if (hash_fonds.containsKey(cle))
        {
            throw new ExceptionFondExistant();
        }
        hash_fonds.put(cle, new Fonds(mont));
    }
        /*
    *Ajoute un instrument au portefeuille
    */
    public void add_instr(String cle) throws ExceptionFondExistant
    {
        this.hash_instr.put(cle, new Instruments());
    }   
    /*
    *Supprime un fond du portefeuille
    */
    public void delete_fund(String cle) throws ExceptionFondInexistant
    {
        try
        {
            double test = search_fond(cle);
            hash_fonds.remove(cle);
        
        }catch (ExceptionFondInexistant e) {
         //   e.printStackTrace();
            System.out.println("Le fond à supprimer n'existe  pas");
        }
    }
    
    /*
    *Ajoute un fond a un isntrument
    */
    
    public void add_fond_to_instr(String cle, Fonds f) throws ExceptionInstrumentInexistant
    {
        if (hash_instr.containsKey(cle))
        {
            hash_instr.get(cle).add_fund(f);
        }
        else 
        {
            throw new ExceptionInstrumentInexistant();
        }
    }
    /*
    *Efface un instrument du portefeuille
    */
    public void delete_instr(String cle)
    {
        try
        {
            search_instr(cle);
            hash_instr.get(cle).getCollection().clear();            
            hash_instr.remove(cle);
            System.out.println("Suppression de l'instrument efféctuée");
        }catch (ExceptionInstrumentInexistant e){
            System.out.println("L'instrument à supprimer n'existe pas");
        }
    }
/*
    *Affiche les instruments du portefeuille 
    */
    public void display() {
           for (String cle : hash_instr.keySet())
           {
               System.out.println("La cle de l'insturment est " + cle);
               hash_instr.get(cle).get_info();
           }
    }
    
}

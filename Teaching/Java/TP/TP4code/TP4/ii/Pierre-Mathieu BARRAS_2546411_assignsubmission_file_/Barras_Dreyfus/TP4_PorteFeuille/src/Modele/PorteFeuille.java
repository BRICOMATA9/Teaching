/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.util.*;
import Controleur.FondsInexistants;
import Controleur.InstrumentInexistants;
import Controleur.FondsExistants;

/**
 *
 * @author evadr
 */
public class PorteFeuille {
    
    private HashMap<String, Fonds> fonds;
    private HashMap<String, Instrument> instrument;
    
    public PorteFeuille(){
        super();
    }
    
    public PorteFeuille(HashMap<String, Fonds> fonds, HashMap<String, Instrument> instrument)
    {
        super();
        this.fonds = fonds;
        this.instrument = instrument;
    }

    public HashMap<String, Fonds> getFonds() {
        return fonds;
    }

    public void setFonds(HashMap<String, Fonds> fonds) {
        this.fonds = fonds;
    }

    public HashMap<String, Instrument> getInstrument() {
        return instrument;
    }

    public void setInstrument(HashMap<String, Instrument> instrument) {
        this.instrument = instrument;
    }
    
    
    //Penser à mettre les exceptions
    public double rechercheFonds(String f) throws FondsInexistants
    {
        if(!this.fonds.containsKey(f)){
            throw new FondsInexistants();
        }else{
            return this.fonds.get(f).getAmount();
        }
    }
    
    
    //Penser à mettre les exceptions
    public ArrayList<Fonds>rechercheInstrument(String i) throws InstrumentInexistants
    {
        if(!this.instrument.containsKey(i)){
            throw new InstrumentInexistants();
        }else{
            return this.instrument.get(i).getValeurFonds();
        }
        
    }
    
    //Penser à mettre l'exception
    public void addFonds (String cle, double amount) throws FondsExistants
    {
        if(this.fonds.containsKey(cle)){
            throw new FondsExistants();
            
        }else{
       
            this.fonds.put(cle,new Fonds(amount));
            System.out.println("L'ajout du fond est réussi");
        }
        
 
    }
    public void addFondsInstruments (String cle, Fonds fonds)
    {
        this.instrument.get(cle).getValeurFonds().add(fonds);
        System.out.println("L'ajout du fond dans l'instrument est réussi");
    }
    
    public void suppFonds(String cle) throws FondsInexistants
    {
        rechercheFonds(cle);
        this.fonds.remove(cle);
        System.out.println("La suppresion du fond est réussi");
    }
    
    public void suppInstruments (String cle) throws InstrumentInexistants
    {
        rechercheInstrument(cle);
        this.instrument.remove(cle);
        System.out.println("La suppression de l'instrument est réussi");
    }
}

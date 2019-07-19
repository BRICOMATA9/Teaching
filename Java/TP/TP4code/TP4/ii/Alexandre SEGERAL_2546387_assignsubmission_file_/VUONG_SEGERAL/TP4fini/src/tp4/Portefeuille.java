/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vuong
 */
public class Portefeuille {
    private final HashMap<String, Fonds> tableF;
    private final HashMap<String, Instrument> tableI;
  
    /*
    Portefeuille( HashMap<String , Fonds> tabF, HashMap<String , Instrument> tabI)
    {
        this.tableF = tabF; 
        this.tableI = tabI; 
    }
*/
    Portefeuille() {
        this.tableF = new HashMap<String, Fonds >();  
        this.tableI = new HashMap<String, Instrument >();  
    }
    
    //Méthode pour chercher la valeur d'un fond
    public double searchFonds( String key) throws FondINexistant 
    {
        double buffer = 0; 
        if ( this.tableF.containsKey(key))
        {
            buffer = this.tableF.get(key).getAmount(); 
        }
        else 
        {
            throw new FondINexistant();
        }
        return buffer; 
    }
    
    //Méthode pour chercher un instrument
    public ArrayList searchInstrument( String key) throws InstumentINexistant 
    {
        ArrayList<Instrument> buffer; 
        
        if ( this.tableI.containsKey(key))
        {
            buffer = this.tableI.get(key).getCollectionFdeI(); 
        }
        else 
        {
            throw new InstumentINexistant();
        }
        return buffer; 
    }
    
    //Ajoute un nouveau fonds à un instrument:
    public void addFondsInsideInstrument( String keyI, Fonds fonds ) throws InstumentINexistant
    {
        //Temporaire
        Instrument temp; 
        //Si le fonds existe dans Portefeuille
        if ( this.tableI.containsKey(keyI))
        {
            //Accède à l'instument de la HashMap de Portfeuille et ajoute le fonds
            this.tableI.get(keyI).addFonds(fonds);           
        }
        else 
        {
            throw new InstumentINexistant(); 
        }
    }
    
    //pour add un fonds dans le portefuille.
    public void addFonds(String key, double amount) throws FondsExistant 
    {
        //Si cette clé existe
         if ( this.tableF.containsKey(key)==false)
         {
             Fonds fonds = new Fonds(amount); //Instancie dans le Fonds 
             this.tableF.put(key, fonds); //AJoute dans la HashMap
             System.out.println("Vous avez bien ajouté un fonds ! "+ this.tableF.get(key).getAmount()+ "\n");
         }
         else 
         {
            throw new FondsExistant();
         }
    }
    
    
    //Getter
    public HashMap<String, Fonds> getFondsCollect()
    {
        return this.tableF; 
    }
     public HashMap<String, Instrument> getInstrumentCollect()
    {
        return this.tableI; 
    }
     
    //Pour suppremier un Fonds 
    public void suppFonds(String key) throws FondINexistant
    {
        //Cherche le fond 
        double test=this.searchFonds(key);
        //Si le fond existe alors il le supprime sinon il renvoi une exception
        if(test!=0)
        {
           tableF.remove(key);
           System.out.println("Elément supprimé");
        }
        else 
        {
            throw new FondINexistant();
        }
    }
    
    //Pour supprimer un Instrument
    public void suppInstrument(String key) throws InstumentINexistant
    {
      //Cherche si l'instrument existe
      ArrayList test=this.searchInstrument(key);
      
      //Si l'instrument existe vide sa collection de fonds et le retire de la hashmap
      if(test!=null)
      {
          tableI.get(key).getCollectionFdeI().clear();
          tableI.remove(key);
          System.out.println("L'instrument a bien été supprimé");
      }
      //Sinon envoie une exception
      else
      {
          throw new InstumentINexistant();
      }
      
    }
    
    //getter des deux hashmap
    public HashMap<String, Fonds> getTableF() 
    {
        return tableF;
    }

    public HashMap<String, Instrument> getTableI() 
    {
        return tableI;
    }
     
    //Pour set la collect de Fonds
    public void setInstrumentCollect(String key, Instrument a)
    {
        this.tableI.put(key, a); 
    }
    //Pour set la collect de Fonds
    public void setFondsCollect(String key, Fonds a)
    {
        this.tableF.put(key, a); 
    }
}

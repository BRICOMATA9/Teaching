/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author laura 
 * @author ludivine
 */
public class Portefeuille {
    //Attributs
    private Map<String,Fonds> mapFonds;
    protected Map<String,Instrument> mapInstrument;
    
    /**
     * Constructeur par défaut
     */
    public Portefeuille()
    {
        mapFonds=new HashMap<>();
        mapInstrument=new HashMap<>();
    }
    
    /**
     * Méthode get
     * @return mapFonds
     */
    public Map<String,Fonds> getMapFonds()
    {
        return mapFonds;
    }
    
    /**
     * Méthode get
     * @return 
     */
    public Map<String,Instrument> getMapInstrument()
    {
        return mapInstrument;
    }
    
    /**
     * Rechercher un fonds
     * @param cle
     * @return le montant associé à la clé fournie
     * @throws FondsInexistant 
     */
    public double rechercheFonds(String cle) throws FondsInexistant
    {
        Set<Entry<String, Fonds>> setMapFonds = mapFonds.entrySet();
        Iterator<Entry<String, Fonds>> it = setMapFonds.iterator();
        //Tant qu'il y a des fonds dans le HashMap
        while(it.hasNext())
        {
            Entry<String, Fonds> e = it.next();
            //Si la clé d'un fonds corresponds à celle passée en paramètres
            if(e.getKey() == null ? cle == null : e.getKey().equals(cle))
            {
                //Retourne le montant associé à la clé
                return e.getValue().getMontant();
            }
            //Sinon lancer une exeption
            else throw new FondsInexistant(cle);
        }
        throw new FondsInexistant(cle);
    }
    
    /**
     * Rechercher un instrument
     * @param cle
     * @return l'ArrayList de l'instrument
     * @throws InstrumentInexistant 
     */
    public ArrayList<Fonds> rechercheInstrument(String cle) throws InstrumentInexistant
    {
        Set<Entry<String, Instrument>> setMapInstrument = mapInstrument.entrySet();
        Iterator<Entry<String, Instrument>> it = setMapInstrument.iterator();
        
        //Tant qu'il y a des instruments dans le HashMap
        while(it.hasNext())
        {
            Entry<String, Instrument> e = it.next();
            //Si la clé d'un instument corresponds à celle passée en paramètres
            if(e.getKey() == null ? cle == null : e.getKey().equals(cle))
            {
                //Retourne l'intrument trouvé
                return e.getValue().getCollectInstru();
            }
            //Sinon lancer une exeption
            else throw new InstrumentInexistant(cle);
        }
        
        throw new InstrumentInexistant(cle);
    }
    
    /**
     * Ajouter un fonds
     * @param cle
     * @param montant
     * @throws FondsExistant 
     */
    public void ajouterFonds(String cle, double montant) throws FondsExistant
    {
        //On essaie de trouver un fonds correspondant à la clé
        try
        {
            rechercheFonds(cle);
            
            throw new FondsExistant(cle);
        }
        //Si ce fonds n'existe pas, on l'ajoute
        catch(FondsInexistant f)
        {
            mapFonds.put(cle,new Fonds(montant));
            System.out.println("Le fond a bien été ajouté");
        }
    }

    /**
     * Ajouter un fonds à un instrument
     * @param cle
     * @param nouveauFond
     * @throws FondsExistant 
     */
    public void ajouterInstrument(String cle, Fonds nouveauFond) throws FondsExistant
    {
        //On essaye de trouver l'instrument
        try
        {
            rechercheInstrument(cle);
            Set<Entry<String, Instrument>> setMapInstrument = mapInstrument.entrySet();
            Iterator<Entry<String, Instrument>> it = setMapInstrument.iterator();

            while(it.hasNext())
            {
                Entry<String, Instrument> e = it.next();
                if(e.getKey() == null ? cle == null : e.getKey().equals(cle))
                {
                    e.getValue().ajoutCollection(nouveauFond);
                    System.out.println("Le fond a bien été ajouté à l'instrument");
                }
            }
        }
        //Si l'instrument n'est pas trouvé
        catch(InstrumentInexistant f)
        {
            mapInstrument.put(cle,new Instrument(new ArrayList<>(Arrays.asList(nouveauFond))));
            System.out.println("L'instrument à été instancié et le fonds a bien été ajouté");
        }
    }
    
    /**
     * Supprimer un fonds
     * @param cle 
     */
    public void supprimerFonds(String cle)
    {
        try
        {
            rechercheFonds(cle);
            mapFonds.remove(cle);
        }
        catch(FondsInexistant f){}
    }
    
    /**
     * Supprimer un instrument
     * @param cle 
     */
    public void supprimerInstrument(String cle)
    {
        try
        {
            rechercheInstrument(cle);
            mapInstrument.remove(cle);
        }
        catch(InstrumentInexistant f){}
    }
}

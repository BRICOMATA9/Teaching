package Modele;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Classe comportant deux tables de hachage, une dédiée aux fonds et une autre aux instruments.
 * @author Kiary
 */

public class Portefeuille {
    
    private HashMap<String,Fonds> idFunds;
    private HashMap<String,Instrument> idInstrument;
    
    /**
     * Constructeur par défaut.
     */
    public Portefeuille(){
        idFunds=new HashMap<String,Fonds>();
        idInstrument=new HashMap<String, Instrument>();
    }
    
    /**
     * Constructeur surchargé.
     * @param newIDFunds la table de hachage des fonds qu'on souhaite ajouter.
     * @param newIDInstrument la table de hachage des instruments qu'on souhaite ajouter.
     */
    public Portefeuille(HashMap<String,Fonds> newIDFunds, HashMap<String,Instrument> newIDInstrument){
        idFunds=newIDFunds;
        idInstrument=newIDInstrument;
    }
    
    /**
     * Méthode permettant de rechercher un fonds au sein du portefeuille.
     * @param key la clé du fonds que l'utilisateur souhaite rechercher.
     * @return le montant du fonds que l'utilisateur souhaite rechercher.
     * @throws FondsInexistant le fonds n'existe pas au sein du portefeuille.
     */
    public double searchFunds(String key) throws FondsInexistant{
        double returnAmount=0;
        try{
            if(idFunds.containsKey(key)==false){
                throw new FondsInexistant("Cette clé n'existe pas dans les données du Fonds.");
            }
            returnAmount=idFunds.get(key).getAmount();
        } catch (FondsInexistant fi){fi.getMessage();}
        return returnAmount;
    }
    
    /**
     * Méthode permettant de rechercher un instrument dans le portefeuille.
     * @param key la clé de l'instrument que l'utilisateur souhaite rechercher.
     * @return la liste des fonds de l'instrument.
     * @throws InstrumentInexistant l'instrument n'existe pas dans le portefeuille.
     */
    public ArrayList<Fonds> searchInstrument(String key) throws InstrumentInexistant{
        ArrayList<Fonds> returnArray=null;
        try{
            if(idInstrument.containsKey(key)==false){
                throw new InstrumentInexistant("Cette clé n'existe pas dans les données de l'Instrument.");
            }
            returnArray=idInstrument.get(key).getArrayFunds();
        } catch (InstrumentInexistant ii){ii.getMessage();}
        return returnArray;
    }
    
    /**
     * Ajout d'un fonds au sein du portefeuille.
     * @param key la clé à laquelle doit être associée ce fonds.
     * @param amount le montant du fonds qu'on souhaite ajouter.
     * @throws FondsExistant la clé associée à ce nouveau fonds existe déjà dans la liste des fonds du portefeuille.
     */
    public void addFundsPortefeuille(String key, double amount) throws FondsExistant{
        try{
            if(idFunds.containsKey(key)==true){
                throw new FondsExistant("Cette clé existe déjà dans les données.");
            }
            idFunds.put(key, new Fonds(amount));
        } catch (FondsExistant fe){fe.getMessage();}
    }
    
    /**
     * Ajout d'un fonds dans un instrument du portefeuille.
     * @param key la clé associée à ce nouveau instrument.
     * @param newFunds le fonds qu'on souhaite ajouter à l'instrument.
     */
    public void addFundsInInstrument(String key, Fonds newFunds){
        Instrument it=idInstrument.get(key);
        it.addFunds(newFunds);
    }
    
    /**
     * Suppression d'un fonds du portefeuille.
     * @param key la clé associée au fonds qu'on souhaite supprimer.
     */
    public void deleteFunds(String key){
        try{
        if(searchFunds(key)==0){
            System.out.println("Le fonds n'existe pas.");
        }
        else{
            idFunds.remove(key);
        }
        }catch (FondsInexistant fi){fi.getMessage();}
    }
    
    /**
     * Suppression d'un instrument du portefeuille.<br>
     * On supprime d'abord l'ensemble des fonds contenus dans l'instrument puis on supprime l'instrument du portefeuille.
     * @param key la clé associée à l'instrument qu'on souhaite supprimer.
     */
    public void deleteInstrument(String key){
        try{
            if(searchInstrument(key)!=null){
                idInstrument.get(key).getArrayFunds().clear();
                idInstrument.remove(key);
            }
        }catch (InstrumentInexistant ii){ii.getMessage();}
    }
    
    /**
     * Getter de la table de hachage de l'ensemble des instruments du portefeuille.
     * @return la table de hachage de l'ensemble des instruments du portefeuille.
     */
    public HashMap<String,Instrument> getIDInstrument(){
        return idInstrument;
    }
    
    /**
     * Getter de la table de hachage de l'ensemble des fonds du portefeuille.
     * @return la table de hachage de l'ensemble des fonds du portefeuille.
     */
    public HashMap<String,Fonds> getIDFunds(){
        return idFunds;
    }
}

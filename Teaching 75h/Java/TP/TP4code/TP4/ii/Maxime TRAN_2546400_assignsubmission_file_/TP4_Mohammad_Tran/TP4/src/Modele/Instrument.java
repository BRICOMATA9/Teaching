package Modele;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * Classe permettant d'avoir une liste dynamique de fonds.
 * @author Kiary
 */
public class Instrument {
    
    private ArrayList<Fonds> arrayFunds;
    
    /**
     * Constructeur par défaut.
     */
    public Instrument(){
        arrayFunds=new ArrayList<Fonds>();
    }
    
    /**
     * Constructeur surchargé.
     * @param newFunds la liste de fonds qu'on souhaite ajouter à l'instrument.
     */
    public Instrument(ArrayList<Fonds> newFunds){
        arrayFunds=newFunds;
    }
    
    /**
     * Méthode permettant d'ajouter un nouveau fonds dans l'intrument.
     * @param newFundsToAdd le nouveau fonds qu'on souhaite ajouter.
     */
    public void addFunds(Fonds newFundsToAdd){
        arrayFunds.add(newFundsToAdd);
    }
    
    /**
     * Méthode qui permet de trier la liste de fonds que possède l'instrument.
     */
    public void sortByAmount(){
        Collections.sort(arrayFunds);
    }
    
    /**
     * Méthode qui calcule le montant total des fonds que possède l'instrument.
     * @return le montant total des fonds de l'instrument.
     */
    public double totalAmount(){
        double total=0;
        Iterator<Fonds> it=arrayFunds.iterator();
        while(it.hasNext()){
            total+=it.next().getAmount();
        }
        return total;
    }
    
    /**
     * Getter de la liste de fonds.
     * @return la liste des fonds de l'instrument.
     */
    public ArrayList<Fonds> getArrayFunds(){
        return arrayFunds;
    }
}

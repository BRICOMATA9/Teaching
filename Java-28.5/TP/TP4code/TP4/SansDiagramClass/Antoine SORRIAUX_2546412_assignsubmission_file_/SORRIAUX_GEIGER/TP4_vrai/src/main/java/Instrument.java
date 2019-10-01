
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * INSTRUMENT
 */

/**
 *
 * @author antoinesorriaux et thomasgeiger
 */
public class Instrument {
    
    /**
    * Initialisation de la liste de fonds
    */
    
    public List<fonds> collectionfonds = new ArrayList<fonds>(); 
    
    /**
    * Constructeur par défaut et sur chargé de la classe Instrument
    */
    
    Instrument(){
             
    }
    
    Instrument(List<fonds> collectfonds){
        
        this.collectionfonds = collectfonds;
        
    }
    
    /**
    * Ajout Fonds
    */
    
    void AjoutFonds(fonds obj1){
        
        collectionfonds.add(obj1);
        
    }
    
    /**
    * Tri
    */
    
    void tri(){
               
      Collections.sort(collectionfonds);		
        
    }
    
}

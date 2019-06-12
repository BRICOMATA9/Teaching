
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * VUE
 */

/**
 *
 * @author antoinesorriaux et thomasgeiger
 */
public class Vue {
    
    /**
    * initialisation variable classe "Vue"
    */
    
    private int somme;
    
    /**
    * Constructeur de la classe "Vue"
    */
    
   public Vue(){   
       
   }
   
   /**
    * Affichage des instruments et caractéristiques
    */
   public void DisplayforInstru(HashMap <String,Instrument> hash){
       
       for(Map.Entry <String, Instrument> entry : hash.entrySet()) {
    String cle = entry.getKey();
    Instrument valeur = entry.getValue();
    valeur.tri();
    System.out.println("Clé : " + cle + " ");
    System.out.print("Montants : ");
    valeur.collectionfonds.forEach(fonds -> System.out.print(fonds.amount + " ") ); // 5 4 3 2 1
    // traitements
    Iterator<fonds> iter = valeur.collectionfonds.iterator();
    int i = 0;
    while (iter.hasNext()) {
     fonds value = iter.next();
     this.somme += value.amount;
             
     i++;
    }
    System.out.println(" ");
    System.out.println("Montant total : " + this.somme);
    System.out.println("Nombre de fonds : " + i);
    
}
       

    
}
   
public void DisplayforFonds(HashMap <String,Instrument> hash){
    
    
    
}
   
   
       
      
       
   
   
    
}

package Vue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import Modèle.Instrument;
import Modèle.Portefeuille;

public class affichage {
	
	public Portefeuille portefeuille;
	
	public affichage(Portefeuille pfeuille) {
		portefeuille=pfeuille;
	}
	//affichage d'instrument
	public void afficheInstru() {
		
		System.out.println("Affichage des informations relatives à l'instrument demandé");
	        //faire des getters et setters de HashMap sur hashmap 
	        for(Map.Entry<String, Instrument> mapentry : portefeuille.getHash2().entrySet())
	        {
	            double total = 0;
	            System.out.println("La clé de l'instrument est : " + mapentry.getKey());
	            System.out.println("Il a " + mapentry.getValue().valFond.size() + "fonds");
	            for (int i = 0; i < mapentry.getValue().valFond.size(); i++) 
	            {
	            	//get fond recupère amount
	                total += mapentry.getValue().valFond.get(i).getFond();
	            }
	            System.out.println("La somme des fonds totale est : " + total);
	        }
	    }
		
		
		}
		



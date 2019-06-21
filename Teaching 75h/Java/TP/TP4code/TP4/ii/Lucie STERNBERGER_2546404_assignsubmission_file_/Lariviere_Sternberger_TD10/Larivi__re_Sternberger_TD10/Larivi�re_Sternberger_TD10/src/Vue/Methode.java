package Vue;

import java.util.Map;
/**
 * IMPORTS
 */
import java.util.Map.Entry;
import Modele.FondInexistantException;
import Modele.Fonds;
import Modele.Instrument;
import Modele.InstrumentInexistantException;
import Modele.Portefeuille;

/**
 * 
 * @author Clément Larivière
 * @author Lucie Sternberger
 * Classe : <b>Methode</b>
 */
public class Methode 
{
	/**
	 * Afficher un Instrument
	 * @param p
	 * @throws InstrumentInexistantException
	 */
	public void afficherInstru(Portefeuille p) throws InstrumentInexistantException 
	{
		int nbfonds=0;
		int sommemontfonds=0;
		
		System.out.println("AFFICHAGE INSTRUMENT");
		/**
		 * Parcours de la Hashmap Instrument du portefeuille par le biais d'un iterator
		 */
		for(Map.Entry<String, Instrument> i : p.hashInstru.entrySet()) {
		
			System.out.println("La cle de l'instrument est : " + i.getKey());
			
			/**
			 * Parcours de la collection de Fonds par un iterator
			 */
			for(Fonds f : p.rechercherInstru(i.getKey())) 
			{
				
				System.out.println("et a pour montant : " +f.getMontant());
				nbfonds++;
				sommemontfonds+=f.getMontant();
				
			}	
			System.out.println("Le nombre de fonds de cet instrument est " + nbfonds);
			System.out.println("Le montant total des fonds de cet instrument est " +sommemontfonds);
		}
		
	}
	
	/**
	 * Affichage du Pourcentage
	 * @param p
	 * @param cleF
	 * @throws FondInexistantException
	 * @throws InstrumentInexistantException
	 */
	public void afficherPourcentage(Portefeuille p, String cleF) throws FondInexistantException, InstrumentInexistantException {
		
		double montant;
		int total = 0;
		int nbfond=0;
		
			
			montant=p.rechercherFond(cleF);
	
			/**
			 * Parcours de la Hashmap par le biais d'un iterator
			 */
			for(Map.Entry<String, Modele.Fonds> i : p.gethashFonds().entrySet()) 
			{/**
			 * Affectation à la variable total du nombre de Fonds présents dans la collection de l'Instrument en question
			 */
			total = p.rechercherInstru(i.getKey()).size();
			
			/**
			 * Parcours de la collection par le biais d'un iterator + comparaison montant des fonds pour chaque Instrument
			 * Incrémentation si identique
			 */
			for(Fonds f : p.rechercherInstru(i.getKey())) 
			{
				if(montant == f.getMontant()) 
				{
					nbfond+=1;
				}
			}
			
			/**
			 * Affichage du Pourcentage
			 */
			System.out.println("Le pourcentage de l'instrument" +i.getKey());
			System.out.println("avec comme montant : " +montant);
			System.out.println("est : " + nbfond *100 / total);
			
			nbfond=0;
			}
	}
}

	



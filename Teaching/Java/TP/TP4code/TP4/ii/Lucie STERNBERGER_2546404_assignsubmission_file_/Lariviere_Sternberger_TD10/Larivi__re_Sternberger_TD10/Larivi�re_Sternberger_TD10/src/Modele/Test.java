package Modele;

import java.util.ArrayList;
/**
 * IMPORTS
 */
import java.util.Scanner;
import Vue.Methode;

/**
 * 
 * @author Clément Larivière
 * @author Lucie Sternberger
 *  AIDES : Openclassroom, seances de TD avec M.Djoudi
 * Classe : <b>Test</b>
 */
public class Test 
{
	/**
	 * Main
	 * @param args
	 * @throws FondExistantException
	 * @throws FondInexistantException
	 * @throws InstrumentInexistantException
	 */
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws FondExistantException, FondInexistantException, InstrumentInexistantException 
	{
		int choix =0;
		double montant=0;
		

			Scanner sc = new Scanner(System.in);
	        Portefeuille p = new Portefeuille();
	        Fonds f = new Fonds();
	        Instrument i = new Instrument();
	        Methode m= new Methode();
	        String cle = null;
	           
	        Fonds f1 = new Fonds();
	        Fonds f2 = new Fonds();
	        Fonds f3 = new Fonds();
	        
	        ArrayList<Fonds> testFond = new ArrayList<>();
	        
	        testFond.add(f1);
	        testFond.add(f2);
	        
	       Instrument II=new Instrument(testFond);
	       
		      p.ajouterFondHFond(cle, montant);
		      p.ajouterFondHFond(cle, montant);;
		       
		      
		     p.ajouterFondHInstru(cle, f1);
		     p.ajouterFondHInstru(cle, f2);
		     p.ajouterFondHInstru(cle, f2);
		      
		      p.supprimerFondH("2");
		      p.supprimerInstruH("6");
		       
		 m.afficherInstru(p);

	       
	}
	
}

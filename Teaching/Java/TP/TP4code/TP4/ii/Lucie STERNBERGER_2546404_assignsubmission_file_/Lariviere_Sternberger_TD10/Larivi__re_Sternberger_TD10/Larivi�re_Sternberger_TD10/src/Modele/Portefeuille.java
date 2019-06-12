package Modele;

/**
 * IMPORTS
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Clément Larivière
 * @author Lucie Sternberger
 * Classe : <b>Portefeuille</b>
 */
@SuppressWarnings("serial")
public class Portefeuille extends Exception 
{
	/**
	 * VARIABLES
	 */
	HashMap<String, Fonds> hashFonds = new HashMap <String, Fonds> ();
	public HashMap<String, Instrument> hashInstru = new HashMap <String, Instrument> ();
	
	/**
	 * CONSTRUCTEURS
	 */
	
	/**
	 * Constructeur par défaut 
	 */
	public Portefeuille()
	{
		
	}
	
	/**
	 * Constructeur particulier 
	 * @param hashFonds
	 * @param hashInstru
	 */
	public Portefeuille(HashMap<String, Fonds> hashFonds, HashMap<String, Instrument> hashInstru)
	{
		this.hashFonds=hashFonds;
		this.hashInstru=hashInstru;
	}
	

	/**
	 * GETTERS & SETTERS
	 */
	
	/**
	 * Getter Hashmap Fonds (hashFonds)
	 * @return hashFonds
	 */
	public HashMap<String, Fonds> gethashFonds()
	{
		return this.hashFonds;
	}
	
	/**
	 * Getter Hashmap Instruments (hashInstru)
	 * @return hashInstru
	 */
	public HashMap<String, Instrument> gethashInstru()
	{
		return this.hashInstru;
	}

	
	/**
	 * METHODES
	 */
	
	/**
	 * Recherche un Fond
	 * @param cleF
	 * @return montant_associe
	 * @throws FondInexistantException
	 */
	public double rechercherFond (String cleF) throws FondInexistantException
	{
		boolean test_cle = false;
		Fonds f = new Fonds();
		double montant_associe=0;
		
		/**
		 * Check si la clé en paramêtre CleF existe dans hashFonds
		 */
		test_cle=this.hashFonds.containsKey(cleF);
		
		/**
		 * Si check échoue, alors 
		 * @throws FondInexistantException
		 */
		if(test_cle == false) 
		{
			throw new FondInexistantException();
		}
		
		/**
		 * Si check reussi, alors 
		 * @return montant_associe
		 */
		else 
		{
			f = this.hashFonds.get(cleF);
			montant_associe = f.getMontant();
			return montant_associe;
		}
	}
	
	/**
	 * Recherche un Instrument 
	 * @param cleI
	 * @return collection_associee
	 * @throws InstrumentInexistantException
	 */
	public ArrayList<Fonds> rechercherInstru(String cleI) throws InstrumentInexistantException 
	{
		boolean test_cle = false;
		Instrument i = new Instrument();
		ArrayList<Fonds> collection_associee = new ArrayList<Fonds>();
		
		/**
		 * Check si la clé en parametre CleI existe dans hashFonds
		 */
		test_cle=this.hashInstru.containsKey(cleI);
		
		/**
		 * Si check échoue, alors 
		 * @throws InstrumentInexistantException
		 */
		if(test_cle == false) 
		{
			throw new InstrumentInexistantException();		
		}
		
		/**
		 * Si check reussi, alors 
		 * @return collection_associee
		 */
		else 
		{			
			i = this.hashInstru.get(cleI);
			collection_associee = i.getInstru();
			return collection_associee;			
		}
	}
	
	
	/**
	 * Ajout d'un Fond à la Hashmap Fond hashFonds
	 * @param cleF
	 * @param montant
	 * @throws FondExistantException
	 * @throws FondInexistantException
	 */
	public void ajouterFondHFond(String cleF, double montant) throws FondExistantException, FondInexistantException 
	{
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir la cle fond");
		cleF = sc.nextLine();
		System.out.println("Veuillez saisir le montant de ce fond");
		montant = sc.nextInt();
		
		
		try 
		{
			this.rechercherFond(cleF);
			throw new FondExistantException();
		}
		catch(FondInexistantException ie) 
		{
			/**
			 * Ajout d'un Fond, via sa clef cleF, dans la hashmap Fond hashFonds avec le montant f correspondant 
			 */
			Fonds f = new Fonds();
			this.hashFonds.put(cleF, f);
			System.out.println("Fond ajoute");
		
		}
	}
	
	/**
	 * Ajout d'un Fond dans la Hashmap Instrument hashInstru
	 * @param cleI
	 * @param f
	 * @throws InstrumentInexistantException
	 */
	public void ajouterFondHInstru(String cleI, Fonds f) throws InstrumentInexistantException 
	{

		Instrument i = new Instrument(cleI);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir la cle instrument");
		cleI = sc.nextLine();
		
		try
		{
			rechercherInstru(cleI);
			
		}
		catch(InstrumentInexistantException e) 
		{
			/**
			 * Ajout d'un Fond, via sa clef cleI, dans la hashmap Fond hashFonds avec le montant i correspond 
			 */
			this.hashInstru.put(cleI, i);
			
			/**
			 * Ajout d'un Fond à la collection d'Instruments i
			 */
			i.ajouterFond(f);
			
			System.out.println("Fond ajoute a l'instrument");
		}
	}
	
	/**
	 * Suppression d'un Fond dans la Hashmap de Fond hashFonds
	 * @param cleF
	 * @throws FondInexistantException
	 */
	public void supprimerFondH(String cleF) throws FondInexistantException 
	{
		try
		{
			this.rechercherFond(cleF);
			/**
			 * Supprime le fond dont la clef est cleF
			 */
			this.hashFonds.remove(cleF);
			System.out.println("Fond supprime");
		}
		catch(FondInexistantException e) 
		{
			System.out.println("ERREUR le fond n'existe pas");
		}
	}
	
	/**
	 * Suppression d'un Instrument dans la Hashmap Instrument hashInstru
	 * @param cleI
	 * @throws InstrumentInexistantException
	 */
	public void supprimerInstruH(String cleI) throws InstrumentInexistantException 
	{	
		try
		{
			ArrayList <Fonds> collection = new ArrayList<Fonds>();
			/**
			 * Recupère la collection de l'instrument dont la clef est cleI
			 */
			collection=rechercherInstru(cleI);
			/**
			 * Vide la collection
			 */
			collection.clear();
			
			this.rechercherInstru(cleI);
			/**
			 * Supprime l'Instrument dont la clef est cleI dans la Hashmap hashInstru
			 */
			this.hashInstru.remove(cleI);
			System.out.println("Instrument supprime");
		}
		catch(InstrumentInexistantException e) 
		{
			System.out.println("Erreur l'instrument n'existe pas");
		}
	}
}

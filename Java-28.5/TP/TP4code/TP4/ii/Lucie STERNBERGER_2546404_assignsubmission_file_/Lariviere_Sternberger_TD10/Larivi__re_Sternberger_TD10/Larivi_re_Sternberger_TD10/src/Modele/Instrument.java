package Modele;

/**
 * IMPORTS
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;

/**
 * 
 * @author Clément Larivière
 * @author Lucie Sternberger
 * Classe : <b>Instrument</b>
 */
public class Instrument 
{
	/**
	 * VARIABLES
	 */
	ArrayList <Fonds> collection = new ArrayList<Fonds>();
	String cleI;
	
	
	/**
	 * CONSTRUCTEURS
	 */
	
	/**
	 * Constructeur par défaut 
	 */
	public Instrument()
	{
		
	}
	
	/**
	 * Constructeur particulier 1
	 * @param collection
	 */
	public Instrument(ArrayList <Fonds> collection)
	{
		this.collection=collection;
	}
	
	/**
	 * Constructeur particulier 2
	 * @param cleI
	 */
	public Instrument(String cleI)
	{
		this.cleI=cleI;
	}
	
	
	/**
	 * METHODES
	 */
	
	/**
	 * Ajout d'un fond à la collection
	 * @param f
	 */
	public void ajouterFond(Fonds f)
	{
		collection.add(f);
	}
	
	/**
	 * Tri de la collection
	 */
	public void triCollection() 
	{
		List <Fonds> collectiontri = this.collection;
		Collections.sort(collectiontri, Collections.reverseOrder()); 
	}
	
	
	/**
	 * GETTERS & SETTERS
	 */
	
	/**
	 * Getter collection
	 * @return collection
	 */
	public ArrayList<Fonds> getInstru()
	{	
		return collection;
	}
	
	/**
	 * Getter CleI
	 * @return cleI
	 */
	public String getCleI() 
	{
		return cleI;
	}

}

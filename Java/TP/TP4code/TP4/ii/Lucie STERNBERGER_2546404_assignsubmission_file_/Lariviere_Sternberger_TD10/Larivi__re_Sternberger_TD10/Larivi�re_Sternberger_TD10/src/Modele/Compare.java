package Modele;

/**
 * IMPORTS
 */
import java.lang.Comparable;

/**
 * @author Clément Larivière
 * @author Lucie Sternberger
 * Classe : <b>Compare</b>
 */
public class Compare implements Comparable<Fonds> 
{
	/**
	 * VARIABLES
	 */
	String cleF;
	double montant;
	
	
	/**
	 * METHODES
	 */
	
	/**
	 * Fonction comparant deux objets de la classe Fond (retourne un booleen)
	 * @param f
	 * @return boolean
	 */
	public boolean equals(Fonds f)
	{
		Fonds r = new Fonds(this.montant, this.cleF);
		
		//test montant obj parametre = obj reference
		if(f.getMontant() == r.getMontant())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Fonction comparant deux objets de la classe Fond (retourne un Integer)
	 * @param f
	 * @return int
	 */
	public int compareTo(Fonds f)
	{
		Fonds r = new Fonds(this.montant, this.cleF);
		
		if(r.getMontant()>f.getMontant())
		{
			return 1;
		}
		else if( equals(f) )
		{
			return 0;
		}
		else {
			return -1;
		}
	}
	
}

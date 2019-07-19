package bdd;

import java.io.Serializable;
import java.sql.Time;
import java.util.Iterator;
import java.util.Vector;
/**
 * Classe enseignement qui représente le type d'enseignement
 * @author Alexander Remen et Tonya Vo Thanh
 *
 */
public class Enseignement implements Serializable{
	
	public static final int TD = 0;
	public static final int TP = 1;
	public static final int CM = 2;
	public static final int BE = 3;
	
	private Vector<Enseignant> liste_enseignants;
	private int type_enseignement;
	private Time volume_horaire;
	private Vector<Groupe> liste_groupes;
	
	/**
	 * Constructeur d'un enseignement
	 * @param type_enseignement
	 * @param volume_horaire
	 */
	public Enseignement(int type_enseignement, Time volume_horaire) {
		super();
		this.type_enseignement = type_enseignement;
		this.volume_horaire = volume_horaire;
		liste_enseignants = new Vector<Enseignant>();
		liste_groupes = new Vector<Groupe>();
	}
	/**
	 * Méthode qui retourne le type d'enseignement 
	 * @param nom de l'enseignement
	 * @return le type (int)
	 */
	public static int getTypeEnseignement(String nom)
	{
		int type_enseignement = -1;
		
		if(nom.compareToIgnoreCase("CM")==0){type_enseignement = Enseignement.CM;}
		else if(nom.compareToIgnoreCase("TD")==0){type_enseignement = Enseignement.TD;}
		else if(nom.compareToIgnoreCase("TP")==0){type_enseignement = Enseignement.TP;}
		else if(nom.compareToIgnoreCase("BE")==0){type_enseignement = Enseignement.BE;}
				
		return type_enseignement;
	}
	
	/**
	 * Méthode qui permet d'ajouter un groupe et un enseignant qui sont 
	 * @param g le groupe
	 * @param e l'enseignant
	 */
	public void ajoutGroupeEnseignant(Groupe g, Enseignant e)
	{
		liste_groupes.add(g);
		liste_enseignants.add(e);
	}

	/**
	 * Méthode qui retourne l'enseignant qui correspond au groupe
	 * @param g le groupe
	 * @return l'enseignant
	 */
	public Enseignant getEnseignant(Groupe g)
	{
		Enseignant ens = null;
		int i=0;
		while (i<liste_groupes.size() && ens==null)
		{
			if(liste_groupes.elementAt(i).egal(g))
			{
				ens = liste_enseignants.elementAt(i);
			}
			i++;
		}
		return ens;
	}

	/**
	 * Méthode qui retourne le type d'enseignement
	 * @return the type_enseignement
	 */
	public int getType_enseignement() {
		return type_enseignement;
	}

	/**
	 * Méthode qui configure le type d'enseignement
	 * @param type_enseignement le type d'enseignement
	 */
	public void setType_enseignement(int type_enseignement) {
		this.type_enseignement = type_enseignement;
	}

	/**
	 * Méthode qui retourne la liste d'enseignement
	 * @return the liste_enseignants
	 */
	public Vector<Enseignant> getListe_enseignants() {
		return liste_enseignants;
	}

	/**
	 * Méthode qui configure la liste d'enseignement
	 * @param liste_enseignants la liste d'enseignants
	 */
	public void setListe_enseignants(Vector<Enseignant> liste_enseignants) {
		this.liste_enseignants = liste_enseignants;
	}

	/**
	 * Méthode qui retourne la liste des groupes
	 * @return la liste des groupes
	 */
	public Vector<Groupe> getListe_groupes() {
		return liste_groupes;
	}

	/**
	 * Méthode qui configure la liste des groupes
	 * @param liste_groupes la liste des groupes
	 */
	public void setListe_groupes(Vector<Groupe> liste_groupes) {
		this.liste_groupes = liste_groupes;
	}

	/**
	 * Méthode qui retourne le volume horaire
	 * @return the volume_horaire
	 */
	public Time getVolume_horaire() {
		return volume_horaire;
	}

	/**
	 * Méthode qui configure le volume horaire
	 * @param volume_horaire 
	 */
	public void setVolume_horaire(Time volume_horaire) {
		this.volume_horaire = volume_horaire;
	}

	/**
	 * Méthode qui retourne la liste des enseignants en String
	 * @return String - la liste des enseignants
	 */
	public String recupEnseignants() {
		String enseignants="";
		Iterator i = this.liste_enseignants.iterator();
		while(i.hasNext())
		{
			enseignants +=((Enseignant)i.next()).getNum_personne()+" ";
		}
		return enseignants.substring(0, enseignants.length()-1);
	}
	/**
	 * Méthode qui retourne tous les groupes de la liste en String
	 * @return les groupes en String
	 */
	public String recupGroupes() {
		String groupes="";
		Iterator i = this.liste_groupes.iterator();
		while(i.hasNext())
		{
			groupes +=((Groupe)i.next()).getnum_groupe()+" ";
		}
		return groupes.substring(0, groupes.length()-1);
	}
	/**
	 * Méthode qui retourne le volume horaire en String
	 * @return le volume horaire en String
	 */
	public String recupvolume() {
		return volume_horaire.toString().substring(0, 5);
	}
	
	
}

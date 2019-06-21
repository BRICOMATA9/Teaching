package bdd;

import java.io.Serializable;
import java.sql.Time;
import java.util.Iterator;
import java.util.Vector;

public class Enseignement implements Serializable{
	
	public static final int TD = 0;
	public static final int TP = 1;
	public static final int CM = 2;
	public static final int BE = 3;
	
	private Vector<Enseignant> liste_enseignants;
	private int type_enseignement;
	private Time volume_horaire;
	private Vector<Groupe> liste_groupes;

	public Enseignement(int type_enseignement, Time volume_horaire) {
		super();
		this.type_enseignement = type_enseignement;
		this.volume_horaire = volume_horaire;
		liste_enseignants = new Vector<Enseignant>();
		liste_groupes = new Vector<Groupe>();
	}

	public static int getTypeEnseignement(String nom){
		int type_enseignement = -1;
		
		if(nom.compareToIgnoreCase("CM")==0){type_enseignement = Enseignement.CM;}
		else if(nom.compareToIgnoreCase("TD")==0){type_enseignement = Enseignement.TD;}
		else if(nom.compareToIgnoreCase("TP")==0){type_enseignement = Enseignement.TP;}
		else if(nom.compareToIgnoreCase("BE")==0){type_enseignement = Enseignement.BE;}
				
		return type_enseignement;
	}

	public void ajoutGroupeEnseignant(Groupe g, Enseignant e){
		liste_groupes.add(g);
		liste_enseignants.add(e);
	}

	public Enseignant getEnseignant(Groupe g){
		Enseignant ens = null;
		int i=0;
		while (i<liste_groupes.size() && ens==null){
			if(liste_groupes.elementAt(i).egal(g)){
				ens = liste_enseignants.elementAt(i);
			}
			i++;
		}
		return ens;
	}

	public int getType_enseignement() {
		return type_enseignement;
	}

	public void setType_enseignement(int type_enseignement) {
		this.type_enseignement = type_enseignement;
	}

	public Vector<Enseignant> getListe_enseignants() {
		return liste_enseignants;
	}

	public void setListe_enseignants(Vector<Enseignant> liste_enseignants) {
		this.liste_enseignants = liste_enseignants;
	}

	public Vector<Groupe> getListe_groupes() {
		return liste_groupes;
	}

	public void setListe_groupes(Vector<Groupe> liste_groupes) {
		this.liste_groupes = liste_groupes;
	}

	public Time getVolume_horaire() {
		return volume_horaire;
	}

	public void setVolume_horaire(Time volume_horaire) {
		this.volume_horaire = volume_horaire;
	}

	public String recupEnseignants() {
		String enseignants="";
		Iterator i = this.liste_enseignants.iterator();
		while(i.hasNext()){
			enseignants +=((Enseignant)i.next()).getNum_personne()+" ";
		}
		return enseignants.substring(0, enseignants.length()-1);
	}

	public String recupGroupes() {
		String groupes="";
		Iterator i = this.liste_groupes.iterator();
		while(i.hasNext()){
			groupes +=((Groupe)i.next()).getnum_groupe()+" ";
		}
		return groupes.substring(0, groupes.length()-1);
	}

	public String recupvolume() {
		return volume_horaire.toString().substring(0, 5);
	}
}

package bdd;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

public class Matiere implements Serializable{

	private static int nbMat =0;
	public static final int obligatoire =1;
	public static final int optionnelle =2;
	private String num_matiere;
	private String intitule;
	private int type;
	private Vector<Enseignement> liste_enseignement;
	
	public Matiere(String num_matiere, String intitule, int type) {
		super();
		this.num_matiere = num_matiere;
		this.intitule = intitule;
		this.type = type;
		liste_enseignement = new Vector<Enseignement>();
	}

	public void ajoutEnseignement(Enseignement e){
		liste_enseignement.add(e);
	}

	public String getNum_matiere() {
		return num_matiere;
	}

	public void setNum_matiere(String num_matiere) {
		this.num_matiere = num_matiere;
	}

	public Vector<Enseignement> getListe_enseignement() {
		return liste_enseignement;
	}

	public void setListe_enseignement(Vector<Enseignement> liste_enseignement) {
		this.liste_enseignement = liste_enseignement;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String toString(){
		if(this!=null)
		return intitule;
		else return "";
		
	}

	public boolean egal(Matiere mat){
		return (num_matiere.compareTo(mat.getNum_matiere())==0);
	}

	public Enseignant getEnseignant(Groupe gp) throws Exception{
		Enseignant enseignant= null;
		Iterator i = this.liste_enseignement.iterator();
		
		while(i.hasNext() && (enseignant == null)){
			enseignant=((Enseignement)i.next()).getEnseignant(gp);
		}
		return enseignant;
	}
}

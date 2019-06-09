package javamyadmin.bdd;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

public class Promotion implements Serializable{
	
	private String nom_promotion;
	private Responsable resp;
	private Vector<Etudiant> liste_etudiant;

	public Promotion(String nom_promotion, Vector<Etudiant> liste_etudiant) {
		super();
		this.nom_promotion = nom_promotion;
		this.liste_etudiant = liste_etudiant;
		
		Iterator i = this.liste_etudiant.iterator();
		while(i.hasNext()){
			((Etudiant) i.next()).setPromo(this);
		}
			
	}

	public Responsable getResp() {
		return resp;
	}

	public void setResp(Responsable resp) {
		this.resp = resp;
	}

	public String getNom_promotion() {
		return nom_promotion;
	}

	public Vector<Etudiant> getListe_etudiant() {
		return liste_etudiant;
	}
	
	public void ajoutEtudiant(Etudiant et){
		liste_etudiant.add(et);
	}

	public void setListe_etudiant(Vector<Etudiant> liste_etudiant) {
		this.liste_etudiant = liste_etudiant;
	}
}

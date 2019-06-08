package javamyadmin.Model;

import java.io.Serializable;

public class Salle implements Serializable{

	private static int nbSalle =0;
	public static final int TP = 1;
	public static final int AMPHI =2;
	public static final int COURS = 3;

	private String nom_salle;
	private int type_Salle;
	private int taille;

	public static int getTypeSalle(String nom){
		int type_enseignement = -1;
		
		if(nom.compareToIgnoreCase("TP")==0){type_enseignement = Salle.TP;}
		else if(nom.compareToIgnoreCase("AMPHI")==0){type_enseignement = Salle.AMPHI;}
		else if(nom.compareToIgnoreCase("COURS")==0){type_enseignement = Salle.COURS;}
				
		return type_enseignement;
	}

	public Salle(String nom_salle, int salle, int taille) {
		super();
		// TODO Auto-generated constructor stub
		this.nom_salle = nom_salle;
		type_Salle = salle;
		this.taille = taille;
	}

	public String getNom_salle() {
		return nom_salle;
	}

	public void setNom_salle(String nom_salle) {
		this.nom_salle = nom_salle;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getType_Salle() {
		return type_Salle;
	}

	public void setType_Salle(int type_Salle) {
		this.type_Salle = type_Salle;
	}

	public String toString(){
		return (nom_salle);
	}

	public boolean egal(Salle salle) {
		return (this.nom_salle.compareTo(salle.getNom_salle())==0);
	}
}

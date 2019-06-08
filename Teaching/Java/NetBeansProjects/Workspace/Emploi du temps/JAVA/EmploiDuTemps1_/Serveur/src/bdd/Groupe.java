package bdd;

import java.io.Serializable;
import java.util.Vector;

public class Groupe implements Serializable {

	private static int nbSpec =0; 
	private String num_groupe;
	private Responsable responsable;

	public Groupe(String num_groupe) {
		super();
		this.num_groupe = num_groupe;
	}

	public String getnum_groupe() {
		return num_groupe;
	}

	public void setnum_groupe(String num_groupe) {
		this.num_groupe = num_groupe;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public boolean egal(Groupe g){
		return ((this.num_groupe.compareTo(g.getnum_groupe()))==0);
	}

	public String toString(){
		if (this != null) 
			return num_groupe;
		else return "";
		
	}
}

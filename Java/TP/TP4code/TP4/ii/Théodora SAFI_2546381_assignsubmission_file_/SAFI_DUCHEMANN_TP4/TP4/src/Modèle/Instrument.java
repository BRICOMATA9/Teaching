package Modèle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Instrument {
	
	//Déclaration arraylist + key
	public ArrayList<Fonds> valFond;
	public String key;
	
	//Constructeur par défaut
	public Instrument() {
		this.valFond= new ArrayList<Fonds>();	
		this.key=null;
	}
	//Constructeur avec paramètres
	public Instrument(ArrayList<Fonds> pvalFond, String key) {
		this.valFond=pvalFond;
		this.key=key;
	}
	
	//ajout d'un fond
	public void ajoutFond(Fonds fond) {		
		valFond.add(fond);	
	}
	
	//Fonction tri
	public void tri() {		
		Collections.sort(this.valFond);	
		for(int i=0; i<valFond.size();i++){
	          System.out.println(valFond.get(i).getFond());
		}
	}

	//Getters key + Fonds
	public String getKey() {
		return this.key;
	}
	
	public ArrayList<Fonds> getFond() {
		return valFond;
	}
}

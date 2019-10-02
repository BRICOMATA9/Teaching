package Modèle;
import java.util.ArrayList;
import java.util.HashMap;

public class Portefeuille {
	
	//Création de 2 HashMap
	HashMap<String, Fonds> hash1 = new HashMap<String, Fonds>();
	private HashMap<String, Instrument> hash2 = new HashMap<String, Instrument>();
	int i;
	
	//par défaut, vient instancier les 2 hashmap ???
	public Portefeuille() {
		hash1=null;
		setHash2(null);		
	}
	//Constructeur avec paramètre
	public Portefeuille(HashMap<String, Fonds> hash1,HashMap<String, Instrument> hash2) {
		this.hash1=hash1;
		this.setHash2(hash2);
	}
	
	//getter
	
	public HashMap<String, Fonds> getHashFond() {
		return hash1;
	}
	
	public HashMap<String, Instrument> getHashInstru(){
		return getHash2();
	}
	
	//Méthodes
	
	public void rechercheFond(String key) throws FondInexistant {
		
		if (hash1.containsKey(key)) {
			System.out.println(hash1.get(key));
			i=1;
		}
		else {
			i=0;
			throw new FondInexistant();
			
		}
	}
	
	public void rechercheInstru(String key) throws InstruInexistant {
		if (getHash2().containsKey(key)) {
			i=1;
			System.out.println(getHash2().get(key));
		}
		else {
			i=0;
			throw new InstruInexistant();
		}
	}
	
	//ajout d'un fond
	
	public void ajouterFond(String key,double amount) throws FondExistant{
		if(!hash1.containsKey(key)) {
			hash1.put(key, new Fonds(amount));
		}else {
			
			throw new FondExistant();
			
		}
		
	}
	//ajout d'un instrument
	
	public void ajouterInstru(String key, Fonds fond) {
	        ArrayList<Fonds> ajoutInstru = new ArrayList();
	        ajoutInstru.add(fond);
	        Instrument nouv = new Instrument(ajoutInstru, key);
	        getHash2().put(key, nouv);
	        System.out.println("L'instrument est ajouté");
	}
	
	//Suppression d'un fond
	
	public void supprimerFond(String key, Fonds fond) throws FondInexistant {
		rechercheFond(key);
		if(i==1) {
			hash1.remove(key);
		}
		else {
			System.out.println("Le fond demandé ne peut pas être supprimé car il n'existe pas");
		}
	}
	
	//Suppression d'un instrument
	
	public void supprimerInstru(String key) throws InstruInexistant {
		rechercheInstru(key);
		if(i==1) {
			getHash2().remove(key);
		}
		else {
			System.out.println("L'instrument demandé ne peut pas être supprimé car il n'existe pas");
		}
	}
	
	//getter + setter de hash2
	public HashMap<String, Instrument> getHash2() {
		return hash2;
	}
	public void setHash2(HashMap<String, Instrument> hash2) {
		this.hash2 = hash2;
	}
	//getter + setter de hash1
	public HashMap<String, Fonds> getHash1() {
		return hash1;
	}
	public void setHash1(HashMap<String, Fonds> hash1) {
		this.hash1 = hash1;
	}
	
}
